package org.fardin.mysimpletelegramquizbotwithspringboot.commands;

import org.fardin.mysimpletelegramquizbotwithspringboot.services.UserStateService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class CommandDispatcher {
    UserStateService userStateService;

    public CommandDispatcher(UserStateService userStateService) {
        this.userStateService = userStateService;
    }

    public void dispatch(Update update){

    }
}
