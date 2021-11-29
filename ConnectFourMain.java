import java.util.Scanner;
public class ConnectFourMain
{
  /* The start 
   * 
   * the game */
  public static void main(String[] args)
  {
    
    Scanner input = new Scanner(System.in);
    ConnectFour cf = new ConnectFour();      // Creates the ConnectFour object (DO NOT DELETE IT)
    Displayer displayer = new Displayer();   // Creates the Displayer object (DO NOT DELETE IT)
    //inidicate each data types
    char discType ;
    int col;
    do 
    {
      
      //header layout
      displayer.Header();
      System.out.print("Who will start frist(X or O)?");
      discType = input.nextLine().toUpperCase().charAt(0);
      
      if (discType =='O'||discType == 'X')
      {
        //determine each disctype
        if ( discType =='O')
        {
          //set player o
          cf.SetCurrPlayer(Disc.O_DISC);
        }
        
        else if (discType=='X')
        {
          //set player x
          cf.SetCurrPlayer(Disc.X_DISC);
        }
        
        //the system will keep looping unless it is false
        while ( cf.CheckWinner()!=true)
        {
          
          
          //display of the grid
          displayer.DisplayGrid(cf.GetGrid());
          //break loop if grid is full
          if (cf.CheckGridFull()==true)
          {
            
            break;
          }
          
          //if current player is o
          else if ( cf.GetCurrPlayer()==Disc.O_DISC)
          {
            
            //input disc
            System.out.print("Player O. pick a column to insert your disc :");
            col= input.nextInt();
            
            //check if column is within the range
            if(col <1||col>7)
            {
             //it will keep looping if column is out of the range
              while (true)
              {
                System.out.println("Column "+ col +" is out of range");
                System.out.print("Player O. pick a column to insert your disc :");
                col= input.nextInt();
                if (col>=1&&col<=7)
                {
                  break;
                }
              }
            }
            //if column is in the range
            if (col>=1&&col<=7)
            {
              
              //check if insert disc is column is filled or not
              if(cf.InsertDisc((col-1))==false)
              {
                //keep looping if column is filled
                while(true)
                {
                  System.out.println("Column "+ col +" is unavaillable");
                  System.out.print("Player O. pick a column to insert your disc :");
                  col= input.nextInt();
                  //break if column is not filled
                  
                  if (cf.InsertDisc(col-1)==true)
                  {
                    break;
                  }
                  
                } 
              }
              
              
              //if there is no winner player will be switched 
              //else if there is a winner player wont be switched and the loop will end
              if(cf.CheckWinner()==false)
              {
                cf.SwitchPlayer();
              }
              else
              {
                //it will exit the loop when there is a winner
                break;
              }
              
              
            }
          }
          
          
          
          
          
          //if player is x
          else if (cf.GetCurrPlayer()==Disc.X_DISC)
          {
            
            //input disc
            System.out.print("Player X. pick a column to insert your disc :");
            col= input.nextInt();
            
            //check if column is within the range
            //if column is not in the range
            if(col<1||col>7)
            {
              //will keep looping if column is out of the range 
              while (true)
              {
                System.out.println("Column "+ col +" is out of range");
                System.out.print("Player O. pick a column to insert your disc :");
                col= input.nextInt();
                //break id column is in the range
                if (col>=1&&col<=7)
                {
                  break;
                }
              }
            }
            //if column is in the range
            if (col>=1&&col<=7)
            {
              
              
              //check if insert disc is filled or not
              if(cf.InsertDisc(col-1)==false)
              {
                //keep looping if column is filled
                while(true)
                {
                  System.out.println("Column "+col+" is not available");
                  System.out.print("Player X. pick a column to insert your disc :");
                  col= input.nextInt();
                  
                  //break the loop once column chosen is not filled
                  if(cf.InsertDisc(col-1)==true)
                  {
                    break;
                  }
                  
                  
                }
              }
              //if there is no winner player will be switched 
              //else if there is a winner player wont be switched and the loop will end
              if(cf.CheckWinner()==false)
              {
                cf.SwitchPlayer();
              }
              else
              {
                //it will exit the loop when there is a winner
                break;
              }
            }
            
          }
          
          
          
          
          
          
          
          
          
        }
      }
      else
      {
        //if player is not x or o
        System.out.println("Invalid Player Character");
      }
      //check if grid is full
      if (cf.CheckGridFull()==true)
      {
        //give warning and break the loop if grid is full
        System.out.println("Grid is full");
        break;
      }
      
    }
    
    //exit do while loop if there a winner
    while (  cf.CheckWinner()!=true );
    if(cf.CheckWinner()==true)
    {
      //display final grid
      displayer.DisplayGrid(cf.GetGrid());
      //determine the winner
      System.out.print("The Winner is ");
      if(cf.GetCurrPlayer()==Disc.X_DISC)
      {
        //when x player win
        System.out.print("X Player");
      }
      
      else if( cf.GetCurrPlayer()==Disc.O_DISC)
      {
        //when o player win
        System.out.print("O Player");
      }
      
      else if (cf.CheckWinner() !=true )
      {
        //when there is no winner or tie
        System.out.print("TIE");
      }
    }
    
  }
}

