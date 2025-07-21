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
    class Tuple {
        TreeNode node;
        int row, col;

        public Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // we need a data structure to store all the nodes in the verical order. 
        // this tree map will map the nodes to the respective vertical axis numbers.
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        // for horizontal or level mapping or tracking, we need a queue 
        // This queue contains tuple which consists of node, row number, col number
        Queue<Tuple> q = new LinkedList<>();

        // add the root element to the queue
        q.add(new Tuple(root, 0, 0));

        // traverse through the entire tree 
        while (!q.isEmpty()) {
            // retrieve the element from the queue from the front
            Tuple tuple = q.poll();

            // unpack the tuple
            TreeNode tempNode = tuple.node;
            int row = tuple.row;
            int col = tuple.col;

            // We will be building two things: Tree map and Priority queue 
            // this is because, the end resultant has a vertical number mapped to a treemap which again mapps the horizontal number to the queue of values.
            // Here we have used the priority queue. The reason is when multiple elements are placed in the same column, they have to displayed from top to bottom.
            // End resultant DS: TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

            // let's build the treemap of integer and treemap
            // This maps the vertical number to the treemap 
            // TreeMap<Integer, TreeMap>
            if (!map.containsKey(row)) {
                map.put(row, new TreeMap<>());
            }

            // let's build the treemap of integer and priority queue
            if (!map.get(row).containsKey(col)) {
                map.get(row).put(col, new PriorityQueue<>());
            }

            // So far, we have created only the DS to store the value. Only now we are going to start storing the values
            // For each node, we need three values: node value, node row number, node col number

            map.get(row).get(col).add(tempNode.val);
            if (tempNode.left != null)
                q.add(new Tuple(tempNode.left, row - 1, col + 1));
            if (tempNode.right != null)
                q.add(new Tuple(tempNode.right, row + 1, col + 1));

        }

        // We have traversed the entire tree. Now, we have to parse this TreeMap and create a List of lists to return as output

        List<List<Integer>> result = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> x : map.values()) {
            // creating the sublists
            result.add(new ArrayList<>());
            // traverse through the Treemap containing Integer and Prioirty Queue to access the elements
            for (PriorityQueue<Integer> y : x.values()) {
                // add the elements to the first of the arraylist
                while (!y.isEmpty())
                    result.get(result.size() - 1).add(y.poll());
            }
        }
        return result;
    }
}