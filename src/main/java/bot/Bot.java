package bot;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;

@Component
public class Bot extends TelegramLongPollingBot {

    private final String botUsername = "CatboyInfoBot";

    private final String botToken = "5101164766:AAE8wx_MkOjf_zuOlMgmM2QFSLWe0hLPd-Q";

    private ArrayList<String> idList = new ArrayList<>();

    private String id;

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

        long chat_id = 0;
//        String id = null;
//        if(update.getMessage() != null && update.getMessage().getText() == "/start" && update.getMessage().hasText()){
//            chat_id = update.getMessage().getChatId();
//            id = Long.toString(chat_id);
//            idList.add(id);
//        }
        if (update.getMessage() != null && update.getMessage().hasText()) {
            chat_id = update.getMessage().getChatId();
            id = Long.toString(chat_id);
            System.out.println(id);
//            String str = update.getMessage().getText();
//            if(str.equals("/start"))
//            {
//                idList.add(id);
//                idList.forEach((i) -> System.out.println(i));
////                System.out.println(str);
//            }
        }
        
        try {
            execute(new SendMessage(id, "Hello!" ));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public void sendMsg(ResponseEntity<String> response){
//        if(id != null){
            try {
//            execute(new SendMessage(idList.get(0), response.toString()));
                execute(new SendMessage("730360558", response.getBody()));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
//        }
    }

}
