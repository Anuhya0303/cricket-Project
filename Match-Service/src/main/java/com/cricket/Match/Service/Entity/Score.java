package com.cricket.Match.Service.Entity;


import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table(name="score")
public class Score {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scoreId;
    private int runs;
    private int wickets;
    private int overs;
    private Long matchId;
    


@ManyToOne
 Player player;
    
    
    public Score() {
		
	}
    
    
	public Score(Long scoreId, int runs, int wickets, int overs,Long matchId,Long playerId) {
		super();
		this.scoreId =scoreId;
	    this.runs = runs;
		this.wickets = wickets;
		this.overs = overs;
		this.matchId=matchId;
		this.player=new Player(playerId,"", "","",null);
	}
	

	
	public Long getScoreId() {
		return scoreId;
	}


	public void setScoreId(Long scoreId) {
		this.scoreId = scoreId;
	}


	public int getRuns() {
		return runs;
	}

	public Player getPlayer() {
		return player;
	}


	public void setPlayer(Player player) {
		this.player = player;
	}
	
	


	


	public void setRuns(int runs) {
		this.runs = runs;
	}


	public int getWickets() {
		return wickets;
	}


	public void setWickets(int wickets) {
		this.wickets = wickets;
	}


	public Long getMatchId() {
		return matchId;
	}


	public void setMatchId(Long matchId) {
		this.matchId = matchId;
	}


	public int getOvers() {
		return overs;
	}


	public void setOvers(int overs) {
		this.overs = overs;
	}


	@Override
	public String toString() {
		return "Score [scoreId=" + scoreId + ", runs=" + runs + ", wickets=" + wickets + ", overs=" + overs
				+ ", matchId=" + matchId + ", player=" + player + "]";
	}


	

}
    
	


