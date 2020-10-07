package com.hphan.datastructure;

import java.io.IOException;

public class QuickSort
{
    // Driver program
    public static void main(String args[]) throws IOException
    {
	int arr[] = { 2, 3, 1 };
	int n = arr.length;

	quickSort(arr, 0, n - 1);

	System.out.println("sorted array");
	printArray(arr);
    }

    private static void quickSort(int[] arr, int left, int right)
    {
	if (left < right)
	{
	    int p = partition(arr, left, right);
	    System.out.println("Partition " + p);
	    quickSort(arr, left, p - 1);
	    quickSort(arr, p + 1, right);
	}
    }

    private static int partition(int[] arr, int left, int right)
    {
	System.out.println("Left = " + left + " right = " + right);
	int pivotVal = arr[right];
	int swapIndex = left;

	for (int i = left; i < right; i++)
	{
	    System.out.println("Checking " + i);
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
	System.out.println("Swapping " + i  + ":" + j);
	int t = A[i];
	A[i] = A[j];
	A[j] = t;
    }

    static void printArray(int arr[])
    {
	int n = arr.length;
	for (int i = 0; i < n; ++i)
	    System.out.print(arr[i] + " ");
	System.out.println();
    }

}
