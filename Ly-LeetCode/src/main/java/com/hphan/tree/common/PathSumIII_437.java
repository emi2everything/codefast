package com.hphan.tree.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathSumIII_437
{
    /**
     * Method 3: From leetcode discussion
     * I learned the technic from method 2. But it is only faster than 60%. Let's try other.
     * 
     * Idea: The idea of method 3 is that, at every node, I have a map telling me, 
     * from root to previous node, how what are the possible sum and how many times it happen
     * If sumToFind - current sum = any value in that map, then yes I found
     * It is similar to the first problem discuss with Pranjul in office
     * 
     * It is also a common technic but not very intuitive :|
     * 					_
     * For example:			_________________________		
     * Value				5 	-5 	3 	2 	1 	4
     * SumTilNode	0(init)		5	0	3	5	6	10
     * At 5  5-5 = 0 (1 way) -> +1
     * At 2  5-5 = 0 (2 way) --> +2
     * --> 3
     * 
     * 
     * Other example looking for 8		
     * 				_________
     * Value		10	5	3	3
     * SumTilNode	10	15	18	21
     * At first 3, I try to see if there is any 5 out there
     * --> found 1
     */
    
    public int pathSum(TreeNode root, int sum)
    {
	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,1);	//Init is important
	return dfs3(root,sum,map,0);
    }
    
    public int dfs3(TreeNode root, int sum, Map<Integer,Integer> posSum , int runningSum)
    {
	
	//Edge
	if (root == null)
	    return 0;
	
	//Init
	int count = 0;
	runningSum += root.val;
	
	if (posSum.get(runningSum-sum)!=null)
	    count+=posSum.get(runningSum-sum);

	posSum.put(runningSum,posSum.getOrDefault(runningSum, 0)+1);
	
	//Now go to children
	count += dfs3(root.left,sum,posSum,runningSum);
	count += dfs3(root.right,sum,posSum,runningSum);

	posSum.put(runningSum,posSum.get(runningSum)-1);
	
	return count;
    }
    
    
    /**
     * Method 2: From a youtube solution.
     * I want to practice this method because it use add and remove node. 
     * I've seen it twice so it must be a pattern should remember.
     * Using this method it also return 3 options like the one below
     * 
     * Idea: Idea is you make a path from root to any of the node, and try to sum value from that node up to root, see how many count it is and return count at the end
     * It is faster maybe because there is no List construction required. compared to my first method
     */
    public int pathSumMethod2(TreeNode root, int sum)
    {
	//Edge
	if (root==null)
	    return 0;
	
	//Call
	int[] out = new int[1];
	List<Integer> nodeSinceRoot = new ArrayList<Integer>();

	dfs2(root,sum, out, nodeSinceRoot);
	return out[0];
    }
    
    public void dfs2(TreeNode cur, int sum, int[] out, List<Integer> nodeSinceRoot)
    {
	//edge
	if (cur==null)
	    return;
	
	//Add current node
	nodeSinceRoot.add(cur.val);
	
	//Call children first (it does not matter I calculate for myself first or children first)
	dfs2(cur.left,sum,out, nodeSinceRoot);
	dfs2(cur.right,sum,out, nodeSinceRoot);

	//Now I count for current node
	int localSum = 0;
	for (int i = nodeSinceRoot.size()-1; i > -1 ; i--)
	{
	    localSum+=nodeSinceRoot.get(i);
	    if (localSum==sum)
		out[0] = out[0]+1;
	}
	
	//Remove current node
	nodeSinceRoot.remove(nodeSinceRoot.size()-1);
    }
    
    
    /**
     * Method 1:
     * Got the whole thing very quickly but it is 28 ms, faster than 13.23% of Java
     * online submissions
     * 
     * I like this because let say 5->-5->4->1 my method will count 3 paths which is 5 and 4->1 and 5->-5->4->1 will make sum 5
     * The question does not make it clear it in above case it should count 2 or 3 :)
     */
    public int pathSumLy(TreeNode root, int sum)
    {

	// Edge
	if (root == null)
	    return 0;

	int[] out = new int[1];

	dfs(root, sum, out);

	return out[0];
    }

    public List<Integer> dfs(TreeNode cur, int sum, int[] out)
    {
	List<Integer> posVal = new ArrayList<Integer>();

	if (cur == null)
	    return posVal;

	posVal.add(cur.val);
	if (cur.val == sum)
	    out[0] += 1;

	for (Integer downSum : dfs(cur.left, sum, out))
	{
	    posVal.add(cur.val + downSum);
	    if (cur.val + downSum == sum)
		out[0] += 1;
	}

	for (Integer downSum : dfs(cur.right, sum, out))
	{
	    posVal.add(cur.val + downSum);
	    if (cur.val + downSum == sum)
		out[0] += 1;
	}
	return posVal;
    }
}
