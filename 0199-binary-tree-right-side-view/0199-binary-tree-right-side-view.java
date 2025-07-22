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
    public List<Integer> rightSideView(TreeNode root) {
        // So, this is going to be a recursive approach to traverse the tree
        // we need a DS to store the resultant value, let me create it
        List<Integer> result = new ArrayList<>();

        // let's have a recursive helper function 
        rightView(root, result, 0); // 0 - represent the level of root node
        return result;
    }
    public void rightView(TreeNode node, List<Integer> result, int currLevel){
        // base case
        if(node == null) return;


        // when do we find the right element??
        // so the idea is always go to the right element first and left while moving down.
        // right recursive call firsta nd then left recursive call
        // the left recursive call is very important becasue, when no right child is present, the left child could be viewed from the right view
        // So how do we know if a node is at the right view??
        // Everytime, we move down, we add the first element into the result

        if(currLevel == result.size()){
            result.add(node.val);
        }

        rightView(node.right, result, currLevel+1);
        rightView(node.left, result, currLevel+1);

    }
}