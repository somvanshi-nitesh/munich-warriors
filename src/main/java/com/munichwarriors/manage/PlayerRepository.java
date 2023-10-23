package com.munichwarriors.manage;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

	@Query("SELECT p FROM Player p WHERE p.firstName = :firstName")
	Optional<Player> findByFirstName(String firstName);

	@Query("SELECT p FROM Player p WHERE p.firstName = :firstName AND p.lastName = :lastName")
	Optional findByFirstNameAndLastName(String firstName, String lastName);
}
