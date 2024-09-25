/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        int count = 1;
        while(fast.next != null){
            if(count <= n){
                fast = fast.next;
            }else{
                slow = slow.next;
                fast = fast.next;
            }
            count++;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}