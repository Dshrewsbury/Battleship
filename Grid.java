public class Grid
{ 
	private int _colorGrid[][];
	private Ship _shipGrid[][];
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
    
    	// Initialize colorGrid to all blue for water - MICHAEL/BROCK
 	}

 	// Return whether it was a hit or not - KIRSTEN/NOAH
 	boolean isHit(xCoordinate, yCoordinate)
 	{

 		// If its a hit, increment hit count on that ship

 		// Check to see if that ship is sunk, if it is increment shipsSunk counter

 	}

 	// - MICHAEL/BROCK
 	boolean isValidSelection(int xCoordinate, int yCoordinate)  
 	{
 		boolean isValidMove = false;
 		// If colorgrid is anything but blue, its already been chosen so return false
 		if()

 		// Else its a valid choice so return true

 		return isValidMove;
 	}

 	void displayGrid()
 	{
 		// Call GUI to display grid

 	}

 	// KIRSTEN/NOAH
 	void setUpGrid()
 	{
 		// Display set up grid GUI

 		// GUI will return coordinate, orientation for each ship

 		// some getFunctionCall that returns/sets coordinates/orientation
 		aircraftCarrier.setLocation(xCoordinate, yCoordinate);
 		aircraftCarrier.setOrientation(orientation);
 		setShipOnGrid(aircraftCarrier, xCoordinate, yCoordinate, orientation);

 		// Repeat above for other ships, could just turn 5 ships into ship array

 		// Whatever color we decide for ship, just leave this here aren't sure if we'll be using it
 		_colorGrid[xCoordinate][yCoordinate] = gray



 	}

 	// - MICHAEL/BROCK
 	void setShipOnGrid(Ship ship, int xCoordinate, int yCoordinate, int orientation)
 	{
 		int shipSize = ship.getSize();

 		// If its horizontal set the x axis values to the ship
 		for(int i = 0, i < shipSize; i++)
 		{
 			_shipGrid[xCoordinate + i][yCoordinate] = ship;
 		}
 		// Else if its vertical set the y axis values to the ship
 		

 		// For now at least we'll say the 
 		_colorGrid[xCoordinate][yCoordinate] = gray

 	}

}