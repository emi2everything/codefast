package com.hphan.greedy;

public class CanReach3
{
    public boolean canReach(int[] arr, int start) 
    {
        return dfs(arr,start,0);    
    }
    
    public boolean dfs(int[] arr, int start, int count)
    {
        if (count >= arr.length)
            return false;
        if (start > arr.length -1)
            return false;
        if (start < 0)
            return false;
        
        if (arr[start] == 0)
            return true;
        
        return dfs(arr, start + arr[start], count+1)
            || dfs(arr, start - arr[start], count+1);
        
    }
}
