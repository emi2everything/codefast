package com.hphan.array;

import java.util.PriorityQueue;

import com.hphan.linkedlist.ListNode;

/**
 * Whole purpose of this exercise is trying to use min heap
 * 
 * @author Ly
 *
 */
public class MergeKSortedList_23
{
    /**
     * Method 1: Get all of elements from all lists in an array, then run a sort
     * Method 2 (implemented): Get all elements from all list in a heap, then reconstruct the list
     * Method 3: Do like merge 2 sorted array, but everytime go through all array to find min, put in, then again do that till no more
     * Method 4: Divide and conquer, merge first 2, then next 2, so and so, till only 1 big array
     * Method 5: Merge list 1 and 2, then 1/2 and 3, on and on...
     */
    public ListNode mergeKLists(ListNode[] lists)
    {
	PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((a, b) -> a.val - b.val); //current - existing < 0 then okay otherwise swap

	for (int i = 0; i < lists.length; i++)
	{
	    ListNode head = lists[i];
	    while (head != null)
	    {
		minHeap.add(head);
		head = head.next;
	    }
	}

	ListNode cur = minHeap.poll();
	ListNode out = cur;
	
	while (cur != null)
	{
	    cur.next = minHeap.poll();
	    cur = cur.next;
	}
	return out;
    }
}
