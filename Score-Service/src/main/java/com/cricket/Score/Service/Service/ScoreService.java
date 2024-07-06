package com.cricket.Score.Service.Service;

import java.util.Optional;

import com.cricket.Score.Service.Entity.Score;

public interface ScoreService {
	public Optional<Score> getScore(Long scoreId);
	
	public void addPlayer(Score s);
	
	 public void deletePlayer(Long scoreId);
	 
	 public void updatePlayer(Score newScoreData, Long scoreId);
	 
	 public Optional<Score> getMatchScore(Long matchId);

}
