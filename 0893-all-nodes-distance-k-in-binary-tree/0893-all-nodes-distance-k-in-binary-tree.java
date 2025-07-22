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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // The idea here is quite simple. the target node is given. 
        // We have to traverse the the nodes that are radially outwards to the target
        // by radially outward, I mean the nodes that are to the left, right and upwards
        // The left and right part isn;t a big issue, it can be done by BFS
        // But, for the upwards part, we have to keep track of the parent nodes of each node
        // For that, we'll be using a hashmap

        // Let's start by creating the hashmap that stores the parent of each node
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        findParent(parents, root, null); 

        // The findParent function maps the nodes to their parents
        // the arguments are parents map, node and parent node
        // here child node is null, cause root won't have a parent

        // Here we need a Queue for BFS
        // Along with a queue, we need a DS (HashSet in this case) to store the visited nodes
        // This is needed because when traversing upwards, we might come accross the visited nodes, which is unnecessary. So, let me create it quickly
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();

        // let's start with the target and the distance be 0 initially
        int distance = 0;
        q.add(target);
        visited.add(target);

        // when the queue is not empty, each node is taken and traversed radially
        while(!q.isEmpty()){
            int size = q.size();
            if(distance == k){  // no more traversals
                break;
            }

            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                // traverse left node
                if(node.left != null && !visited.contains(node.left)){
                    q.add(node.left);
                    visited.add(node.left);
                }
                // let's do the same for right nodes
                if(node.right != null && !visited.contains(node.right)){
                    q.add(node.right);
                    visited.add(node.right);
                }
                // traverse upwards, here's where the parents map comes in handy
                TreeNode par = parents.get(node);
                if(par != null && !visited.contains(par)){
                    q.add(par);
                    visited.add(par);
                }

            }
            distance++;     // increase the distance
        }

        // Now, traverse the queue and returns the elements as a list
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            int val = q.poll().val;
            list.add(val);
        }

        return list;
    }

    public void findParent(Map<TreeNode, TreeNode> parents, TreeNode node, TreeNode parent){
        if(node == null) return;
        parents.put(node, parent);
        findParent(parents, node.left, node);
        findParent(parents, node.right, node);
    }
}