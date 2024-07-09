package com.cricket.Player.Service.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cricket.Player.Service.Entity.Player;
import com.cricket.Player.Service.Service.PlayerServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController

public class PlayerController {
	
	
	    @Autowired
	    private PlayerServiceImpl playerService;

	    /*retriveing all players
	       adding description to get method and grouping get tags*/
	    @Tag
	    (name = "get",description="get methods for player API")
	    @GetMapping("/players")
		public List<Player> getAllPlayers() {
			return playerService.getAllPlayers();
		}
	    /*posting a particular player
	        adding description to post method */
	    @PostMapping("/addPlayer")
		public Player addPlayer(@RequestBody Player p) {
			return playerService.addPlayer(p);
		}

	    /*retriveing a particular player*/
	    @Tag
	    (name = "get",description="get methods for player API")
	    @GetMapping("/player/{playerId}")
	    public Optional<Player> getPlayerById(@PathVariable Long playerId) {
			return playerService.getPlayer(playerId);
		}
	    
	    /*deleting a particular player
	      giveing response codes */
	    @ApiResponses({@ApiResponse(responseCode = "200",
				description = "okay",
				content = {@Content(mediaType = "application/json",
				schema = @Schema(implementation = Player.class))}),
			@ApiResponse(responseCode = "404",
			description = "player data not found",
			content = @Content)})
	    @Operation(summary = "deleting a player",
				description = "deleting a existing player. The response is deleted on player table")

	    /*deleting a particular player*/
	    @DeleteMapping("/playerr/{playerId}")
	    public void deletePlayerById(@PathVariable Long playerId){
	    	 playerService.deletePlayer(playerId);
	    }

	   /*updating a particular player*/
	    @Operation(summary = "updating a player",
				description = "update an existing player. The response is updated on player table")
	    @PutMapping("updatePlayer/{playerId}")
		public void updatePlayer(@RequestBody Player p) {
	    	playerService.updatePlayer(p);
		}

	    /*retriveing data in the form of pages*/
	    @Tag
	    (name = "get",description="get methods for employee API")
	    @GetMapping("/page")
		public  Page<Player> getUserByPage(@RequestParam("pageNo") Optional<Integer> pageNo,
				@RequestParam("sortBy") Optional<String> sortColumn) {
			return playerService.getUserByPage(pageNo,sortColumn);
		}
	    
	  //Searching
	  	@GetMapping("/search")
	  	public ResponseEntity<List<Player>> searchplayer(@RequestParam("query") String query) {
	      List<Player> players = playerService.searchPlayers(query);
	      if (players.isEmpty()) {
	          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(players, HttpStatus.OK);
	  	}

	   
	    
	  
  }
 

	   

