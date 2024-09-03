package org.fardin.mysimpletelegramquizbotwithspringboot.commands;

import org.fardin.mysimpletelegramquizbotwithspringboot.services.MessageService;
import org.fardin.mysimpletelegramquizbotwithspringboot.services.UserStateService;
import org.fardin.mysimpletelegramquizbotwithspringboot.states.ConversationState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class HomeCommand implements Command{
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
        messageService.sendMessage(update.getMessage().getFrom().getId(),"now you are in home");
        userStateService.findByUserId(update.getMessage().getFrom().getId()).getUserState().setConversationState(ConversationState.QUIZ);
    }
}
