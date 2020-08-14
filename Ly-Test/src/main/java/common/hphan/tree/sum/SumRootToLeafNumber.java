package common.hphan.tree.sum;

import com.hphan.tree.common.TreeNode;

public class SumRootToLeafNumber
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
	// Expect 124 + 136 + 1357

	
	System.out.println(sumNumbers(root));
    }
    
    public static int sumNumbers(TreeNode root) 
    {
	if (root == null)
	    return 0;
	return sum(root,0);
    }
    
    public static int sum(TreeNode node, int previousSum)
    {
	int thisSum = previousSum*10 + node.val;

	if (node.left==null && node.right==null)
	   return thisSum;
		
	int sumTillNow = 0;
	if (node.left!=null)
	    sumTillNow+=sum(node.left,thisSum);
	if (node.right!=null)
	    sumTillNow+=sum(node.right,thisSum);
	return sumTillNow;
    }

}
