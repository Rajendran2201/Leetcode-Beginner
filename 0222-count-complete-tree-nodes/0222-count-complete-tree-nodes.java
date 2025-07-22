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
    public int countNodes(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 0;
        if(root != null){
            queue.add(root);
            count++;
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                    count++;
                }
                if(node.right != null){
                    queue.add(node.right);
                    count++;
                }
            }
        }
        return count;
    }
}