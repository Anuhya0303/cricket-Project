package com.cricket.Match.Service.Entity;




import jakarta.persistence.Entity;



import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;


@Entity
@Table(name="Player")
public class Player {
	 
	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long playerId;
	    private String name;
	    private String role;
	    private String age;
	    private Long scoreId;
	    
	 

	   

		public Long getScoreId() {
			return scoreId;
		}

		public void setScoreId(Long scoreId) {
			this.scoreId = scoreId;
		}

		public Player() {
			
		}
	    
	    public Player(Long playerId, String name, String role, String age,Long scoreId) {
			super();
			this.playerId = playerId;
			this.name = name;
			this.role = role;
			this.age = age;
			this.scoreId=scoreId;
		}

		public Long getPlayerId() {
			return playerId;
		}

		public void setPlayerId(Long playerId) {
			this.playerId = playerId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}
	   

		

}
