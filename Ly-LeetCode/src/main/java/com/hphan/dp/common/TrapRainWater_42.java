package com.hphan.dp.common;

/**
 * Typical 1D DP problem
 * 
 * @author Ly
 *
 */
public class TrapRainWater_42
{

    public static void main(String[] args)
    {
	// TODO Auto-generated method stub

    }

    /**
     * 2pointer
     */
    public int trap(int[] height)
    {
	if (height.length < 3)
	    return 0;

	int p1 = 0, p2 = height.length - 1, sum = 0, maxLeft = 0, maxRight = 0;
	boolean left = true;

	while (p1 < p2)
	{
	    if (left)
		sum += Math.max(0, Math.min(maxLeft, maxRight) - height[p1]);
	    else
		sum += Math.max(0, Math.min(maxLeft, maxRight) - height[p2]);

	    maxRight = Math.max(height[p2], maxRight);
	    maxLeft = Math.max(height[p1], maxLeft);

	    if (height[p1] > height[p2])
	    {
		p2--;
		left = false;
	    } else
	    {
		p1++;
		left = true;
	    }
	}
	return sum;
    }
    
    
    /**
     * DP Solution
     */
    public int trap2Pass(int[] height)
    {
	// edge
	if (height.length == 0)
	    return 0;

	// init
	int sum = 0;
	int[] maxLeft = new int[height.length];
	int[] maxRight = new int[height.length];

	// first values
	maxLeft[0] = height[0];
	maxRight[height.length - 1] = height[height.length - 1];

	// Populate max left and max right for each element
	for (int i = 1; i < height.length; i++)
	    maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);

	for (int i = height.length - 2; i >= 0; i--)
	    maxRight[i] = Math.max(maxRight[i + 1], height[i]);

	// Calculate possible volumn at each point
	for (int i = 1; i < height.length - 1; i++)
	    sum += Math.max(0, Math.min(maxLeft[i - 1], maxRight[i + 1]) - height[i]);

	return sum;
    }
}
