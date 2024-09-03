package org.fardin.mysimpletelegramquizbotwithspringboot.services;

import org.fardin.mysimpletelegramquizbotwithspringboot.models.User;
import org.fardin.mysimpletelegramquizbotwithspringboot.repositories.UserRepository;
import org.fardin.mysimpletelegramquizbotwithspringboot.states.ConversationState;
import org.fardin.mysimpletelegramquizbotwithspringboot.states.UserState;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class UserStateService {
    List<User> users = new ArrayList<>();
    UserRepository repository;

    public UserStateService(UserRepository repository) {
        this.repository = repository;
        users = repository.findAll();
        for(User user : users){
            UserState userState = new UserState();
            userState.setConversationState(ConversationState.START);
            user.setUserState(userState);
        }
    }
    public User findByUserId(Long userId){
        for(User user : users){
            if(Objects.equals(user.getUserid(), userId)){
                return user;
            }
        }
        return null;
    }

    public User findOrRegisterByUserId(Update update){
        if(update.hasMessage()){
            Long userId = update.getMessage().getFrom().getId();
            User user = findByUserId(userId);
            if(user == null){
                System.out.println("user was null");
                for(User u : users){
                    System.out.println(u);
                }
                return registerUser(update);
            }else{
                return user;
            }
        }
        return null;
    }
    public User registerUser(Update update){
        if(!update.hasMessage()){
            return null;
        }
        Long userId = update.getMessage().getFrom().getId();
        String name = update.getMessage().getFrom().getFirstName();
        String username = update.getMessage().getFrom().getUserName();
        User user = new User();
        UserState userState = new UserState();
        userState.setConversationState(ConversationState.START);
        user.setUserState(userState);
        user.setUserid(userId);
        user.setName(name);
        user.setUsername(username);
        repository.save(user);
        users.add(user);
        return user;
    }




}
