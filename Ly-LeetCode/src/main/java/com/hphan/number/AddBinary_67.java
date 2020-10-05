package com.hphan.number;

public class AddBinary_67
{
    /**
     * Try bit manipulation
     */
    
    
    /**
     * First though: Similar to adding decimal number
     */
    public String addBinary(String a, String b)
    {
	int p1 = a.length() - 1, p2 = b.length() - 1, carry = 0;
	StringBuilder sb = new StringBuilder();

	while (p1 > -1 || p2 > -1)
	{
	    int v1 = 0;
	    int v2 = 0;

	    if (p1 > -1)
		v1 = a.charAt(p1) - '0';
	    if (p2 > -1)
		v2 = b.charAt(p2) - '0';

	    int sum = v1 + v2 + carry;
	    if (sum < 2)
	    {
		sb.append(sum);
		carry = 0;
	    } else
	    {
		sb.append(sum - 2);
		carry = 1;
	    }

	    p1--;
	    p2--;
	}
	if (carry == 1)
	    sb.append("1");
	return sb.reverse().toString();
    }
}
