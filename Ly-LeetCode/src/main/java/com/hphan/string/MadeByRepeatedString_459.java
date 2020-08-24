package com.hphan.string;

public class MadeByRepeatedString_459
{
    /**
     * Method 1: With optimization, make all subString possible, and check if the input can be made by repeating it
     */
    public boolean repeatedSubstringPattern(String s) {
        
        // i is the length, not char index
        for (int i = s.length()/2; i>0;i--)
        {
            if (s.length()%i==0)
            {
                String from0toI = s.substring(0,i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0 ; j<s.length()/i;j++)
                {
                    sb.append(from0toI);
                }
                if (sb.toString().equals(s))
                    return true;
            }
        }
        return false;
    }
}
