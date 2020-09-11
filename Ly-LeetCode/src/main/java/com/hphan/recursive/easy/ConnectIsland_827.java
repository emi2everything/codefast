package com.hphan.recursive.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ConnectIsland_827
{
    public int largestIsland(int[][] grid)
    {
	// edge
	if (grid.length == 0 || grid[0].length == 0)
	    return 0;

	int n = grid.length;

	// Even every single slot is an island it is n*n ( but they are not island
	// anymore).
	// +1 as 0 and 1 taken --> 1+n*n island is moreeee than enough for this int[]
	int[] islandSize = new int[1 + n * n];

	int iId = 2;
	int size = 0;

	Map<Integer, Integer> iSize = new HashMap<Integer, Integer>();

	// Calculate island size of all island
	for (int i = 0; i < grid.length; i++)
	{
	    for (int j = 0; j < grid[0].length; j++)
	    {
		if (grid[i][j] == 1)
		{
		    size = mark(grid, i, j, iId);
		    iSize.put(iId, size);
		    iId++;
		}
	    }
	}

	int max = 0;

	boolean found0 = false;
	// Find 0 which have the biggest island size
	for (int i = 0; i < grid.length; i++)
	{
	    for (int j = 0; j < grid[0].length; j++)
	    {
		Set<Integer> iNearBy = new HashSet<Integer>();
		if (grid[i][j] == 0)
		{
		    found0 = true;
		    if (i > 0 && grid[i - 1][j] > 0)
			iNearBy.add(grid[i - 1][j]);
		    if (j > 0 && grid[i][j - 1] > 0)
			iNearBy.add(grid[i][j - 1]);
		    if (i < grid.length - 1 && grid[i + 1][j] > 0)
			iNearBy.add(grid[i + 1][j]);
		    if (j < grid[0].length - 1 && grid[i][j + 1] > 0)
			iNearBy.add(grid[i][j + 1]);
		}
		int newSize = 1;
		for (Integer island : iNearBy)
		    newSize += iSize.get(island);
		if (newSize > max)
		    max = newSize;
	    }
	}
	if (found0)
	    return max;
	return n * n;
    }

    // Calculate island size
    public int mark(int[][] grid, int i, int j, int iId)
    {
	if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == 0)
	    return 0;

	if (grid[i][j] == 1)
	{
	    grid[i][j] = iId;
	    return 1 + mark(grid, i + 1, j, iId) + mark(grid, i, j + 1, iId) + mark(grid, i - 1, j, iId)
		    + mark(grid, i, j - 1, iId);
	}
	return 0;
    }
}
