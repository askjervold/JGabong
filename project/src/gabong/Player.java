package gabong;

import java.util.ArrayList;

public class Player {

	private String name;
	private ArrayList<Card> hand;
	
	public Player() {
		hand = new ArrayList<Card>();
	}
	
	public Player(String name) {
		this.name = name;
		hand = new ArrayList<Card>();
	}

	public void draw(Deck deck) {
		hand.add(deck.popDeck());
		hand.get(hand.size()-1).setOwner(this);
	}
	
	public void drawForTwos(Deck deck, int numberOfTwos) {
		for (int i = 0; i < numberOfTwos; i++) {
			draw(deck);
			draw(deck);
		}
	}
	
	public void playCard(Deck deck, Card card) {
		deck.playCard(card);
		hand.remove(card);
	}
	
	public void moveCard(int from, int to) {	// This method will allow a player to sort his cards according to taste, by letting him or her move one card at a time manually.
		hand.add(to, hand.get(from));
	}
	
	public void mergesortHand() {
		hand = mergesort(hand);
	}
	
	public ArrayList<Card> mergesort(ArrayList<Card> cards) {
		if (cards.size() <= 1) return cards;
		
		else {
			ArrayList<Card> left = new ArrayList<Card>();
			ArrayList<Card> right = new ArrayList<Card>();
			ArrayList<Card> result = new ArrayList<Card>();
			
			int middle = (int) (cards.size() / 2);
			
			for (int i = 0; i < middle; i++) {
				left.add(cards.get(i));
			}
			for (int i = middle; i < cards.size(); i++) {
				right.add(cards.get(i));
			}
			
			left = mergesort(left);
			right = mergesort(right);
			result = merge(left, right);
		
			return result;
		}
	}
	
	// A method used by the merge sort method.
	public ArrayList<Card> merge(ArrayList<Card> left, ArrayList<Card> right) {
		ArrayList<Card> result = new ArrayList<Card>();
		
		while((left.size() > 0) || (right.size() > 0)) {
			if ((left.size() > 0) && (right.size() > 0)) {
				if (left.get(0).getValue() < right.get(0).getValue()) {
					result.add(left.get(0));
					left.remove(0);
				}
				else {
					result.add(right.get(0));
					right.remove(0);
				}
			}
			else if (left.size() > 0) {
				result.add(left.get(0));
				left.remove(0);
			}
			else if (right.size() > 0) {
				result.add(right.get(0));
				right.remove(0);
			}
		}
		
		return result;
	}
	
	public String getName() {
		return name;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

//	public void addCardToHand(Card c) {
//		hand.add(c);
//	}

	public String toString() {
		return name;
	}

}
