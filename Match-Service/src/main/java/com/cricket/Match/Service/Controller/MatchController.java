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
	
	    /*adding a match*/
	    @PostMapping("/addMatch")
	    public Match createMatch(@RequestBody Match match) {
	        return matchService.createMatch(match);
	    }
            /*retriveing all matches*/
	    @GetMapping("/getAllMatches")
	    public List<Match> getAllMatches() {
	        return matchService.getAllMatches();
	    }


              /*retriveing match by id*/
	      @GetMapping("/getMatch/{matchId}")
	      public Match getMatchById(@PathVariable Long matchId) {
	    	  return matchService.getMatchById(matchId);
	      }
	      /*updating a particular match*/
	        @PutMapping("updateMatch/{matchId}")
	        public Match updateMatch(@RequestBody Match m){
	        	return matchService.updateMatch(m);
	        }
	        /*deleting a particular match*/
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
