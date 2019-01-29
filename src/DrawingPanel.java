/**
 * Drawing Panel Class<br />
 * This is the class that is used to draw things on the 
 * screen.
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
 */
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrawingPanel extends JPanel implements MouseListener{
	// the grid we are drawing
	private MyGrid mg;
	
	/**
	 * Default constructor for DrawingPanel<br />
	 * we create the grid we are using here and add a
	 * MouseListener and set this drawing panel to focus
	 */
	public DrawingPanel()
	{
		super();
		
		// set this drawing panel to focused
		// so we can get mouse events
		setFocusable(true);
		requestFocusInWindow();
		
		// add our mouse listener to the drawing panel
		addMouseListener(this);
		
		// create the grid
		mg=new MyGrid();
	}
	
	/**
	 * the method we use to draw things into our panel
	 * the only thing we draw is the grid
	 * @param g the graphics object we will be using
	 */
	public void paintComponent(Graphics g)
	{
	    super.paintComponent(g);
	    mg.draw(g);
	}
	
	//
	public void mouseClicked(MouseEvent m)
	{
		// convert to grid coordinates
		int row = m.getY()/(mg.getRectHeight()+mg.getMargin());
		int col = m.getX()/(mg.getRectWidth() + mg.getMargin());
		String gameOverMessage = "";
		boolean gameOver = false;
		//System.out.println(m.getX() + " " + m.getY() + " " + col + " " + row);
		//mg.test(row, col);
			
		// update the grid
		mg.updateGrid(row, col);
				
		// update the screen
		repaint();
		
		// check if dead
		if(mg.checkDead(row, col))
		{
			gameOverMessage="You Lose!";
			gameOver = true;
		}
		
		// check if win
		if(mg.playerWin())
		{
			gameOverMessage="You Win!";
			gameOver = true;
		}
		
		// end game if game over
		if(gameOver)
		{
			JOptionPane.showMessageDialog(null, gameOverMessage);
			System.exit(0);
		}
	}
	
	// useless mouse interface methods that we must have
	// due to using an interface
	public void mouseEntered(MouseEvent m){}
	public void mouseExited(MouseEvent m){}
	public void mousePressed(MouseEvent m){}
	public void mouseReleased(MouseEvent m){}	
}
