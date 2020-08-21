package com.hphan.linkedlist;

/**
 * Pay attention to all edge case
 */
public class RemoveNode_203
{
  public ListNode removeElements(ListNode head, int val) {
        
        // Find the head
        while (head!=null && head.val == val)
            head = head.next;            
        
        ListNode cur = head;
        ListNode prev = null;
        
        // Remove node
        while (cur!=null)
        {
            if (cur.val != val)
            {
                if (prev!=null)
                   prev.next = cur;
                else
                    prev = cur;
                prev = cur;
            }
            else
                prev.next = null;
            cur = cur.next;
        }
        
        return head;
    }
}
