package org.fardin.mysimpletelegramquizbotwithspringboot.commands;

import org.fardin.mysimpletelegramquizbotwithspringboot.services.UserStateService;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface Command {
    public void execute(Update update);
}
