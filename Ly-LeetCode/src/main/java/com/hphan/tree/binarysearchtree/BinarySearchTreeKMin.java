package com.hphan.tree.binarysearchtree;

import com.hphan.tree.common.TreeNode;

/**
 * So damn simple using only definition of binary search tree and traversal
 *
 */
public class BinarySearchTreeKMin
{
    public static void main(String[] args)
    {
	/**
	 *    10 
	 *  5    15 
	 * 	12 20
	 */

	TreeNode n1 = new TreeNode(10);
	TreeNode n2 = new TreeNode(5);
	TreeNode n3 = new TreeNode(15);
	TreeNode n4 = new TreeNode(12);
	TreeNode n5 = new TreeNode(20);

	n1.left = n2;
	n1.right = n3;
	n3.left = n4;
	n3.right = n5;

	TreeNode root = n1;

	System.out.println(kthSmallest(root,5));
    }
    
    public static int kthSmallest(TreeNode root, int k) 
    {
	if (root == null )
	    return 0;
	
	int[] kA = {k,-1};
	
	traversalInOrder(root,kA);
	
	return kA[1];
    }

    private static void traversalInOrder(TreeNode root, int[] kA)
    {
	
	if (root.left != null)
	   traversalInOrder(root.left, kA);
	
	if (kA[0] == 1)
	    kA[1] = root.val;
	kA[0] = kA[0]-1;
	
	if (root.right!=null)
	    traversalInOrder(root.right, kA);
    }
}
