package org.fardin.mysimpletelegramquizbotwithspringboot.services;

import org.fardin.mysimpletelegramquizbotwithspringboot.states.UserState;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserStateService {
    private Map<Long, UserState> userStates = new HashMap<>();

    public UserState getUserState(Long userId) {
        return userStates.computeIfAbsent(userId, id -> new UserState());

    }

    public void setUserState(Long userId, UserState state) {
        userStates.put(userId, state);
    }
}
