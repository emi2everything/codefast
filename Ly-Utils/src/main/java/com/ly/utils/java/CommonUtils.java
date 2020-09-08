package com.ly.utils.java;

import java.util.List;

public class CommonUtils
{
    public static void print(int[] arr)
    {
	for (int i = 0; i < arr.length; i++)
	{
	    System.out.print(arr[i] + " ");
	}
	System.out.println();

    }

    public static void print(int[][] arr)
    {
	for (int i = 0; i < arr.length; i++)
	{
	    for (int j = 0; j < arr[0].length; j++)
	    {
		System.out.print(arr[i][j] + " ");
	    }
	    System.out.println();
	}
    }

    public static void print(List<List<Integer>> arr)
    {
	for (int i = 0; i < arr.size(); i++)
	{
	    for (int j = 0; j < arr.get(i).size(); j++)
	    {
		System.out.print(arr.get(i).get(j) + " ");
	    }
	    System.out.println();
	}

    }

    public static void print(char[][] arr)
    {
	for (int i = 0; i < arr.length; i++)
	{
	    for (int j = 0; j < arr[0].length; j++)
	    {
		System.out.print(arr[i][j] + " ");
	    }
	    System.out.println();
	}
    }
}
