package gabong;

import java.util.ArrayList;

public class Game {

	private ArrayList<Player> players;
	private ArrayList<Round> rounds;
	
	private Player gabongmester;
	
	private boolean gameOver;
	
	public Game(int numberOfPlayers) {
		this.players = new ArrayList<Player>();
		this.rounds = new ArrayList<Round>();
				
		for (int i = 0; i < numberOfPlayers; i++) {
			Player p = new Player("Player"+(i+1));
			players.add(p);
		}
		
		int randomPlayer = (int) (Math.random()*players.size());
		setGabongmester(players.get(randomPlayer));
		
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public ArrayList<Round> getRounds() {
		return rounds;
	}

	public Player getGabongmester() {
		return gabongmester;
	}

	public void setGabongmester(Player gabongmester) {
		this.gabongmester = gabongmester;
	}

	public boolean isGameOver() {
		return gameOver;
	}
	
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

//	public void addPlayers(ArrayList<Player> players, int numberOfPlayers) {
//		for (int i = 0; i < numberOfPlayers; i++) {
//			players.add(new Player());
//		}
//	}
}
