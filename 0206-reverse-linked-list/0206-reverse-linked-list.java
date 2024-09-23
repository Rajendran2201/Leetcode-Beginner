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
    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        // Whenever a reversal problem comes, go with a stack for brute force
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp!= null) {
            stack.push(temp);
            temp = temp.next;
        }

        ListNode ans = stack.pop();
        ListNode temp2 = ans;
        while (!stack.isEmpty()) {
            temp2.next = stack.pop();
            temp2 = temp2.next;
        }
        temp2.next = null;

        return ans;
    }
}