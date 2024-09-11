class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 1, end = nums.length - 2;
        if(nums.length == 1){
            return nums[0];
        }
        if(nums[0] != nums[1]){
            return nums[0];
        }

        if(nums[nums.length-1] != nums[nums.length-2]){
            return nums[nums.length-1];
        }

        while(start <= end){
            int mid = start + (end-start)/2;

            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid];
            }
            // left sorted: (even, odd)
            if((mid % 2 == 1 && nums[mid] == nums[mid-1]) 
            || (mid % 2 == 0 && nums[mid] == nums[mid+1])){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}