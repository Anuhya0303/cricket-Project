package com.cricket.Match.Service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cricket.Match.Service.Entity.Match;
import com.cricket.Match.Service.Service.MatchServiceImpl;

@RestController
public class MatchController {
	
	@Autowired
	    private MatchServiceImpl matchService;
	
	
	    @PostMapping("/addMatch")
	    public Match createMatch(@RequestBody Match match) {
	        return matchService.createMatch(match);
	    }

	    @GetMapping("/getAllMatches")
	    public List<Match> getAllMatches() {
	        return matchService.getAllMatches();
	    }

//	     @GetMapping("/team/{team}")
//	    public List<Match> getMatchesByTeam(@PathVariable String team) {
//	        return matchService.getMatchesByTeam(team);
//	     }
	        
//	        @GetMapping("getMatch/{matchId}")
//	        public List<Match> getMatchById(@PathVariable Long matchId) {
//	            return matchService.getMatchById(matchId);
//	    }

	      @GetMapping("/getMatch/{matchId}")
	      public Match getMatchById(@PathVariable Long matchId) {
	    	  return matchService.getMatchById(matchId);
	      }
	      
	        @PutMapping("updateMatch/{matchId}")
	        public Match updateMatch(@RequestBody Match m){
	        	return matchService.updateMatch(m);
	        }
	        
	        @DeleteMapping("deleteMatch/{matchId}")
	        public void deleteMatch(@PathVariable Long matchId) {
	        	matchService.deleteMatch(matchId);
	        }
	        
	        //rest templateee
	        
	        @GetMapping("/rest/{matchId}")
	    	public Match retriveMatch(@PathVariable Long matchId){
	          return matchService.retrieveMatch(matchId);
	    	}
	        
}
