package project4;
/**
 *<b>Title:</b> Program 4<br>
 *<b>Filename:</b> Card.java<br>
 *<b>Date Written:</b> December 14, 2015<br>
 *<b>Due Date:</b> December 22nd, 2015<br>
 * <p>Description: Creates a card object.  <p>
 * @author Brian Jordan
 */
public class Card extends java.lang.Object {
	private int rank; //an integer between 0 - 12 representing the card's rank
	private int suit; // an integer between 0 - 3 representing the card's suit
	
	/**
	 * Default constructor which randomly assigns numbers to rank and suit
	 */
	public Card(){
		rank = (int) (Math.random()*(13-1));
		suit = (int) (Math.random()*4);
	}
	/**
	 * Card()
	 * @param n rank and suit based on the number received. (Range of N: 0 <= n >= 51)
	 */
	public Card(int n)throws Exception{
		if (n < 0 || n >51)
			throw new Exception("Card is out of range");
		 rank = n % 13;
	        if (rank == 0)
	            rank = 13;
	        suit = n / 13;
	    }
	
	/**
	 * Card()
	 * @param r represents the rank of the card
	 * @param s represents the suit of the card
	 */
	Card(int r, int s){
		rank = r;
		suit = s;
	}
	/**
	 * compareByRank compares card based on rank, returns -1 if lower, returns 0 if equal and 1 if greater
	 * @param otherCard
	 * @return
	 */
	public int compareByRank(Card otherCard){
		int num = 0;
		if (this.rank == otherCard.rank)
			num = 0;
		else if (this.rank > otherCard.rank)
			num = 1;
		else if (this.rank < otherCard.rank)
			num = -1;
		return num;
	}
	/**
	 * compareBySuit compares card based on suit, returns -1 if lower, returns 0 if equal and 1 if greater
	 * @param otherCard
	 * @return
	 */
	public int compareBySuit(Card otherCard){
		int num = 0;
		if (this.suit == otherCard.suit)
			num = 0;
		else if (this.suit > otherCard.suit)
			num = 1;
		else if (this.suit < otherCard.suit)
			num = -1;
		return num;
	}
	/**
	 * equals() returns true if two cards are equal
	 * @param OtherCard
	 * @return
	 */
	public boolean equals(Card OtherCard){
		return (this.equals(OtherCard));
	}
	/**
	 * getRank() returns the rank of card
	 * @return
	 */
	public int getRank() {
		return rank;
	}
	/**
	 * setRank() changes rank
	 * @param rank
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}
	/**
	 * getSuit() returns suit of card
	 * @return
	 */
	public int getSuit() {
		return suit;
	}
	/**
	 * setSuit() changes suit of current card
	 * @param suit
	 */
	public void setSuit(int suit) throws Exception{
		if (suit < 0 || suit > 3)
			throw new Exception();
		this.suit = suit;
	}
	/**
	 * getSuitAsString() returns suit as a string
	 * @return
	 */
	public String getSuitAsString(){
		String str = "";
		if (suit == 0)
			str = new String("Clubs");
		else if (suit == 1)
			str = new String("Diamonds");
		else if (suit == 2)
			str = new String("Hearts");
		else if (suit == 3)
			str = new String("Spades");
		return str;
	}
	/**
	 * getRankAsString returns rank as a string
	 * @return
	 */
	public String getRankAsString(){
		String str ="";
		if (rank == 1)
            str = "Ace";
        else if (rank == 11)
            str = "Jack";
        else if (rank == 12)
            str = "Queen";
        else if (rank == 13)
            str = "King";
        else
            str = rank + "";
		return str;
	}
	/**
	 * toString()
	 * @return the current state of card as a string
	 */
	public String toString(){
		String str = "";
		str = this.getRankAsString() + " of " + this.getSuitAsString();
		return str;
	}
}