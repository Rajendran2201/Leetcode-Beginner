class Solution {
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            int min = nums[i];
            int max = nums[i];
            for(int j=i; j<n; j++){
                min = Math.min(nums[j], min);
                max = Math.max(nums[j], max);
                sum += (max - min);
            }
        }
        return sum;
    }
}