package com.hphan.tree.common;

import java.util.Stack;

public class LowestCommonAncestorStack
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
	
	
	System.out.println("Lowest common ancestor of 7 and 4 are " + lowestCommonAncestor(n1,n7,n4).val);
    }
    
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
	if (root == null)
	{
	    return null;
	}
	
	Stack<TreeNode> pathToP = new Stack<TreeNode>();
	Stack<TreeNode> pathToQ = new Stack<TreeNode>();
	
	pathTo(root,p,pathToP);
	pathTo(root,q,pathToQ);
	
	TreeNode out = null;
	
	while (pathToP.size() > 0 && pathToQ.size() > 0)
	{
	    TreeNode pS = pathToP.pop();
	    TreeNode qS = pathToQ.pop();
	    if (qS.equals(pS))
		out =  qS;
	}
	
	return out;
    }

    public static boolean pathTo(TreeNode root, TreeNode p, Stack<TreeNode> pathStack)
    {
	if (root == null)
	    return false;
	
	if (root.equals(p) || pathTo(root.left, p, pathStack) == true || pathTo(root.right, p, pathStack) == true)
	{
	    pathStack.add(root);
	    return true;
	}
	return false;
    }
}
