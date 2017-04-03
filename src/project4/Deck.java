package project4;
import java.util.ArrayList;
import java.util.Collections;
/**
 *<b>Title:</b> Program 4<br>
 *<b>Filename:</b> Deck.java<br>
 *<b>Date Written:</b> December 14, 2015<br>
 *<b>Due Date:</b> December 22nd, 2015<br>
 * <p>Description: Creates 52 cards and stores in array list.  <p>
 * @author Brian Jordan
 */
public class Deck {
	public static final int CARDS_IN_DECK = 26; // I changed this because when it was at 52 it was creating 104 cards(Two Decks)Brian
	private ArrayList<Card> cards = new ArrayList<Card>();
	public Deck() {
		cards.ensureCapacity(CARDS_IN_DECK);
		initialize();
	}
	public void initialize(){
		for(int i = 0;i < CARDS_IN_DECK; i++) {
			try {
				cards.add(new GoFishCard(i));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public String toString(){
		return "No. of cards: " + cards.size() +"\n" + cards.toString();
	}
	public void shuffle() { Collections.shuffle(cards); }
	
	public Card deal() {
		if(!cards.isEmpty())
			return cards.remove(0);
		return null;
	}
	public boolean isEmpty(){ return cards.isEmpty(); }
}