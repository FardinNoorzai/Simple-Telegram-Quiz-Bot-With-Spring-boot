package org.fardin.mysimpletelegramquizbotwithspringboot.commands;

import org.fardin.mysimpletelegramquizbotwithspringboot.services.MessageService;
import org.fardin.mysimpletelegramquizbotwithspringboot.services.UserStateService;
import org.fardin.mysimpletelegramquizbotwithspringboot.util.KeyboardUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

import java.util.ArrayList;
import java.util.List;

@Component
public class SelectQuizQuestionCountCommand implements Command{
    UserStateService userStateService;
    MessageService messageService;

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

        String message = update.getMessage().getText();
        if(message.equals("5")){
            int count = Integer.parseInt(update.getMessage().getText());
            userStateService.findByUserId(update.getMessage().getFrom().getId()).getQuizInformation().setQuestionCount(count);
        }else{
            messageService.sendMessage(update.getMessage().getFrom().getId(),"select from the keyboard!");
        }
    }
}
