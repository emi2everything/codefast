package com.hphan.greedy;

public class ReconstructQueue
{
    public static void main(String[] args)
    {
	int[][] input = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
	
	System.out.println("Ouput");
	output = reconstructQueue(input);
    }
    
    class Solution {
	    public int[][] reconstructQueue(int[][] people) {
	        
	        for (int i = 0 ; i < people.length; i ++)
	        {
	            int hi=people[i][0];
	            int ki=people[i][1];
	            
	            int j=0;
	            int finalPos =0;
	            while(j<i)
	            {                   
	                int hj = people[j][0];
	                int kj = people[j][1];
	                
	                if (hi >= hj)
	                {
	                  finalPos = j+1;
	                }
	                else
	                {
	                  if (ki==0)
	                  {
	                    break;
	                  }
	                  else
	                  {
	                    finalPos = j+1;
	                    ki--;
	                  }
	                }
	                j++;
	                
	            }
	          people = insertTo(people, i,  finalPos);
	        }
	        return people;
	 
	    }
	    
	    public static int[][] insertTo(int[][] people, int oriPos, int finalPos)
	    {
	      int[][] output = new int[people.length][];
	      for (int i = 0; i < finalPos; i ++)
	      {
	        output[i] = people[i];
	      }
	      output[finalPos] = people[oriPos];
	      
	      int oriIndex = finalPos;
	      int outIndex = finalPos+1;
	      
	      while(outIndex<people.length)
	      {
	        if (oriIndex==oriPos)
	        {
	          oriIndex++;
	          continue;
	        }
	        output[outIndex] = people[oriIndex];
	        oriIndex++;
	        outIndex++;
	      }
	      
	      return output;
	    }
	}