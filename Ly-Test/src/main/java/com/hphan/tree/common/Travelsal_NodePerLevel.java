package com.hphan.tree.common;

import java.util.ArrayList;
import java.util.List;

import com.ly.utils.java.CommonUtils;

public class Travelsal_NodePerLevel
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
	
	List<List<Integer>> output = levelOrder(root);
	
	for (List<Integer> o : output)
	{
	    for (Integer l : o)
	    {
		System.out.print(l);
	    }
	    System.out.println();
	}
    }
    
    public static List<List<Integer>> levelOrder(TreeNode root)
    {
	List<List<Integer>> allLevelList = new ArrayList<List<Integer>>();
	
	if (root == null)
	    return allLevelList;
	
	else
	    return getLevelNode(root,allLevelList,0);
    }

    public static List<List<Integer>> getLevelNode(TreeNode node, List<List<Integer>> allLevelList, int level)
    {
	if (allLevelList.size()-1 < level) {
	    allLevelList.add(new ArrayList<Integer>());
	}
	
	allLevelList.get(level).add(node.val);
	
	if (node.left!=null)
	{
	    getLevelNode(node.left,allLevelList,level+1);
	}
	if (node.right!=null)
	{
	    getLevelNode(node.right,allLevelList,level+1);
	}
	
	return allLevelList;
    }
}
