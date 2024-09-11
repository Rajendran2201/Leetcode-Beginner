class Solution {
    public boolean search(int[] nums, int target) {
         int start = 0, end = nums.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[mid] == nums[start] && nums[mid] == nums[end]){
                start++;
                end--;
                continue;
            }
            // left sorted
            if(nums[mid] >= nums[start]){
                if(target >= nums[start] && target <= nums[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
            // righ sorted
            if(nums[mid] <= nums[end]){
                if(target <= nums[end] && target >= nums[mid]){
                    start = mid + 1;
                    
                }else{
                   end = mid - 1;
                }
            }
        }
        return false;
    }
}