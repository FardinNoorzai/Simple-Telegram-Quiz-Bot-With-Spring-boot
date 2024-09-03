package org.fardin.mysimpletelegramquizbotwithspringboot.commands;

import org.fardin.mysimpletelegramquizbotwithspringboot.services.MessageService;
import org.fardin.mysimpletelegramquizbotwithspringboot.services.UserStateService;
import org.fardin.mysimpletelegramquizbotwithspringboot.states.ConversationState;
import org.fardin.mysimpletelegramquizbotwithspringboot.util.KeyboardUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.ArrayList;
import java.util.List;

@Component
public class StartCommand implements Command{
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
        List<String> buttonNames = new ArrayList<>();
        buttonNames.add("شروع امتحان");
        buttonNames.add("مشاهده نمرات قبلی");
        buttonNames.add("گرفتن لینک مخصوص");
        buttonNames.add("مشاهده مشخصات");
        ReplyKeyboardMarkup replyKeyboardMarkup = KeyboardUtil.createKeyboard(4,buttonNames);
        messageService.sendMessageWithKeyboard(update.getMessage().getFrom().getId(),"سلام موفقانه اسم شما در ربات ذخیره شد\nبرای ادامه یکی از دکه ها را انتخاب کن!",replyKeyboardMarkup);
        userStateService.findByUserId(update.getMessage().getFrom().getId()).getUserState().setConversationState(ConversationState.HOME);
    }
}
