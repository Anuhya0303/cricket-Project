package com.cricket.Player.Service.Repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import com.cricket.Player.Service.Entity.Player;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

//	@Query("SELECT p FROM Player p Where p.name LIKE %:name%")
//	List<Player> searchPlayer1(@Param("query")String name);
	
	
	@Query("SELECT p FROM Player p WHERE p.name ILIKE %:name%")
	List<Player> searchPlayer1(@Param("name") String name);

	
	
}
