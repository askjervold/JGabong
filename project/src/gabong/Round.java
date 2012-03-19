package gabong;

import java.util.ArrayList;
import java.util.Stack;

public class Round {
	
	private int direction;
	private Player gabongmester;
	private Player nextPlayer;
	private boolean roundOver;
	private ArrayList<Player> players = new ArrayList<Player>();
	
	ArrayList<Card> legalCards = new ArrayList<Card>();
	
//	ArrayList<String> legalSuits = new ArrayList<String>();
//	ArrayList<Integer> legalFaces = new ArrayList<Integer>();

	
	private Stack<Card> deck;
	
	public Round(Player gabongmester, ArrayList<Player> players) {
		setRoundOver(false);
		
		this.gabongmester = gabongmester;
		this.nextPlayer = this.gabongmester;
		this.players = players;
		direction = 0;
		
		Deck d = new Deck(players.size());
		d.shuffleDeck();
		deck = d.getDeck();
		
		setDeck(d.getDeck());
	}
	
//	private boolean isPlayerDone(Player player) {
//		ArrayList<Card> hand = player.getHand();
//		if (hand.size() == 0) return true;
//		return false;
//	}
	
//	public void thisFaceLegal(int face) {
//		legalFaces.removeAll(legalFaces);
//		legalFaces.add(face);
//	}
//	
//	public void regularCard(String suit) {	// Most cards will allow you to play any card of the same suit.
//		allFacesLegal();
//		thisSuitLegal(suit);
//	}
//	
//	public void thisSuitLegal(String suit) {
//		legalSuits.removeAll(legalSuits);
//		legalSuits.add(suit);
//	}
//	
//	public void allFacesLegal() {
//		legalFaces.removeAll(legalFaces);
//		for (int i = 1; i < 14; i++) {
//			legalFaces.add(i);
//		}
//		legalFaces.remove(9);	// Because 10 is a suit (and is in the 9th spot), it is not allowed when all faces are legal.
//	}
//	
//	public void allSuitsLegal() {
//		legalSuits.removeAll(legalSuits);
//		legalSuits.add("S");
//		legalSuits.add("H");
//		legalSuits.add("D");
//		legalSuits.add("C");
//	}
	
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public Player getGabongmester() {
		return gabongmester;
	}

	public void setGabongmester(Player gabongmester) {
		this.gabongmester = gabongmester;
	}

	public Player getNextPlayer() {
		return nextPlayer;
	}

	public void setNextPlayer(Player nextPlayer) {
		this.nextPlayer = nextPlayer;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	public boolean isRoundOver() {
		return roundOver;
	}

	public void setRoundOver(boolean roundOver) {
		this.roundOver = roundOver;
	}

	public Stack<Card> getDeck() {
		return deck;
	}

	public void setDeck(Stack<Card> deck) {
		this.deck = deck;
	}
}
