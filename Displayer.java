// Displayer.java - ver 1.00 //

/* To display the grid with the given 2D array */
public class Displayer
{
   public Displayer()
   {
   }
   
   /* Takes in the 2D grid and displays the contains as a 
    * grid on the screen, for players to see the current state
    * 
    * @param grid - The 2D array that contains Disc objects */
   public void DisplayGrid(Disc[][] grid) 
   {
     
     //for loop for row
     for (int row = 0 ; row <ConnectFour.GRID_HEIGHT ;row++)
     {
       System.out.print("    ------------------------------------\n    |");
       //for loop for column
       for (int col=0;col<ConnectFour.GRID_WIDTH ; col++)
       {
         //check if grid is not null
         if (grid[row][col] != null)
         {
           //check if disc type is x 
           if ( grid[row][col].GetDiscType()==Disc.X_DISC)
           {
             System.out.print(" X  |");
           }
           else if (grid[row][col].GetDiscType()==Disc.O_DISC)
           {
             //check if disc type is o
             System.out.print(" O  |");
           }
         }
         else
         {
           //when grid is null
           System.out.print("    |");
         }
       }
       System.out.println("");
     }
     //layout of option to be chose by the prompts
     System.out.println("    ------------------------------------");
     System.out.println("COL   1    2    3    4    5    6    7");
   }
   public void Header ()
   {
     //layout of game header
     System.out.println("==============================");
     System.out.println("|       CONNECT   FOUR       |");
     System.out.println("==============================");
   }
}