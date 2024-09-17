class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            ans[i] = findNextGreaterElement(nums1[i], nums2);
        }
        return ans;
    }
    public int findNextGreaterElement(int x, int[] nums2){
        int index = findIndex(x, nums2);
        if(index == -1){
            return index;
        }
        for(int i = index; i<nums2.length; i++){
            if(nums2[i] > x){
                return nums2[i];
            }
        }
        return -1;
    }
    public int findIndex(int x, int[] nums){
        for(int i=0; i<nums.length; i++){
            if(nums[i] == x){
                return i;
            }
        }
        return -1;
    }
}