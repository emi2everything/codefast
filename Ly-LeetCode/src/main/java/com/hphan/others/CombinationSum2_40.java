package com.hphan.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The tricky thing is this: Each number in candidates may only be used once in
 * the combination. It is not an accurate description, see below 1 can be use
 * twice in 1,1,6 but 1(index1),7 and 1(index5), 7 are the same :| Heck
 * 
 * Input: candidates = [10,1,2,7,6,1,5], target = 8, A solution set is: [ [1,
 * 7], [1, 2, 5], [2, 6], [1, 1, 6] ]
 * 
 * @author Ly
 *
 */
public class CombinationSum2_40
{
    public static void main(String[] args)
    {
	System.out.println("Test");
    }

    /**
     * Use a set - it is slow as it has to convert set to list
     */
    public List<List<Integer>> combinationSum2Set(int[] candidates, int target)
    {
	Arrays.sort(candidates);
	Set<List<Integer>> temp = callSet(candidates, target, candidates.length - 1);
	return new ArrayList<List<Integer>>(temp);
    }

    public static Set<List<Integer>> callSet(int[] candidates, int target, int pos)
    {
	Set<List<Integer>> out = new HashSet<List<Integer>>();

	if (target < 0)
	    return out;

	if (target == 0)
	{
	    List<Integer> combi = new ArrayList<Integer>();
	    out.add(combi);
	    return out;
	}

	for (int i = pos; i >= 0; i--)
	{
	    for (List<Integer> c : call(candidates, target - candidates[i], i - 1))
	    {
		c.add(candidates[i]);
		out.add(c);
	    }
	}

	return out;
    }

    /**
     * How to not use set
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
	Arrays.sort(candidates);
	return call(candidates, target, candidates.length - 1);
    }

    public static List<List<Integer>> call(int[] candidates, int target, int pos)
    {
	List<List<Integer>> out = new ArrayList<List<Integer>>();

	if (target < 0)
	    return out;

	if (target == 0)
	{
	    List<Integer> combi = new ArrayList<Integer>();
	    out.add(combi);
	    return out;
	}

	for (int i = pos; i >= 0; i--)
	{
	    if (i == pos || candidates[i] != candidates[i + 1]) // So that it won't go to similar path
	    {
		List<List<Integer>> recurList = call(candidates, target - candidates[i], i - 1);
		for (int j = 0; j < recurList.size(); j++)
		{
		    recurList.get(j).add(candidates[i]);
		    out.add(recurList.get(j));
		}
	    }
	}
	return out;
    }

}
