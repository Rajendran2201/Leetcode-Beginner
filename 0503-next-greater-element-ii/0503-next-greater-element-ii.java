class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        int n = nums.length;
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for(int i=2*n-1; i>=0; i--){
            int index = i % n;
            while(!stack.isEmpty() && stack.peek() <= nums[index]){
               stack.pop();
            }

            if(!stack.isEmpty() && stack.peek() > nums[index]){
                res[index] = stack.peek();
            }
            stack.push(nums[index]);

        }
        return res;
    }
}