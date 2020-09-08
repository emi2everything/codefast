package com.hphan.string;

public class ZigZagConversion_6
{
    public static void main(String[] args)
    {
	System.out.println(convert("PAYPALISHIRING", 4));
    }
    
    
    /**
     * Intuitive but faster than 6.64% of Java online submissions for ZigZag Conversion
     */
    public static String convert(String s, int numRows) {
	      
	      if (numRows < 2)
	          return s;
	      
	        int noChar = s.length(), sIndex = 0, pos = 0;
		    int noSpace = (numRows-2)*(numRows-1)*noChar/(numRows + numRows-2);
	        int numCol = (int) Math.ceil((double) (noChar+noSpace)/numRows);
	        
	        char[][] d = new char[numRows][numCol];
	        
	        outer: for (int j = 0 ; j < numCol; j ++)
	        {
	            for (int i = 0 ; i < numRows; i++)
	            {
	        	if (pos % (numRows-1) == 0)
	        	{
	        	    if (sIndex > noChar-1)
	        		d[i][j] = '|';
	        	    else
	        	    {
	        		d[i][j] = s.charAt(sIndex);
	        		sIndex++;
	        		pos = 0;
	        	    }
	        	}
	        	else
	        	{
	        	    if (i+1 == numRows-(pos%numRows))
	        	    {
	                    if (sIndex > noChar-1)
	                        d[i][j] = '|';
	                    else
	                    {
	                        d[i][j] = s.charAt(sIndex);
	                        sIndex++;
	                    }
	        	    }
	        	    else 
	        	    {
	        		d[i][j] = '|';
	        	    }
	        	}
	            }
	            pos++;
	        }
	        
	       // CommonUtils.print(d);
	        
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0 ; i < numRows ; i ++)
	        {
	            for (int j = 0 ; j < numCol ; j++)
	            {
	        	if (d[i][j] != '|')
	        	    sb.append(d[i][j]);
	            }
	        }
	        
	        return sb.toString();
	    }
}
