package com.hphan.linkedlist;

import java.util.ArrayList;
import java.util.List;

import com.hphan.tree.common.TreeNode;

/**
 * Given the head of a singly linked list where elements are sorted in ascending
 * order, convert it to a height balanced BST.
 * 
 * @author Ly
 *
 */
public class SortedListToBinarySearchTree_109
{
    /*
     * Method 2: ------------------------------------------------- 
     * I only need to find mid, I can do that with a linked list
     * Converting is not required
     * The trick is for left side I have to cut the link list
     * To do that I need to keep PRE to set PRE.NEXT = null
     * -------------------------------------------------
     */
    public TreeNode sortedListToBST(ListNode head)
    {
	if (head == null)
	    return null;

	if (head.next == null)
	    return new TreeNode(head.val);

	ListNode fast = head;
	ListNode slow = head;
	ListNode preSlow = null;

	while (fast != null && fast.next != null)
	{
	    fast = fast.next.next;
	    preSlow = slow;
	    slow = slow.next;
	}
	TreeNode node = new TreeNode(slow.val);
	node.right = sortedListToBST(slow.next);
	preSlow.next = null;
	node.left = sortedListToBST(head);
	return node;
    }

    /*
     * Method 1: ------------------------------------------------- I know how to do
     * from array, so I convert to array
     * -------------------------------------------------
     */
    public TreeNode sortedListToBST2(ListNode head)
    {
	// Edge
	if (head == null)
	    return null;

	// Convert to familiar
	List<Integer> input = new ArrayList<Integer>();
	while (head != null)
	{
	    input.add(head.val);
	    head = head.next;
	}
	int start = 0, end = input.size() - 1;

	TreeNode out = null;
	out = construct(input, start, end, out);
	return out;
    }

    public TreeNode construct(List<Integer> input, int start, int end, TreeNode head)
    {
	if (start > end || start > input.size() - 1 || end < 0)
	    return null;
	int mid = (start + end + 1) / 2;
	head = new TreeNode(input.get(mid));
	head.left = construct(input, start, mid - 1, head);
	head.right = construct(input, mid + 1, end, head);
	return head;
    }
}
