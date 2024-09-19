class Solution {
    public int trap(int[] height) {
        int total = 0, n = height.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];

        prefixMax[0] = height[0];
        suffixMax[n-1] = height[n-1];
        //computing prefix max of each element
        for(int i=1; i<n; i++){
            prefixMax[i] = height[i] > prefixMax[i-1] ? height[i] : prefixMax[i-1];
        }
         //computing suffix max of each element
        for(int i=n-2; i>=0; i--){
            suffixMax[i] = height[i] > suffixMax[i+1] ? height[i] : suffixMax[i+1];
        }
        for(int i=0; i<n; i++){
            int lmax = prefixMax[i];
            int rmax = suffixMax[i];
            if(height[i] < lmax && height[i] < rmax){
                total += (Math.min(lmax, rmax) - height[i]); 
            }
        }
        return total;
    }
}