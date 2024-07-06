package com.cricket.Player.Service.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.cricket.Player.Service.Entity.Player;

public interface PlayerService {
	public List<Player> getAllPlayers();
	
	public Player addPlayer(Player p);
	
	public Optional<Player> getPlayer(long playerId);
	
	public void deletePlayer(long playerId);
	
	public void updatePlayer(Player p);
	
	public Page<Player> getUserByPage(Optional<Integer> pageNo, Optional<String> sortColumn);
	
	public List<Player> searchPlayers(String query) ;

}
