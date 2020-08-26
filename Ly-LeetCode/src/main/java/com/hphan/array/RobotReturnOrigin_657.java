package com.hphan.array;

/**
 * Tip: Don't split to array if not necessary. And compare == char is faster than .equals string
 * @author Ly
 *
 */
public class RobotReturnOrigin_657
{
    public boolean judgeCircle(String moves)
    {
	int up = 0;
	int right = 0;
	for (int i = 0; i < moves.length(); i++)
	{
	    switch (moves.charAt(i))
	    {
	    case 'U':
		up++;
		break;
	    case 'D':
		up--;
		break;
	    case 'R':
		right++;
		break;
	    case 'L':
		right--;
		break;
	    }
	}
	return up == 0 && right == 0;
    }
}
