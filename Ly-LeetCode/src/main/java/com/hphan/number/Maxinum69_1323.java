package com.hphan.number;

public class Maxinum69_1323
{
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
}
