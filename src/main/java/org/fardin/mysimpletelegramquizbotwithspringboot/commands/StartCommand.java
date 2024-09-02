package org.fardin.mysimpletelegramquizbotwithspringboot.commands;

import org.fardin.mysimpletelegramquizbotwithspringboot.services.UserStateService;

public class StartCommand implements Command{
    @Override
    public void execute(Long userId, String message, UserStateService userStateService) {

    }
}
