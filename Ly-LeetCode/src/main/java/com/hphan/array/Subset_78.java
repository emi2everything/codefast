package com.hphan.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Typical dfs
 * 
 * @author Ly
 *
 */
public class Subset_78
{
    /**
     * Method 2: Try to make it faster
     */


    /**
     * Method 1: DFS
     */
    public static List<List<Integer>> subsetsDfs(int[] nums)
    {
	List<List<Integer>> output = new ArrayList<List<Integer>>();

	// Edge
	if (nums.length == 0)
	    return output;

	// Logic
	return dfs(nums.length - 1, nums);
    }

    public static List<List<Integer>> dfs(int index, int[] nums)
    {
	List<List<Integer>> output = new ArrayList<List<Integer>>();

	if (index == 0)
	{
	    List<Integer> localOut = Arrays.asList(nums[index]);
	    output.add(localOut);
	    output.add(new ArrayList<>());
	    return output;
	}

	for (List<Integer> prev : dfs(index - 1, nums))
	{
	    output.add(prev);
	    List<Integer> localOut = new ArrayList<Integer>(prev);
	    localOut.add(nums[index]);
	    output.add(localOut);
	}
	return output;
    }
}
