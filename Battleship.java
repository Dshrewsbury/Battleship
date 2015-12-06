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


   public static void main(String[] args)
   {
      // KIRSTEN/NOAH
      // Create two players, call initialize grid for both of them
     int gameover = 0;
	  Scanner in = new Scanner(System.in);
	  
   
     GUI _mainGrid = new GUI();
    
    // Throw these into its own function? Its creating the window
     _mainGrid.setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));    
     _mainGrid.exitOnClose();    
     _mainGrid.createButtonGrid();    
     _mainGrid.addButtonPanel();   

     _mainGrid.initializeGrids();

     // This function will change, to accept an integer that tells the GUI which player window to display
     //_mainGrid.setVisible(true);
     
	  // Initializing both player's grids, starting with player 1
	  //_player1.initializeGrid(); not here anymore
	  //_player2.initializeGrid();
	  
	  // Display player 1's GUI
	  
	  
	  // After a valid move, display player 2's GUI, so valid move needs close the GUI?

      // In while loop have each player take a turn until one has won, 1 for player 1 win, 
	  while (!gameover)
	  {
         // This function will change, to accept an integer that tells the GUI which player window to display, have it return an integer to whether the game is over
         gameover = _mainGrid.setVisible(true);
		 
	  }

     // Displays Victory, just print for now 
   }

}
