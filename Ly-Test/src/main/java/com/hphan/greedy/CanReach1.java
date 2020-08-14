package com.hphan.greedy;

public class CanReach1
{
public boolean canJump(int[] nums) {
        
        // validation
        if (nums.length == 0)
        {
            return false;
        }
        
        int lastValid = nums.length - 1;
        for (int i = nums.length-1; i >=0 ; i --)
        {
            if (i + nums[i] >= lastValid)
            {
                lastValid = i;
            }
        }
        
        if (lastValid == 0)
            return true;
        return false;
    }
}
