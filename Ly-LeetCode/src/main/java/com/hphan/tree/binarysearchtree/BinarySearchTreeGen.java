package com.hphan.tree.binarysearchtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hphan.tree.common.InOrder_PreOrder_PostOrder;
import com.hphan.tree.common.TreeNode;

public class BinarySearchTreeGen
{

    public static void main(String[] args)
    {
	int n = 3;

	List<TreeNode> output = generateBinarySearchTree(1, n, n);

	for (TreeNode o : output)
	{
	    System.out.println("tree");
	    InOrder_PreOrder_PostOrder.printPreOrder(o);
	}

    }

    private static List<TreeNode> generateBinarySearchTree(int from, int to, int n)
    {
	System.out.println("Trying  " + from + " to " + to);

	List<TreeNode> treeList = new ArrayList<TreeNode>();
	if (from < 1 || to > n || from > to)
	{
	    treeList.add(null);
	    return treeList;
	}
	for (int i = from; i <= to; i++)
	{
	    System.out.println("Looping i = " + i);
	    TreeNode ni = new TreeNode(i);

	    for (TreeNode left : generateBinarySearchTree(from, i - 1, n))
	    {
		ni.left = left;
		System.out.println("adding " + left + " as left to " + ni);
		for (TreeNode right : generateBinarySearchTree(i + 1, to, n))
		{
		    ni.right = right;
		    treeList.add(ni.copy());
		    System.out.println("adding " + right + " as right to " + ni);

		}
	    }
	}
	return treeList;
    }

}
