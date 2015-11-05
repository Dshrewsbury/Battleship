import java.awt.*;
import java.awt.dnd.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GUI implements KeyListener
{
   JFrame frame = new JFrame();
   
   
   
   public void setSize(Dimension size)
   {
      frame.setSize(size);
   }
   
   
   public void setVisible(boolean isVisible)
   {
      frame.setVisible(isVisible);
   }
   
   
   public void exitOnClose()
   {
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   
   public void keyPressed(KeyEvent event)
   {
      // TODO Auto-generated method stub
      
   }
   
   
   public void keyReleased(KeyEvent event)
   {
      // TODO Auto-generated method stub
      
   }
   
   
   public void keyTyped(KeyEvent event)
   {
      // TODO Auto-generated method stub
      
   }
   
}

