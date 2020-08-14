package com.hphan.tree.common;

public class TreeNode
{
    public Integer val;
    public TreeNode right;
    public TreeNode left;

    public TreeNode(Integer v)
    {
	val = v;
    }
    
    public TreeNode(Integer v, TreeNode l, TreeNode r)
    {
	val = v;
	left = l;
	right = r;
    }

    @Override
    public String toString()
    {
	return String.valueOf(val);
    }

    public TreeNode copy()
    {
	TreeNode left = null;
	TreeNode right = null;
	if (this.left != null)
	{
	    left = this.left.copy();
	}
	if (this.right != null)
	{
	    right = this.right.copy();
	}
	return new TreeNode(val, left, right);
    }

}
