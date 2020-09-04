package com.hphan.number;

public class Maxinum69_1323
{
    public static void main(String[] args)
    {
	System.out.println(maximum69Number2(8227272));
    }
    public int maximum69Number(int num)
    {
	// Key word: At most
	// I will go right to left, find the last 6 and make it 9. If everything already
	// 9, return as is
	// How do I go right to left? % by 10 --> get digit

	int var = num, countDigit = 0, pos = -1;
	while (var > 0)
	{
	    int digit = var % 10;
	    var = var / 10;

	    if (digit == 6)
		pos = countDigit;
	    countDigit++;
	}
	if (pos == -1)
	    return num;
	return num + Double.valueOf(3 * Math.pow(10, pos)).intValue();
    }

    public static int maximum69Number2(int num)
    {
	if (num <= 0)
	{ return num; }
	int digits = (int) Math.ceil(Math.log10(num));
	System.out.println("Mathlog10 = " + Math.log10(num));
	System.out.println("Digits = " + digits);
	int changed = 0;
	boolean flip = false;
	for (int i = 0; i < digits; i++)
	{
	    System.out.println("Final = " + (int)(num/Math.pow(10, digits - i - 1) % 10));
	    System.out.println("Test = " + (int)(Math.pow(10, digits - i - 1)));
	    
	    if ((int) (num / Math.pow(10, digits - i - 1) % 10) == 6 && !flip)
	    {
		changed = changed * 10 + 9;
		flip = true;
	    } else
	    {
		changed = changed * 10 + (int) ((int) num / Math.pow(10, digits - i - 1)) % 10;
	    }
	}
	return changed;
    }
}
