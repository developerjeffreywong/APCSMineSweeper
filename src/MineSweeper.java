/**
 * The MineSweeper Main Class
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
 
import java.awt.Container;
import javax.swing.JFrame;
public class MineSweeper extends JFrame{
	
	// width and height of the window
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	
	// position of the window on the screen
	public static final int XPOS = 0;
	public static final int YPOS = 0;
	
	
	// our DrawingPanel to display the grid
	private DrawingPanel dp;
	
	// the constructor
	public MineSweeper()
	{
		// call the original JFrame constructor
		super();
		
		// create a new DrawingPanel
		dp = new DrawingPanel();
		// get the JFrame container that holds all
		// the elements
		Container c = getContentPane();
		
		// add our Drawing Panel to the JFrame
		c.add(dp);
	}
	
	public static void main(String [] args)
	{
		MineSweeper window = new MineSweeper();
		window.setBounds(XPOS, YPOS, WIDTH, HEIGHT);
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setVisible(true);
	}
}
