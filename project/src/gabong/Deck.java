package gabong;

import java.util.ArrayList;
import java.util.Stack;

public class Deck {

	private Stack<Card> stack;	// The stack of cards in play.
	private Stack<Card> deck;	// The deck.
	private Stack<Card> tempStack;	// A temporary stack for when the deck is empty and we flip the stack.
	
	private int numberOfPlayers;
	
	final int CARDS_PER_DECK = 52;	// There are 52 cards in a regular card deck.
	final String SUITS[] = {"S", "H", "D", "C"};	// There are four suits in a deck of cards.
	final int FACES = CARDS_PER_DECK/SUITS.length;	// There are 13 faces per suit.
	final double DECKS_PER_PLAYER = 0.5;	// For each two players, another standard deck is added.
	final int CARDS_PER_PLAYER = 8;	// Each player starts with 8 cards.
	
	public Deck(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
		stack = new Stack<Card>();
		deck = new Stack<Card>();
		tempStack = new Stack<Card>();
		for (int i = 0; i < (int) (this.numberOfPlayers*DECKS_PER_PLAYER); i++) {	// Each iteration adds a standard deck.
			for (int j = 0; j < SUITS.length; j++) {	// Each iteration cycles a suit.
				for (int k = 1; k < FACES+1; k++) {	// Each iteration adds a card of suit j, face k.
					Card c = new Card(SUITS[j], k);
					deck.push(c);
				}
			}
		}
	}

	public void shuffleDeck() {	// Not an ideal way of shuffling, but it works.

		String shuffler[] = new String[deck.size()];	// Creates a temporary array used for shuffling with 52 slots per deck, with one deck per two players.
//		int shuffled[] = new int[((int) (numberOfPlayers*DECKS_PER_PLAYER))*CARDS_PER_DECK];	// An array to save time by tracking which spaces are already filled in the shuffler-array.
		int randomPlace = (int) (Math.random()*shuffler.length);	// Sets a random spot in the array to place the first card.
		
		for (int i = 0; i < shuffler.length; i++) {
	
			while (shuffler[randomPlace] != null) {	// Checks if this spot is empty. If it isn't, a new random spot will be chosen.
				randomPlace = (int) (Math.random()*shuffler.length);
			}
			
			shuffler[randomPlace] = deck.pop().toString();	// Places the card in the selected random spot.
		
//		for (int i = 0, k = 0; i < shuffler.length; i++) {
//			
//			if (shuffled[randomPlace] != 0) {
//				if ((randomPlace + shuffled[i]) < shuffler.length) {
//					k = i;
//					while (randomPlace + k < shuffler.length) {
//						k++;
//					}
//				}
//		
//			}
//			
//			shuffler[randomPlace] = deck.pop().toString();	// Places the card in the selected random spot.
//			shuffled[randomPlace] = 1;	// Marks the spot as full.
//			randomPlace = (int) (Math.random()*shuffler.length); 
		}
		
		for (int i = 0; i < shuffler.length; i++) {
			Card c = new Card(""+shuffler[i].charAt(0), Integer.parseInt(""+shuffler[i].charAt(1), 16));	// Creates cards in the shuffled deck based on the strings in the shuffler.
			deck.push(c);
		}
	}
	
	public void deal(ArrayList<Player> players) {
		for (int i = 0; i < CARDS_PER_PLAYER; i++) {
			for (Player p : players) {
				p.getHand().add(deck.pop());
				p.getHand().get(i).setOwner(p);
			}
		}
		stack.push(deck.pop());
	}

	public void refillDeck() {
		tempStack.push(stack.pop());
		int s = stack.size();
		for (int i = 0; i < s; i++) {
			deck.push(stack.pop());
			deck.get(i).setOwner(null);
		}
		shuffleDeck();
		stack.push(tempStack.pop());
	}
	
	public Card popDeck() {
		return deck.pop();
	}
	
	public void playCard(Card card) {
		stack.push(card);
	}
	
	public Stack<Card> getStack() {
		return stack;
	}

	public Stack<Card> getDeck() {
		return deck;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

}
