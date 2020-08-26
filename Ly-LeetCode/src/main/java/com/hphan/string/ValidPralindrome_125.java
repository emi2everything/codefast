package com.hphan.string;

/**
 * 
 * @author Ly
 * Can be done faster using while and 2 pointers but I'm lazy
 */
public class ValidPralindrome_125
{
    public boolean isPalindrome(String s)
    {
	s = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
	
	for (int i = 0 ; i < s.length()/2;i++)
	{
	    if (s.charAt(i)!=s.charAt(s.length()-1-i))
		return false;
	}
	return true;
    }
}
