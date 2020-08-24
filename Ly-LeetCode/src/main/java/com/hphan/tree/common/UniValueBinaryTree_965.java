package com.hphan.tree.common;

public class UniValueBinaryTree_965
{
    public boolean isUnivalTree(TreeNode root)
    {
	if (root == null)
	    return true;
	int val = root.val;
	return check(root, val);
    }

    public boolean check(TreeNode root, int val)
    {
	if (root == null)
	    return true;
	if (root.val != val)
	    return false;
	return check(root.left, val) && check(root.right, val);
    }
}
