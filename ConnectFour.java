// ConnectFour.java - ver 1.00 //

/* The game that keeps track of all the information, such as
 * the grid and which player's turn */
public class ConnectFour
{
  public final static int GRID_HEIGHT = 6;     // The default height of the grid (DO NOT CHANGE)
  public final static int GRID_WIDTH  = 7;     // The default width of the grid (DO NOT CHANGE)
  
  private Disc[][] grid;                       // The grid of the game. A 2D array of Disc objects (DO NOT CHANGE)
  private int currPlayer;                      // Keeps track of the current player (DO NOT CHANGE)
  
  //======================= CONSTRUCTOR =======================//
  public ConnectFour()
  {
    // Instantiate the grid when ConnectFour object is constructed.
    this.grid = new Disc[ ConnectFour.GRID_HEIGHT ][ ConnectFour.GRID_WIDTH ];
  }
  
  //====================== PRIVATE METHOD =======================//
  /* PLACE YOUR PRIVATE METHODS HERE (NOT PRIVATE VARIABLES) */
  
  
  //private method to check winner from horizontal win
  private boolean Horizontal()
  {
    //return type
    boolean result = false;
    //check every row 
    for(int row = 0; row < grid.length ; row++)
    {
      //check column within the range of 4
      //to give a limit to the disc to exit
      for(int col = 0; col < grid[row].length-3; col++)
      {
        //if statement to check if it is null
        if(grid[row][col] !=null&&  grid[row][col+1] !=null&& grid[row][col+2] !=null && grid[row][col+3] !=null)
        {
          //comparing each grid across right and left to the disc type 
          //column will be increment while row will stay the same
          //to check each column from the row pointed 
          if (grid[row][col].GetDiscType() == this.currPlayer && grid[row][col+1].GetDiscType() == this.currPlayer &&grid[row][col+2].GetDiscType() == this.currPlayer &&grid[row][col+3].GetDiscType() == this.currPlayer)
          {
            result=true;
            //if result is true the loop will break;
            break;
          }
        }
      }
    }
    return result;
  }
  private boolean Vertical()
  {
    boolean result = false;
    //row is within the range of 4 
    //to give a limit to the disc to exit
    for(int row = 0; row < grid.length - 3; row++)
    {
      //checked every column 
      for(int col = 0; col < grid[row].length; col++)
      {
        //check if every diagonal grid is not null
        if (this.grid[row][col] != null   &&  this.grid[row+1][col] != null && this.grid[row+2][col] != null &&this.grid[row+3][col] != null)
        {
          
          //row will be increment because it will check up and down while column with stay the same
          if (this.grid[row][col].GetDiscType() == this.currPlayer   
                &&  this.grid[row+1][col].GetDiscType() == this.currPlayer 
                &&this.grid[row+2][col].GetDiscType() == this.currPlayer && 
              this.grid[row+3][col].GetDiscType() == this.currPlayer)
          {
            
            //when boolean result is true it will return true
            result =true;
            break;
          }
        }
      }
      
    }
    //return boolean result
    return result;
  }
  private boolean DiagonalUp()
  {
    
    boolean result = false;
    //check grid within the range
    
    //check grid within the range
    for (int row= 3; row <this.grid.length; row++)
    {
      for (int col = 0; col < this.grid[row].length-3; col++)
      {
        //check if every diagonal row is null or not
        if (this.grid[row][col] != null&&this.grid[row-1][col+1]!=null&&this.grid[row-2][col+2]!=null&&this.grid[row-3][col+3]!=null)
        {
          //row will be substract while col will be add
          if (this.grid[row][col].GetDiscType() == this.currPlayer &&this.grid[row-1][col+1].GetDiscType()==this.currPlayer&&grid[row-2][col+2].GetDiscType()==this.currPlayer&&grid[row-3][col+3].GetDiscType()==this.currPlayer)
          {
            //if boolean result is true
            result = true;
          }
        }
      }
    }
    
    //return boolean result
    return result;
  }
  private boolean DiagonalDown()
  {
    
    boolean result = false;
    
    
    
    //check grid within the range
    for (int row= 0; row <this.grid.length-3; row++)
    {
      //check grid within the range
      for (int col = 0; col < this.grid[row].length-3; col++)
      {
        //check if diagonal down grid is null or not
        if (this.grid[row][col] != null && this.grid[row+1][col+1]!=null&&this.grid[row+2][col+2]!=null&&this.grid[row+3][col+3]!=null)
        {
          //comparing disctype to curr player disc 
          //row and col will be add
          if (this.grid[row][col].GetDiscType() == this.currPlayer &&this.grid[row+1][col+1].GetDiscType()==this.currPlayer&&grid[row+2][col+2].GetDiscType()==this.currPlayer&&grid[row+3][col+3].GetDiscType()==this.currPlayer)
          {
            //when  result is true
            result = true;
          }
          
        }
        
      }
      
    }
    
    //return boolean result
    return result;
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  //====================== PUBLIC METHOD =======================//
  /* It returns the 2D grid to the caller
   * 
   * @return - The 2D grid containing Disc objects */
  public Disc[][] GetGrid()
  {
    
    //return DISC grid
    return this.grid;   // Dummy return. Needs to be modified.
  }
  
  /* Returns the current player, represented by a number value
   * 
   * @return - The value that represents the player.
   *           0 represents player X (value 0 is stored in Disc.X_DISC)
   *           1 represents player O (value 1 is stored in Disc.O_DISC) */   
  public int GetCurrPlayer()
  {
    //return current player which represents base on a disc type
    return this.currPlayer;    // Dummy return. Needs to be modified
  }
  
  /* Set who will be the current playing inserting disc
   * 
   * @param startPlayer - The value that represents the player */
  public void SetCurrPlayer(int startPlayer)
  {
    //instantiate current player
    this.currPlayer=startPlayer;
    
    
    
  }
  
  /* Inserts a disc in the specified column and will determine
   * if it successfully inserted or not
   * 
   * @param col - The column that the player wants to insert the disc
   * @return    - Return true, if the disc is inserted successfully.
   *              Return false, if the column is full */    
  public boolean InsertDisc(int col)
  {
    boolean result =false;
    //for loop - backwards
    //start inserting from the bottom
    for (int row = GRID_HEIGHT-1;row>=0 ;row--)
    {
      //check if grid is empty or not
      if (grid[row][col] == null)
      {
        //check current player to disc type
        if(this.currPlayer ==Disc.X_DISC)
        {
          //inserting disc type
          this.grid[row][col]= new Disc (Disc.X_DISC);
          result = true;
          break;
          
        }
        //check current player to disc type
        else if (this.currPlayer ==Disc.O_DISC)
        {
          //inserting disctype
          this.grid[row][col]= new Disc (Disc.O_DISC);
          result = true;
          break;
          
        }
      }
      
      else
      {
        //check if result is false
        result = false;
      }
      
      
    }  
    return result;   // Dummy return. Needs to be modified
  }
  
  /* Switch player turn to the next player (If current player is X, then it 
   * switches to O. If current player is O, then it switches to X) */   
  public void SwitchPlayer()
  {
    //if current player is x
    if(GetCurrPlayer()==Disc.X_DISC)
    {
      //current player will be o
      this.currPlayer =Disc.O_DISC;
    }
    //if current player is o
    else if (GetCurrPlayer() == Disc.O_DISC)
    {
      //current player will be x
      this.currPlayer=Disc.X_DISC;
    }
    
  }
  
  /* Check is there a winner 
   * @return - Returns true, if there is a winner.
   *           Returns false, if there is no winner */      
  public boolean CheckWinner()
  {
    boolean result = false;
    //check if the return type of each check winner methods is true or false
    if(Horizontal() == true||Vertical()==true ||DiagonalUp()==true||DiagonalDown()==true)
    {
      //if it is true .result will be true
      result = true;
    }
    else
    {
      //if it is false.result will be false
      result = false;
    }
    
    return result;    // Dummy return. Needs to be modified
  }
  
  /* Check if the grid is full
   * @return - Returns true, if the grid is full.
   *           Returns false, if the grid is not full. */    
  public boolean CheckGridFull()
  {
    boolean result = false;
    int count =0;
    //check the top row of every column
    for(int col =0 ; col<this.grid[0].length ;col++)
    {
      //check if it is null or not
      if(this.grid[0][col] != null)
      {
        //counter to check number of column filled in the top row
        count++;
      }
      //check if it matches the our grid column
      if(count == GRID_WIDTH)
      {
        //if true means grid is full
        result =true;
        //loop will break
        break;
        
      }
      else
      {
        //else result is false
        result= false ;
      }
    }
    return result;    // Dummy return. Needs to be modified
  }
}