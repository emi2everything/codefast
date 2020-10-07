package com.hphan.array;

public class FindKLargest_215
{

    public int findKthLargest(int[] nums, int k)
    {
	/**
	 * Let's do eat processed food
	*/
	// Arrays.sort(nums);
	// return nums[nums.length-k];

	return quickSort(nums, 0, nums.length - 1, k);
    }

    private static int quickSort(int[] arr, int left, int right, int k)
    {
	if (left <= right)
	{
	    int p = partition(arr, left, right);

	    if (p == arr.length - k)
	    	return arr[p];
	    else
	    {	    
    	    	int leftVal = quickSort(arr, left, p - 1, k);

    	    	if (leftVal != Integer.MAX_VALUE)
    	    	    return leftVal;
    	    	
    	    	int rightVal = quickSort(arr, p + 1, right,k);
    	    	
    	    	if (rightVal != Integer.MAX_VALUE)
    	    	    return rightVal;
    	    	
	    }
	}
	return Integer.MAX_VALUE;
    }

    private static int partition(int[] arr, int left, int right)
    {
	int pivotVal = arr[right];
	int swapIndex = left;

	for (int i = left; i < right; i++)
	{
	    if (arr[i] <= pivotVal)
	    {
		swap(arr, swapIndex, i);
		swapIndex++;
	    }
	}
	swap(arr, swapIndex, right);
	return swapIndex;
    }
    
    static void swap(int[] A, int i, int j)
    {
	int t = A[i];
	A[i] = A[j];
	A[j] = t;
    }
}
