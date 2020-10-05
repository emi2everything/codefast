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
    
    /**
     * 2 pointers
     */
    public int[] twoSum3(int[] numbers, int target) 
    {
        int p1 = 0;
        int p2 = numbers.length - 1;
        int[] out = new int[2];
            
        while (p1 < p2)
        {
            int tmpSum = numbers[p1] + numbers[p2];
            if (tmpSum == target)
            {
                out[0] = p1+1;
                out[1] = p2+1;
            }
            if (tmpSum > target)
                p2--;
            else 
                p1++;
        }
        return out;
    }
}
