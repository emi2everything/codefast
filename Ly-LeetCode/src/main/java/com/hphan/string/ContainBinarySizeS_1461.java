package com.hphan.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution from leetcode
 * Learning point: rolling hash, implement set check in this case
 * @author Ly
 *
 */
public class ContainBinarySizeS_1461
{
    public static void main(String[] args)
    {
	int val = 7;
	System.out.println(" val = " + String.format("%3s", Integer.toBinaryString(val)));
	val = val << 1;
	System.out.println(" val = " + String.format("%3s", Integer.toBinaryString(val)));
	int a = 6;
	System.out.println(" a = " + String.format("%3s", Integer.toBinaryString(a)));
	val = val & a;
	System.out.println(" val = " + String.format("%3s", Integer.toBinaryString(val)));
	val = val | 0;
	System.out.println(" val = " + String.format("%3s", Integer.toBinaryString(val)));
	System.out.println(val);

	System.out.println(hasAllCodes("00101101", 2));
    }

    public static boolean hasAllCodes2(String s, int k)
    {
	int need = 1 << k;
	System.out.println(need);
	Set<String> got = new HashSet<String>();

	for (int i = k; i <= s.length(); i++)
	{
	    String a = s.substring(i - k, i);
	    System.out.println("i = " + i + " and i-k= " + (i - k) + " and a = " + a);

	    if (!got.contains(a))
	    {
		got.add(a);
		need--;
		// return true when found all occurrences
		if (need == 0)
		{ return true; }
	    }
	}
	return false;
    }

    public static boolean hasAllCodes(String s, int k)
    {
	int need = 1 << k;
	boolean[] got = new boolean[need];
	int allOne = need - 1;

	int hashVal = 0;

	for (int i = 0; i < s.length(); i++)
	{
	    int a = ((hashVal << 1) & allOne);
	    int b = a | s.charAt(i)-'0'; //get binary version of the char, similar to s.charAt() - 'A'. Here '0' will be 0
	    hashVal = b;
	    System.out.println(" a = " + String.format("%3s", Integer.toBinaryString(a)));
	    System.out.println(" b = " + String.format("%3s", Integer.toBinaryString(b)));

	    System.out.println("--------------");

	    if (i >= k - 1 && !got[hashVal])
	    {
		got[hashVal] = true;
		need--;
		if (need == 0)
		{ return true; }
	    }
	}
	return false;
    }
}
