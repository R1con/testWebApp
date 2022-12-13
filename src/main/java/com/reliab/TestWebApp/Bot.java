package com.reliab.TestWebApp;

import com.reliab.TestWebApp.properties.BotProperties;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.webapp.WebAppInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Bot extends TelegramLongPollingBot {
    private final BotProperties botProperties;

    @Override
    public String getBotUsername() {
        return botProperties.getName();
    }

    @Override
    public String getBotToken() {
        return  botProperties.getToken();
    }

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            execute(SendMessage.builder()
                    .text("webapp")
                    .chatId(update.getMessage().getChatId())
                    .replyMarkup(getKeyboard())
                    .build());
        }
    }

    public InlineKeyboardMarkup getKeyboard() {
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        WebAppInfo webAppInfo = WebAppInfo.builder().url(botProperties.getUrl()).build();
        buttons.add(Collections.singletonList(
                InlineKeyboardButton.builder().webApp(webAppInfo).text("TEST").build()
        ));

        return InlineKeyboardMarkup.builder().keyboard(buttons).build();
    }
}
