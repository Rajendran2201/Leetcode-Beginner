class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        int n = nums.length;
        Arrays.fill(res, -1);
       for(int i=0; i<n; i++){
        for(int j=1; j<n; j++){
            int index = (i+j) % n;
            if(nums[index] > nums[i]){
                res[i] = nums[index];
                break;
            }
        }
       }
        return res;
    }
}