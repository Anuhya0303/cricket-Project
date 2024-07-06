package com.cricket.Player.Service.Service;

import java.util.ArrayList;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;


import com.cricket.Player.Service.Entity.Player;

import com.cricket.Player.Service.Repository.PlayerRepository;


@Service
public class PlayerServiceImpl implements PlayerService{
	
	 
	
	@Autowired
    private PlayerRepository playerRepository;

	public List<Player> getAllPlayers() {
		List<Player> playersList = new ArrayList<>();
		playerRepository.findAll().forEach(playersList::add);
		return playersList;
		
	}

	public Player addPlayer(Player p) {
		return playerRepository.save(p);
	}

	public Optional<Player> getPlayer(long playerId) {
		return	playerRepository.findById(playerId);
		
	}

	public void deletePlayer(long playerId) {
		playerRepository.deleteById(playerId);
	}

	public void updatePlayer(Player p) {
		playerRepository.save(p);
		
	}

	public Page<Player> getUserByPage(Optional<Integer> pageNo, Optional<String> sortColumn) {
		return playerRepository.findAll(PageRequest.of(pageNo.orElse(0),2,Direction.DESC,sortColumn.orElse("playerId")));
	}

//	public List<Player> searchPlayers(String query) {
//		// TODO Auto-generated method stub
//		return playerRepository.searchPlayer1(query).stream()
//				.collect(Collectors.toList());
//	}
	public List<Player> searchPlayers(String query) {
        return playerRepository.searchPlayer1(query).stream()
                .collect(Collectors.toList());
    }
	

	

	
	
}
	

    

