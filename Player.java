import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;


public class Player
{ 

   // Player should own GUI
   private static final int GRID_WIDTH             = 15;
   private static final int GRID_LENGTH            = 20;
   
   private GUI _colorGrid;
   private Grid _grid;
   private String _name;
   private int _xCoordinate  =  -1; //the first index given, indicating row
   private int _yCoordinate  = -1; //the second index given, indicating column
   private boolean _validTargetIs = false; //whether target coordinates have been “entered” before 
   //private int[] _targetCoordinates = new int[2];
   private boolean _shipsSet;
   private int _shipsSunk = 0; // Keeps track of how many ships have been sunk
   private Player _otherPlayer;


 public Player(String playerName)
 {
    _name = playerName;
    
    // We don't know if it will work like this or not as Ben is handling it
    GUI _colorGrid = new GUI();
    
    _colorGrid.setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
    
    _colorGrid.exitOnClose();
    
    _colorGrid.createButtonGrid();
    
    _colorGrid.addButtonPanel();
    
    _colorGrid.setVisible(true);
 }


  public void takeATurn(int xCoordinate, int yCoordinate)
  {
  
       _xCoordinate = xCoordinate;
       _yCoordinate = yCoordinate;

        // GUI returns coordinates to check for hit/miss, need to error trap if they try and select something thats already been hit- so check color of colorgrid
       _validTargetIs = _grid.isValidSelection(xCoordinate, yCoordinate); // returns true if its a valid move
       
       
    if(_validTargetIs)
    {
	    // Valid move was made so check for hit, which will increment hit counter of ship in the grid class function, and check to see if ship was sunk
	    if(_grid.isHit(_xCoordinate, _yCoordinate))
	    {
	       if (_grid.checkIfShipSunk(_xCoordinate, _yCoordinate))
	       {
	          _colorGrid.setColor(_xCoordinate, _yCoordinate, Color.RED);
	          _grid._colorGrid[_xCoordinate][_yCoordinate] = Color.RED;  
	       }
	       
	       else
	       {
	          _colorGrid.setColor(_xCoordinate, _yCoordinate, Color.ORANGE); //Red or some int that represents red
	          _grid._colorGrid[_xCoordinate][_yCoordinate] = Color.ORANGE;         
	       }
	       
	    } 

    }
  }
  
