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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        // Edge case: when the tree is empty, return empty list
        if(root == null){
            return ans;
        }

        int flag = 0;

        // Add the root element to the queue
        queue.add(root);

        // traverse the elements in the queue
        while(!queue.isEmpty()){
            List<Integer> sublevel = new ArrayList<>();
            int levels = queue.size();

            // Add the left and right elements 
            for(int i=0; i<levels; i++){
                TreeNode curr = queue.peek();
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }

                curr = queue.poll();

                // create sublevel list
                sublevel.add(curr.val);
            }

            // add the sub level elements to the main list 
            if(flag == 0){
                ans.add(sublevel);
                flag = 1;
            }else{
                Collections.reverse(sublevel);
                ans.add(sublevel);
                flag = 0;
            }
            

        }        
        // return the list
        return ans;
    }
}