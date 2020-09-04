package com.hphan.number;

/**
 * Read problem statement carefully
 * 
 * @author Ly
 *
 */
public class MissingNumber_568
{
    public int missingNumber(int[] nums) {
        int actualSum = 0;
        for (int i = 0 ; i < nums.length; i ++)
            actualSum += nums[i];
        int mathSum = (nums.length*(nums.length+1))/2;
        return mathSum - actualSum;
    }
}
