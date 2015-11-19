import java.awt.*;
import java.awt.dnd.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * GUI Controller
 * @author Michael
 * @author Brock
 */
public class GUI
{
   // Instance variables
   JButton[][] _buttonGrid = new JButton[20][15];
   JFrame _frame = new JFrame();
   JPanel _buttonPanel = new JPanel();
   JPanel _displayPanel = new JPanel();
   JPanel _panelOfPanels = new JPanel();
   JPanel _panelOfLabels = new JPanel();
   JLabel _buttonLabel = new JLabel("Enemy Grid", SwingConstants.CENTER);
   JLabel _displayLabel = new JLabel("Your Grid", SwingConstants.CENTER);
   JLabel _headerLabel = new JLabel("BATTLESHIP", SwingConstants.CENTER);
   
   public void createButtonGrid()
   {  
      // Set the layout of the button panel to a grid layout.
      _buttonPanel.setLayout(new GridLayout(20, 15));
      
      // Create the 2d array of buttons.
      for (int i = 0; i < _buttonGrid.length; i++)
      {
         for (int j = 0; j < _buttonGrid[i].length; j++)
         {
            _buttonGrid[i][j] = new JButton();
            _buttonGrid[i][j].setBackground(Color.BLUE);
            _buttonPanel.add(_buttonGrid[i][j]);
         }
      }
   }
   
   public void addButtonPanel()
   {  
      _buttonLabel.setFont(new Font("Times New Roman", Font.PLAIN, 32));
      _displayLabel.setFont(new Font("Times New Roman", Font.PLAIN, 32));
      _headerLabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
      
      // Set layout of the two major panels.
      _panelOfLabels.setLayout(new BorderLayout());
      _panelOfPanels.setLayout(new BorderLayout());
      
      _buttonPanel.setPreferredSize( new Dimension(850, 850));
      _displayPanel.setPreferredSize(new Dimension(850, 850));
      _panelOfLabels.setPreferredSize(new Dimension(100, 100));
      
      // TODO Remove later
      _displayPanel.setBackground(Color.RED);
      
      _panelOfLabels.add(_displayLabel, BorderLayout.WEST);
      _panelOfLabels.add(_headerLabel, BorderLayout.CENTER);
      _panelOfLabels.add(_buttonLabel, BorderLayout.EAST);
      
      _panelOfPanels.add(_displayPanel, BorderLayout.WEST);
      _panelOfPanels.add(_buttonPanel, BorderLayout.EAST);
      
      _frame.setLayout(new BorderLayout());
      _frame.add(_panelOfLabels, BorderLayout.NORTH);
      _frame.add(_panelOfPanels, BorderLayout.SOUTH);
   }
   
   public void setSize(Dimension size)
   {
      _frame.setSize(size);
   }
   
   
   public void setVisible(boolean isVisible)
   {
      _frame.setVisible(isVisible);
   }
   
   
   public void exitOnClose()
   {
      _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

