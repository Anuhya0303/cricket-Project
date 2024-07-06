package com.cricket.Score.Service.Service;






import java.util.List;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.cricket.Score.Service.Entity.Score;
import com.cricket.Score.Service.Repository.ScoreRepository;

@Service
public class ScoreServiceImpl implements ScoreService{
	
	 @Autowired
	    private ScoreRepository scoreRepository;
	 
	
	 public Optional<Score> getScore(Long scoreId) {
			return scoreRepository.findById(scoreId);
		}

	 public void addPlayer(Score s) {
			// TODO Auto-generated method stub
			scoreRepository.save(s);
		}
	 public void deletePlayer(Long scoreId) {
			scoreRepository.deleteById(scoreId);
		}
	
	// public void updatePlayer(Score score, Long scoreId) {
		//	scoreRepository.save(score);
	//	}
	 
	 public void updatePlayer(Score newScoreData, Long scoreId) {
	        
	        Score existingScore = scoreRepository.findById(scoreId)
	            .orElseThrow(() -> new IllegalArgumentException("Score not found with id " + scoreId));
	        existingScore.setWickets(newScoreData.getWickets());
	        scoreRepository.save(existingScore);
	    }
    //rest
	public Optional<Score> getMatchScore(Long matchId) {
		// TODO Auto-generated method stub
		return scoreRepository.findByMatchId(matchId);
	}
	 
}
