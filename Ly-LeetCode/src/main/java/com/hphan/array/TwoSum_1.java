package com.hphan.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1
{
    /**
     * Hash Table - One Pass
     */
    public int[] twoSum(int[] nums, int target)
    {
	int[] out = new int[2];

	Map<Integer, Integer> m = new HashMap<Integer, Integer>();

	for (int i = 0; i < nums.length; i++)
	{
	    if (m.get(target - nums[i]) != null)
	    {
		out[0] = i;
		out[1] = m.get(target - nums[i]);
		return out;
	    }
	    m.put(nums[i], i);
	}
	return out;
    }

    /**
     * Hash Table - Two Pass
     */
    public int[] twoSum2(int[] nums, int target)
    {
	int[] out = new int[2];

	Map<Integer, Integer> m = new HashMap<Integer, Integer>();

	for (int i = 0; i < nums.length; i++)
	    m.put(nums[i], i);

	for (int i = 0; i < nums.length; i++)
	{
	    if (m.get(target - nums[i]) != null && i != m.get(target - nums[i]))
	    {
		out[0] = i;
		out[1] = m.get(target - nums[i]);
		return out;
	    }
	}
	return out;
    }
}
