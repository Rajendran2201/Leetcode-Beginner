import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];
        
        // Sort intervals by their start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> res = new ArrayList<>();
        
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            // If intervals overlap, merge them
            if (current[1] >= intervals[i][0]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                res.add(current);
                current = intervals[i];
            }
        }
        // Add the last interval
        res.add(current);
        
        return res.toArray(new int[res.size()][]);
    }
}
