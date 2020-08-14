package com.hphan.greedy;

public class RemoveKdigitGetMin
{
    /**
     * Given a non-negative integer num represented as a string, remove k digits
     * from the number so that the new number is the smallest possible.
     * 
     * Note: The length of num is less than 10002 and will be ≥ k. The given num
     * does not contain any leading zero. Example 1:
     * 
     * Input: num = "1432219", k = 3 Output: "1219" Explanation: Remove the three
     * digits 4, 3, and 2 to form the new number 1219 which is the smallest. Example
     * 2:
     * 
     * Input: num = "10200", k = 1 Output: "200" Explanation: Remove the leading 1
     * and the number is 200. Note that the output must not contain leading zeroes.
     * Example 3:
     * 
     * Input: num = "10", k = 2 Output: "0" Explanation: Remove all the digits from
     * the number and it is left with nothing which is 0.
     */

    public static void main(String[] args)
    {
	System.out.println("Test");
    }

    /**
     * Logic: Do k time. If digit > next digit, remove this digit. If all digit at acending order, remove last digit. 
     */
    public String removeKdigits(String num, int k)
    {

	// Validate
	if (num.length() == 0)
	{ return "0"; }

	// Make string builder
	StringBuilder sb = new StringBuilder(num);

	// Logic: Delete digit if the digit after it is smaller than itself. Or delete
	// last digit
	outer: for (int i = 0; i < k; i++)
	{
	    boolean deleted = false;
	    int pos = 0;
	    inner: while (pos < sb.length() - 1)
	    {

		if (sb.charAt(pos) > sb.charAt(pos + 1))
		{
		    sb.delete(pos, pos + 1);
		    deleted = true;
		    break inner;
		} else
		{
		    pos++;
		}
	    }
	    if (!deleted)
	    {
		sb.delete(pos, pos + 1);
	    }
	}

	// Take care of leading zero
	int i = 0;
	while (i < sb.length())
	{
	    if (sb.charAt(i) == '0')
	    {
		sb.delete(i, i + 1); // Dont do i++ because after delete 1 becomes 0
	    } else
	    {
		break;
	    }
	}

	if (sb.length() == 0)
	{ return "0"; }

	return sb.toString();
    }
}
