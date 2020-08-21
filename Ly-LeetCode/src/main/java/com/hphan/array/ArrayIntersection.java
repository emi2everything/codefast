package com.hphan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayIntersection
{
    public static void main(String[] args)
    {

    }

    public List<String> commonChars(String[] A)
    {
	//edge
	if (A.length == 0)
	    return new ArrayList<String>();

	//logic
	int[] charCheck = new int[24];
	for (int i = 0 ; i < charCheck.length; i ++)
	{
	    charCheck[i] = 0;
	}
		
	for (int i = 0; i < A.length; i++)
	{
	    int[] charAvai = new int[24];
	    for (int j = 0; j < A[i].length(); j++)
	    {
		charAvai[A[i].charAt(j) - 'a'] +=1;
	    }

	    for (int j = 0 ; j < charCheck.length ; j++)
	    {
		charCheck[j] = Math.min(charCheck[j],charAvai[j]);
	    }
	}
	
	List<String> output = new ArrayList<String>();
	for (int i = 0 ; i < charCheck.length; i++)
	{
	    for (int j = 0; j < (charCheck[i]) ; j++)
	    {
		output.add(String.valueOf((char)('a' + i)));
	    }
	}
	return output;
    }

}
