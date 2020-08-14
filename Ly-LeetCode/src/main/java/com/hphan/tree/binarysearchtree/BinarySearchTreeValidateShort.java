package com.hphan.tree.binarysearchtree;

import com.hphan.tree.common.TreeNode;

public class BinarySearchTreeValidateShort
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
       if (node == null)
           return true;
       return validate(node, Long.MIN_VALUE, Long.MAX_VALUE);       
   }
   
   public static boolean validate(TreeNode node, Long minAllow, Long maxAllow)
   {
       if (node == null)
           return true;
       if (minAllow >= node.val || maxAllow <= node.val)
       {
           return false;
       }
       return validate(node.left, minAllow, Long.valueOf(node.val)) && validate(node.right, Long.valueOf(node.val), maxAllow);
   }
}
