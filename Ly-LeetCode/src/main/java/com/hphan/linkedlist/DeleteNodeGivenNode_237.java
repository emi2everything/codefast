package com.hphan.linkedlist;

/**
 * The point is the only give reference of the node they want to delete 
 *
 */
public class DeleteNodeGivenNode_237
{
    public void deleteNode(ListNode node) {
        if (node==null)
            return;
        
        if (node.next==null)
            node =  null;
        
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
