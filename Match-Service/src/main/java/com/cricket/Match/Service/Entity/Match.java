package com.cricket.Match.Service.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="match")
public class Match {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchId;
    private String teamA;
    private String teamB;
    private String venue;
    private String date;
    private Long playerId;
    @Transient
    Player player;
    @Transient
    Score score;

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public Match() {
		
	}
    
	public Match(Long matchId, String teamA, String teamB, String venue, String date,Long playerId) {
		super();
		this.matchId = matchId;
		this.teamA = teamA;
		this.teamB = teamB;
		this.venue = venue;
		this.date = date;
		this.playerId=playerId;
	}
	 

	public void setmatchId(Long matchId) {
		this.matchId = matchId;
	}

	public String getTeamA() {
		return teamA;
	}

	public void setTeamA(String teamA) {
		this.teamA = teamA;
	}

	public String getTeamB() {
		return teamB;
	}

	public void setTeamB(String teamB) {
		this.teamB = teamB;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getmatchId() {
		return matchId;
	}
    
    

}
