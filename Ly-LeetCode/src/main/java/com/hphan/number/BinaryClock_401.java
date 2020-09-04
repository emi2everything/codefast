package com.hphan.number;

import java.util.ArrayList;
import java.util.List;

public class BinaryClock_401
{
    /**
     * Brute Force
     */
    public List<String> readBinaryWatch(int num)
    {
	List<String> output = new ArrayList<String>();

	for (int i = 0; i < 12; i++)
	    for (int j = 0; j < 60; j++)
		if (Integer.bitCount(i) + Integer.bitCount(j) == num)
		    output.add(String.format("%d:%02d", i, j));
	return output;
    }
}
