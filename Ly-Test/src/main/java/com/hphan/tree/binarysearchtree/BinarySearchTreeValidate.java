package com.hphan.tree.binarysearchtree;

import com.hphan.tree.common.TreeNode;

public class BinarySearchTreeValidate
{
    public static void main(String[] args)
    {
	/**
	 *    10 
	 *  5    15 
	 * 	6 20
	 */

	TreeNode n1 = new TreeNode(10);
	TreeNode n2 = new TreeNode(5);
	TreeNode n3 = new TreeNode(15);
	TreeNode n4 = new TreeNode(6);
	TreeNode n5 = new TreeNode(20);

	n1.left = n2;
	n1.right = n3;
	n3.left = n4;
	n3.right = n5;

	TreeNode root = n1;

	System.out.println("Validate binary search tree");
	System.out.println(isValidBST(root));

    }

    public static boolean isValidBST(TreeNode node)
    {
	Integer minRight = null;
	Integer maxLeft = null;
	
	if (node == null)
	    return true;
	System.out.println("Checking node " + node.val);

	if (node.left == null && node.right == null)
	{
	    System.out.println("Checking node " + node.val + " is leave so true ");
	    return true;
	}

	if (node.right != null)
	{
	    minRight = getMin(node.right);
	    if (minRight <= node.val)
	    {
		System.out.println("Checking node " + node.val + " false for min right < node ");
		return false;
	    }
	}

	if (node.left !=null)
	{
	    maxLeft = getMax(node.left);
	    if (maxLeft >= node.val)
	    {
		System.out.println("Checking node " + node.val + " false for max left > node ");
		return false;
	    }
	}
	System.out.println("Checking node " + node.val + " true so far with minRight = " + minRight + " and maxLEft = " + maxLeft);
	return isValidBST(node.left)&&isValidBST(node.right);
    }

    public static Integer getMin(TreeNode node)
    {
	Integer minLeft = node.val;
	Integer minRight = node.val;
	if (node.right!=null)
	    minRight = getMax(node.right);
	if (node.left!=null)
	    minLeft = getMax(node.left);
	
	return Math.max(Math.min(node.val, minRight),minLeft);
    }

    public static Integer getMax(TreeNode node)
    {
	Integer maxLeft = node.val;
	Integer maxRight = node.val;
	if (node.right!=null)
	    maxRight = getMax(node.right);
	if (node.left!=null)
	    maxLeft = getMax(node.left);
	
	return Math.max(Math.max(node.val, maxRight),maxLeft);
    }
}
