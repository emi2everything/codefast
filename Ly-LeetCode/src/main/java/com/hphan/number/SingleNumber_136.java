package com.hphan.number;

public class SingleNumber_136
{
    /**
     * Method 1: Using a set add/remove to keep track of appearance is ood/even number
     * Method 2: Same thing, use a map
     * Method 3: Same thing, use a list (add/remove)
     * Method 4: Bit manipulation -- Hehe let's do it
     * a XOR 0 = a
     * a XOR a = 0
     */
    public int singleNumber(int[] nums)
    {
	int out = 0;
	for (int i = 0 ; i < nums.length ; i++)
	    out = out ^ nums[i];
	return out;
    }
}
