import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.dnd.*;

import javax.swing.*;

import java.awt.event.*;


/**
 * GUI Controller
 * @author Michael
 * @author Brock
 */
// Need to connect our Color Grid class to this GUI
public class GUI
{
   private static Player _player1;
   private static Player _player2;
   
   // Have a pointer to the current player?
   private Player _currentPlayer;
   
   // Instance variables, I'm assuming somewhere in here we'll add your own grid
   JButton[][] _buttonGrid = new JButton[20][15];
   JButton[][] _buttonGrid2 = new JButton[20][15];
   JButton _placeShipsButton = new JButton("  Place Ships  ");
   JFrame _frame = new JFrame();
   JPanel _buttonPanel = new JPanel();
   JPanel _displayPanel = new JPanel();
   JPanel _panelOfPanels = new JPanel();
   JPanel _panelOfLabels = new JPanel();
   JPanel _panelOfButtons = new JPanel();
   JLabel _buttonLabel = new JLabel("Enemy Grid", SwingConstants.CENTER);
   JLabel _displayLabel = new JLabel("Your Grid", SwingConstants.CENTER);
   JLabel _headerLabel = new JLabel("BATTLESHIP", SwingConstants.CENTER);
   
   public GUI()
   {
      _player1 = new Player();
      _player2 = new Player();
      _currentPlayer = _player1;
   }
   
   
//   public void createButtonGrid()
//   {  
//      // Set the layout of the button panel to a grid layout.
//      _buttonPanel.setLayout(new GridLayout(20, 15));
//      // NEED TO ADD HEADERS, A-J, 1-10
//      // Create the 2d array of buttons.
//      for (int i = 0; i < _buttonGrid.length; i++)
//      {
//         for (int j = 0; j < _buttonGrid[i].length; j++)
//         {
//            _buttonGrid[i][j] = new JButton();
//            
//            // KIRSTEN/NOAH HERE, Using currentPlayer, call function in Player that gets the status of color grid and returns either an int/Color based on what it is
//            // Based on that color setbackground to Red or White
//            
//            
//            Color currentColor = _currentPlayer.returnColorFromGrid(i, j);    
//            _buttonGrid[i][j].setBackground(currentColor);
//            
//            _buttonGrid[i][j].addActionListener(new GridListener(_buttonGrid));
//            _buttonPanel.add(_buttonGrid[i][j]);
//         }
//      }
//   }

   Rectangle _window;
   int _winHeight;
   int _winWidth;
   
   public void createShipPlacementButton()
   { 
       _placeShipsButton.addActionListener(new ButtonListener());
       _panelOfButtons.setLayout(new GridLayout());
       _panelOfButtons.setPreferredSize(new Dimension(200, 100));
   }
   
   public void createButtonGrid(JPanel pannel, JButton[][] grid, GridListener listener)
   { 
       // Set the layout of the button panel to a grid layout.
       pannel.setLayout(new GridLayout(20, 15));
       // NEED TO ADD HEADERS, A-J, 1-10
       // Create the 2d array of buttons.
       for (int i = 0; i < grid.length; i++)
       {
          for (int j = 0; j < grid[i].length; j++)
          {
             grid[i][j] = new JButton();
             
             // KIRSTEN/NOAH HERE, Using currentPlayer, call function in Player that gets the status of color grid and returns either an int/Color based on what it is
             // Based on that color set background to Red or White
             grid[i][j].setBackground(Color.WHITE);
             grid[i][j].addActionListener(listener);
             pannel.add(grid[i][j]);
          }
       }
   }
   
   private class ButtonListener implements ActionListener
   {

       @Override
       public void actionPerformed(ActionEvent e)
       {
           JFrame dialogBox = new JFrame();
           
           JOptionPane.showMessageDialog(dialogBox, 
                   "You clicked the place ships button!", 
                   "Ship Placement", JOptionPane.INFORMATION_MESSAGE);
           
       }            
   }
   
   private class GridListener implements ActionListener
   {
       private JButton[][] _self = null;
       
       public GridListener(JButton[][] grid)
       {
           _self = grid;
       }

