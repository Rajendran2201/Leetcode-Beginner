/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // let's write a couple of base cases here
        if(root == null) return null;
        if(root == p || root == q) return root;

        // traverse through the tree using DFS and find p and q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // the idea is we return null when the node is null or it contains any value other than p and q
        // But when it contains p or q, we return it (already covered in base case)
        // when a node get two values from either sides, it is the LCA
        if(left != null && right != null){
            return root;
        }

        // we have covered the case where both nodes are found
        // Now it's time to handle the case where only one node is found or neither of the nodes are found
        // the values are propogated upwards, when the root has a value on one side and empty on the other side, it has to choose the non-null value

        return left == null? right : left;


    }
}