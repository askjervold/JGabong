package gabong;

import java.util.ArrayList;

public class Lulz {

	// The following Merge Sort attempts to check if hand is sorted before it starts the merge sort routine, but it
	// is poorly implemented.
//	public ArrayList<Card> mergesort(ArrayList<Card> cards) {
//		if (cards.size() <= 1) {
//			System.out.println("Hand too small to sort!");
//			return cards;
//		}
//
//		boolean sorted = false;
//		
//		// Checks if the hand is already sorted, in linear time.
//		for (int i = 1; i < cards.size(); i++) {
//			if (cards.get(i).getValue() < cards.get(i-1).getValue()) break;
//			else if ((cards.get(i).getValue() < cards.get(i-1).getValue()) && (i < cards.size()-1)) continue;
//			
//			sorted = true;
//		}
//		
//		if (sorted) {
//			System.out.println("Hand already sorted!");
//			return cards;
//		}
//		
//		else {
//			ArrayList<Card> left = new ArrayList<Card>();
//			ArrayList<Card> right = new ArrayList<Card>();
//			ArrayList<Card> result = new ArrayList<Card>();
//			
//			int middle = (int) (cards.size() / 2);
//			
//			for (int i = 0; i < middle; i++) {
//				left.add(cards.get(i));
//			}
//			for (int i = middle; i < cards.size(); i++) {
//				right.add(cards.get(i));
//			}
//			
//			left = mergesort(left);
//			right = mergesort(right);
//			result = merge(left, right);
//		
//			return result;
//		}
//	}
	
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
	
	
	
//	public void sortHand() {
//	ArrayList<Card> spades = new ArrayList<Card>();
//	ArrayList<Card> hearts = new ArrayList<Card>();
//	ArrayList<Card> clubs = new ArrayList<Card>();
//	ArrayList<Card> diamonds = new ArrayList<Card>();
//	
//	for (Card c : hand) {
//		if (c.getSuit().equals("S")) {
//			spades.add(c);
//		}
//		else if (c.getSuit().equals("H")) {
//			hearts.add(c);
//		}
//		else if (c.getSuit().equals("C")) {
//			clubs.add(c);
//		}
//		else if (c.getSuit().equals("D")) {
//			diamonds.add(c);
//		}
//	}
//	hand.removeAll(hand);
//	
//	sortSuit(spades);
//	sortSuit(hearts);
//	sortSuit(clubs);
//	sortSuit(diamonds);
//	
//	for (Card c : spades) {
//		hand.add(c);
//	}
//	spades.removeAll(spades);
//	for (Card c : hearts) {
//		hand.add(c);
//	}
//	hearts.removeAll(hearts);
//	for (Card c : clubs) {
//		hand.add(c);
//	}
//	clubs.removeAll(clubs);
//	for (Card c : diamonds) {
//		hand.add(c);
//	}
//	diamonds.removeAll(diamonds);
//	
//}
//
//private void sortSuit(ArrayList<Card> suit) {
//	if (suit.size() > 1) {
//		boolean sorted = false;
//		
//		int lowestFace = 14;
//		for (int i = 0; i < suit.size(); i++) {
//			if (suit.get(i).getFace() < lowestFace) lowestFace = suit.get(i).getFace();
//		}
//		while (sorted == false) {
//			for (int i = 0, j = 1; j < suit.size(); i++, j++) {
//				if (suit.get(i).getFace() <= suit.get(j).getFace()) continue;
//				else {
//					Card tempCard = suit.get(i);
//					suit.remove(i);
//					suit.add(j, tempCard);
//				}
//			}
//			
//			if (suit.get(0).getFace() <= lowestFace) sorted = true;
//		}
//		
////		int lowestFace = 14;
////		for (int i = 0; i < suit.size(); i++) {
////			if (suit.get(i).getFace() < lowestFace) lowestFace = suit.get(i).getFace();
////			else if (suit.get(i).getFace() == lowestFace) lowestFace--;
////		}
////		while (sorted == false) {
////			for (int i = 0, j = 1; j < suit.size(); i++, j++) {
////				if (suit.get(i).getFace() > suit.get(j).getFace()) {
////					Card tempCard = suit.get(i);
////					suit.remove(i);
////					suit.add(j, tempCard);
////				}
////			}
////			
////			if (suit.get(0).getFace() <= lowestFace) sorted = true;
////			else if ((lowestFace < suit.get(0).getFace()) && (suit.get(0).getFace() == suit.get(1).getFace())) {
////				sorted = true;
////			}
////		}
//	}
//}
	
}
