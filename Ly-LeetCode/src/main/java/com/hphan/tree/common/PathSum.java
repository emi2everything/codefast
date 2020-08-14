package com.hphan.tree.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ly.utils.java.CommonUtils;

public class PathSum
{
    public static void main(String[] args)
    {
	Integer[] treeVal = { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1 };
	TreeNode root = ConstructTreeArray.createTree(treeVal);

	// InOrder_PreOrder_PostOrder.printPreOrder(root);
	CommonUtils.print(Travelsal_NodePerLevel.levelOrder(root));

	System.out.println("--------------------");

	CommonUtils.print(pathSum(root, 22));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum)
    {
	List<List<Integer>> output = new ArrayList<List<Integer>>();

	// edge
	if (root == null)
	{ return output; }

	return doPathSum(root, new ArrayList<Integer>(), output, sum);
    }

    private static List<List<Integer>> doPathSum(TreeNode root, List<Integer> path, List<List<Integer>> output,
	    int remainSum)
    {

	if (root == null)
	{ return output; }

	List<Integer> pathCopy = new ArrayList<Integer>();

	for (Integer i : path)
	    pathCopy.add(i);
	
	pathCopy.add(root.val);

	remainSum -= root.val;

	if (remainSum == 0 && root.left == null && root.right == null)
	{
	    output.add(pathCopy);

	    return output;
	} else if (remainSum < 0)
	{ return output; }

	if (root.left != null)
	    doPathSum(root.left, pathCopy, output, remainSum);

	if (root.right != null)
	    doPathSum(root.right, pathCopy, output, remainSum);

	return output;
    }
}
