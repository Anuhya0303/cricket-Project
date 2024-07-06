package com.cricket.Match.Service.Service;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cricket.Match.Service.Entity.Match;
import com.cricket.Match.Service.Entity.Player;
import com.cricket.Match.Service.Entity.Score;
import com.cricket.Match.Service.Entity.UserScore;
import com.cricket.Match.Service.Repository.MatchRepository;

@Service
public class MatchServiceImpl implements MatchService{
	
	@Autowired
    private MatchRepository matchRepository;
	
	@Autowired
	  public RestTemplate restTemplate;


	public Match createMatch(Match match) {
        return matchRepository.save(match);
    }
	
	
	//JAVA 8 CONCEPT
//	public List<Match> getMatchesByTeam(String team) {
//        return matchRepository.findAll().stream()
//                .filter(match -> match.getTeamA().equalsIgnoreCase(team) || match.getTeamB().equalsIgnoreCase(team))
//                .collect(Collectors.toList());
//    }
//	public Event getEvent(Long eventId) {
//		return eventRepository.findById(eventId).get();
//	}

	public List<Match> getAllMatches() {
		// TODO Auto-generated method stub
		//return matchRepository.findAll();
		List<Match> matchList=new ArrayList<>();
		matchRepository.findAll().forEach(matchList::add);
		return matchList;
	}



	
	public Match getMatchById(Long matchId) {
		return matchRepository.findById(matchId).orElse(null);
	}
	
	public void deleteMatch(Long matchId) {
		List<Match> matchList=matchRepository.findAll();
		
		Match matchToDelete =  matchList.stream()
				.filter(match -> match.getmatchId().equals(matchId))
				.findFirst()
	    .orElseThrow(() -> new IllegalArgumentException("match with ID" +matchId + "not found"));
	}
	
	public Match updateMatch(Match updatedMatch) {
		List<Match> matches=matchRepository.findAll();
		
		Optional<Match> matchToUpdate = matches.stream()
				                               .filter(match-> match.getmatchId().equals(updatedMatch.getmatchId()))
				                               .findFirst();
		return matchToUpdate.map(match -> {
			match.setDate(updatedMatch.getDate());
			
			
			return matchRepository.save(match);
		}).orElseThrow(() -> new IllegalArgumentException("Match with id" + updatedMatch.getmatchId() + "not found"));
	}
//rest template


	public Match retrieveMatch(Long matchId) {

		
		Match match=matchRepository.findById(matchId).get(); 
		
	 Score score=restTemplate.getForObject("http://localhost:8092/scores/rest/"+matchId,Score.class );
		match.setScore(score);
		
		Player player=restTemplate.getForObject("http://localhost:8090/player/"+match.getPlayerId(), Player.class);
		match.setPlayer(player);
		
		return match;

		
}
}
