package com.ly.utils.java;

import java.util.HashMap;
import java.util.Map;

public class VariableInMethod
{
    public static void main(String[] args)
    {
	int i1 = 0;
	Integer i2 =0;
	int[] arr1 = new int[3];
	Map<Integer,Integer> m1 = new HashMap<Integer,Integer>();

	changeValue(i1,i2,arr1, m1);
	
	System.out.println(i1);
	System.out.println(i2);
	System.out.println(arr1[0]);
	System.out.println(m1.size());
	
    }

    private static void changeValue(int i1, Integer i2, int[] arr1, Map<Integer,Integer> m1)
    {
	i1 = 1; 
	i2 = 1;
	arr1[0] = 1;
	m1.put(0,0);
    }
}
