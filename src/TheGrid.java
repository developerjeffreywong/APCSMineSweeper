/**
 * This is the Grid used for MineSweeper
 * It is a 3D array<br />
 * Example:<br />
 * <br />
 * {{{1,0}{1,0}{0,1}}<br />
 *  {{-1,0},{1,0},{0,0}}<br />
 *  {{1,1},{1,0},{0,0}}}<br />
 *  <br />
 * This is a 3x3 grid.
 * In Row 0, Column 0, {1,0},
 * The first number indicates how many bombs are beside
 * this location.
 * The second number indicates whether the number is hidden
 * or not (1 to show, 0 to hide)
 * 
 * a[column][row][info[2]]
 * 
 * @author Jeffrey Wong
 *
 * MIT LICENSE
 * Copyright (c) 2016 Jeffrey Wong (contact@jeffreywong.ca)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */
//YOU ARE NOT TO MODIFY ANYTHING BELOW!!!!
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

public class TheGrid {
	
	// 3D array for the grid
	private int [][][] grid;
	
	// rows and columns of grid
	private int rows;
	private int cols;
	
	// number of bombs
	private int numBombs;
	
	// dimensions of each rectangle
	private int rectWidth;
	private int rectHeight;
	private int margin;
	
	// font we will use
	private Font theFont;
	
	// constants
	/** the integer representing the bomb in the grid*/
	public final static int BOMB = -1;
	
	/** the integer we use to hide the number */
	public final static int HIDE = 0; // int to hide number
	
	/** the integer we use to show the number<br />
	 * if the number we show is zero, nothing will be shown 
	 */
	public final static int SHOW = 1; // int to show number
	
	/** the color of the background */
	public static Color COLORBG = Color.BLACK;
	
	/** the color of the rectangles */
	public static Color COLORFG = Color.GREEN;
	
	/** the color of the bomb tile when clicked */
	public static Color COLORBOMB = Color.RED;
	
	/** TESTING FLAG <br />
	 * if set to true, the value of the grid will be displayed
	 */
	public static boolean TESTING = false;
	
	/** 
	 * Create the grid and randomly place 
	 * given number of bombs in the grid. <br />
	 * The maximum number of bombs is (r*c)/4
	 * 
	 * @param r the number of rows for the grid
	 * @param c the number of columns for the grid
	 * @param nb the number of bombs to find
	 * @param m the space between individual rectangles
	 * 
	 */
	public TheGrid(int r, int c, int nb, int m)
	{
		rows = r;
		cols = c;
		numBombs = nb;
		
		// calculate the width of each square
		margin = m;
		rectWidth=MineSweeper.WIDTH/cols - margin;
		rectHeight=MineSweeper.HEIGHT/rows - margin;
		
		// create our font
		theFont = new Font("SansSerif", Font.PLAIN, (int)(rectHeight/1.33));
		grid = new int[rows][cols][2];
		
		// check to see if we are over the
		// maximum number of bombs allowed
		if(numBombs > (rows*cols)/4)
		{
			numBombs = (rows*cols)/4;
		}
		
		// keep track of the number of bombs placed
		int bombsPlaced = 0;
		
		// keep putting bombs until the required number
		// of bombs placed is reached
		while(bombsPlaced < numBombs)
		{
			// Generate a random coordinate
			int row = (int)(Math.random()*rows);
			int col = (int)(Math.random()*cols);
			if(grid[row][col][0] != BOMB)
			{
				grid[row][col][0] = BOMB;
				bombsPlaced++;
			}
		}
	}
	
	/**
	 * The default constructor<br />
	 * Will create a 5x4 grid with 5 bombs
	 * and a margin of 5 pixels between the rectangles
	 */
	public TheGrid()
	{
		this(5,4,100,5);
	}
	
	/**
	 * draws the grid onto the screen
	 * @param g graphics object
	 */
	public void draw(Graphics g)
	{
		// draw a rectangle of COLORBG that will
		// cover the entire screen
		g.setColor(COLORBG);
		g.fillRect(0, 0, MineSweeper.WIDTH, MineSweeper.HEIGHT);
		
		// if not testing, use appropriate font size
		if(!TESTING){g.setFont(theFont);}
		
		// go through each element of our grid
		for(int r = 0; r < grid.length; r++)
		{
			for(int c = 0; c < grid[r].length; c++)
			{
				g.setColor(COLORFG); // reset color to our grid
				
				/* if not testing
				 * we will draw filled in rectangles for the
				 * ones we have not yet clicked
				 * and just a rectangular outline for the ones
				 * we have clicked
				 * we will draw a filled in rectangle for the
				 * bomb when the bomb is clicked
				 */
				if(!TESTING)
				{
					// we have not clicked this rectangle yet
					if(grid[r][c][1]==HIDE)
					{	
						g.fillRoundRect(rectWidth*c + margin*c, rectHeight*r + margin*r, rectWidth, rectHeight, rectWidth/4, rectHeight/4);
					}
					else
					{
						// clicked and not a bomb and not 0
						if(grid[r][c][0] > 0)
						{
							g.drawRoundRect(rectWidth*c + margin*c, rectHeight*r + margin*r, rectWidth, rectHeight, rectWidth/4, rectHeight/4);
							g.drawString("" + grid[r][c][0], rectWidth*c + margin*c + theFont.getSize()/2, rectHeight*r + margin*r + theFont.getSize());
						}
						// clicked and is a bomb
						else if(grid[r][c][0] == BOMB)
						{
							g.setColor(COLORBOMB);
							g.fillRoundRect(rectWidth*c + margin*c, rectHeight*r + margin*r, rectWidth, rectHeight, rectWidth/4, rectHeight/4);
						}
						// clicked and is a zero, just draw a rectangle 
						else
						{
							g.drawRoundRect(rectWidth*c + margin*c, rectHeight*r + margin*r, rectWidth, rectHeight, rectWidth/4, rectHeight/4);
						}
					}
				}
				/*
				 * We draw a rectangle that is not filled in
				 * Draw a string inside rectangle with the values of the grid
				 */
				else
				{
					g.drawRoundRect(rectWidth*c + margin*c, rectHeight*r + margin*r, rectWidth, rectHeight, rectWidth/4, rectHeight/4);
					g.drawString("{" + grid[r][c][0] + "," + grid[r][c][1] + "}", rectWidth*c + margin*c, rectHeight*r + margin*r + rectHeight/2);
				}
			}
		}
	}
	
	// GETTER METHODS BELOW
	/**  returns the number of rows in the grid
	 * @return the number of rows in the grid */
	public int getRows()
	{
		return rows;
	}
	
	/** returns the number of columns in the grid 
	 * @return the number of columns in the grid */
	public int getCols()
	{
		return cols;
	}
	
	/** returns the total number of bombs in the grid 
	 * @return the total number of bombs in the grid */
	public int getNumBombs()
	{
		return numBombs;
	}
	
	/** returns the width of one rectangle in the grid 
	 * @return the width of one rectangle in the grid */
	public int getRectWidth()
	{
		return rectWidth;
	}
	
	/** returns the height of one rectangle in the grid 
	 * @return the height of one rectangle in the grid */
	public int getRectHeight()
	{
		return rectHeight;
	}
	/** returns the space between each rectangle in the grid  
	 * @return the space between each rectangle in the grid */
	public int getMargin()
	{
		return margin;
	}
	
	/** returns the grid 
	 * @return the grid */
	public int [][][] getGrid()
	{
		return grid;
	}
	
	/**public void test(int r, int c)
	{
		grid[r][c][1]=SHOW;
	}*/
}
