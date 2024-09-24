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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode oddhead = new ListNode(0); 
        ListNode oddtail = oddhead;
        ListNode evenhead =  new ListNode(0);
        ListNode eventail = evenhead;
        ListNode temp = head;
        int count = 0;

        while(temp != null){
            if(count % 2 == 0){
                eventail.next = temp;
                eventail = eventail.next;
            }else{
                oddtail.next = temp;
                oddtail = oddtail.next;
            }
            count++;
            temp = temp.next;

        }
        // If you miss this, it will lead to cause a cycle in the LL
        oddtail.next = null; // VERY IMPORTANT
        eventail.next = oddhead.next;
        return  evenhead.next;
    }
}