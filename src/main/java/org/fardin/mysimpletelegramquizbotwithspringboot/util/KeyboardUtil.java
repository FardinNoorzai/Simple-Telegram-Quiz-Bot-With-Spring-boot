package org.fardin.mysimpletelegramquizbotwithspringboot.util;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;
public class KeyboardUtil{
        public static ReplyKeyboardMarkup createKeyboard(int numButtons, List<String> labels) {
            ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
            keyboardMarkup.setResizeKeyboard(true);
            keyboardMarkup.setOneTimeKeyboard(true);

            List<KeyboardRow> keyboardRows = new ArrayList<>();
            KeyboardRow row = new KeyboardRow();

            for (int i = 0; i < numButtons; i++) {
                if (i < labels.size()) {
                    row.add(new KeyboardButton(labels.get(i)));
                } else {
                    row.add(new KeyboardButton("Button " + (i + 1)));
                }

                if ((i + 1) % 3 == 0) {
                    keyboardRows.add(row);
                    row = new KeyboardRow();
                }
            }

            if (!row.isEmpty()) {
                keyboardRows.add(row);
            }

            keyboardMarkup.setKeyboard(keyboardRows);
            return keyboardMarkup;
        }


}
