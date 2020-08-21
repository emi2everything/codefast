package com.hphan.number;

public class IntegerToRoman
{

    public static void main(String[] args)
    {
	System.out.println("Out = " + intToRoman2(1234));
    }

    public String intToRoman(int num)
    {
	// 2341 will have 2000 (MM) + 300 (CCC) + 40 (XL) + 1 (I) --> MMCCCXLI

	String[] x1 = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
	String[] x10 = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
	String[] x100 = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
	String[] x1000 = { "", "M", "MM", "MMM" };

	return x1000[num / 1000] + x100[num % 1000 / 100] + x10[num % 100 / 10] + x1[num % 10];
    }

    public static String intToRoman2(int num)
    {
	int[] value = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
	String[] text = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

	StringBuilder out = new StringBuilder();
	while (num > 0)
	{
	    inner: for (int i = 0; i < text.length; i++)
	    {
		if (value[i] <= num)
		{
		    out.append(text[i]);
		    num = num - value[i];
		    break inner;
		}
	    }
	}
	return out.toString();
    }

}
