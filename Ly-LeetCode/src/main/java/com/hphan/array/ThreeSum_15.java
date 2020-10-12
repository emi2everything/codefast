package com.hphan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15
{
    public List<List<Integer>> threeSum(int[] nums)
    {
	List<List<Integer>> out = new ArrayList<List<Integer>>();

	Arrays.sort(nums);

	for (int i = 0; i < nums.length; i++)
	    if (i == 0 || nums[i] != nums[i - 1])
		twoSum(nums, out, i);

	return out;
    }

    /**
     * Two sum 2 pointers
     */
    private void twoSum(int[] nums, List<List<Integer>> out, int firstOne)
    {
	int low = firstOne + 1, high = nums.length - 1;

	while (low < high)
	{
	    int sum = nums[firstOne] + nums[low] + nums[high];
	    if (sum > 0)
		high--;
	    else if (sum < 0)
		low++;
	    else
	    {
		out.add(Arrays.asList(nums[firstOne], nums[low], nums[high]));
		low++;
		while (low < high && nums[low] == nums[low - 1])
		    low++;
	    }
	}
    }
}
