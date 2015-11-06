/**
 * A ship class in the Battleship game
 * 
 * @author Michael
 * @author Brock
 */

// Dan Comments: Need something that sets/initializes orientation of ship, though I guess it could default to 0

public class Ship
{
   String _name;
   int _hitCount;
   int[] _location = new int[2];
   int _size;
   int _orientation;
   
   
   /*
    * Makes sure user cannot create a ship without a name and size.
    */
   private Ship() {}
   
   
   /**
    * Main constructor for ship.
    * @param name the name of the ship
    * @param size the size of the ship (i.e. 2, 3, 4, 5)
    */
   public Ship(String name, int size)
   {
      _name = name;
      _size = size;
   }
   
   
   /**
    * Gets the name of the ship.
    * @return the name of the ship
    */
   public String getName() {return _name;}
   
   
   /**
    * Returns the location of the ship
    * @return the location of the ship
    */
   public int[] getLocation() {return _location;}
   
   
   /**
    * Returns the size of the ship
    * @return the size of the ship
    */
   public int getSize() {return _size;}
   
   
   /**
    * Return a boolean if the ship is sunk
    * @return boolean if ship is sunk
    */
   public boolean checkIfShipSunk() {return _hitCount == _size;}
   
   
   /**
    * Sets the location of the ship.
    * @param row the row of the ship
    * @param col the column of the ship
    */
   public void setLocation(int row, int col)
   {
      _location[0] = row;
      _location[1] = col;
   }
   
   
   /**
    * Increments the hit counter for the ship.
    */
   public void incrementHitCounter() {_hitCount++;}
   
   
   /**
    * Rotates the orientation of the ship. 0 is horizontal, 1 is vertical
    */
   public void rotateShip() {_orientation = (_orientation + 1) % 2;}

   
   
   
   
   
   
   
   
}
