package org.fardin.mysimpletelegramquizbotwithspringboot.commands;

import org.fardin.mysimpletelegramquizbotwithspringboot.models.Category;
import org.fardin.mysimpletelegramquizbotwithspringboot.repositories.CategoryRepository;
import org.fardin.mysimpletelegramquizbotwithspringboot.services.MessageService;
import org.fardin.mysimpletelegramquizbotwithspringboot.services.UserStateService;
import org.fardin.mysimpletelegramquizbotwithspringboot.states.ConversationState;
import org.fardin.mysimpletelegramquizbotwithspringboot.util.KeyboardUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

import java.util.ArrayList;
import java.util.List;

@Component
public class HomeCommand implements Command{
    UserStateService userStateService;
    MessageService messageService;
    CategoryRepository categoryRepository;

    public HomeCommand(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Autowired
    public void setUserStateService(UserStateService userStateService) {
        this.userStateService = userStateService;
    }

    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void execute(Update update) {
        if(update.getMessage().getText().equals("شروع امتحان")){
            List<Category> categoryList = categoryRepository.findAll();
             List<String> buttonNames = new ArrayList<>();
            for(Category category : categoryList){
                buttonNames.add(category.getName());
            }
            ReplyKeyboardMarkup replyKeyboardMarkup = KeyboardUtil.createKeyboard(buttonNames.size(), buttonNames);
            messageService.sendMessageWithKeyboard(update.getMessage().getFrom().getId(),"یکی از بخش ها را انتخاب کن",replyKeyboardMarkup);
            userStateService.findByUserId(update.getMessage().getFrom().getId()).getUserState().setConversationState(ConversationState.SELECT_QUIZ);
        }


    }

//    List<String> buttonNames = new ArrayList<>();
//            buttonNames.add("10");
//            buttonNames.add("15");
//            buttonNames.add("20");
//            buttonNames.add("25");
//    ReplyKeyboardMarkup replyKeyboardMarkup = KeyboardUtil.createKeyboard(4,buttonNames);
//            messageService.sendMessageWithKeyboard(update.getMessage().getFrom().getId(),"چند سوال شامل امتحان باشد؟",replyKeyboardMarkup);
//            userStateService.findByUserId(update.getMessage().getFrom().getId()).getUserState().setConversationState(ConversationState.SELECT_QUIZ);

}
