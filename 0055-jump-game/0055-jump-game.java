class Solution {
    public boolean canJump(int[] nums) {
        // We use a greedy strategy and keep a variable maxReach to store the farthest index we can reach at any point.
        // As we iterate through the array:

            // If the current index i is greater than maxReach, it means we are stuck and can't proceed.
            // Otherwise, we update maxReach to the maximum of its current value and i + nums[i].
            // If we can iterate through the entire array without getting stuck, we can reach the last index.

        int maxReach = 0;
        for(int i=0; i<nums.length; i++){
            if(i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        return true;
    }
}