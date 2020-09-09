package com.hphan.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39
{

    public static void main(String[] args)
    {
    }

    /**
     * Recursion forward - copy array take time
     */
    public List<List<Integer>> combinationSumForward(int[] candidates, int target)
    {

	// call
	List<List<Integer>> out = new ArrayList<List<Integer>>();
	Arrays.sort(candidates);
	call(out, candidates, target, candidates.length - 1, new ArrayList<Integer>());
	return out;
    }

    public void call(List<List<Integer>> out, int[] candidates, int target, int pos, List<Integer> temp)
    {
	if (target == 0)
	{
	    if (temp.size() != 0)
		out.add(temp);
	    return;
	} else if (target < 0)
	    return;

	for (int i = pos; i >= 0; i--)
	{
	    List<Integer> temp2 = new ArrayList<Integer>(temp);
	    temp2.add(candidates[i]);
	    call(out, candidates, target - candidates[i], i, temp2);
	}
    }

    /**
     * Recursion backward - Yay! Got it in first run
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
	return callBackWard(candidates, target, candidates.length - 1);
    }

    private List<List<Integer>> callBackWard(int[] candidates, int target, int pos)
    {
	List<List<Integer>> out = new ArrayList<List<Integer>>();
	if (target==0)
	{
	    List<Integer> combination = new ArrayList<Integer>();
	    out.add(combination);
	}
	if (target < 0)
	{
	    return out;
	}
	
	for (int i = pos; i >= 0 ; i--)
	{
	    for (List<Integer> combi : callBackWard(candidates, target-candidates[i], i))
	    {
		combi.add(candidates[i]);
		out.add(combi);
	    }
	}
	return out;
    }

}
