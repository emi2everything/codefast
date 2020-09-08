package com.hphan.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationPhoneNumber_17
{
    public static void main(String[] args)
    {
	System.out.println(letterCombinations("23"));
    }
    
    public static List<String> letterCombinations(String digits) {
        Map<Character,String> m = new HashMap<Character,String>();
        m.put('2',"abc");
        m.put('3',"def");
        m.put('4',"ghi");
        m.put('5',"jkl");
        m.put('6',"mno");
        m.put('7',"pqrs");
        m.put('8',"tuv");
        m.put('9',"wxyz");
        
        return call(m, digits, digits.length()-1);
    }
    
    public static List<String> call(Map<Character, String> m, String digits, int pos)
    {
        List<String> out = new ArrayList<String>();
        
        if (pos == -1)
            return out;
        
        List<String> prev =  call(m,digits,pos-1);
        Character charVal = digits.charAt(pos);
	    String s = m.get(charVal);
        
        if (s == null)
            return prev;
        
        if (pos == 0 || prev.size() == 0)
            for (int i = 0 ; i < s.length(); i++)
                out.add(String.valueOf(s.charAt(i)));
        else
            for (int j = 0 ; j < prev.size() ; j++)
                for (int i = 0 ; i < s.length(); i++)
                    out.add(prev.get(j) + s.charAt(i));
        return out;
    }
}
