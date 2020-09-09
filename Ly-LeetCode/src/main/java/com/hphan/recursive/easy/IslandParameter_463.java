package com.hphan.recursive.easy;

/**
 * Another problem can be solved by countIsland. But it does have other simple method. Go for that first.
 * @author Ly
 *
 */
public class IslandParameter_463
{
    /**
     * Method 2: Solving it by just going through the array
     */
    public int islandPerimeter(int[][] grid)
    {
	int peri = 0;
	for (int i = 0; i < grid.length; i++)
	{
	    for (int j = 0; j < grid[0].length; j++)
	    {
		if (grid[i][j] == 1)
		{
		    peri +=4;
		    if (i > 0 && grid[i-1][j]==1)
			peri--;
		    if (j > 0 && grid[i][j-1]==1)
			peri--;
		    if (i <grid.length-1 && grid[i+1][j]==1)
			peri--;
		    if (j < grid[0].length-1 && grid[i][j+1]==1)
			peri--;
		}
	    }
	}
	return 0;
    }
    
    
    /**
     * Method 1: Solving it as an island problem which does not have to be - can use for multiple island, find max parameter
     */
    public int islandPerimeterIsland(int[][] grid)
    {
	for (int i = 0; i < grid.length; i++)
	{
	    for (int j = 0; j < grid[0].length; j++)
	    {
		if (grid[i][j] == 1)
		    return mark(grid, i, j);
	    }
	}
	return 0;
    }

    public int mark(int[][] board, int i, int j)
    {
	board[i][j] = 2;
	int peri = 4;

	if (i < board.length - 1)
	{
	    if (board[i + 1][j] == 1)
	    {
		peri--;
		peri += mark(board, i + 1, j);
	    }
	    else if (board[i + 1][j] == 2)
		peri--;
	}
	
	if (j < board[0].length - 1)
	{
	    if (board[i][j+1] == 1)
	    {
		peri--;
		peri += mark(board, i, j+1);
	    }
	    else if (board[i][j+1] == 2)
		peri--;
	}
	
	if (i > 0)
	{
	    if (board[i - 1][j] == 1)
	    {
		peri--;
		peri += mark(board, i - 1, j);
	    }
	    else if (board[i - 1][j] == 2)
		peri--;
	}
	
	if (j > 0)
	{
	    if (board[i][j-1] == 1)
	    {
		peri--;
		peri += mark(board, i, j-1);
	    }
	    else if (board[i][j-1] == 2)
		peri--;
	}
	return peri;
    }
}
