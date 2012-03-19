package gabong;

import java.util.ArrayList;

// The rules of the game (and therein the card logic) can be found at: http://org.ntnu.no/ntnugabong/docs/regelhefte.pdf

public final class CardLogic {

	static ArrayList<Card> legalCards = new ArrayList<Card>();
	final static String SUITS[] = {"S", "H", "D", "C"};	// There are four suits in a deck of cards.
	
	public static void playCard (Round r, Card c) {
		String suit = c.getSuit();	
		int face = c.getFace();
		
		// Gets the needed variables from the round, to make the code easier.
		ArrayList<Player> players = r.getPlayers();
		Player nextPlayer = r.getNextPlayer();
		int nextPlayerIndex = players.indexOf(nextPlayer);
		Player gabongmester = r.getGabongmester();
		int direction = r.getDirection();
		
		
		if (face == 1) {	// The ace does nothing special.
			nextPlayer = players.get(nextPlayerIndex+direction);
			playRegularCard(suit, face);
		}
		else if (face == 2) {	// If a 2 is played, the next player has to play a 2 of any suit.
			nextPlayer = players.get(nextPlayerIndex+direction);
			playTwo();
		}
		else if (face == 3) {	// A 3 skips the next player, but that player can still play a 6 of any suit.
			nextPlayer = players.get(nextPlayerIndex+2*direction);
			playRegularCard(suit, face);
		}
		else if (face == 4) {	// A 4 does nothing special. At all. In any way.
			nextPlayer = players.get(nextPlayerIndex+direction);
			playRegularCard(suit, face);
		}
		else if (face == 5) {	// If a 5 is played, the turn goes to the Master.
			nextPlayer = gabongmester;
			playRegularCard(suit, face);
		}
		else if (face == 6) {	// A 6 can be played if you are skipped by a 3. Otherwise it's a regular card.
			nextPlayer = players.get(nextPlayerIndex+direction);
			playRegularCard(suit, face);
		}
		else if (face == 7) {	// You can't play a 7 of a different suit when a 7 is played. Other than that, it's a regular card.
			nextPlayer = players.get(nextPlayerIndex+direction);
			playSeven(suit);
		}
		else if (face == 8) {	// With an 8, you can switch suits. If no suit is selected, the new suit is the suit of the 8.
			nextPlayer = players.get(nextPlayerIndex+direction);
			playRegularCard(suit, face);
		}
		else if (face == 9) {	// A 9 does nothing special in-game.
			nextPlayer = players.get(nextPlayerIndex+direction);
			playRegularCard(suit, face);
		}
		else if (face == 10) {	// 10 is its own suit, and must be switched to and from by an 8.
			nextPlayer = players.get(nextPlayerIndex+direction);
			playTen();
		}
		else if (face == 11) {	// The Jack moves the turn to the next player, and then changes the direction. Otherwise a regular card. 
			nextPlayer = players.get(nextPlayerIndex+direction);
			direction = direction*(-1);
			playRegularCard(suit, face);
		}
		else if (face == 12) {	// The Queen gives the turn to the previous player and then continues as normal. Regular cards when it comes to suits and faces.
			nextPlayer = players.get(nextPlayerIndex-direction);
			playRegularCard(suit, face);
		}
		else if (face == 13) {	// The King changes the direction. Regular card.
			direction = direction*(-1);
			nextPlayer = players.get(nextPlayerIndex+direction);
			playRegularCard(suit, face);
		}
		
		r.setNextPlayer(nextPlayer);
		r.setDirection(direction);
	}

	public static void playRegularCard(String suit, int face) {
		legalCards.removeAll(legalCards);
		for (int i = 1; i < 14; i++) {
			legalCards.add(new Card(suit, i));
		}
		
		for (int i = 0; i < 4; i++) {
			if (suit.equals(SUITS[i])) {
				continue;
			}
			legalCards.add(new Card(SUITS[i], face));
		}
	}
	
	public static void playTwo() {
		legalCards.removeAll(legalCards);
		for (int i = 0; i < 4; i++) {
			legalCards.add(new Card(SUITS[i], 2));
		}
	}
	
	public static void playSeven(String suit) {
		legalCards.removeAll(legalCards);
		for (int i = 1; i < 14; i++) {
			legalCards.add(new Card(suit, i));
		}
	}
	
	public static void playTen() {
		legalCards.removeAll(legalCards);
		for (int i = 0; i < 4; i++) {
			legalCards.add(new Card(SUITS[i], 8));
			legalCards.add(new Card(SUITS[i], 10));
		}
	} 
}
