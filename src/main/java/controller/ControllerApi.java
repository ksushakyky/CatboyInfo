package controller;

import bot.Bot;
import model.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
import java.util.Arrays;

@RestController
public class ControllerApi {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private ClientRepository clientRepository;

    private Bot bot = new Bot();

    @GetMapping("/ping")
    public ResponseEntity<String> getDetailsPing() {
//        System.out.println(clientRepository.findAll());
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Application");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> responseJson = restTemplate.exchange("https://api.catboys.com/ping", HttpMethod.GET, entity, String.class);
        bot.sendMsg(responseJson);
        return responseJson;
    }

    @GetMapping("/catboy")
    public ResponseEntity<String> getDetailsCatboy() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Application");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> responseJson = restTemplate.exchange("https://api.catboys.com/catboy", HttpMethod.GET, entity, String.class);
        bot.sendMsg(responseJson);
        return responseJson;
    }
}
