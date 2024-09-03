package org.fardin.mysimpletelegramquizbotwithspringboot.states;

public class UserState {
    ConversationState state;

    public ConversationState getConversationState() {
        return state;
    }

    public void setConversationState(ConversationState state) {
        this.state = state;
    }
}
