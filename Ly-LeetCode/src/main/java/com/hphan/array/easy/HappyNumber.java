package com.hphan.array.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Pay attention to all edge cases. There could be many
 *
 */
class HappyNumber
{
    public boolean isHappy(int n)
    {
	if (n == 1)
	    return true;

	if (n < 4)
	    return false;

	Set<Integer> history = new HashSet<Integer>();
	
	while (n > 3)
	{
	    int sum = 0;
	    while (n > 0)
	    {
		sum += Math.pow(n % 10, 2);
		n = n / 10;
	    }
	    n = sum;

	    if (history.contains(n))
		return false;
	    history.add(n);
	}
	if (n == 1)
	    return true;
	return false;
    }
}
