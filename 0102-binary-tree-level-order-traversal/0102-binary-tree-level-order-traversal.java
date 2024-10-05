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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        // Edge case
        if(root == null){
            return ans;
        }
        queue.add(root);

        while(!queue.isEmpty()){
            int levels = queue.size();
            List<Integer> sublevels = new ArrayList<>();
            for(int i=0; i<levels; i++){
                TreeNode curr = queue.peek();

                // adding left children to the queue
                if(curr.left != null){
                    queue.add(curr.left);
                }
                // adding right children to the queue
                if(curr.right != null){
                    queue.add(curr.right);
                }

                curr = queue.remove();
                // creating sublists of each level
                sublevels.add(curr.val);
            }
            ans.add(sublevels);
        }
        return ans;
    }
}