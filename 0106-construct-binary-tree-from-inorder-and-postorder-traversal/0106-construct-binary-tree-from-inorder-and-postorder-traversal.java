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
    int postorderIndex;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex =  postorder.length-1;
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        TreeNode root = helper(postorder, 0, inorder.length-1);
        return root;
    }

    public TreeNode helper(int[] postorder, int start, int end){
        if(start > end) return null;

        int rootVal = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        
        // right and left - same order
        root.right = helper(postorder, rootIndex+1, end);
        root.left = helper(postorder, start, rootIndex-1);

        return root;

    }
}