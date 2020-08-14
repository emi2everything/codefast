package com.hphan.dp.common;

import java.util.Stack;

import com.ly.utils.java.CommonUtils;

/**
 * Typical dynamic programming 2D
 */
public class LongestCommonSubSequence
{

    public static void main(String[] args)
    {
	String s1 = "cdcba";
	String s2 = "abcdc";

	System.out.println(getLongestCommonSubSequence(s1, s2));
    }

    public static String getLongestCommonSubSequence(String s1, String s2)
    {
	if (s1.length() == 0 || s2.length() == 0)
	    return "";

	// Create DP matrix: s1 for row, s2 for column
	int[][] R = new int[s1.length() + 1][s2.length() + 1];
	for (int i = 0; i < s1.length(); i++)
	{
	    for (int j = 0; j < s2.length(); j++)
	    {
		// Setup DP matrix
		if (i == 0)
		    R[i][j] = 0;
		if (j == 0)
		    R[i][j] = 0;

		// Populate matrix
		if (s1.charAt(i) == s2.charAt(j))
		{
		    R[i + 1][j + 1] = 1 + R[i][j]; // R[i][j] is lss of before this character
		} else
		{
		    R[i + 1][j + 1] = Math.max(R[i][j + 1], R[i + 1][j]);
		}
	    }
	}

	CommonUtils.print(R);

	// Backtrack to find longest subString
	Stack<Character> bts = new Stack<Character>();

	int i = s1.length();
	int j = s2.length();
	while (i > 0 && j > 0)
	{
	   // System.out.println("Checking " + i + ":" + j);
	    if (R[i][j] == R[i - 1][j])
	    {
		i = i - 1;
	    }
	    else if (R[i][j] == R[i][j - 1])
	    {
		j = j - 1;
	    }
	    else if (R[i][j] == R[i - 1][j-1] + 1)
	    {
		bts.push(s1.charAt(i - 1));
		i = i-1;
		j = j-1;
	    } 
	}

	StringBuilder output = new StringBuilder();
	while (bts.size() != 0)
	{
	    output.append(bts.pop());
	}

	return output.toString();
    }

}
