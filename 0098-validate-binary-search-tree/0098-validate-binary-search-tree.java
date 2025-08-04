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
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return isSorted(list);
    }

    public void inOrder(TreeNode node, List<Integer> list){
        if(node != null){
            inOrder(node.left, list);
            list.add(node.val);
            inOrder(node.right, list);
        }
    }

    public boolean isSorted(List<Integer> list){
        int n = list.size();

        for(int i=0; i < n - 1; i++){
            if(list.get(i + 1) <= list.get(i))
                return false;
        }
        return true;
    }
}