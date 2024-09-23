/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ptr1 = list1;
        ListNode ptr2 = list2;

        ListNode dummyNode = new ListNode(0);
        ListNode ans = dummyNode;

        while (ptr1 != null && ptr2 != null) {
            if (ptr1 != null && ptr1.val < ptr2.val) {
                ans.next = ptr1;
                ptr1 = ptr1.next;
            } else if (ptr2 != null) {
                ans.next = ptr2;
                ptr2 = ptr2.next;
            }
            ans = ans.next;
        }
        // In case of remaining elements, they also need to be added
        if (ptr1 != null) {
            ans.next = ptr1;
        }else{
            ans.next = ptr2;
        }
        return dummyNode.next;
    }
}