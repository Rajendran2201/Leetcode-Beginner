/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
       return checkheight(root) != -1;
    }

    private int checkheight(TreeNode root){
        if(root == null) return 0;
        int leftheight = checkheight(root.left);
        if(leftheight == -1) return -1;
        int rightheight = checkheight(root.right);
        if(rightheight == -1) return -1;
        int difference = Math.abs(leftheight - rightheight);
        if(difference > 1) return -1;
        return Math.max(leftheight, rightheight) + 1;
    }
}