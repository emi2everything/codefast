package com.hphan.linkedlist;

import java.util.Stack;

/**
 * Sometimes it is just slow and honest work. No trick
 *
 */
public class PalimdromLinkList
{
    public boolean isPalindrome(ListNode head)
    {
	if (head == null)
	    return true;

	ListNode n1 = head;
	ListNode n2 = head;

	while (n2 != null)
	{
	    n1 = n1.next;
	    if (n2.next != null)
		n2 = n2.next.next;
	    else
		n2 = null;
	}

	// By now n1 = mid, n2 is end

	// Restart n2
	n2 = head;

	Stack<ListNode> reverse = new Stack<ListNode>();
	construct(reverse, n1);

	while (reverse.size() > 0)
	{
	    n1 = reverse.pop();
	    if (n1.val != n2.val)
		return false;
	    n2 = n2.next;
	}
	return true;
    }

    public Stack<ListNode> construct(Stack<ListNode> stack, ListNode n1)
    {
	while (n1 != null)
	{
	    stack.push(n1);
	    n1 = n1.next;
	}
	return stack;
    }
}
