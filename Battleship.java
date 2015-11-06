import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * Battleship GUI Main
 * @author Michael
 * @author Brock
 */
public class Battleship
{

   public static void main(String[] args)
   {
   	// We don't know if it will work like this or not as Ben is handling it
      GUI window = new GUI();
      
      window.setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
      
      window.exitOnClose();
      
      window.setVisible(true);

      // KIRSTEN/NOAH
      // Create two players, call initialize grid for both of them

      // In while loop have each player take a turn until one has won


   }

}
