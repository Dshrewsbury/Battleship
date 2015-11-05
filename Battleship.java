import java.awt.Dimension;
import java.awt.Toolkit;


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
