package com.hphan.array.easy;

public class UglyNumber
{

    public static void main(String[] args)
    {
	System.out.println(isUgly(14));
    }

    public static boolean isUgly(int num)
    {
	// Just a point in question definition
	if (num < 0)
	    return false;
	if (num == 0)
	    return true;

	int[] factor = { 2, 3, 5 };
	while (num > 1)
	{
	    boolean able = false;
	    inner: for (int i = 0; i < factor.length; i++)
	    {
		if (num % factor[i] == 0)
		{
		    able = true;
		    num = num / factor[i];
		    break inner;
		}
	    }
	    if (!able)
	    { return false; }
	}
	return true;
    }
}
