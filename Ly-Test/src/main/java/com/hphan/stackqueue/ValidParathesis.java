package com.hphan.stackqueue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class ValidParathesis
{
    public static void main(String[] args)
    {

    }

    public boolean isValid(String s)
    {
	// edge
	if ("".equals(s))
	    return true;

	Stack<Character> bracketStack = new Stack<Character>();

	Map<Character, Character> bracketPair = new HashMap<Character, Character>();
	bracketPair.put(')', '(');
	bracketPair.put('}', '{');
	bracketPair.put(']', '[');

	Set<Character> openBracket = new HashSet<Character>();
	openBracket.add('(');
	openBracket.add('[');
	openBracket.add('{');

	for (int i = 0; i < s.length(); i++)
	{
	    if (openBracket.contains(s.charAt(i)))
	    {
		bracketStack.push(s.charAt(i));
	    } else
	    {
		if (bracketStack.size() == 0 || !bracketStack.peek().equals(bracketPair.get(s.charAt(i))))
		{ return false; }
		bracketStack.pop();
	    }
	}
	if (bracketStack.size() > 0)
	    return false;
	return true;
    }
}
