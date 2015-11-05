
public class Player
{ 
   private Grid _grid;
   private String _name;
   private int _xCoordinate  =  -1; //the first index given, indicating row
   private int _yCoordinate  = -1; //the second index given, indicating column
   private boolean _validTargetIs = false; //whether target coordinates have been “entered” before 
   private int[] _targetCoordinates = new int[2];
   private boolean _shipsSet;


 public Player(String playerName)
 {

    _name = playerName;
 }



void takeATurn()
{
  selectTargetCoordinates() // Grid class

  while  (!_validTargetIs) 
  {

     _targetCoordinates = mouseListener();  // within gridlistener() inner class of GUI? Returns x and y coordinates of selected target on grid
     _xCoordinate = _targetCoordinates[0];
     _yCoordinate = _targetCoordinates[1];

     _validTargetIs = isValidTarget( _xCoordinate,  _yCoodinate);
  }

}


//NEED TO DISCUSS!!!!!

   public void isValidPlacement(int _xCoordinate, int _yCoordinate,
      int shipSize, boolean isVertical)
      {

       boolean validPlacementIs = true;

       dragListener() (innerclass)

        //if x or y coordinate are empty ||  if x or y coordinate are outside 
        //the range 0 - 9  || if part of all of a ship is in location)

            // return false;

        //else

            // return true\
      }

   public boolean areShipsSet()
   
   {
       _shipsSet = true;
   
       for (int i = 0; i < Ships.length() && _shipsSet; i++)
   
       {
   
           if (Ships[i].getLocation() == null)
   
           {
   
               _shipsSet = false;
   
           }
   
   }
   
   
   return _shipsSet;
   
   }

    






   public void switchPlayer()   // Need to discuss at meeting.  Correct class?
   
   {
       if (_player ==  _player1)
   
        {  
   
           // Have screen “blank out” after turn was completed 
          //(delayed time so user can see if they hit/miss).  
          //Then next player has to hit “Enter” to display grid?
   
           _player = player2;
   
           _player2.getGrid().displayGrid(); // Both opponent grid and target grid?  Or just one grid?;
   
        }
   
   
       else
   
       {
   
           _player = player1;
   
           _player1.getGrid().displayGrid();
   
       }
   
   }



   public boolean checkForVictory()
   {
   
       boolean victoryIs = false;
   
       isSunk = false;
   
       
   
       if (Ship.checkIfShipSunk(destroyer) && 
             Ship.checkIfShipSunk(battleship) && Ship.checkifShipSunk(submarine)
             && Ship.checkIfShipSunk(carrier) && Ship.checkIfShipSunk(patrolBoat)
   
       {
           victoryIs = true;
       }
   
   
       return victoryIs;
   }





   public void initializeGrid()
   {
      _grid = new Grid();
   }

}

