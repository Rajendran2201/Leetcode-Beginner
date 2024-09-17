class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int[] ans = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            ans[i] = findNGE(nums1[i], nums2);
        }
        return ans;
    }
    public int findNGE(int x, int[] nums){
        Stack<Integer> stack = new Stack<>();
        for(int i=nums.length-1; i>=0; i--){
            if(nums[i] == x){
                while(true){
                    if(stack.isEmpty()){
                        return -1;
                    }
                    int max = stack.pop();
                    if(max > x){
                        return max;
                    }
                }
                
            }else{
                stack.push(nums[i]);
            }
        }
        return -1;
    }
}