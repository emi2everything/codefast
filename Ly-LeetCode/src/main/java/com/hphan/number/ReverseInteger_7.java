package com.hphan.number;

public class ReverseInteger_7
{
    /**
     * The only thing here is check for max and min :) Before it goes overflow
     */
    public int reverse(int x)
    {
	int max = Integer.MAX_VALUE / 10;
	int min = Integer.MIN_VALUE / 10;
	int out = 0;

	while (x != 0)
	{
	    if (out > max || out < min)
		return 0;
	    out = out * 10 + x % 10;
	    x = x / 10;
	}

	return out;
    }
}
