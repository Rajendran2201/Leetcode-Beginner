class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();

        int i = num.length-1;
        while( i>=0 || k>0){
            // if i>0 then we have to add nums[i] to k 
            if(i >=0 ){
                k += num[i];
                i--;
            }
            // take the last digit of k and add it to the result
            result.addFirst(k%10);
            k /= 10;
        }

        return result;
    }
}