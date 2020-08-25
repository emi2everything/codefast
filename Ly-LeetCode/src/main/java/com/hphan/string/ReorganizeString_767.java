package com.hphan.string;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * The output is correct, but Leetcode not able to detect that
 * Key Point:
 * - Comfortable with using inner static class
 * - Comfortable with priority queue and compare class
 * @author Ly
 *
 */
public class ReorganizeString_767
{
    static class Pair
    {
	public Pair(int a, int b)
	{
	    key = a;
	    value = b;
	}

	int key;
	int value;

	public String toString()
	{
	    return "(" + key + ":" + value + ")";
	}
    }

    public static String reorganizeString(String S)
    {
	/*
	 * Count character
	 */
	final int[] charCount = new int[27];
	for (int i = 0; i < S.length(); i++)
	    charCount[(int) S.charAt(i) - 97] = charCount[(int) S.charAt(i) - 97] + 1;

	/*
	 * Construct priority queue. I want char to be in descending order of the count
	 */
	PriorityQueue<Pair> q = new PriorityQueue<Pair>((a, b) -> {
	    return b.value - a.value;
	});

	for (int i = 0; i < charCount.length; i++)
	{
	    if (charCount[i] > (S.length() + 1) / 2)
		return "";
	    if (charCount[i] > 0)
		q.add(new ReorganizeString_767.Pair(i, charCount[i]));
	}
	List<Pair> finalList = new ArrayList<Pair>();
	while (q.size() > 0)
	    finalList.add(q.poll());

	/*
	 * Construct output from queue
	 */
	StringBuilder sb = new StringBuilder();
	int invalid = -1;
	int sum = 1;
	int previousSum = Integer.MAX_VALUE;
	while (sum > 0 && sum != previousSum)
	{
	    previousSum = sum;
	    sum = 0;
	    inner: for (int i = 0; i < finalList.size(); i++)
	    {
		if (finalList.get(i).value > 0 && invalid != i)
		{
		    sb.append((char) (finalList.get(i).key + 97));
		    finalList.get(i).value = finalList.get(i).value-1;
		    invalid = i;
		    break inner;
		}
	    }
	    for (int i = 0; i < finalList.size(); i++)
		sum = sum + finalList.get(i).value;
	}

	return sb.toString();
    }
}
