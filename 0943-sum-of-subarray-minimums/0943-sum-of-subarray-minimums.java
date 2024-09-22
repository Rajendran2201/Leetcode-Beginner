class Solution {
    public int sumSubarrayMins(int[] arr) {
       int n = arr.length;
       int[] nse = findNSE(arr);
       int[] psee = findPSEE(arr);
       long total = 0; 
       int mod = (int) Math.pow(10, 9) + 7;

       for(int i=0; i<n; i++){
            int left = i - psee[i];
            int right = nse[i] - i;
            total += (long) (left*right) % mod  * arr[i]  % mod;
            total %= mod;
       }

       return (int)total;

    }

    public int[] findNSE(int[] arr){
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1; i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nse[i] = n;
            }else{
                nse[i] = stack.peek();
            }
            stack.push(i);
        }
        return nse;
    }

    public int[] findPSEE(int[] arr){
        int n= arr.length;
        int[] pse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                pse[i] = -1;
            }else{
                pse[i] = stack.peek();
            }
            stack.push(i);
        }
        return pse;
    }
    
}