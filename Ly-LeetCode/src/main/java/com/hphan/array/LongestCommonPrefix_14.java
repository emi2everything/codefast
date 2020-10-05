package com.hphan.array;

public class LongestCommonPrefix_14
{
  public String longestCommonPrefix(String[] s) {
        
        if (s.length==0)
            return "";
        if (s.length==1)
            return s[0];
            
        int end = 0;
        outer: for (int i = 0 ; i < s[0].length() ; i++)
        {
            for (int j = 1 ; j < s.length ; j++)
                if (s[j].length()-1 < i || s[0].charAt(i) != s[j].charAt(i))
                    break outer;
            end++;
        }
        return s[0].substring(0,end);
    }
}
