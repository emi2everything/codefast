package com.hphan.tree.common;

import java.util.HashMap;
import java.util.Map;

public class PseudoPalindromicPath
{
    /**
     * Refine after seeing other
     * Tip: 
     * - Use an array instead of HashMap for count if key is limited. Here they say 0-9 only
     * - Instead of copy the whole thing, after doing with a certain node, remove it existence from the entry --> sibling and parent node won't see it
     */
    public int pseudoPalindromicPaths(TreeNode root)
    {
        int[] count = { 0 };
        int[] check = new int[10];
        countPath(root, count, check);
        return count[0];
        }

        public void countPath(TreeNode root, int[] count, int[] check)
        {
        check[root.val] +=1;
        if (root.left == null && root.right == null)
        {
            int pairCount = 0;
            for (int i = 0 ; i < check.length; i ++)
                if (check[i] % 2 != 0)
                    pairCount++;
            
            if (pairCount <= 1)
            count[0] +=1;
        } 
        else
        {
            if (root.left != null)
                countPath(root.left, count, check);
            if (root.right != null)
                countPath(root.right, count, check);
        }
        check[root.val] -=1;
    }
        
    // First attemp --- can be optimize a bit
//    public void countPathRaw(TreeNode root, int[] count, HashMap<Integer, Integer> check)
//    {
//	if (root == null)
//	    return;
//
//	HashMap<Integer, Integer> checkClone = (HashMap<Integer, Integer>) check.clone();
//	put(checkClone, root.val);
//
//	if (root.left == null && root.right == null)
//	{
//	    int pairCount = 0;
//	    for (Integer key : checkClone.keySet())
//	    {
//		if (checkClone.get(key) % 2 != 0)
//		    pairCount++;
//	    }
//	    if (pairCount <= 1)
//		count[0] = count[0] + 1;
//	} else
//	{
//	    if (root.left != null)
//		countPath(root.left, count, checkClone);
//	    if (root.right != null)
//		countPath(root.right, count, checkClone);
//	}
//
//    }
//
//    public void put(HashMap<Integer, Integer> check, int val)
//    {
//	if (check.get(val) == null)
//	    check.put(val, 1);
//	else
//	{
//	    check.put(val, check.get(val) + 1);
//	}
//    }
}
