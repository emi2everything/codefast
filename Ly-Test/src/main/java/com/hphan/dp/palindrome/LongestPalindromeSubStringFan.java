package com.hphan.dp.palindrome;

public class LongestPalindromeSubStringFan
{
    public static void main(String[] args)
    {
	String s = "ac";
	System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s)
    {
	if (s.length()==0) return "";
	
	int max = 0;
	String out = ""+ s.charAt(0);
	for (int i = 0; i < s.length(); i++)
	{
	    int localMaxE = 0;
	    String localOutE = "";

	    int localMaxO = 1;
	    String localOutO = "" + s.charAt(i);

	    // Paralindrom for even subString
	    inner1: for (int j = 0; j < Math.min(i+1, s.length() - i -1); j++)
	    {
		if (s.charAt(i + j + 1 ) == s.charAt(i-j))
		{
		    localMaxE+=2;
		    localOutE = s.charAt(i-j) + localOutE + s.charAt(i + j + 1);
		} else
		{
		    if (max < localMaxE)
		    {
			max = localMaxE;
			out = localOutE;
		    }
		    break inner1;
		}
		if (max < localMaxE)
		{
		    max = localMaxE;
		    out = localOutE;
		}
	    }

	    // Paralindrom for odd subString
	    inner2: for (int j = 0; j < Math.min(i, s.length() - i - 1); j++)
	    {
		if (s.charAt(i + j + 1) == s.charAt(i - j - 1))
		{
		    localMaxO+=2;
		    localOutO = s.charAt(i - j -1)  + localOutO + s.charAt(i + j +1);
		} else
		{
		    if (max < localMaxO)
		    {
			max = localMaxO;
			out = localOutO;
		    }
		    break inner2;
		}
		if (max < localMaxO)
		{
		    max = localMaxO;
		    out = localOutO;
		}
	    }
	}

	return out;
    }
}
