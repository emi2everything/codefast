package com.hphan.array;

public class ProductOfArrayExceptItself_238
{
    /**
     * /* Similar to trap water problem
     **/
    public int[] productExceptSelf(int[] nums)
    {
	int[] left = new int[nums.length];
	int[] right = new int[nums.length];
	int[] out = new int[nums.length];

	left[0] = nums[0];
	for (int i = 1; i < nums.length; i++)
	    left[i] = left[i - 1] * nums[i];

	right[nums.length - 1] = nums[nums.length - 1];
	for (int i = nums.length - 2; i >= 0; i--)
	    right[i] = right[i + 1] * nums[i];

	for (int i = 0; i < nums.length; i++)
	{
	    int l = 1, r = 1;
	    if (i - 1 >= 0)
		l = left[i - 1];
	    if (i + 1 <= nums.length - 1)
		r = right[i + 1];
	    out[i] = l * r;
	}

	return out;
    }

    /**
     * I didn't come up with this :) It is very good though
     * @param nums
     * @return
     */
    public int[] productExceptSelfWithO1Space(int[] nums)
    {
	int length = nums.length;
	int[] answer = new int[length];

	answer[0] = 1;
	for (int i = 1; i < length; i++)
	    answer[i] = nums[i - 1] * answer[i - 1];

	int R = 1;
	for (int i = length - 1; i >= 0; i--)
	{
	    answer[i] = answer[i] * R;
	    R *= nums[i];
	}

	return answer;
    }
}
