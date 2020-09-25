package com.hphan.dp.common;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogData_937
{
    public static void main(String[] args)
    {
	Integer[] log = { 3, 2, 1 };
	Integer[] out = simpleComparator(log);
	for (Integer line : out)
	    System.out.println(line);
    }

    private static Integer[] simpleComparator(Integer[] log)
    {
	Comparator<Integer> myCom = new Comparator<Integer>()
	{
	    @Override
	    public int compare(Integer thisOne, Integer previousOne) //o1 = this // o2 = previous
	    {
		if (thisOne > previousOne)
		    return 1;	//keep it
		if (thisOne < previousOne)
		    return -1;	//index move it
		return 0;
	    }
	};
	Arrays.sort(log,myCom);
	return log;
    }

    public static String[] reorderLogFiles(String[] logs)
    {
	Comparator<String> myComp = new Comparator<String>()
	{

	    @Override
	    public int compare(String s1, String s2)
	    {
		String[] s1a = s1.split(" ", 2);
		String[] s2a = s2.split(" ", 2);

		boolean isDigit1 = Character.isDigit(s1a[1].charAt(0));
		boolean isDigit2 = Character.isDigit(s2a[1].charAt(0));

		if (!isDigit1 && !isDigit2)
		{
		    if (s1a[1].equals(s2a[1]))
			return s1a[0].compareTo(s2a[0]);
		    else
			return s1a[1].compareTo(s2a[1]);
		}

		if (isDigit1 && isDigit2)
		{ return 0; }
		if (!isDigit1 && isDigit2)
		    return -1;
		else if (isDigit1 && !isDigit2)
		    return 1;

		return 0;
	    }
	};

	Arrays.sort(logs, myComp);

	return logs;
    }
}
