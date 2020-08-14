package com.hphan.tree.common;

import java.util.ArrayList;
import java.util.List;

public class ConstructTreeArray
{

    static TreeNode createTree(Integer[] treeVal)
    {
        int skip = 0;
        List<TreeNode> nodeList = new ArrayList<TreeNode>();
        for (Integer v : treeVal)
        {
            if (v == null)
        	nodeList.add(null);
            else
            {
        	TreeNode n = new TreeNode(v);
        	nodeList.add(n);
            }
        }
    
        for (int i = 0; i < nodeList.size(); i++)
        {
            if (nodeList.get(i) == null)
            {
        	// skip
        	skip += 2;
            } else
            {
        	//System.out.println("Node = " + nodeList.get(i));
        	try
        	{
        	    //System.out.println("Node left " + (2 * i + 1 - skip) + " = " + nodeList.get(2 * i + 1 - skip));
        	    nodeList.get(i).left = nodeList.get(2 * i + 1 - skip);
        	} 
        	catch (Exception e)
        	{
        	    // Do nothing
        	}
    
        	try
        	{
        	    //System.out.println("Node right " + (2 * i + 2 - skip) + " = " + nodeList.get(2 * i + 2 - skip));
        	    nodeList.get(i).right = nodeList.get(2 * i + 2 - skip);
        	} catch (Exception e)
        	{
        	    // Do nothing
        	}
            }
    
        }
    
        return nodeList.get(0);
    }

}
