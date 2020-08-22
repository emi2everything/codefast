package com.hphan.tree.binarysearchtree;

import com.hphan.tree.common.TreeNode;

public class ArrayToBinarySearchTree
{
    public TreeNode sortedArrayToBST(int[] input) 
    {
        
	int start = 0, end = input.length - 1;

	TreeNode out = null;
	out = construct(input, start, end, out);
	return out;
    }

    public TreeNode construct(int[] input, int start, int end, TreeNode head)
    {
	if (start > end || start > input.length - 1 || end < 0)
	    return null;
	int mid = (start + end + 1) / 2;
	head = new TreeNode(input[mid]);
	head.left = construct(input, start, mid - 1, head);
	head.right = construct(input, mid + 1, end, head);
	return head;
    }
}
