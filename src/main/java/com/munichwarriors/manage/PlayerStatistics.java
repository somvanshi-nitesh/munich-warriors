package com.munichwarriors.manage;

import jakarta.persistence.*;

@Entity
@Table(name = "player_statistics")
public class PlayerStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statistic_id")
    private Long statisticId;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @Column(name = "matches_played")
    private Integer matchesPlayed;

    @Column(name = "runs_scored")
    private Integer runsScored;

    @Column(name = "wickets_taken")
    private Integer wicketsTaken;

    @Column(name = "centuries")
    private Integer centuries;

    @Column(name = "fifties")
    private Integer fifties;

	public Long getStatisticId() {
		return statisticId;
	}

	public void setStatisticId(Long statisticId) {
		this.statisticId = statisticId;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Integer getMatchesPlayed() {
		return matchesPlayed;
	}

	public void setMatchesPlayed(Integer matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}

	public Integer getRunsScored() {
		return runsScored;
	}

	public void setRunsScored(Integer runsScored) {
		this.runsScored = runsScored;
	}

	public Integer getWicketsTaken() {
		return wicketsTaken;
	}

	public void setWicketsTaken(Integer wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}

	public Integer getCenturies() {
		return centuries;
	}

	public void setCenturies(Integer centuries) {
		this.centuries = centuries;
	}

	public Integer getFifties() {
		return fifties;
	}

	public void setFifties(Integer fifties) {
		this.fifties = fifties;
	}
}

