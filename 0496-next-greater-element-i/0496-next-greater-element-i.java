class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=nums2.length-1; i>=0; i--){
            int num = nums2[i];
            int nge = -1;
            while(!stack.isEmpty() && stack.peek() <= num){
                stack.pop();
            }
            if(!stack.isEmpty() && stack.peek() > num){
                nge = stack.peek();
            }else{
                nge = -1;
            }

            map.put(num, nge);
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}