package org.fardin.mysimpletelegramquizbotwithspringboot.commands;

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
public class SelectQuizCommand implements Command{
    UserStateService userStateService;
    MessageService messageService;
    CategoryRepository categoryRepository;

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

    }
}
