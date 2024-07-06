package com.cricket.Match.Service.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cricket.Match.Service.Entity.Match;
import com.cricket.Match.Service.Repository.MatchRepository;
import com.cricket.Match.Service.Service.MatchService;

public class MatchServiceTest {
	
	@Autowired
	MatchService service;
	@MockBean
	MatchRepository matchRepository;

	@Test
	public void testGetMatchById() {
		when(matchRepository.findById(1L)).thenReturn(prepareMatchData());
		Match match = service.getMatchById(1L);
		assertEquals(1L,match.getmatchId());
		assertEquals("rcb",match.getTeamA());
		
	}

	private Optional<Match> prepareMatchData() {
		 Match m= new Match();
		m.setmatchId((long) 1);
		m.setTeamA("rcb");
		return Optional.of(m);
	}

}
