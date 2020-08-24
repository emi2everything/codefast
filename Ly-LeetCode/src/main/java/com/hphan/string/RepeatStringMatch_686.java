package com.hphan.string;

public class RepeatStringMatch_686
{
    public int repeatedStringMatch(String A, String B) {
        int repeat = B.length()/A.length();
        
        //Best case match 
        if (B.length()%A.length()!=0)
            repeat++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < repeat; i ++)
            sb.append(A);
        if (sb.toString().contains(B))
            return repeat;
        
        //Worst case match where B is half here half there
        sb.append(A);
        repeat++;
        if (sb.toString().contains(B))
            return repeat;
        return -1;
    }
}
