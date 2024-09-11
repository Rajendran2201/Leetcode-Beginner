class Solution {
    public int findMin(int[] nums) {
       
       int start = 0, end = nums.length - 1;
       int ans = Integer.MAX_VALUE;
       while(start <= end){
        int mid = start + (end-start)/2;

        if(nums[mid] >= nums[start]){
            ans = Math.min(ans, nums[start]);
            start = mid + 1;
        }else{
            ans = Math.min(ans, nums[mid]);
            end = mid;
        }
       }
       return ans;

    }
}