      public void actionPerformed(ActionEvent e) 
      {
      
         // Create a frame for a dialog box if the button is invalid.
         JFrame dialogBox;
         
         // Use a nested for loop to loop through the buttons and find which
         // one was clicked.
         for (int row = 0; row < 20; row++) 
         {
               for (int col = 0; col < 15; col++) 
               {
                  // If the button is valid, continue, otherwise, show an error.
                  if (_self[row][col] == e.getSource() && 
                          _self[row][col].getBackground() == Color.WHITE)
                  {
                     dialogBox = new JFrame();
                     
                     // Display a coordinate message.
                     JOptionPane.showMessageDialog(dialogBox, 
                           "Coordinates: " + row + ", " + col, 
                           "Button Coordinates", JOptionPane.INFORMATION_MESSAGE);
                     
                     // Needs to know which player to use, we also need to change the color of the selected cell based off of response
                     boolean result = _currentPlayer.takeATurn(row, col); //0 for miss 1 for hit? 
                     
                     // KIRSTEN/NOAH HERE, Using currentPlayer, call function in Player that sets the status of color grid in the Grid class if takeATurn returns as a hit
                     // Then Based on that color setbackground to Red if its a hit
                     
                     //works if current player is initialized 
                     _currentPlayer.setColorGrid(row, col, result ? Color.ORANGE : Color.WHITE);
                     
                     _buttonGrid[row][col].setBackground(result ? Color.ORANGE : Color.WHITE);
                     
                     // changeGridColor(row, col, result);
                     // switchPlayer();
                  }
                  
                  else if (_self[row][col] == e.getSource() && 
                          _self[row][col].getBackground() == Color.WHITE)
                  {
                     dialogBox = new JFrame();
                     
                     // Display an error message.
                     JOptionPane.showMessageDialog(dialogBox, 
                           "Button already chosen", "Invalid Button", 
                           JOptionPane.ERROR_MESSAGE);
                  }
               }
            }
         }  
   }
   
   public void setColor(int xCoordinate, int yCoordinate, Color color)
   {
      _buttonGrid[xCoordinate][yCoordinate].setBackground(color);
   }
   
   private class WindowListener implements ComponentListener
   {

    @Override
    public void componentHidden(ComponentEvent e)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void componentMoved(ComponentEvent e)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void componentResized(ComponentEvent e)
    {
        _window = _frame.getBounds();
        _winHeight = (int) (_window.height * 0.80);
        _winWidth = (int) (_window.width * 0.45);
        
        _buttonPanel.setPreferredSize(new Dimension(_winWidth, _winHeight));
        _displayPanel.setPreferredSize(new Dimension(_winWidth, _winHeight));
        _panelOfLabels.setPreferredSize(new Dimension(100, 100));
        
    }

       @Override
       public void componentShown(ComponentEvent e)
       {
           // TODO Auto-generated method stub
           
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
      
      _panelOfLabels.add(_displayLabel, BorderLayout.WEST);
      _panelOfLabels.add(_headerLabel, BorderLayout.CENTER);
      _panelOfLabels.add(_buttonLabel, BorderLayout.EAST);
      
      _panelOfButtons.add(_placeShipsButton);
      
      _panelOfPanels.add(_displayPanel, BorderLayout.WEST);
      _panelOfPanels.add(_buttonPanel, BorderLayout.EAST);
      
      _frame.setLayout(new BorderLayout());
      _frame.add(_panelOfLabels, BorderLayout.NORTH);
      _frame.add(_panelOfButtons, BorderLayout.LINE_START);
      _frame.add(_panelOfPanels, BorderLayout.SOUTH);
   }
   
   public void setSize(Dimension size)
   {
      _frame.setSize(size);
   }
   
   // This function will change, to accept an integer that tells the GUI which player window to display, have it return an integer to whether the game is over
   public int setVisible(boolean isVisible)
   {
      _frame.setVisible(isVisible);

      return 0;
   }
   
   
   public void exitOnClose()
   {
      _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public void initializeGrids()
   {
      _player1 = new Player();
      _player2 = new Player();
      
      //Added the player's initialize grid that used to be in the main 12/11/15
      _player1.initializeGrid(); 
      _player2.initializeGrid();

      // Display setup window for player 1, which waits until acceptable placement then exits
      // in that display, have action listener for two buttons, one that calls the randomize function, 
      // two that is the "done" button and closes the window
      // Pass player to setup window

      // Display setup window for player 2, which waits until acceptable placement then exits

      
   }
   
   public void setupGUIWindow()
   {
//        //setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));    
//        _frame.setExtendedState(Frame.MAXIMIZED_BOTH);
//        exitOnClose();    
//        createButtonGrid();    
//        addButtonPanel();   
        
	     //setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));   
         
	     _frame.setExtendedState(Frame.MAXIMIZED_BOTH);
	     _frame.addComponentListener(new WindowListener());
	     exitOnClose();  
	     createShipPlacementButton();
	     createButtonGrid(_displayPanel, _buttonGrid2, null);    // player
	     createButtonGrid(_buttonPanel, _buttonGrid, new GridListener(_buttonGrid));      // enemy
	     addButtonPanel();   
   }
   
   public void switchPlayer()
   {
       if(_currentPlayer == _player1)
       {
          _currentPlayer = _player2;
       }
       else
       {
          _currentPlayer = _player1;
       }
   }
   
}