package com.hphan.string;

/**
 * Lesson:
 * 1) May not need to interate whole string 
 * 2) Be careful using for loop iterator for other purpose, because of i++
 * @author Ly
 *
 */
public class NeedleInHayStack_28
{
    public int strStr(String haystack, String needle) {
        if (needle.equals(""))
            return 0;
        if (needle.length()>haystack.length())
            return -1;
        
        for (int i = 0 ; i < haystack.length()-needle.length()+1; i++)
        {
            char c = haystack.charAt(i);
            if (c == needle.charAt(0))
            {
                int j = 0;
                inner: for (j = 0 ; j < needle.length(); j++)
                {
                    if (haystack.charAt(i+j) != needle.charAt(j))
                        break inner; 
                }
                 if (j == needle.length())
                    return i;
            }
        }
        return -1;
    }
}
