package com.facebook.sunteam;

/**
 * 
 * @author suresh
 *
 */
public class Bowler {
	private String playerName;
	private String playerJursyNumber;
	private String playerRole;
	private String playerBest;

	public Bowler() {
		// TODO Auto-generated constructor stub
	}
	
	public Bowler(String playerName, String playerJursyNumber, String playerRole, String playerBest) {
		super();
		this.playerName = playerName;
		this.playerJursyNumber = playerJursyNumber;
		this.playerRole = playerRole;
		this.playerBest = playerBest;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerJursyNumber() {
		return playerJursyNumber;
	}

	public void setPlayerJursyNumber(String playerJursyNumber) {
		this.playerJursyNumber = playerJursyNumber;
	}

	public String getPlayerRole() {
		return playerRole;
	}

	public void setPlayerRole(String playerRole) {
		this.playerRole = playerRole;
	}

	public String getPlayerBest() {
		return playerBest;
	}

	public void setPlayerBest(String playerBest) {
		this.playerBest = playerBest;
	}

}
