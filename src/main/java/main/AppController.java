package main;

import bot.Bot;
import main.Client;
import main.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

@RestController
public class AppController {

        @Autowired
        RestTemplate restTemplate;

        @Autowired
        private ClientRepository clientRepository;

        private Bot bot = new Bot();

        @GetMapping("/ping")
        public ResponseEntity<String> getDetailsPing(Model model, HttpServletRequest request){
            //        List<Client> list
            //
            //            Iterable<Client> clientIterable =  ClientRepository.findAll();
            //            ArrayList<Client> clients = new ArrayList<>();
            //            for(Client client : clientIterable) {
            //                clients.add(client);
            //            }
            Date date = new Date();
            HttpHeaders headers = new HttpHeaders();
            headers.add("user-agent", "Application");
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<String> responseJson = restTemplate.exchange("https://api.catboys.com/ping", HttpMethod.GET, entity, String.class);
            clientRepository.save((new Client(1,  date.toString(), request.getRequestURL().toString(), request.getRemoteAddr().toString())));
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