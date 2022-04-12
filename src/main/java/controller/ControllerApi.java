package controller;

import bot.Bot;
import model.Client;
import model.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

@RestController
public class ControllerApi {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private ClientRepository clientRepository;

    private Bot bot = new Bot();

    @GetMapping("/ping")
    public ResponseEntity<String> getDetailsPing(Model model, HttpServletRequest request){

        Date date = new Date();
//        String getURL = request.getRequestURL().toString();
//        String getIp = request.getRemoteAddr().toString();
//
//        System.out.println(getURL);
//        System.out.println(getIp);
//        System.out.println(date);
//            model.addAttribute("orderId", orderId);
//        System.out.println(model.toString());
        HttpHeaders headers = new HttpHeaders();
        clientRepository.save((new Client(1, 1, date.toString(), request.getRequestURL().toString(), request.getRemoteAddr().toString())));
        Iterable<Client> customers = clientRepository.findAll();
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Client customer : customers) {
            System.out.println(customer);
        }
//        System.out.println();
//        System.out.println(clientRepository.findAll());
//        System.out.println("this");
//        System.out.println(clientRepository.toString());
        headers.add("user-agent", "Application");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> responseJson = restTemplate.exchange("https://api.catboys.com/ping", HttpMethod.GET, entity, String.class);
//        bot.sendMsg(responseJson);
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
