package com.hphan.linkedlist;

import java.util.Stack;

/**
 * Sometimes it is just slow and honest work. No trick
 *
 */
public class PalimdromLinkList
{
    public static void main(String[] args)
    {
	ListNode n1 = new ListNode(1);
	ListNode n2 = new ListNode(2);
	ListNode n3 = new ListNode(1);
	n1.next = n2;
	n2.next = n3;
	
	System.out.println(isPalindromeN(n1));
    }
    
    /**
     * Space 1? Have to reverse in place second half
     */
    public static boolean isPalindromeN(ListNode head)
    {
        
    if (head == null)
        return true;
    
	// 1. Find Middle Node
	ListNode slow = head;
	ListNode fast = head;
	boolean even = true;
	
	while (fast != null && slow!=null)
	{
	    if (fast.next == null)
	    {	
		even = false;
		break;
	    }
	    else
	    {
		fast = fast.next.next;
		slow = slow.next;
	    }
	}
	
	System.out.println(slow.val);
	
	// 2. Reverse the later half
	ListNode mid = slow;
	if (!even)
	    mid = mid.next;
	
	mid = reverseLinkList(mid);
		
	// 3. Compare
	ListNode start2 = mid;
	while (head!=null && start2!=null)
	{
	    if (head.val!=start2.val)
		return false;
	    head = head.next;
	    start2 = start2.next;
	}
	
	// 4. Reverse back reversed part
	mid = reverseLinkList(mid);
	return true;
    }
    
    
    public static ListNode reverseLinkList(ListNode head)
    {
	ListNode previous = null;
	
	while (head!=null)
	{
	    ListNode curNext = head.next;
	    head.next = previous;
	    previous = head;
	    head = curNext;
	}
	return previous;
    }
    
    /**
     * Recursive solution - Still O(n) for stack call space will take n
     */
    ListNode front;
    public boolean isPalindromeR(ListNode head)
    {
	front = head;
	return call(head);
    }

    public boolean call(ListNode cur)
    {
	if (cur == null)
	    return true;
	if (call(cur.next) == true)
	{
	    if (cur.val == front.val)
	    {
		front = front.next;
		return true;
	    }
	}
	return false;
    }

    /**
     * Stack - Space complexity = n
     */
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
