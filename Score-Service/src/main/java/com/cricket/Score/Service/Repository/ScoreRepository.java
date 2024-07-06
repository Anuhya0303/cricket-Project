package com.cricket.Score.Service.Repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cricket.Score.Service.Entity.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long>{

	Optional<Score> findByMatchId(Long matchId);

	

	

	
}
