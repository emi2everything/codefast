package com.hphan.string;

public class ValidParalimdrom_680
{
    public boolean validPalindrome(String s)
    {
	if (s.length() < 2)
	    return true;

	int i = 0, j = s.length() - 1, count = 0;

	while (i < j)
	{
	    if (count > 1)
		return false;

	    if (s.charAt(i) != s.charAt(j))
	    {
		if ((s.charAt(i + 1) == s.charAt(j)) && (i + 1 == j || s.charAt(i + 2) == s.charAt(j - 1)))
		{
		    count++;
		    i++;
		} else if (s.charAt(i) == s.charAt(j - 1) && (i + 1 == j || s.charAt(i + 1) == s.charAt(j - 2)))
		{
		    count++;
		    j--;
		} else
		{
		    return false;
		}
	    }
	    i++;
	    j--;
	}
	if (count > 1)
	    return false;
	return true;
    }
}
