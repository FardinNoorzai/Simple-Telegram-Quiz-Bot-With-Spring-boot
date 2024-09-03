package org.fardin.mysimpletelegramquizbotwithspringboot.commands;

import org.fardin.mysimpletelegramquizbotwithspringboot.models.User;
import org.fardin.mysimpletelegramquizbotwithspringboot.services.UserStateService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;


@Component
public class CommandDispatcher {
    UserStateService userStateService;
    StartCommand startCommand;
    HomeCommand homeCommand;


    public CommandDispatcher(UserStateService userStateService,@Lazy StartCommand startCommand,@Lazy HomeCommand homeCommand) {
        this.userStateService = userStateService;
        this.startCommand = startCommand;
        this.homeCommand = homeCommand;
    }

    public void dispatch(Update update){
        User user = userStateService.findOrRegisterByUserId(update);
        switch (user.getUserState().getConversationState()){
            case START:
                startCommand.execute(update);
                break;
            case HOME:
                homeCommand.execute(update);


        }
    }
}
