package com.hphan.string;

/**
 * Careful: What if either delete left or right can make current checking char equal? Which one should I do? What if only one will lead to correct answer?
 * Better check the next char as well. It is required.
 * @author Ly
 *
 */
public class DeleteOneMakeParalindrome
{
    public static void main(String[] args)
    {
	System.out.println(validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }

    public static boolean validPalindrome(String s)
    {
	int left = 0;
	int right = s.length() - 1;
	int del = 0;

	while (left < s.length() / 2 && right > s.length() / 2)
	{
	    System.out.println(left + ":" + s.charAt(left));
	    System.out.println(right + ":" + s.charAt(right));
	    System.out.println(del);
	    
	    if (del > 1)
	    { return false; }
	    if (s.charAt(left) != s.charAt(right))
	    {
		if (s.charAt(left + 1) == s.charAt(right) && s.charAt(left+2)==s.charAt(right-1))
		{
		    System.out.println("Left+1 = Right" + s.charAt(left+1) + ":" + s.charAt(right));
		    del++;
		    left++;
		} else if (s.charAt(left) == s.charAt(right-1) && s.charAt(left+1)==s.charAt(right-2))
		{
		    System.out.println("Left = Right-1" + s.charAt(left) + ":" + s.charAt(right-1));

		    del++;
		    right--;
		} else
		{
		    System.out.println("Delete either one does not work: Left + 1 = " + s.charAt(left+1) + " and right-1 = " + s.charAt(right-1));
		    return false;
		}
	    }
	    else
	    {
		System.out.println("Already equal");
	    }
	    left++;
	    right--;
	    System.out.println(s.substring(left,right+1));
	    System.out.println("-------------");

	}
	if (del > 1)
	    return false;
	return true;
    }
}
