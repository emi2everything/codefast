package com.hphan.tree.common;

public class InOrder_PreOrder_PostOrder
{
    public static void main(String[] args)
    {
	System.out.println("Example of in order traversal");
	
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
	
	/**
	 * Print in order
	 * 	2
	 *  1	    3
	 */
	System.out.println("Printing inorder");
	printInOrder(root);
	
	/**
	 * Print pre order
	 * 	1
	 *  2	    3
	 */
	System.out.println("Printing preorder");
	printPreOrder(root);
	
	/**
	 * Print in order
	 * 	3
	 *  1	    2
	 */
	System.out.println("Printing post order");
	printPostOrder(root);
    }

    public static void printPostOrder(TreeNode node)
    {
	if (node != null)
	{
	    printPostOrder(node.left);
	    printPostOrder(node.right);
	    System.out.println(node.val);
	}
    }

    public static void printPreOrder(TreeNode node)
    {
	if (node != null)
	{
	    System.out.println(node.val);
	    printPreOrder(node.left);
	    printPreOrder(node.right);
	}
    }

    public static void printInOrder(TreeNode node)
    {
	if (node != null)
	{
	    printInOrder(node.left);
	    System.out.println(node.val);
	    printInOrder(node.right);
	}
    }
}
