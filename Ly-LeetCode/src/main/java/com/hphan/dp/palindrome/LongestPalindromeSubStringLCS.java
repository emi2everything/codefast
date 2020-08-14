package com.hphan.dp.palindrome;

import com.hphan.dp.common.LongestCommonSubString;

public class LongestPalindromeSubStringLCS
{
    public static void main(String[] args)
    {
	String s = "asccsaascvbvbvbvbvcsabvcsa";
	System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s)
    {
	if (s.length()==0) return "";
	
	String reverseS = getReverse(s);
	
	return LongestCommonSubString.getLongestCommonSubString(s,reverseS);
    }

    public static String getReverse(String s)
    {
	StringBuilder sb = new StringBuilder();
	for (int i = s.length()-1; i>=0; i--)
	{
	    sb.append(s.charAt(i));
	}
	return sb.toString();
    }
}
