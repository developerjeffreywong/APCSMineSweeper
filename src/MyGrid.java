import java.awt.Color;
public class MyGrid extends TheGrid{
	
	// the grid is modelled by a 3D array
	// refer to documentation about TheGrid.java
	private int [][][] grid;
	
	// YOU DO NOT NEED ANY OTHER GLOBAL VARIABLES //
	
	/**
	 * Default Constructor <br />
	 * You only need to use this constructor<br />
	 * This constructor will create the grid from TheGrid class
	 * with the bombs but you need to fill in the grid with the
	 * correct numbers as hints so the player can play the game 
	 */
	public MyGrid()
	{
		/* because MyGrid class extends TheGrid class
		 * we have to first make TheGrid object using
		 * the the parent constructor
		 * 
		 * you can only use super once, so comment the
		 * one you are not using
		 * 
		 * refer to TheGrid documentation*/
		
		// default constructor of TheGrid class
		//super(); 
		
		// second constructor of TheGrid class
		super(10,10,25,4);
		
		// make our own copy of the grid for this class
		grid = getGrid();
		
		/* figure out the correct numbers (hints)
		 * to place in the grid below
		 * 
		 * you can also modify how the grid looks here
		 */
		TESTING=false; // turn on or off testing mode
	}
	
	/**
	 * checks to see if the player clicked on a bomb
	 * @param row the row that was clicked
	 * @param col the col that was clicked
	 * @return true if player clicks on a bomb
	 */
	public boolean checkDead(int x, int y)
	{
		return false;
	}
	
	/**
	 * checks to see if the player has won the game <br />
	 * the player wins when only the rectangles with the
	 * bombs are hidden
	 * @return true if the player wins
	 */
	public boolean playerWin()
	{
		return false;
	}
	
	/**
	 * Update the Grid<br />
	 * the status of the rectangle clicked by the user should
	 * change to show<br />
	 * if the value of the grid is 0, it should keep unhiding
	 * all rectangles around it until there is a number
	 * @param r the row that was clicked
	 * @param c the column that was clicked
	 */
	public void updateGrid(int r, int c)
	{
		// change status of the rectangle clicked to SHOW
		grid[r][c][1]=SHOW;
	}
	
}
