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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        preorder(ans, root);
        return ans;
    }
    public void preorder(List<Integer> ans, TreeNode root){
        if(root != null){
            ans.add(root.val);
            preorder(ans, root.left);
            preorder(ans, root.right);
        }
    }
}