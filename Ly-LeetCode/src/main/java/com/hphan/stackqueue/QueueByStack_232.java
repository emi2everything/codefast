package com.hphan.stackqueue;

import java.util.Stack;

/**
 * Implement queue by 2 stacks. I know this.
 * 
 * @author Ly
 *
 */
public class QueueByStack_232
{
    class MyQueue
    {

	private Stack<Integer> in;
	private Stack<Integer> out;

	/** Initialize your data structure here. */
	public MyQueue()
	{
	    in = new Stack<Integer>();
	    out = new Stack<Integer>();
	}

	/** Push element x to the back of queue. */
	public void push(int x)
	{
	    in.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop()
	{
	    if (out.size() == 0)
	    {
		while (in.size() > 0)
		    out.push(in.pop());
	    }
	    return out.pop();
	}

	/** Get the front element. */
	public int peek()
	{
	    if (out.size() == 0)
	    {
		while (in.size() > 0)
		    out.push(in.pop());
	    }
	    return out.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty()
	{
	    if (in.size() == 0 && out.size() == 0)
		return true;
	    return false;
	}
    }
}
