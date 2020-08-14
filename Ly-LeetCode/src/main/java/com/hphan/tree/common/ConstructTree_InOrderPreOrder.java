package com.hphan.tree.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hint
 * Inoder list: All value of the left of n will be in n left child. Similarly for on the right.
 * Preoder list: for all the value on the left of n, the direct child will be the first one in preorder list.
 *
 */
public class ConstructTree_InOrderPreOrder
{
    public static void main(String[] args)
    {
	int[] preorder = { 3, 9, 20, 15, 7 };
	int[] inorder = { 9, 3, 15, 20, 7 };

	TreeNode root = buildTree(preorder, inorder);

	System.out.println("Printing the tree");
	List<List<Integer>> a = Travelsal_NodePerLevel.levelOrder(root);
	
	for (List<Integer> o : a)
	{
	    for (Integer l : o)
	    {
		System.out.print(l + " ");
	    }
	    System.out.println();
	}
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder)
    {
	if (preorder.length ==0)
	    return null;
	
	Map<Integer, Integer> preOrderMap = new HashMap<Integer, Integer>();
	for (int i = 0; i < inorder.length; i++)
	{
	    preOrderMap.put(preorder[i], i);
	}
	
	return constructNode(0, inorder.length-1,  inorder, preorder, preOrderMap);
    }

    private static TreeNode constructNode(int startInOrder, int endInOrder, int[] inorder, int[] preorder, Map<Integer,Integer> preOrderMap)
    {
	//Edge
	if (startInOrder > endInOrder)
	    return null;
	
	//Look into inorder set from Start to End, find for each value, what is the one with min preorder index
	//Take that value
	
	int firstIndexInPreOder = Integer.MAX_VALUE;
	int indexInInOrder = -1;
	
	for (int i = startInOrder; i <=endInOrder; i++)
	{
	    int valueInOrder =  inorder[i];
	    int valueIndexPreOder = preOrderMap.get(valueInOrder);
	    if (valueIndexPreOder < firstIndexInPreOder)
	    {
		firstIndexInPreOder = valueIndexPreOder;
		indexInInOrder = i;
	    }
	}
	
	//Get that value
	int rootValue = preorder[firstIndexInPreOder];
	
	//Create the node
	TreeNode curr = new TreeNode(rootValue);
	
	//Continue to build left and right
	curr.left =  constructNode(startInOrder,indexInInOrder-1,inorder,preorder,preOrderMap);
	curr.right =  constructNode(indexInInOrder+1,endInOrder,inorder,preorder, preOrderMap);
	return curr;
    }
    
    
}
