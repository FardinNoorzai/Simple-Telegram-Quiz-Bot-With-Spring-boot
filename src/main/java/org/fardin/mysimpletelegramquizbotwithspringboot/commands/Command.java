package org.fardin.mysimpletelegramquizbotwithspringboot.commands;

import org.fardin.mysimpletelegramquizbotwithspringboot.services.UserStateService;

public interface Command {
    public void execute(Long userId, String message, UserStateService userStateService);
}
