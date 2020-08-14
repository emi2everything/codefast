package com.hphan.tree.common;

import java.util.Stack;

public class LowestCommonAncestor
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
	
	
	System.out.println("Lowest common ancestor of 7 and 6 are " + lowestCommonAncestor(n1,n6,n4).val);
    }
    
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
	if (root == null)
	{
	    return null;
	}
	
	if (root.equals(p) || root.equals(q))
	    return root;
	
	TreeNode left = lowestCommonAncestor(root.left,p,q);
	TreeNode right = lowestCommonAncestor(root.right,p,q);

	if((left == p && right == q) || (left == q && right == p))
            return root;
        else if(left == null)
            return right;
        else
            return left;
    }

}
