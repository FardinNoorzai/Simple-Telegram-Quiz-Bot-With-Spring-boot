package org.fardin.mysimpletelegramquizbotwithspringboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.bots.AbsSender;

@Component
public class MessageService {
    AbsSender sender;

    @Autowired
    public void setSender(AbsSender sender) {
        this.sender = sender;
    }
    public void sendMessage(Long id,String message){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(id);
        try {
            sender.execute(sendMessage);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void sendMessageWithKeyboard(Long id, String message, ReplyKeyboardMarkup keyboardMarkup){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(id);
        sendMessage.setReplyMarkup(keyboardMarkup);
        try {
            sender.execute(sendMessage);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
