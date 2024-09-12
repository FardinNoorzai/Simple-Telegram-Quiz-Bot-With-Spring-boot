package org.fardin.mysimpletelegramquizbotwithspringboot.commands;

import org.fardin.mysimpletelegramquizbotwithspringboot.models.Category;
import org.fardin.mysimpletelegramquizbotwithspringboot.models.QuizInformation;
import org.fardin.mysimpletelegramquizbotwithspringboot.repositories.CategoryRepository;
import org.fardin.mysimpletelegramquizbotwithspringboot.services.MessageService;
import org.fardin.mysimpletelegramquizbotwithspringboot.services.UserStateService;
import org.fardin.mysimpletelegramquizbotwithspringboot.states.ConversationState;
import org.fardin.mysimpletelegramquizbotwithspringboot.util.KeyboardUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import java.util.ArrayList;
import java.util.List;

@Component
public class SelectQuizCommand implements Command{
    UserStateService userStateService;
    MessageService messageService;
    CategoryRepository categoryRepository;

    @Autowired
    public void setUserStateService(UserStateService userStateService) {
        this.userStateService = userStateService;
    }

    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {this.categoryRepository = categoryRepository;}

    @Override
    public void execute(Update update) {
        String categoryName = update.getMessage().getText();
        Category category = categoryRepository.findByName(categoryName);
        if(category != null) {
            QuizInformation quizInformation = new QuizInformation();
            quizInformation.setCategory(category);
            userStateService.findByUserId(update.getMessage().getFrom().getId()).setQuizInformation(quizInformation);
            List<String> lables = new ArrayList<>();
            lables.add("5");
            lables.add("10");
            lables.add("15");
            ReplyKeyboardMarkup keyboardMarkup =  KeyboardUtil.createKeyboard(3,lables);
            long userId = update.getMessage().getFrom().getId();
            messageService.sendMessageWithKeyboard(userId,"select the quiz question count",keyboardMarkup);
            userStateService.findByUserId(update.getMessage().getFrom().getId()).getUserState().setConversationState(ConversationState.SELECT_QUIZ_QUESTION_COUNT);
        }else{
            messageService.sendMessage(update.getMessage().getFrom().getId(),"select from the keyboard!");
        }
    }
}
