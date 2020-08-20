package com.hphan.example;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapByPriorityQueueExample
{
    public static void main(String[] args)
    {
	class MyComparator implements Comparator<Integer>
	{
	    /**
	     * a is existing element in queue
	     * b is the new one coming in queue
	     */
	    public int compare(Integer a, Integer b)
	    {
		if (b < a)
		    return 1; //yes 
		if (b > a)
		    return -1; //no
		return 0;
	    }
	}

	int[] test = { 2, 3, 1 };
	PriorityQueue<Integer> p = new PriorityQueue<Integer>(new MyComparator());

	for (int a : test)
	{
	    p.add(a);
	}
	
	System.out.println(p.toString());
	while(p.size()>0)
	{
	    System.out.println(p.poll());
	}

    }

}
