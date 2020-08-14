package com.hphan.convert;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger
{

    public static void main(String[] args)
    {
	// TODO Auto-generated method stub

    }

    public int romanToInt(String s)
    {
	Map<Character,Integer> roman = new HashMap<Character,Integer>();
	roman.put('I',1);
	roman.put('V',5);
	roman.put('X',10);
	roman.put('L',50);
	roman.put('C',100);
	roman.put('D',500);
	roman.put('M',1000);
	
	int output = 0;
	
	for (int i = 0 ; i < s.length(); i++)
	{
	    if (i < s.length()-1 && roman.get(s.charAt(i)) < roman.get(s.charAt(i+1)))
	    {
		output = output - roman.get(s.charAt(i));
	    }
	    else
	    {
		output = output + roman.get(s.charAt(i));
	    }
	}
	return output;
    }
}
