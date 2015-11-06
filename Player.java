
public class Player
{ 
   private Grid _grid;
   private String _name;
   private int _xCoordinate  =  -1; //the first index given, indicating row
   private int _yCoordinate  = -1; //the second index given, indicating column
   private boolean _validTargetIs = false; //whether target coordinates have been “entered” before 
   private int[] _targetCoordinates = new int[2];
   private boolean _shipsSet;
   private int _shipsSunk = 0; // Keeps track of how many ships have been sunk
   private Player _otherPlayer;


 public Player(String playerName)
 {
    _name = playerName;
 }


  public void takeATurn()
  {

    // Loop here that continues to get a move until it is valid
    while  (!_validTargetIs) 
    {

       _targetCoordinates = mouseListener();  // within gridlistener() inner class of GUI? Returns x and y coordinates of selected target on grid
       _xCoordinate = _targetCoordinates[0];
       _yCoordinate = _targetCoordinates[1];

        // GUI returns coordinates to check for hit/miss, need to error trap if they try and select something thats already been hit- so check color of colorgrid
       _validTargetIs = _grid.isValidSelection(xCoordinate, yCoordinate); // returns true if its a valid move
    }

    // Valid move was made so check for hit, which will increment hit counter of ship in the grid class function, and check to see if ship was sunk
    if(_grid.isHit(_xCoordinate, _yCoordinate))
    {
      _grid.setColor(_xCoordinate, _yCoordinate, red) //Red or some int that represents red

      // Possibly call some GUI function to display some sunk color
    } 
    else // Else it was a miss so set it to white
    {
       _grid.setColor(_xCoordinate, _yCoordinate, white) //Red or some int that represents red
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
   
       isSunk = false;
   
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
      _grid.setUpGrid();
   }

}

