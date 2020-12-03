/*
 * A class that takes a maze and finds every possible solution using recursion and backtracking
 *
 * @author Jose Polanco
 * Advanced Java COMPSCI 221-02
 */
package maze;

public class Maze 
{
    private char[][] maze;
    private int ROWS;
    private int COLS;
    
    public Maze(int rows, int cols, char[][] userMaze) 
    {
        ROWS = rows;
        COLS = cols;
        maze = new char[ROWS][COLS];
        for(int i = 0; i < this.ROWS; ++i)
        {
            for(int j = 0; j < this.COLS; ++j)
            {
                maze[i][j] = userMaze[i][j];
            }
        }
    }
    
    /**Method for solving the maze 
     * 
     * @param r: Row index of starting point
     * @param c: Column index of starting point 
     */
    public void solve(int r, int c) 
    {
        if(maze[r][c] == 'e')
            this.print();
        if(maze[r][c] == 'b')
            move(r, c);
        if(maze[r][c] == '0')
        {
            maze[r][c] = 'p';
            move(r, c);
            maze[r][c] = '0';
        }
    }
    
    private void move(int r, int c)
    {
        if(upAvail(r,c)){solve(r-1, c);}
        if(downAvail(r,c)){solve(r+1, c);}
        if(leftAvail(r,c)){solve(r, c-1);}
        if(rightAvail(r,c)){solve(r, c+1);}
    }
    
    /**Method that checks if the cell above is a wall
     * 
     * @param r: Index of current row
     * @param c: index of current column
     * @return: returns false if a wall, true if not a wall
     */
    private boolean upAvail(int r, int c)
    {
        if(r - 1 < 0 || maze[r-1][c] == '1')
            return false;
        return true;
    }
    
    /**Method that checks if the cell below is a wall
     * 
     * @param r: Index of current row
     * @param c: index of current column
     * @return: returns false if a wall, true if not a wall
     */
    private boolean downAvail(int r, int c)
    {
        if(r + 1 >= ROWS || maze[r+1][c] == '1')
            return false;
        return true;
    }
    
    /**Method that checks if the cell to the left is a wall
     * 
     * @param r: Index of current row
     * @param c: index of current column
     * @return: returns false if a wall, true if not a wall
     */
    private boolean leftAvail(int r, int c)
    {
        if(c - 1 < 0 || maze[r][c-1] == '1')
            return false;
        return true;
    }
    
    /**Method that checks if the cell to the right is a wall
     * 
     * @param r: Index of current row
     * @param c: index of current column
     * @return: returns false if a wall, true if not a wall
     */
    private boolean rightAvail(int r, int c)
    {
        if(c + 1 >= COLS || maze[r][c+1] == '1')
            return false;
        return true;
    }
    
    /**Method for printing when a solution if found
     * 
     * @return: returns the given maze in string format
     */
    private void print() 
    {
        System.out.println(this);
    }
    
    
    public String toString() 
    {
        String str = "";
        for(int i = 0; i < this.ROWS; ++i)
        {
            for(int j = 0; j < this.COLS; ++j)
            {
                str += maze[i][j] + " ";
            }
            str += "\n";
        }             
        return str;
    }
}
