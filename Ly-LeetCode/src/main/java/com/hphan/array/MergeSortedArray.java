package com.hphan.array;

/**
 * Be careful how you copy element of array
 *
 */
public class MergeSortedArray
{
    class Solution
    {
	public void merge(int[] nums1, int m, int[] nums2, int n)
	{

	    if (m == 0)
	    {
		for (int i = 0; i < n; i++)
		    nums1[i] = nums2[i];
		return;
	    }
	    if (n == 0)
		return;

	    int len = m + n;

	    // Move array 1 element to the end
	    for (int i = m - 1; i >= 0; i--)
		nums1[i + n] = nums1[i];

	    // Merge
	    int i = n, j = 0, index = 0;
	    while (i < len && j < n)
	    {
		if (nums1[i] < nums2[j])
		{
		    nums1[index] = nums1[i];
		    i++;
		} else
		{
		    nums1[index] = nums2[j];
		    j++;
		}
		index++;
	    }
	    // Remaining
	    while (i < m)
	    {
		nums1[index] = nums1[i];
		index++;
		i++;
	    }
	    while (j < n)
	    {
		nums1[index] = nums2[j];
		index++;
		j++;
	    }
	}
    }
}
