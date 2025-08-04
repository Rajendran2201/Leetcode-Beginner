class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for(int fast=1; fast<nums.length; fast++){
            // check the elements pointed by slow and fast
            // if they are same, increment fast (automatically done through the for loop)
            // otherwise increment slow and replace slow by fast
            if(nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow+1; // number of elements = indeex of unique elements + 1
    }
}

// TC: O(n)
// SC: O(1)