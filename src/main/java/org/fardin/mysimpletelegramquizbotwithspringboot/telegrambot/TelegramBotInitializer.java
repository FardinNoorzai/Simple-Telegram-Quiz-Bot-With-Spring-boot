package org.fardin.mysimpletelegramquizbotwithspringboot.telegrambot;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
@Component
public class TelegramBotInitializer {
    private final TelegramBot telegramBot;

    public TelegramBotInitializer(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void init(){
        try{
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(telegramBot);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
