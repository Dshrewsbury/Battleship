import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Scanner;

/**
 * Battleship GUI Main
 * @author Michael
 * @author Brock
 */
public class Battleship
{
	private static Player _player1;
	private static Player _player2;

   public static void main(String[] args)
   {
      // KIRSTEN/NOAH
      // Create two players, call initialize grid for both of them
	  Scanner in = new Scanner(System.in);
	  
	  // How much error trapping do we want for names?
	  
	  // Create the first player with the inputted name
	  System.out.println("Player 1: Enter your name ");
	  _player1 = new Player(in.next());
	  
	  
	  //Create the second player with the inputted name
	  System.out.println("Player 2: Enter your name ");
	  _player2 = new Player(in.next());
	  
	  
	  // Initializing both player's grids, starting with player 1
	  _player1.initializeGrid();
	  _player2.initializeGrid();
	  
	  // Display player 1's GUI
	  
	  
	  // After a valid move, display player 2's GUI, so valid move needs close the GUI?

      // In while loop have each player take a turn until one has won
	  while (!_player1.checkForVictory() && !_player2.checkForVictory())
	  {
		 
	  }
   }

}
