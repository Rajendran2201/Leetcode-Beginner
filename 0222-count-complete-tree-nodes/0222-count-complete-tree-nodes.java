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
        // Here's the optimised version 
        // The ideas here is quite simple. All we have to know is to understand a property of a full BT.
        // The maximum number of nodes in a full BT is 2^h - 1 where h is the height of the BT
        // A complete BT is a collection of FULL Binary Subtrees. 

        // So, here's the algo:
            // FInd the left height and right height of the root node
            // If both are equal, the complete BT is a full binary tree, apply the formula
            // If not apply the formula separtely to the left subtree and right subtree
            // add the resultants together. Also add 1 extra for the root node
        if(root == null) return 0;
        int leftLength = findLeftCount(root);
        int rightLength = findRightCount(root);

        if(leftLength == rightLength)
            return (int)Math.pow(2, leftLength) - 1;
        
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    public int findLeftCount(TreeNode node){
        int count = 0;
        while(node != null){
            node = node.left;
            count++;
        }
        return count;
    }
    public int findRightCount(TreeNode node){
        int count = 0;
        while(node != null){
            node = node.right;
            count++;
        }
        return count;
    }
}