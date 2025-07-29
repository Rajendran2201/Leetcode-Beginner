class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Read Editorial Approach 1: Linear Search

        // This problem has three parts 
        // Left, merging interval, right

        int n = intervals.length;
        int i = 0;

        List<int[]> res = new ArrayList<>();

        // add left values (need not be merged)
        while(i < n && newInterval[0] > intervals[i][1]){
            res.add(intervals[i]);
            i++;
        }

        // check the mergeable part and add it 
        while(i < n && newInterval[1] >= intervals[i][0]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        res.add(newInterval);

        // add the right part
        while(i < n){
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);

    }
}