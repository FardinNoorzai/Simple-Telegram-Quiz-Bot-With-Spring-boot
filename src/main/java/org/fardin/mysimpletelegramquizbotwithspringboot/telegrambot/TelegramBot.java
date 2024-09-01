package org.fardin.mysimpletelegramquizbotwithspringboot.telegrambot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    @Value("${bot.token}")
    String token;
    @Value("${bot.username}")
    String botUserName;
    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update);
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
}
