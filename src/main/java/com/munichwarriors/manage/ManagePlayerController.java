package com.munichwarriors.manage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ManagePlayerController {
    private final PlayerRepository playerRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public ManagePlayerController(PlayerRepository playerRepository, RestTemplate restTemplate) {
        this.playerRepository = playerRepository;
        this.restTemplate = restTemplate;
//        restTemplate.getInterceptors().add(
//            new BasicAuthenticationInterceptor("ylFmOlhqhGqLj0TwdUuZbEDLq3TraxzrcwmCbpO6nJr48Cs3", "CbXaakRFsCOCkBjNOza4Z5ZDhP9ZICmFBrbZU7zDQwJMu6Zl")
//        );
    }

    @GetMapping("/getPlayersDetails")
    public void update() {
        System.out.println("Hello");
        List<Player> allPlayers = playerRepository.findAll();
        
        for (Player player : allPlayers) {
			System.out.println(player.getFirstName());
		}
    }
}
