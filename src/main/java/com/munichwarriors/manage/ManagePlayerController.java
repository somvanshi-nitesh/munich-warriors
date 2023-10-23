package com.munichwarriors.manage;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public ResponseEntity<List<Player>> update() {
		List<Player> allPlayers = playerRepository.findAll();

		for (Player player : allPlayers) {
			System.out.println(player.getFirstName());
		}
		return ResponseEntity.ok(allPlayers);

	}

	@PostMapping("/addPlayersDetails")
	public ResponseEntity<?> addPlayer(@RequestBody Player player) {
		// Check if a player with the same first name and last name exists
		Optional<Player> existingPlayer = playerRepository.findByFirstNameAndLastName(player.getFirstName(),
				player.getLastName());

		if (existingPlayer.isPresent()) {
			// A player with the same first name and last name already exists
			return ResponseEntity.badRequest().body("A player with the same first name and last name already exists.");
		} else {
			// No existing player with the same first name and last name, so save the new
			// player
			Player savedPlayer = playerRepository.save(player);
			return ResponseEntity.ok(savedPlayer);
		}
	}

	@DeleteMapping("/delete/{fname}")
	public ResponseEntity<String> deletePlayer(@PathVariable String fname) {
		try {

			// Check if the player exists
			Optional<Player> player = playerRepository.findByFirstName(fname);

			if (player.isPresent()) {
				playerRepository.delete(player.get());
				return ResponseEntity.ok("Player deleted successfully.");
			} else {
			//	return ResponseEntity.notFound().build("Player not found");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player doesn't exist in database");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete player.");
		}
	}
}
