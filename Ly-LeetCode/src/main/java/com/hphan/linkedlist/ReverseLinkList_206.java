package com.hphan.linkedlist;

public class ReverseLinkList_206
{
    /**
     * Recursive
     */
    public ListNode reverseList2(ListNode head)
    {
	if (head == null || head.next == null)
	    return head; // Return the original last node as the handler

	ListNode first = reverseList(head.next);
	head.next.next = head;
	head.next = null;
	return first; // Keep passing the last node back
    }

    /**
     * Iterative
     */
    public ListNode reverseList(ListNode head)
    {
	ListNode prev = null;
	
	while (head!=null)
	{
	    ListNode next = head.next;
	    head.next = prev;
	    prev = head;
	    head = next;
	}
	return prev;
    }
}
