package com.hphan.tree.common;

/**
 * Typical dfs tree - why slower than 50%?
 * 
 * @author Ly
 *
 */
public class TreeToLinkedListInPlace_114
{
    public void flatten(TreeNode root)
    {
	flatLeft(root);
    }

    public void flatLeft(TreeNode root)
    {
	if (root == null)
	    return;

	flatLeft(root.left);
	flatLeft(root.right);

	TreeNode right = root.right;
	root.right = root.left;
	root.left = null;

	while (root.right != null)
	    root = root.right;

	root.right = right;
    }
}
