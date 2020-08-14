package com.hphan.ds;

/**
 * 2 4
 * 1 3
 */
public class PrintDiagonal
{
    public static void main(String[] args)
    {
	int n = 5;
	
	int[][] matrix = {	{0,5,9,12,14},
				{0,1,6,10,13},
				{0,0,2,7,11},
				{0,0,0,3,8},
				{0,0,0,0,4}};
	
	// Print right half
	for (int c = 0 ; c < n ; c++)
	{
	    for (int d = 0 ; d < (n-c); d++)
	    {
		int col = d;
		int row = c+d;
		System.out.println(matrix[col][row]);
	    }
	}
	
	//Print left half
	
	
    }

}
