package com.hphan.tree.common;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class Travesal_PreOrder_Iterative
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

	/**
	 * Inorder iterative
	 */

	inOrderIterativeWithSet(root);
	inOrderIterative2Loop(root);
    }

    private static void inOrderIterative2Loop(TreeNode root)
    {
	System.out.println("Using 2 loop");
	if(root == null)
	    return ;
	TreeNode curr= root;
	Stack<TreeNode> st = new Stack<TreeNode>();
	while (!st.isEmpty() || curr != null)
	{
	    if (curr!=null)
		System.out.println("------- Calling "+ curr.val);
	    while (curr != null)
	    {
		System.out.println("Pushing " + curr.val);
		st.push(curr);
		curr = curr.left;
	    }
	    TreeNode cu = st.pop();
	    System.out.println("Poping " + cu.val);
	    System.out.println(cu.val);
	    curr = cu.right;
	}
    }

    private static void inOrderIterativeWithSet(TreeNode root)
    {
	if (root == null)
	    return;

	Set<TreeNode> checked = new HashSet<TreeNode>();

	Stack<TreeNode> nodeToCheck = new Stack<TreeNode>();
	nodeToCheck.push(root);

	while (nodeToCheck.size() != 0)
	{
	    TreeNode currNode = nodeToCheck.pop();
	    if (checked.contains(currNode) || (currNode.right == null && currNode.left == null))
	    {
		System.out.println(currNode.val);
	    } else
	    {
		checked.add(currNode);
		if (currNode.right != null)
		{
		    nodeToCheck.push(currNode.right);
		}
		nodeToCheck.push(currNode);
		if (currNode.left != null)
		{
		    nodeToCheck.push(currNode.left);
		}
	    }
	}
    }

}
