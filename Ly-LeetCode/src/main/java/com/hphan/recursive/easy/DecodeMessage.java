package com.hphan.recursive.easy;

public class DecodeMessage
{
    public static void main(String[] args)
    {
	String input = "2[b2[a]]";
	System.out.println(decodeStringUsingStack(input));
    }

    public static String decodeStringUsingStack(String s)
    {
	return s;
    }

    public static String decodeString(String s)
    {
	StringBuilder out = new StringBuilder();
	int i = 0;
	while (i < s.length())
	{
	    String noLoop = "";

	    if (Character.isDigit(s.charAt(i)))
	    {
		noLoop += s.charAt(i);
		while (Character.isDigit(s.charAt(i + 1)))
		{
		    noLoop += s.charAt(i + 1);
		    i++;
		}
		int bIndex = i + 2;
		int bracketCounter = 1;
		StringBuilder bracketContent = new StringBuilder();

		while (bracketCounter > 0 && bIndex < s.length())
		{
		    // Bracket counter
		    if (s.charAt(bIndex) == ']')
			bracketCounter -= 1;
		    else if (s.charAt(bIndex) == '[')
			bracketCounter += 1;

		    // Bracket Content
		    bracketContent.append(String.valueOf(s.charAt(bIndex)));
		    bIndex++;
		}
		String bracketContentS = bracketContent.deleteCharAt(bracketContent.length() - 1).toString();
		String backetContentDecoded = decodeString(bracketContentS);
		Integer noLoopInt = Integer.parseInt(noLoop);
		for (int j = 0; j < noLoopInt; j++)
		    out.append(backetContentDecoded);

		i = bIndex;

	    } else
	    {
		out.append(String.valueOf(s.charAt(i)));
		i++;
	    }
	}
	return out.toString();
    }
}
