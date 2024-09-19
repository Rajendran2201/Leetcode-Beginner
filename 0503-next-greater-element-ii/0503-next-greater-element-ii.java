class Solution {
    public int[] nextGreaterElements(int[] nums) {
       int[] res = new int[nums.length];
       for(int i=0; i<nums.length; i++){
            res[i] = findNGE(nums[i], i, nums);
       }
       return res;
    }
    public int findNGE(int x, int index, int[] nums){
       for(int i=index; i<nums.length; i++){
        if(nums[i] > x){
            return nums[i];
        }
       }
       for(int i=0; i<index; i++){
         if(nums[i] > x){
            return nums[i];
        }
       }
       return -1;
    }
}