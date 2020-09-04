package com.hphan.number;

import java.util.HashSet;
import java.util.Set;

/**
 * A simple problem can be complicated with constraint
 * With this problem the array can look like a link list which make it detect cyclic linked link problem
 * 
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one duplicate number in nums, return this duplicate number.
 * @author Ly
 *
 */
public class FindTheDuplicateNumber_287
{
    /**
     * See this example
     * 
     * Value	| 3 | 2 | 1 | 2
     *   i 	| 0 | 1 | 2 | 3
     *   
     *   It can be see as link link 0 -> 3 -> 2 -> 1 
     *   				      ^----|
     *   The cycle has 1 and 2
     *   I know how to find cycle in a linked list. The repeated value is the begining of the cycle. Let's do the hare problem.
     *   
     *   
     *   -----x-----  -----y------
     *   O --> O --> O --> O --> *   <-- meet here
     *               ^		 | .
     *               |  	 O .	
     *               |		 | z
     *               |___________O .
     *               
     *   First pointer goes 1 step at a time p1
     *   Second pointer goes 2 steps at a time p2
     *   Distance by p1 = D(p1) , by p2 = D(p2)
     *   Because p2 is twice as fast --> 2 D(p1) = D(p2)
     *   From the begining to meeting point, must be in the cycle
     *   D(p1) = x + ay + az + y
     *   D(p2) = x + by + bz + y (We don't care about a and b, it could be any number)
     *   
     *   2 (x + y + ay + az) = x + by + bz + y
     *   x + y = (b-a)y + (b-a)z 
     *   
     *   I don't care about b-a because how many times it goes a cycle it will end up same place
     *   but see, x + y = c(y + z) --> If x = z, do distance x+y will meet someone go distnace c(y+z) which is a cycle
     *   x = z is an answer
     *   Follow-up: How to prove x=z is the only answer 
     */
    public int findDuplicateLL(int[] nums)
    {
	int p1 = 0;
	int p2 = 0;
	while(p1 == 0 || p1!=p2)
	{
	    p1 = nums[p1];
	    p2 = nums[nums[p2]]; // we can do this because assumption nums length = n+1 --> won't be out of bound
	}
    
	p2 = 0;
	
	// Step 1 by 1 till beginning of cycle
	while (p1!=p2)
	{
	    p1 = nums[p1];
	    p2 = nums[p2];
	}
	return p1;
    }
    
    /**
     * 5 mins solution
     */
    public int findDuplicate(int[] nums) {
        int n = nums.length-1;
        Set<Integer> visited = new HashSet<Integer>();
        for (int i = 0 ; i < nums.length ; i ++)
        {
            if (visited.contains(nums[i]))
                return nums[i];
            visited.add(nums[i]);
        }
        return 0;
    }
}
