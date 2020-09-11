package com.hphan.stackqueue;

import java.util.LinkedList;
import java.util.Queue;


/**
 * Either push or pop will take time O(n) and other O(1)
 * 
 * @author Ly
 *
 */
public class StackByQueue_225
{
    class MyStack
    {
	Queue<Integer> main;
	Queue<Integer> tem;

	/** Initialize your data structure here. */
	public MyStack()
	{
	    main = new LinkedList<Integer>();
	    tem = new LinkedList<Integer>();
	}

	/** Push element x onto stack. */
	public void push(int x)
	{
	    tem.add(x);
	    while(main.size()>0)
		tem.add(main.poll());
	    main = tem;
	    tem = new LinkedList<>();
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop()
	{
	    return main.poll();
	}

	/** Get the top element. */
	public int top()
	{
	    return main.peek();
	}

	/** Returns whether the stack is empty. */
	public boolean empty()
	{
	    if(main.size()==0)
		return true;
	    return false;
	}
    }
}
