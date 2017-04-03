package project4;
/**
 *<b>Title:</b> Program 4<br>
 *<b>Filename:</b> Hand.java<br>
 *<b>Date Written:</b> December 14, 2015<br>
 *<b>Due Date:</b> December 22nd, 2015<br>
 * <p>Description: The hand class implements a linked list of GoFishCard. Cards can be added and removed. <p>
 * @author Brian Jordan
 */
import java.util.Comparator;
import java.util.Iterator;

public class Hand extends java.lang.Object{
	
	java.util.LinkedList<GoFishCard> hand; //linked list of GoldFish Cards
	
	public Hand(){
		hand = new java.util.LinkedList<GoFishCard>();
	}
	/**
	 * Counts the number of cards of a particular rank in the hand
	 * @param rank
	 * @return the total number of one specific rank
	 */
	public int countRank(int rank) throws Exception{
		if (rank < 0 || rank > 13)
			throw new Exception("Int Rank is out of range");
		int count = 0;
		if (hand.size() == 0)
			count = 0;
		else{
			Iterator<GoFishCard> iter = hand.iterator();
        	while (iter.hasNext()) {
        		if (iter.next().getRank() == rank){
        			count++;
        		}
        		System.out.println(count);
        	}
		}
		return count;
	}
	/**
	 * returns 1 if a book(all 4 cards of a particular suit) is in the hand and removes the book from the hand
	 * @return returns 1 if a book is found within the hand
	 */
	public int evalutae(){
		int check = 0;
		Iterator<GoFishCard> iter = hand.iterator();
		GoFishCard temp = new GoFishCard();
		GoFishCard otherTemp = new GoFishCard();
		GoFishCard otherTemp2 = new GoFishCard();
		GoFishCard otherTemp3 = new GoFishCard();
		boolean book = false;
		while (iter.hasNext() && !book){
			temp = iter.next();
			if (iter.hasNext())
				otherTemp = iter.next();
			if(temp.compareByRank(otherTemp) == 0)
				check++;
			if (iter.hasNext())
				otherTemp2 = iter.next();
			if(temp.compareByRank(otherTemp2) == 0)
				check++;
			if (iter.hasNext())
				otherTemp3 = iter.next();
			if(temp.compareByRank(otherTemp3) == 0)
				check++;
			if (check == 3)
				book = true;
			else check = 0;
		}
		if (book == true){
			check = 1;
			java.util.LinkedList<GoFishCard> tempHand = this.findRank(temp.getRank());
			Iterator it = tempHand.iterator();
			System.out.println("Book: " + tempHand);
			while(it.hasNext()){
				hand.remove(it.next());
			}
		}	
		return check;
	}
	/**
	 * Finds and returns all cards of the specified rank
	 * @param rank, card to be searched within hand
	 * @return temp which contains all cards of specific rank
	 */
	public java.util.LinkedList<GoFishCard> findRank(int rank){
		java.util.LinkedList<GoFishCard> temp = new java.util.LinkedList<GoFishCard>();
		Iterator<GoFishCard> iter = hand.iterator();
		GoFishCard tempCard;
		int i = 0;
			while(iter.hasNext()) {
				tempCard = iter.next();
				if(tempCard.getRank() == rank){
					temp.add(tempCard);
					//hand.remove(i);
					iter.remove();
				}
				i++;
			}
		return temp;
	}
	
	/**
	 * Returns the card at the specified position in this list
	 * @param index
	 * @return a card at a specific position
	 */
	public GoFishCard getCardAt(int index) throws Exception{
		if (index < 0 || index >= hand.size())
			throw new Exception("The index is out of range");
		return hand.get(index);
		
	}
	/**
	 * Returns a list of cards of a specified rank
	 * @param rank
	 * @return returns a list of card of specific rank
	 */
	public java.util.LinkedList<GoFishCard> getCards(int rank){
		java.util.LinkedList<GoFishCard> temp = new java.util.LinkedList<GoFishCard>();
		Iterator<GoFishCard> iter = hand.iterator();
		GoFishCard tempCard;
			while(iter.hasNext()) {
				tempCard = iter.next();
				if(tempCard.getRank() == rank){
					temp.add(tempCard);
					iter.remove();
				}
			}
		return temp;
	}
	/**
	 * Returns the number of cards in the hand
	 * @return the size of the list
	 */
	public int getCount(){
		return hand.size();
	}
	/**
	 * Returns the hand as a LinkedList of GOFish cards
	 * @return returns the entire hand
	 */
	public java.util.LinkedList<GoFishCard> getHand(){
		return hand;
	}
	/**
	 * Returns true if the rank is in the hand
	 * @param rank
	 * @return searches for a specific rank within the hand. Returns true if card is found
	 */
	public boolean hasRank(int rank) throws Exception{
		if (rank < 0 || rank > 13)
			throw new Exception("Int Rank is out of range");
		boolean test = false;
		if (hand.isEmpty())
			test = false;
		else {
			Iterator<GoFishCard> iter = hand.iterator();
			 while (iter.hasNext() && !test) {
		        	if (iter.next().getRank() == rank)
		        		test = true;
		        }
		}
		return test;
	}
	/**
	 * Adds a card to the hand, the hand is sorted by rank
	 * @param A Goldfish card used to add to class
	 */
	public void insertByRank(GoFishCard card){
		if (hand.isEmpty())
			hand.add(card);
		else {
			Iterator<GoFishCard> iter = hand.iterator();
			int y = 0;
			int i = 0;
			while (iter.hasNext() && y >= 0) {         
			    GoFishCard temp = iter.next();
			    y = card.compareByRank(temp);
			    if(y > 0)
			    	i++;
			}
			 hand.add(i, card);;
		}
	}
	/**
	 * Adds a LinkedList of Cards to the hand, the hand is sorted by rank
	 * @param otherHand 
	 */
	public void insertHandinsertHand(java.util.Collection<? extends GoFishCard> otherHand) {
		Iterator iter = otherHand.iterator();
		GoFishCard temp;
		while (iter.hasNext()){
			temp = (GoFishCard) iter.next();
			hand.add(temp);
		}
	}
	/**
	 * Determines if the hand is Empty
	 * @return true if size == 0
	 */
	public boolean isEmpty(){
		return (hand.isEmpty());
	}
	
	/**
	 * Returns a string representation of the hand
	 */
	public java.lang.String toString(){
		String str = "Cards in the hand: ";
		str += hand.toString();
		return str;
	}
}
