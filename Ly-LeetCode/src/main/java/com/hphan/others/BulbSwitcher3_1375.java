package com.hphan.others;


/**
 * Leetcode Solution: The idea is at position k, if the sum from 1 to k is 1 + 2 + ... + k then all bulb till k is on and blue
 * 
 * @author Ly
 *
 */
public class BulbSwitcher3_1375
{
    public int numTimesAllBlue(int[] light) 
    {
	int count = 0, mathSum = 0, actualSum = 0;
	
	for (int i = 0 ; i < light.length ; i++)
	{
	    mathSum += (i+1);
	    actualSum += light[i];
	    if (mathSum == actualSum)
		count++;
	}
	return count;
    }
}
