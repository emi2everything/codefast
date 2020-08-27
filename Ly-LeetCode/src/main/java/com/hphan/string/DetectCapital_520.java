package com.hphan.string;

/**
 * Yay! We got everything in first run, good performance. Remember: Think before typing
 * @author Ly
 *
 */
public class DetectCapital_520
{
    public static void main(String[] args)
    {
	System.out.println(detectCapitalUse("ABC"));
    }

    public static boolean detectCapitalUse(String word)
    {
	if (word.length() < 2)
	    return true;

	boolean firstCap = false;
	if (isCapital(word.charAt(0)))
	    firstCap = true;

	int capCount = 0;
	for (int i = 1; i < word.length(); i++)
	{
	    if (isCapital(word.charAt(i)))
		capCount++;

	    if (!firstCap)
	    {
		if (capCount > 0)
		    return false;
	    } else
	    {
		if (capCount > 0 && capCount < i)
		    return false;
	    }
	}
	return true;
    }

    private static boolean isCapital(char c)
    {
	if (c >= 'A' && c <= 'Z')
	    return true;
	return false;
    }
}
