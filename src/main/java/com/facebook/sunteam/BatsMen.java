package com.facebook.sunteam;
/**
 * 
 * @author sagar
 *
 */
public class BatsMen {

	private String playerName;
	private String playerJursyNumber;
	private String playerRole;

	
	public BatsMen() {
		// TODO Auto-generated constructor stub
	}
	public BatsMen(String playerName, String playerJursyNumber, String playerRole) {
		super();
		this.playerName = playerName;
		this.playerJursyNumber = playerJursyNumber;
		this.playerRole = playerRole;
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

}
