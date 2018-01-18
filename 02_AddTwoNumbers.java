/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode iter = result;
        int overflow = 0;
        int sum;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            sum = x + y + overflow;
            iter.next = new ListNode( sum % 10);
            overflow = (int) (sum / 10);
            iter = iter.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null ) l2 = l2.next;
        }
        
        if (overflow == 1) {
            iter.next = new ListNode(overflow);
        }
        return result.next;
    }
}