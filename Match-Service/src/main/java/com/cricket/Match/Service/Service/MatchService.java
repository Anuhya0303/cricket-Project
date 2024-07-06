package com.cricket.Match.Service.Service;

import java.util.List;

import com.cricket.Match.Service.Entity.Match;

public interface MatchService {
	public Match createMatch(Match match) ;
	
	public List<Match> getAllMatches() ;
	
	public Match getMatchById(Long matchId) ;
	
	public void deleteMatch(Long matchId) ;
	
	public Match updateMatch(Match updatedMatch) ;
	
	public Match retrieveMatch(Long matchId) ;

}
