package com.hphan.linkedlist;

/**
 * Be careful about > and <
 *
 */
public class MergeSortedLinkedList
{
    class Solution
    {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2)
	{
	    if (l1 == null && l2 == null)
		return null;
	    if (l1 == null)
		return l2;
	    if (l2 == null)
		return l1;

	    ListNode output = new ListNode(0, null);
	    ListNode previous = output;

	    while (l1 != null && l2 != null)
	    {
		if (l1.val <= l2.val)
		{
		    previous.next = new ListNode(l1.val, null);
		    l1 = l1.next;
		} else
		{
		    previous.next = new ListNode(l2.val, null);
		    l2 = l2.next;
		}
		previous = previous.next;

	    }

	    // Remaining
	    while (l1 != null)
	    {
		previous.next = new ListNode(l1.val, null);
		previous = previous.next;
		l1 = l1.next;
	    }
	    while (l2 != null)
	    {
		previous.next = new ListNode(l2.val, null);
		previous = previous.next;
		l2 = l2.next;
	    }

	    return output.next;
	}
    }
}
