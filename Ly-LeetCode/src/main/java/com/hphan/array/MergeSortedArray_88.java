package com.hphan.array;

public class MergeSortedArray_88
{
    public void merge(int[] nums1, int m, int[] nums2, int n)
    {
	int i = n, j = 0, p = 0;

	// Shift back
	for (int k = m - 1; k >= 0; k--)
	    nums1[k + n] = nums1[k];

	while (i < m + n && j < n)
	{
	    if (nums1[i] <= nums2[j])
		nums1[p++] = nums1[i++];
	    else
		nums1[p++] = nums2[j++];
	}
	while (j < n)
	{
	    nums1[p++] = nums2[j++];
	}
    }
}
