package project4;
import java.io.*;
import java.util.*;
/**
 *<b>Title:</b> Program 4<br>
 *<b>Filename:</b> Driver.java<br>
 *<b>Date Written:</b> December 14, 2015<br>
 *<b>Due Date:</b> December 22nd, 2015<br>
 * <p>Description: The Driver contains main and runs the game <p>
 * @author Brian Jordan
 */
public class Driver {
	public static void main(String[] args) throws IOException {
		GoFish game = new GoFish();
		game.playGame();
	}
}
