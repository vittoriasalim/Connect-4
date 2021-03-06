// Disc.java - ver 1.00 //

/* Disc object for each disc in the game */
public class Disc 
{
  
  public final static int X_DISC = 0;   // Value that represents X Disc
  public final static int O_DISC = 1;   // Value that represents O Disc
  //private variable can only be accessed with getter method
  private int discType;
  
  public Disc (int discType)
  { 
    //instantiate disctype
    this.discType = discType ;
  }
  
  /* Get the disc type from the disc object
   * 
   * @return - Return the type of disc. Values are based on 
   *           Global (Final Static) variables within Disc class 
   *           X_DISC and O_DISC */
  public int GetDiscType()
  {
    
    //getter method for disctype
    return this.discType;   // A dummy return value. Must modify to return the appropriate value.
  }
}