package com.hphan.tree.common;

/**
 * The second time I meet this question. Done in a note.
 * 
 * @author Ly
 *
 */
public class SymmetricTree_101
{
    public boolean isSymmetric(TreeNode root)
    {
	if (root == null)
	    return true;
	return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode a, TreeNode b)
    {
	if (a == null && b == null)
	    return true;
	if (a == null && b != null || a != null && b == null)
	    return false;

	// Both a and b are not null
	if (a.val != b.val)
	    return false;

	// a.val == b.val
	return dfs(a.left, b.right) && dfs(a.right, b.left);
    }
}
