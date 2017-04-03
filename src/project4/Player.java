package project4;
/**
 *<b>Title:</b> Program 4<br>
 *<b>Filename:</b> Player.java<br>
 *<b>Date Written:</b> December 14, 2015<br>
 *<b>Due Date:</b> December 22nd, 2015<br>
 * <p>Description: The player class implements a hand, points and name. The player class creates an empty hand of GoldFish cards, points set
 * to zero and needs a name to assigned when instantiated <p>
 * @author Brian Jordan
 */
public class Player {
	
	private Hand hand; //hand of cards for the player
	private java.lang.String name; // name of player
	private int points; //points for player

	public Player(java.lang.String n){
		name = n;
		points = 0;
		hand = new Hand();
	}
	/**
	 * addCard Adds a card to the hand
	 * @param card
	 */
	public void addCard(GoFishCard card){
		hand.insertByRank(card);
	}
	/**
	 * addCards Adds a LinkList of Cards to the hand
	 * @param otherHand
	 */
	public void addCards(java.util.LinkedList<GoFishCard> otherHand){
		hand.insertHandinsertHand(otherHand);
	}
	/**
	 * getCard Returns the cards of a specified rank as a LinknedList
	 * @param rank
	 * @return
	 */
	public java.util.LinkedList<GoFishCard> getCard(int rank) throws Exception{
		if (rank < 0 || rank > 13)
			throw new Exception("Int Rank is out of range");
		java.util.LinkedList<GoFishCard> temp = hand.findRank(rank);
		return temp;
	}
	/**
	 * getCardAt returns the card at a specified index in the hand
	 * @param index
	 * @return
	 */
	public GoFishCard getCardAt(int index) throws Exception{
		if (index < 0 || index >= hand.getCount())
			throw new Exception("The index is out of range");
		GoFishCard temp = hand.getCardAt(index);
		return temp;
	}
	
	public Hand getCards(){
			return hand;
		}
	/**
	 * Returns all of the cards of the specified rank as a LinkedList
	 * @param Rank
	 * @return
	 */
	public java.util.LinkedList<GoFishCard> getCards(int rank) throws Exception{
		if (rank < 0 || rank > 13)
			throw new Exception("Int Rank is out of range");
		return hand.findRank(rank);
	}
	/**
	 * getName returns the player's name
	 * @return
	 */
	public java.lang.String getName() {
		return name;
	}
	/**
	 * getPoints returns the number of books the player has
	 * @return
	 */
	public int getPoints() {
		return points;
	}
	/**
	 * getTotalCards Returns the number of cards the player has
	 * @return
	 */
	public int getTotalCards(){
		return hand.getCount();
	}
	/**
	 * hasRank returns true if the player has a specified rank
	 * @param rank
	 * @return
	 * @throws Exception
	 */
	public boolean hasRank(int rank) throws Exception{
		if (rank < 0 || rank > 13)
			throw new Exception("Int Rank is out of range");
		return hand.hasRank(rank);
	}
	/**
	 * setHand Sets hand
	 * @param hand
	 */
	public void setHand(Hand hand){
		this.hand = hand;
	}
	public void addPoint(){
		points++;
	}
	/**
	 * SetName sets the name
	 * @param name
	 */
	public void setName(java.lang.String name) {
		this.name = name;
	}
	/**
	 * showHand Returns the string representation of the hand
	 * @return
	 */
	public java.lang.String showHand(){
		String str = name + "'s Hand:\n" + hand.toString();
		return str;
	}
	/**
	 * Returns the String representation of the player
	 */
	public java.lang.String toString(){
		String str = "Player: " + name + "\nScore: " + points + "\nCurrent Hand: ";
		if (hand.isEmpty())
			str += "Hand is empty";
		else str += hand.toString();
		return str;
	}

}
