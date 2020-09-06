package com.hphan.array;

/**
 * I struggle so much during implementation. I need to practice doing tedious thing
 * 
 * @author Ly
 *
 */
public class DetectPatternLengthM_1566
{
    public static void main(String[] args)
    {
	int[] arr = {1,2,1,2,1,3};
	System.out.println(containsPattern(arr, 2, 3));
    }

    public static boolean containsPattern(int[] arr, int m, int k)
    {
	if (arr.length < m * k)
	    return false;
	
	int n = arr.length;
	boolean can = true;
	
	outer: for ( int i = 0 ; i <= (n-k*m) ; i++)
	{
	    System.out.println("i = " + i);
	    can = true;
	    inner1: for (int kI = 1 ; kI < k ; kI++)
	    {
		System.out.println("--------------");
		inner2: for (int mI = 0 ; mI <= (m-1) ; mI++)
		{
		    System.out.println(i+mI);
		    System.out.println(i+mI+kI*m);
		    System.out.println();
		    if (arr[i+mI] != arr[i+mI+kI*m])
		    {
			can = false;
			break inner1;
		    }
		}
	    }
	    if (can)
		return true;
	}
	if (can)
	    return true;
	return false;
    }
}
