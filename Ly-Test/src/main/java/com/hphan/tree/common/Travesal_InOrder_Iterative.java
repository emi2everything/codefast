package com.hphan.tree.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


public class Travesal_InOrder_Iterative
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

	// Pre Order Iterative

	System.out.println(preorderTraversal(root));
    }

    public static List<Integer>  preorderTraversal(TreeNode root)
    {
	List<Integer> output = new ArrayList<Integer>();
	
	if (root == null)
	    return output;
	
	buildStack(root, output);
	   
	Collections.reverse(output);
	return output;
    }

    public static void buildStack(TreeNode root, List<Integer> valList)
    {
	if (root == null)
	    return;
	buildStack(root.right, valList);
	buildStack(root.left, valList);
	valList.add(root.val);
    }

}
