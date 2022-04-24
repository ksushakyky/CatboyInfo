package bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class Bot extends TelegramLongPollingBot {

//    @Value("${my.example.botUsername}")
//    private String botUsername;
//    @Value("${botToken}")
//    private String botToken;
    private final String botUsername = "CatboyInfoBot";
    private final String botToken = "5101164766:AAE8wx_MkOjf_zuOlMgmM2QFSLWe0hLPd-Q";
    private List<String> idList = new ArrayList<>();
    String id;
    String msg;
    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        long chat_id;
        if (update.getMessage() != null && update.getMessage().hasText()) {
            chat_id = update.getMessage().getChatId();
            id = Long.toString(chat_id);
            msg = update.getMessage().getText();
        }
        event();
    }

    private void event(){
        if(msg.equals("/start"))
        {
            writeId();
            try {
                execute(new SendMessage(id, "Hello, my name is InfoCatboy! I redirect requests from https://catboys.com"));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeId(){
        try {
            Files.write(Paths.get("src/main/java/bot/Users"), Collections.singleton(id));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findAllId(){
        try {
            idList = Files.readAllLines(Paths.get("src/main/java/bot/Users"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(ResponseEntity<String> response){
        findAllId();
        try {
            for (String i:idList) {
                execute(new SendMessage(i, response.getBody()));
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
