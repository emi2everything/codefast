package com.hphan.array;

public class RemoveValueInPlace_27
{
    public int removeElement(int[] nums, int val)
    {
	int len = nums.length;
	int space = 0;

	for (int i = 0; i < nums.length; i++)
	{
	    if (nums[i] == val)
	    {
		len--;
		space++;
	    } else
	    {
		nums[i - space] = nums[i];
	    }
	}
	return len;
    }
}
