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
   public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()){
            
            // Traversing to the leftmost element of the tree/subtree
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            //adding the leftmost element to the list
            // parent node is also the left or right node of the root node
            // so don't worry about it.
            curr = stack.pop();
            ans.add(curr.val);
            
            // changing to the right node
            curr = curr.right;
            
        }
        return ans;
    }
    
}