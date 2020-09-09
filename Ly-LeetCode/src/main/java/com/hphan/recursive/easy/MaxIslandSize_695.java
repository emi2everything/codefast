package com.hphan.recursive.easy;

/**
 * Typical Island Problem
 * 
 * @author Ly
 *
 */
public class MaxIslandSize_695
{
    public int maxAreaOfIsland(int[][] grid)
    {
	if (grid.length == 0)
	    return 0;
	if (grid[0].length == 0)
	    return 0;

	int max = 0;

	for (int i = 0; i < grid.length; i++)
	{
	    for (int j = 0; j < grid[0].length; j++)
	    {
		if (grid[i][j] == 1)
		{
		    int size = mark(grid, i, j);
		    max = max > size ? max : size;
		}
	    }
	}
	return max;
    }

    public int mark(int[][] grid, int i, int j)
    {
	if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == 0)
	    return 0;

	if (grid[i][j] == 1)
	{
	    grid[i][j] = 0;
	    return 1 + mark(grid, i + 1, j) + mark(grid, i, j + 1) + mark(grid, i - 1, j) + mark(grid, i, j - 1);
	}
	return 0;
    }
}
