package com.hphan.tree.common;

/**
 * Such a small problem and I overlook. Never rely on null node in a binary tree to stop. Define a leave properly okay?
 * @author Ly
 *
 */
public class MaxSumI_112
{
    public boolean hasPathSum(TreeNode root, int sum)
    {
	if (root == null)
	    return false;

	return dfs(root, sum, 0);
    }

    public boolean dfs(TreeNode cur, int sum, int curSum)
    {
	if (cur == null)
	    return false;

	curSum += cur.val;
	if (cur.left == null && cur.right == null && curSum == sum)
	    return true;

	return dfs(cur.left, sum, curSum) || dfs(cur.right, sum, curSum);
    }
}
