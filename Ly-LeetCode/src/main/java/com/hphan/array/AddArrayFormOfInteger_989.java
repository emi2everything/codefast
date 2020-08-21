package com.hphan.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddArrayFormOfInteger_989
{

    public static void main(String[] args)
    {
	// TODO Auto-generated method stub

    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        
	List<Integer> output = new ArrayList<Integer>();
        List<Integer> kArr = new ArrayList<Integer>();
        
        // Convert K to array
        while (K >0)
        {
            kArr.add(K%10);
            K = K/10;
        }
        Collections.reverse(kArr);
        
        
        int takeAway = 0;
        int aIndex = A.length-1;
        int kIndex = kArr.size()-1;
        
        while (aIndex >= 0 || kIndex >= 0)
        {
            int aDigit = aIndex>=0?A[aIndex]:0;
            int kDigit = kIndex>=0?kArr.get(kIndex):0;
            
            
            int localSum = aDigit + kDigit + takeAway;
            output.add(localSum%10);
            if (localSum>=10)
        	    takeAway=1;
            else
                takeAway=0;
            aIndex--;
            kIndex--;
        }
        
        if (takeAway==1)
            output.add(1);
        
        Collections.reverse(output);
	    return output;
    }
}
