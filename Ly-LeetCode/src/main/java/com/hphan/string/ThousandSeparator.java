package com.hphan.string;

public class ThousandSeparator
{
    public String thousandSeparator(int n) {
        if (n==0)
            return "0";
        
        StringBuilder sb = new StringBuilder();
        int count = 1;
        while (n>0)
        {
            if (count%3==0)
            {
        	sb.append(",");
            }
            sb.append(n%10);
            n = n/10;
            count++;
        }
        return sb.reverse().toString();
    }
}
