package com.hphan.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCommonCharacterInWord
{
    public static void main(String[] args)
    {

    }

    public int[] intersect(int[] nums1, int[] nums2) 
    {
	//Sort
	Arrays.sort(nums1);
	Arrays.sort(nums2);
	
        List<Integer> output = new ArrayList<Integer>();
        
        int count1 = 0, count2 = 0; //few millisecond faster than 2 separate declaration
        
        while (count1 < nums1.length && count2 < nums2.length)
        {
            if (nums1[count1]==nums2[count2])
            {
        	output.add(nums1[count1]);
        	count1++;
        	count2++;
            }
            
            else if (nums1[count1] > nums2[count2])
        	count2++;
            
            else 
        	count1++;
        }
        
        int[] outputArr = new int[output.size()];
        for (int i = 0 ; i < output.size();i++)
            outputArr[i] = output.get(i);
        return outputArr;
    }
    
    public int[] intersectUsingMap(int[] nums1, int[] nums2) 
    {
        Map<Integer,Integer> n1m = new HashMap<Integer,Integer>();
        Map<Integer,Integer> n2m = new HashMap<Integer,Integer>();
        
        for (int i = 0 ; i < nums1.length ; i++)
        {
            if (n1m.get(nums1[i])!=null)
                n1m.put(nums1[i],1+n1m.get(nums1[i]));
            else
                n1m.put(nums1[i],1);
        }
        System.out.println(n1m);
        
        for (int i = 0 ; i < nums2.length ; i++)
        {
            if (n2m.get(nums2[i])!=null)
                n2m.put(nums2[i],1+n2m.get(nums2[i]));
            else
                n2m.put(nums2[i],1);
        }
                System.out.println(n2m);

        
        List<Integer> output = new ArrayList<Integer>();
        for(Integer k1 : n1m.keySet())
        {
            if (n2m.get(k1)!=null)
            {   
                int count = (Math.min(n2m.get(k1),n1m.get(k1)));
                for (int j = 0; j<count;j++)
                    output.add(k1);
            }
        }
        
        int[] outputArr = new int[output.size()];
        for (int i = 0 ; i < output.size();i++)
            outputArr[i] = output.get(i);
        return outputArr;
    }

}
