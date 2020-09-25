package com.hphan.array;

public class MaxSubArray_53
{
    public static void main(String[] args)
    {
	int[] val = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
	System.out.println(maxSubArray2(val));
    }

    /**
     * Easy O(n)
     */
    public static int maxSubArray2(int[] nums)
    {
	if (nums.length == 0)
	    return 0;

	int sum = nums[0], max = nums[0];

	for (int i = 1; i < nums.length; i++)
	{
	    sum = Math.max(sum + nums[i], nums[i]);
	    max = max > sum ? max : sum;
	}
	return max;
    }
}
