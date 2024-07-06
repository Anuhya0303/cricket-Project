package com.cricket.Match.Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cricket.Match.Service.Entity.Match;


@Repository
public interface MatchRepository extends JpaRepository<Match, Long>{

	

}
