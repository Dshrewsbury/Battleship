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
      GUI window = new GUI();
      
      window.setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
      
      window.exitOnClose();
      
      window.setVisible(true);

   }

}
