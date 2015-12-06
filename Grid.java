import java.awt.Color;

public class Grid
{ 
   Color[][] _colorGrid;
	private Ship[][] _shipGrid;
	private int _shipsSunk = 0; // Keeps track of how many ships have been sunk
	// Should probably just make this into an array
	private Ship aircraftCarrier;
	private Ship battleship;
	private Ship submarine;
	private Ship cruiser;
	private Ship destroyer;


	public Grid()
 	{
 		aircraftCarrier = new Ship("aircraftCarrier", 5);
 		battleship = new Ship("battleship", 4);
 		submarine = new Ship("submarine", 3);
 		cruiser = new Ship("cruiser", 3);
 		destroyer = new Ship("destroyer", 2);
    
 		_colorGrid = new Color[20][15];
 
 		      // Initialize colorGrid to all blue for water - MICHAEL/BROCK
 		      for (int i = 0; i < _colorGrid.length; i++)
 		      {
 		         for (int j = 0; j < _colorGrid[i].length; j++)
 		         {
 		            _colorGrid[i][j] = Color.BLUE;
 		         }
 		      }
 	}

 	// Return whether it was a hit or not - KIRSTEN/NOAH
 	boolean isHit(int xCoordinate, int yCoordinate)
 	{

		boolean result = false;

		if (_shipGrid[xCoordinate][yCoordinate] != null) 
		{

			// If its a hit, increment hit count on that ship
			_shipGrid[xCoordinate][yCoordinate].incrementHitCounter();         

			result = true;

			// Check to see if that ship is sunk, if it is increment shipsSunk counter
			if (_shipGrid[xCoordinate][yCoordinate].checkIfShipSunk())
			{
				_shipsSunk = _shipsSunk + 1;
         }
       }

      return result;
 	}

	
 	// Returns whether or not the selection made by the user is a valid selection.  - MICHAEL/BROCK
 	boolean isValidSelection(int xCoordinate, int yCoordinate)  
 	   {return _colorGrid[xCoordinate][yCoordinate].equals(Color.WHITE);}

 	void displayGrid()
 	{
 		// Call GUI to display grid

 	}
 	
 	// Added by Michael - 12/1/15
 	boolean checkIfShipSunk(int x, int y) {return _shipGrid[x][y].checkIfShipSunk();}

 	// KIRSTEN/NOAH
 	void setUpGrid(int xCoordinate, int yCoordinate, int orientation)
 	{		
		Ship[] shipArray = {aircraftCarrier, battleship, submarine, cruiser, destroyer};
		int[] shipLocation;
		
		// Display set up grid GUI
		displayGrid();

 		// GUI will return coordinate, orientation for each ship

 		// some getFunctionCall that returns/sets coordinates/orientation
		
		for (Ship aShip : shipArray)
		{
			// Set the starting location of the ship, and its orientation
			aShip.setLocation(xCoordinate, yCoordinate);
			aShip.setOrientation(orientation);
			
			// Does getLocation() include orientation?  If not, may want to consider adding getOrientation() method to UML.
			shipLocation = aShip.getLocation();
			
		
			//Modified by Kirsten Pierce on 12/5/15
			aShip.setLocation(xCoordinate, yCoordinate);
			aShip.setOrientation(orientation);
		}
		
 		// Repeat above for other ships, could just turn 5 ships into ship array

 		// Whatever color we decide for ship, just leave this here aren't sure if we'll be using it
 		_colorGrid[xCoordinate][yCoordinate] = Color.GRAY;



 	}

 	// Sets the ship on the grid, with the ship, the coordinates, and the orientation. - MICHAEL/BROCK
 	void setShipOnGrid(Ship ship, int xCoordinate, int yCoordinate, byte orientation)
 	{
 		int shipSize = ship.getSize();

 		// If its horizontal set the x axis values to the ship
 		for(int i = 0; i < shipSize; i++)
 		{
 			_shipGrid[xCoordinate + i][yCoordinate] = ship;
 		}
 		// Else if its vertical set the y axis values to the ship
 		

 		// For now at least we'll say the 
 		_colorGrid[xCoordinate][yCoordinate] = Color.GRAY;

 	}
}