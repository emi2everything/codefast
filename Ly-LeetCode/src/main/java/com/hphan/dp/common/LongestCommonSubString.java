package com.hphan.dp.common;

import java.util.Stack;

import com.ly.utils.java.CommonUtils;

/**
 * Typical dynamic programming 2D
 */
public class LongestCommonSubString
{

    public static void main(String[] args)
    {
	String s1 = "helloword";
	String s2 = "lowor";
	
	System.out.println(getLongestCommonSubString(s1,s2));
    }

    public static String getLongestCommonSubString(String s1, String s2)
    {
	if (s1.length()==0 || s2.length()==0)
	    return "";
	
	//init
	int max = 0;
	int maxI = -1;
	int maxJ = -1;
	
	//Create DP matrix: s1 for row, s2 for column
	int[][] R = new int[s1.length()+1][s2.length()+1];
	for (int i = 0; i < s1.length(); i++)
	{
	    for (int j = 0; j < s2.length() ; j++)
	    {
		//Setup DP matrix
		if (i==0) R[i][j]=0;
		if (j==0) R[i][j]=0;
		
		//Populate matrix
		if (s1.charAt(i) == s2.charAt(j))
		{
		    R[i+1][j+1] = 1 + R[i][j];
		    
		    // Extra: For backtracking
		    if ( R[i+1][j+1] > max)
		    {
			max = R[i+1][j+1];
			maxI=i+1;
			maxJ=j+1;
		    }
		}
		else
		{
		    R[i+1][j+1] = 0;
		}
	    }
	}
	
	CommonUtils.print(R);
	
	//Backtrack to find longest subString
	Stack<Character> backtrackStack = new Stack<Character>();
	int i = maxI;
	int j = maxJ;
	while (R[i][j] != 0)
	{
	    backtrackStack.push(s1.charAt(i-1));
	    i = i-1;
	    j = j-1;
	}
	
	StringBuilder output = new StringBuilder();
	while(backtrackStack.size()!=0)
	{
	    output.append(backtrackStack.pop());
	}
	
	return output.toString();
    }

}
