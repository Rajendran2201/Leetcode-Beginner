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
        if(head == null || head.next == null){
            return null;
        }
       int size = 0;
       ListNode temp = head;
       while(temp != null){
        temp = temp.next;
        size++;
       }

    int frontIndex = size - n;
    int count = 0;
    ListNode dummyNode = new ListNode(0, head);
    ListNode dummy = dummyNode;
    while(dummy != null && dummy.next != null){
        if(count == frontIndex){
            dummy.next = dummy.next.next;
        }
        dummy = dummy.next;
        count++;
    }
    return dummyNode.next;
    }
}