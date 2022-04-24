package main;

import bot.Bot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

@RestController
public class AppController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TelegramBotsApi telegramBotsApi;

    @GetMapping("/ping")
    public ResponseEntity<String> getDetailsPing(HttpServletRequest request) throws TelegramApiException {
        String url = "https://api.catboys.com/ping";
        ResponseEntity<String> responseJson = makeRequest(url);
        botConnect(responseJson);
        sendData(request);
        return responseJson;
    }

    @GetMapping("/catboy")
    public ResponseEntity<String> getDetailsCatboy(HttpServletRequest request) throws TelegramApiException {
        String url = "https://api.catboys.com/catboy";
        ResponseEntity<String> responseJson = makeRequest(url);
        botConnect(responseJson);
        sendData(request);
        return responseJson;
    }
    private ResponseEntity<String>  makeRequest(String url){
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Application");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }

    private void botConnect(ResponseEntity<String> responseJson) throws TelegramApiException {
        Bot bot = new Bot();
        bot.sendMsg(responseJson);
    }

    private void sendData(HttpServletRequest request){
        Date date = new Date();
        clientRepository.save((new Client(1,  date.toString(), request.getRequestURL().toString(), request.getRemoteAddr().toString())));
    }
}