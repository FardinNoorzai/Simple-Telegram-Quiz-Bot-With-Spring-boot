package org.fardin.mysimpletelegramquizbotwithspringboot.commands;

import org.fardin.mysimpletelegramquizbotwithspringboot.models.User;
import org.fardin.mysimpletelegramquizbotwithspringboot.services.UserStateService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;


@Component
public class CommandDispatcher {
    UserStateService userStateService;
    StartCommand startCommand;
    HomeCommand homeCommand;
    SelectQuizCommand selectQuizCommand;
    SelectQuizQuestionCountCommand selectQuizQuestionCountCommand;

    public CommandDispatcher(UserStateService userStateService, @Lazy StartCommand startCommand,@Lazy HomeCommand homeCommand,@Lazy SelectQuizCommand selectQuizCommand,@Lazy SelectQuizQuestionCountCommand selectQuizQuestionCountCommand) {
        this.userStateService = userStateService;
        this.startCommand = startCommand;
        this.homeCommand = homeCommand;
        this.selectQuizCommand = selectQuizCommand;
        this.selectQuizQuestionCountCommand = selectQuizQuestionCountCommand;
    }

    public void dispatch(Update update){
        User user = userStateService.findOrRegisterByUserId(update);
        switch (user.getUserState().getConversationState()){
            case START:
                startCommand.execute(update);
            case HOME:
                homeCommand.execute(update);
            case SELECT_QUIZ:
                selectQuizCommand.execute(update);
            case SELECT_QUIZ_QUESTION_COUNT:
                selectQuizQuestionCountCommand.execute(update);



        }
    }
}
