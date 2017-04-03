package project4;

import java.util.Scanner;
/**
 *<b>Title:</b> Program 4<br>
 *<b>Filename:</b> GoFish.java<br>
 *<b>Date Written:</b> December 14, 2015<br>
 *<b>Due Date:</b> December 22nd, 2015<br>
 * <p>Description: The GoFish class implements the player, hand, deck, card, and GOFishCard class to implement the card Game
 * GoldFish. There are two players, 1st player is the user, second is the computer. Each player takes a turn asking for a specific
 * card. The Game continues until either player or the deck runs out of cards. The winner is whom had the most Books after the game is over <p>
 * @author Brian Jordan
 */
public class GoFish extends java.lang.Object{

	public GoFish(){
		
	}
	
	public void playGame(){
		Deck deck = new Deck(); //creates a deck of regular playing cards
		deck.initialize(); 
		Scanner scan = new Scanner(System.in); //used to have user input a name
		String name = "";
		System.out.println("Game Rules for GoldFish\nAim to get four of a kind of each card to gain a point\nIf the computer does not have your card you will auto draw a card\nSelect the card you want by inserting the specific number"
				+ "\nKings = 13, Queens = 12, Jacks = 11, Aces = 1\nExample if you would want to ask for a queen insert \"12\"\nIf you want to ask for a 7, insert \"7\" ");
		System.out.println("Player 1, Enter Your Name: ");
		name = scan.nextLine(); 
		Player player1 = new Player(name); //creates a player for user
		Player computer = new Player("Computer"); //creates a player for computer
		//shuffles deck and deals 7 cards to each player
		deck.shuffle();
		for(int i = 0; i < 7; i++){
			player1.addCard((GoFishCard)deck.deal());
			computer.addCard((GoFishCard)deck.deal());
		} 
		int round = 1; //used to keep track of round
		int choice = 0; //used to keep track of players choice
	
		while(player1.getTotalCards() > 0 && computer.getTotalCards() > 0 && !deck.isEmpty()){
			System.out.println("----------------------------------------");
			System.out.println("Round " + round++);
			
			//player 1's turn
			System.out.println(player1);
			try {
				while (choice < 1 || choice > 13 || !player1.hasRank(choice)){
					System.out.println("Which Card would you like to ask for?");
					choice = scan.nextInt();
					if (!player1.hasRank(choice))
						System.out.println("Sorry but you do not have that card");
				}
				if (computer.hasRank(choice)){
					System.out.println(computer.getName() + ": Yes");
					player1.addCards(computer.getCards(choice));
				}
				else {
					System.out.println(computer.getName() + ": No, Go Fish");
					player1.addCard((GoFishCard)deck.deal());
				}
				if (player1.getCards().evalutae() == 1)
					player1.addPoint();
				System.out.println(player1 + "\n----------------------------------------");
			} catch (Exception e) {
				
					e.printStackTrace();
				}
				//
				//Computer's turn
				System.out.println(computer);
				choice = 0;
			try{
				while (choice < 1 || choice > 13 || !computer.hasRank(choice)){
					choice = (int) (Math.random()*(13-1));
				}
				System.out.println("Got Any " + choice + "'s?");
				if (player1.hasRank(choice)){
					System.out.println(player1.getName() + ": Yes");
					computer.addCards(player1.getCards(choice));
				}
				else {
					System.out.println(player1.getName() + ": No, Go Fish");				
					computer.addCard((GoFishCard)deck.deal());
					}
				if (computer.getCards().evalutae() == 1)
					computer.addPoint();
				System.out.println(computer + "\n----------------------------------------");
				choice = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	scan.close();
	//prints winner
	if (player1.getPoints() > computer.getPoints()){
		System.out.println(player1.getName() + "WINS!");
	} else if (player1.getPoints() < computer.getPoints()){
		System.out.println(computer.getName() + "WINS!");
	} else if(player1.getPoints() == computer.getPoints()){
		System.out.println("It's a Tie!");
	}
		// END OF METHOD
		//Testing various test methods
		
		//GoFish game = new GoFish();
		//game.playGame();
		
		/*
		Card card1 = new Card(7,2);
		Card card2 = new Card(6,2);
		System.out.println(card1.getSuitAsString());
		System.out.println(card1);
		System.out.println(card2);
		System.out.println(card1.compareByRank(card2));
		System.out.println(card1.compareByRank(card1));
		System.out.println(card2.compareByRank(card1));
		Deck deck = new Deck();
		deck.initialize();
		System.out.println(deck);
		Hand hand3 = new Hand();
		//testing evaluate method
		while (!deck.isEmpty()){
			hand1.insertByRank((GoFishCard)deck.deal());
		}
		System.out.println(hand1);
		System.out.println(hand1.evaluate());
		System.out.println(hand1);
		System.out.println(hand1.evaluate());
		System.out.println(hand1);
		GoFishCard go1 = new GoFishCard();
		GoFishCard go2 = new GoFishCard();
		GoFishCard go3 = new GoFishCard();
		GoFishCard go4 = new GoFishCard();
		GoFishCard go5 = new GoFishCard();
		GoFishCard go6 = new GoFishCard();
		GoFishCard[] k = {go1, go2, go3, go4, go5, go6};
		while (!deck.isEmpty()){
			hand3.insertByRank((GoFishCard)deck.deal());
			
		}
		//hand3.insertByRank(go1);
		//hand3.insertByRank(go2);
		//hand3.insertByRank(go3);
		//hand3.insertByRank(go4);
		//hand3.insertByRank(go5);
		//hand3.insertByRank(go6);
		//testing toString and get size
		System.out.println("\n\nStart" + hand3 + "  size = " + hand3.getCount());
		//testing insert at specific positon
		/*try {
			System.out.println("\n\n" + hand3.getCardAt(4));
		} catch (Exception e) {
			e.printStackTrace();
		}
		//testing hasRank
		if (hand3.hasRank(11))
			System.out.println("it worked");
		else 
			System.out.println("still works");
		//testing countRank
		try {
			System.out.println("Number of : " + hand3.countRank(2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//testing findRank
		java.util.LinkedList<GoFishCard> rank2Hand = hand3.findRank(2);
		System.out.println(rank2Hand);
		//testing book
		System.out.println(hand3.evalutae());
		*/
	}
}
