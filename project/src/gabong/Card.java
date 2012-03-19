package gabong;

public class Card implements Comparable<Card> {

	private int face;
	private String suit;
	private int suitValue;
	private int value;
	private Player owner;
	
	public Card(String suit, int face) {
		this.suit = suit;
		this.face = face;
		
		if (suit.equals("S")) suitValue = 0;
		else if (suit.equals("H")) suitValue = 13;
		else if (suit.equals("C")) suitValue = 26;
		else suitValue = 39;
		
		value = suitValue + face;
	}

	public int getFace() {
		return face;
	}

	public String getSuit() {
		return suit;
	}
	
	public int getSuitValue() {
		return suitValue;
	}

	public int getValue() {
		return value;
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public String toString() {
		return suit + Integer.toHexString(face);
	}
	
	public String ownerName() {
		return owner.toString();
	}
	
	public String toString2() {
		return suit + Integer.toHexString(face) + "(" + owner + ")";
	}

	public int compareTo(Card c) {
		int cValue = c.getSuitValue() + c.getFace();
		
		if (value > cValue) return 1;
		else if (value < cValue) return -1;
		else return 0;
	
	}

}