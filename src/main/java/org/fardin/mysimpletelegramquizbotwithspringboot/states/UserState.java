package org.fardin.mysimpletelegramquizbotwithspringboot.states;

import org.fardin.mysimpletelegramquizbotwithspringboot.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserState {
    private ConversationStates conversationState;
    private Map<String, String> userData;
    User user;

    public UserState() {
        this.conversationState = ConversationStates.START;
        this.userData = new HashMap<>();
    }

    public ConversationStates getConversationState() {
        return conversationState;
    }

    public void setConversationState(ConversationStates conversationState) {
        this.conversationState = conversationState;
    }

    public Map<String, String> getUserData() {
        return userData;
    }

    public void setUserData(String key, String value) {
        this.userData.put(key, value);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
