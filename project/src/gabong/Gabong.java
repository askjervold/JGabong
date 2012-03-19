package gabong;

import java.util.ArrayList;

public class Gabong {

	public static void main(String args[]) {
	
		// The following are merely tests to make sure everything is working as intended.
	
		Deck deck = new Deck(6);
		deck.shuffleDeck();
//		
//		printDeck(deck);	// This loop prints out a shuffled deck.
//		System.out.println("\n");
//	
		Game gabong = new Game(6);
		
		ArrayList<Player> players = gabong.getPlayers();
		deck.deal(players);
//		
//		printHandsV(players);	// This loop prints out the cards that were dealt at the beginning, each player's hand vertically.
//		System.out.println();
//		
//		printDeck(deck);	// This loop prints out the deck after cards have been dealt.
//		System.out.println("\n");
//
//		printDeck(deck);	// This loop prints out what's left in the deck.
//		System.out.println("\n");
//		
//		printStack(deck);	// This loop prints out the stack.
//		System.out.println("\n");
//
//		for (Player p : players) {	// This loop draws one card for each player.
//			p.draw(deck);
//		}
//		
//		drawAllCards(deck, players);	// This loop draws all the cards in the deck successively.
//		
//		printHandsH(players);	// This loop prints out the players' hands horizontally.
//		System.out.println();
//		
//		printDeck(deck);	// This loop prints out what's left in the deck.
//		
//		allPlayersPlayACard(deck, players);	// All the players play the first card in their hands.
//		
//		Player p = players.get(2);
//		playAllCardsInHand(deck, p);	// This loop plays all the cards from player p's hand.
//		
//		printStack(deck);
//		System.out.println("\n");
//		
//		printHandsH(players);
//		System.out.println();
//		
//		deck.refillDeck();
//		
//		printStack(deck);
//		System.out.println("\n");
//		
//		printDeck(deck);
		
//		getPlayer(gabong, 0).draw(deck);
//		System.out.println(getPlayer(gabong, 0).getHand().get(getPlayer(gabong, 0).getHand().size()-1).getOwner());	// Prints the owner of the last card in the players hand.

		printPlayerHand(getPlayer(gabong, 0));	// These three lines test whether the sortHand-method works as intended.
		getPlayer(gabong, 0).mergesortHand();
		printPlayerHand(getPlayer(gabong, 0));
		
	}

//	**************************************************************************************************************
	
	// The below methods are merely test methods that print out various things so I can more easily test
	// that everything works as intended.
	
	public static void printDeck(Deck deck) {
		for (int i = 0; i < deck.getDeck().size(); i++) {	// This loop prints out the deck.
			System.out.print(deck.getDeck().get(i).toString()+" ");
		}
	}
		
	public static void printStack(Deck deck) {
		for (int i = 0; i < deck.getStack().size(); i++) {	// This loop prints out the stack.
			System.out.print(deck.getStack().get(i) + " ");
		}
	}
	
	public static void printHandsH(ArrayList<Player> players) {
		for (Player p : players) {	// This loop prints out the players' hands horizontally.
			for (int i = 0; i < p.getHand().size(); i++) {
				System.out.print(p.getHand().get(i).toString()+" ");
			}
			System.out.println();
		}
	}
	
	public static void printHandsV(ArrayList<Player> players) {
		for (int i = 0; i < 8; i++) {	// This loop prints out the players' hands vertically.
			for (Player p : players) {
				System.out.print(p.getHand().get(i).toString()+" ");
			}
			System.out.println();
		}
	}
	
	public static void printPlayerHand(Player p) {	// Prints the hand of player p.
		for (int i = 0; i < p.getHand().size(); i++) {
			System.out.print(p.getHand().get(i).toString()+" ");
		}
		System.out.println();
	}
	
	public static void drawAllCards(Deck deck, ArrayList<Player> players) {	// This loop draws all the cards in the deck successively.
		while (deck.getDeck().size() > 0) {
			for (Player p : players) {
				if (deck.getDeck().size() > 0) p.draw(deck);
			}
		}
	}
	
	public static void allPlayersPlayACard(Deck deck, ArrayList<Player> players) {	// This loop plays the first card in every players hand.
		for (Player p : players) {
			p.playCard(deck, p.getHand().get(0));
		}
	}
	
	public static void playAllCardsInHand(Deck deck, Player p) {	// This loop plays all the cards in player p's hand.
		ArrayList<Card> hand = p.getHand();
		
		while (hand.size() > 0) {
			p.playCard(deck, hand.get(hand.size()-1));
		}
	}
	
	public static Player getPlayer(Game g, int p) {	// This method returns player p from the game g.  
		return g.getPlayers().get(p);
	}

}
