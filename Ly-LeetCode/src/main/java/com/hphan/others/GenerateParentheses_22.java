package com.hphan.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParentheses_22
{
    public static void main(String[] args)
    {
	System.out.println(generateParenthesisMBackTrack(3));
    }

    /**
     * It works but it is slow
     */
    public static List<String> generateParenthesisFirst(int n)
    {
	List<String> temp = new ArrayList<String>();

	for (int i = 0; i < n; i++)
	{
	    if (i == 0)
	    {
		temp.add("()");
	    } else
	    {
		HashSet<String> temp2 = new HashSet<String>();
		for (int j = 0; j < temp.size(); j++)
		{
		    for (int k = 0; k < temp.get(j).length(); k++)
		    {
			temp2.add(temp.get(j).substring(0, k) + "()" + temp.get(j).substring(k, temp.get(j).length()));
		    }
		}
		temp = new ArrayList<String>(temp2);
	    }
	    if (i == (n - 1))
		return new ArrayList<String>(temp);
	}
	return temp;
    }

    /**
     * Same idea as basic, but use recursion, as slow :D
     */
    public static List<String> generateParenthesis(int n)
    {
	if (n == 1)
	    return Arrays.asList("()");

	Set<String> out = new HashSet<String>();
	for (String option : generateParenthesis(n - 1))
	{
	    for (int i = 0; i < n; i++)
		out.add(option.substring(0, i) + "()" + option.substring(i, option.length()));
	}
	return new ArrayList<String>(out);
    }

    /**
     * Backtracking, create a tree to one by one add the bracket
     */
    public static List<String> generateParenthesisMBackTrack(int n)
    {
	List<String> ans = new ArrayList();
	generate(0,0,ans,n,"");
	return ans;
    }

    private static void generate(int open, int close, List<String> ans, int n, String cur)
    {
	System.out.println(cur);
	if (open >= n && close >= n)
	    ans.add(cur);
	if (open < n)
	    generate(open+1,close,ans,n,cur+"(");
	if (open > close && close < n)
	    generate(open,close+1,ans,n,cur+")");
    }
}
