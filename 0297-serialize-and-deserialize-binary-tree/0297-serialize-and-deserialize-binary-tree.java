/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // convert the tree into a string using level order traversal
        if(root == null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        q.add(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null){
                res.append("n ");
                continue;
            }
            res.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }

        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        for(int i=1; i<values.length; i++){
            TreeNode node = q.poll();
            if(!values[i].equals("n")){
                node.left = new TreeNode(Integer.parseInt(values[i]));
                q.add(node.left);
            }
            i++; // go to next value
            if(i < values.length && !values[i].equals("n")){
                node.right = new TreeNode(Integer.parseInt(values[i]));
                q.add(node.right);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));