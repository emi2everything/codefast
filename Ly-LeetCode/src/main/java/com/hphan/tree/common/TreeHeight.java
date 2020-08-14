package com.hphan.tree.common;

public class TreeHeight
{

    public static void main(String[] args)
    {
	/**
	 * 	 1
	 *   2	      3
	 *4        5    6
	 *          7
	 */

	TreeNode n1 = new TreeNode(1);
	TreeNode n2 = new TreeNode(2);
	TreeNode n3 = new TreeNode(3);
	TreeNode n4 = new TreeNode(4);
	TreeNode n5 = new TreeNode(5);
	TreeNode n6 = new TreeNode(6);
	TreeNode n7 = new TreeNode(7);

	n1.left = n2;
	n1.right = n3;
	n2.left = n4;
	n3.left = n5;
	n3.right =n6;
	n5.right = n7;

	TreeNode root = n1;

	System.out.println("My tree height = " + getTreeHeight(root));
    }

    private static int getTreeHeight(TreeNode node)
    {
	if (node != null)
	{
	    if (node.left == null && node.right == null)
	    { 
		return 1; 
	    }

	    return 1 + Math.max(getTreeHeight(node.left), getTreeHeight(node.right));
	}
	return 0;
    }

}
