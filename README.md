# APCSMineSweeper
This version of Minesweeper is designed as a lab for AP Computer Science A students to work on multidimensional arrays. The Minesweeper application does not function properly and it the task of the students to complete the program.

# Students
Everything you need is in the toStudents directory. Your task is to complete the following methods in MyGrid.java to make MineSweeper function properly
- void initializeHints()
...This method generates the numbers that tell the player how many mines are around a square
- boolean checkDead(int r, int c)
...This method returns true if the player clicks a mine
- boolean checkWin()
...This method returns true when all the squares have been clicked except the squares containing bombs
- void updateGrid(int r, int c)
... This method shows the number beneath the square. If the square is zero, the method will open all the adjacent squares that are not mines. The method will clear an area of zeros to enable faster play.

You can refer to Minesweeper.fodt for more information.
Javadocs for TheGrid class is available in the javadoc folde

# Teachers
The source for of the program is available under the src directory. The students don't need to look at the source of the other three classes. But you can show them after the lab for learning purposes.

# More Information
For more information about the lab, you can visit https://jeffreywong.ca/programs/ap-computer-science:-minesweeper-lab/

# License
This lab and java files are created by Jeffrey Wong. The Java files are distributed under the **MIT License** as shown below. The lab is distributed under the **Creative Commons Attribution ShareALike 4.0 International License** (https://creativecommons.org/licenses/by-sa/4.0/)

# MIT LICENSE
> Copyright (c) 2016 Jeffrey Wong (contact@jeffreywong.ca)
>
> Permission is hereby granted, free of charge, to any person obtaining a copy
> of this software and associated documentation files (the "Software"), to deal
> in the Software without restriction, including without limitation the rights
> to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
> copies of the Software, and to permit persons to whom the Software is
> furnished to do so, subject to the following conditions:
> The above copyright notice and this permission notice shall be included in all
> copies or substantial portions of the Software.
>
> THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
> IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
> FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
> AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
> LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
> OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
> SOFTWARE.
