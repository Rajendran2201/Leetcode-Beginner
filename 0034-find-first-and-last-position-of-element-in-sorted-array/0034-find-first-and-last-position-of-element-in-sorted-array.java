class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = findFirst(nums, target);
        ans[1] = findLast(nums, target);
        return ans;
    }
    int findFirst(int[] nums, int target){
        int start = 0, end = nums.length - 1;
        int first = -1;
        while(start <= end){
            int mid = start + (end-start) / 2;

            if(nums[mid] == target){
                first = mid;
                end = mid - 1;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return first;
    }
    int findLast(int[] nums, int target){
        int start = 0, end = nums.length - 1;
        int last = -1;
        while(start <= end){
            int mid = start + (end-start) / 2;

            if(nums[mid] == target){
                last = mid;
                start = mid + 1;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return last;
    }
}