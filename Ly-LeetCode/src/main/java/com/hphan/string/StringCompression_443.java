package com.hphan.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Ly
 *
 */
public class StringCompression_443
{
    public static void main(String[] args)
    {
	char[] in = { 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'b',
		'b', 'c' };
	int size = compress(in);
	for (int i = 0; i < size; i++)
	    System.out.println(in[i]);
    }

    public static int compress(char[] chars)
    {
	if (chars.length == 0)
	    return 0;

	int read = 1, write = 0, count = 1;
	char prevChar = chars[0];

	while (read < chars.length)
	{
	    if (chars[read] != prevChar)
	    {
		chars[write++] = prevChar;
		if (count > 1)
		{
		    write = insertNumber(chars, count, write);
		    count = 1;
		}
	    } else
	    {
		count++;
	    }
	    prevChar = chars[read];
	    read++;
	}

	// Take care of the last chars
	chars[write++] = prevChar;
	if (count > 1)
	    write = insertNumber(chars, count, write);

	return write;
    }

    /**
     * Handle insert 1 digit and multiple digit
     * 
     * @param chars
     * @param count
     * @param write
     * @return
     */
    private static int insertNumber(char[] chars, int count, int write)
    {
	if (count < 10)
	{
	    chars[write++] = Character.forDigit(count, 10);
	} else
	{
	    List<Integer> digits = new ArrayList<Integer>();
	    while (count > 0)
	    {
		digits.add(count % 10);
		count = count / 10;
	    }
	    for (int i = digits.size() - 1; i > -1; i--)
	    {
		chars[write++] = Character.forDigit(digits.get(i), 10);
	    }
	}
	return write;
    }

}