  public void initializeShips()
  {
	final int GRID_WIDTH             = 15;
     final int GRID_LENGTH            = 20;
     final int HORIZONTAL_ORIENTATION = 0;
     final int VERICAL_ORIENTATION    = 1;
     
     final int AIRCRAFT_SIZE = 5;
     final int BATTLESHIP_SIZE =4;
     final int SUB_SIZE = 3;
     final int CRUISER_SIZE = 3;
     final int DESTROYER_SIZE = 2;
     
     // Construct Ships
     Ship aircraftCarrier = new Ship("aircraftCarrier", AIRCRAFT_SIZE);
     Ship battleship = new Ship("battleship", BATTLESHIP_SIZE);
     Ship submarine = new Ship("submarine", SUB_SIZE);
     Ship cruiser = new Ship("cruiser", CRUISER_SIZE);
     Ship destroyer = new Ship("destroyer", DESTROYER_SIZE);

     Ship[] shipTypes = { aircraftCarrier, battleship, submarine, cruiser,
           destroyer };
     Ship[][] shipGrid = new Ship[GRID_WIDTH][GRID_LENGTH];

     Random orientationGenerator = new Random();
     Random xCoordinateGenerator = new Random();
     Random yCoordinateGenerator = new Random();

     int orientation;
     int xCoordinate;
     int yCoordinate;
     boolean shipSet = false;
     boolean validCoordinates = false;
     boolean shipsIntersect = false;
     
     
     // Places each ship on to the shipGrid
     for (int i = 0; i < shipTypes.length; i++)
     {
        // initially every ship is not set.
        shipSet = false;
        shipsIntersect = false;
        
        while (!shipSet)
        {
           // Randomly obtain the x-coordinate, y-coordinate, and orientation
           // of the ship
           xCoordinate = xCoordinateGenerator.nextInt((GRID_WIDTH));
           yCoordinate = yCoordinateGenerator.nextInt((GRID_LENGTH));
           orientation = orientationGenerator
                 .nextInt((VERICAL_ORIENTATION - HORIZONTAL_ORIENTATION) + 1);
           
           
           // Determine if the ship will be out of bounds, based starting
           // coordinates and ship's size
           if (orientation == VERICAL_ORIENTATION 
                 && xCoordinate + shipTypes[i].getSize() >= GRID_WIDTH)
           {
              validCoordinates = false;
           }
           
           else if (orientation == HORIZONTAL_ORIENTATION && yCoordinate 
                 + shipTypes[i].getSize() >= GRID_LENGTH )
           {
              validCoordinates = false;
           }
           
           else if (shipGrid[xCoordinate][yCoordinate] != null)
           {
              validCoordinates = false;
           }
           
           // If ship's placement will be in-bounds, coordinates are valid
           else
           {
              validCoordinates = true;
           }
           
           // If the coordinates are valid, place a reference to the specific
           // at appropriate grid locations
           if (validCoordinates)
           {
              // If orientation horizontal, place ship on starting coordinates,
              // and rightward for ship size - 1 units
              if (orientation == HORIZONTAL_ORIENTATION)
              {
                 for (int j = 0; j < shipTypes[i].getSize() &&
                       !shipsIntersect; j++)
                 {
                    // Makes sure ship references (besides starting coordinates
                    //) aren't intersecting with already placed ships
                    if (shipGrid[xCoordinate][yCoordinate + j] == null)
                    {
                       shipGrid[xCoordinate][yCoordinate + j] = shipTypes[i];
                    }
                    
                    else
                    {
                       shipsIntersect = true;
                    }
                 }
              }
              
              // If ship's orientation is vertical, then place ship reference
              // on starting coordinates and downward for ship size - 1 units
              else
              {
                 for (int j = 0; j < shipTypes[i].getSize() && 
                       !shipsIntersect; j++)
                 {
                    
                    // Makes sure ship references (besides starting coordinates
                    //) aren't intersecting with already placed ships
                    if (shipGrid[xCoordinate + j][yCoordinate] == null)
                    {
                       shipGrid[xCoordinate + j][yCoordinate] = shipTypes[i];
                    }
                    
                    else
                    {
                       shipsIntersect = true;
                    }
                 }
              }
              
              // If ship references have all occupied empty spaces
              //ship was successfully set
              if (!shipsIntersect)
              {
                 shipSet = true;
              }
           }
        }
     }
  }

//NEED TO DISCUSS!!!!!
// -Hold off on this method for now. Need to know more about how GUI will work
   // public void isValidPlacement(int _xCoordinate, int _yCoordinate,
   //    int shipSize, boolean isVertical)
   //    {

   //     boolean validPlacementIs = true;

   //     dragListener() (innerclass)

   //      //if x or y coordinate are empty ||  if x or y coordinate are outside 
   //      //the range 0 - 9  || if part of all of a ship is in location)

   //          // return false;

   //      //else

   //          // return true\
   //    }

   // public boolean areShipsSet()
   
   // {
   //     _shipsSet = true;
   
   //     for (int i = 0; i < Ships.length() && _shipsSet; i++)
   
   //     {
   
   //         if (Ships[i].getLocation() == null)
   
   //         {
   
   //             _shipsSet = false;
   
   //         }
   
   // }
   
   
   // return _shipsSet;
   
   // }

    





   // Not needed for now, Main should handle player switching
   // public void switchPlayer()   // Need to discuss at meeting.  Correct class?
   
   // {
   //     if (_player ==  _player1)
   
   //      {  
   
   //         // Have screen “blank out” after turn was completed 
   //        //(delayed time so user can see if they hit/miss).  
   //        //Then next player has to hit “Enter” to display grid?
   
   //         _player = player2;
   
   //         _player2.getGrid().displayGrid(); // Both opponent grid and target grid?  Or just one grid?;
   
   //      }
   
   
   //     else
   
   //     {
   
   //         _player = player1;
   
   //         _player1.getGrid().displayGrid();
   
   //     }
   
   // }



   public boolean checkForVictory()
   {
   
       boolean victoryIs = false;
   
   
       if (_grid.getShipsSunk() == 5)
       {
           victoryIs = true;
       }
   
   
       return victoryIs;
   }




  // Initializes grid with ships placed
   public void initializeGrid()
   {
      _grid = new Grid();
      //_grid.setUpGrid();
   }

  // Display GUI
   
  // Close GUI, should return whether or not there was a victory
}

