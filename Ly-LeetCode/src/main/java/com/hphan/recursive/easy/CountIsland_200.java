package com.hphan.recursive.easy;

/**
 * Classic easy recursion question
 * 
 * @author Ly
 *
 */
public class CountIsland_200
{
    public int numIslands(char[][] grid)
    {
	if (grid.length == 0)
	    return 0;
	if (grid[0].length == 0)
	    return 0;

	int count = 0;

	for (int i = 0; i < grid.length; i++)
	{
	    for (int j = 0; j < grid[0].length; j++)
	    {
		if (grid[i][j] == '1')
		{
		    count++;
		    mark(grid, i, j);
		}
	    }
	}
	return count;
    }

    public void mark(char[][] grid, int i, int j)
    {
	grid[i][j] = '0';

	if (i < grid.length - 1 && grid[i + 1][j] == '1')
	    mark(grid, i + 1, j);

	if (j < grid[0].length - 1 && grid[i][j + 1] == '1')
	    mark(grid, i, j + 1);

	if (i > 0 && grid[i - 1][j] == '1')
	    mark(grid, i - 1, j);

	if (j > 0 && grid[i][j - 1] == '1')
	    mark(grid, i, j - 1);
    }
}
