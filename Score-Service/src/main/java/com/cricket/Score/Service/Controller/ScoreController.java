package com.cricket.Score.Service.Controller;







import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.cricket.Score.Service.Entity.Player;
import com.cricket.Score.Service.Entity.Score;
import com.cricket.Score.Service.Entity.UserScore;
import com.cricket.Score.Service.Service.ScoreServiceImpl;

@RestController
public class ScoreController {
	
	@Autowired
	ScoreServiceImpl scoreService;

	/*retriveing a particular player score*/
	@GetMapping("/player/{id}/score/{scoreId}")
	public Optional<Score> getScore(@PathVariable Long scoreId) {
		return scoreService.getScore(scoreId);
	}
	
	/*posting score to particular player*/
	@PostMapping("/player/{id}/score")
	public void addscore(@RequestBody Score score,@PathVariable Long id) {
		score.setPlayer(new Player(id,"","","",null));
		scoreService.addPlayer(score);
	}

	/*deleting score of particular player score*/
	@DeleteMapping("/player/{playerId}/score/{scoreId}")
	public void deletePlayer(@PathVariable Long id) {
		scoreService.deletePlayer(id);
	}
	/*updating a score of particular player*/
	@PutMapping("/player/{playerId}/score/{scoreId}")
	public void updatePlayer(@RequestBody Score score,@PathVariable Long scoreId ) {
		scoreService.updatePlayer(score,scoreId);
	}
	
	//restTemplate 
	@GetMapping("/scores/rest/{matchId}")
    public Optional<Score> getMatchScore(@PathVariable Long matchId) {
    	return scoreService.getMatchScore(matchId);
    	
    	
    	
		
    	
    }
}
