package org.fardin.mysimpletelegramquizbotwithspringboot.telegrambot;

import org.fardin.mysimpletelegramquizbotwithspringboot.commands.CommandDispatcher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.List;

@Configuration
public class TelegramBot extends TelegramLongPollingBot {

    @Value("${bot.token}")
    String token;
    @Value("${bot.username}")
    String botUserName;
    CommandDispatcher commandDispatcher;
    public TelegramBot(CommandDispatcher commandDispatcher){
        this.commandDispatcher = commandDispatcher;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            commandDispatcher.dispatch(update);
        }
    }

    @Override
    public String getBotToken() {
        return token;
    }
    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }

    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    @Bean
    public AbsSender sender(){
        return this;
    }
}
