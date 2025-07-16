class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        int oddCount = nums[0] % 2 == 1? 1: 0;
        int evenCount = nums[0] % 2 == 0? 1: 0;
        int alternateCount = 1;
        boolean isExpectingEven = (nums[0] % 2 == 1) ? true : false;

        for(int i=1; i<n; i++){
            if(nums[i]%2 == 1){
                oddCount++;
            }else{
                evenCount++;
            }
            
            if((isExpectingEven == true && nums[i]%2 == 0) || (isExpectingEven == false && nums[i]%2 == 1)){
                alternateCount++;
                isExpectingEven = !isExpectingEven;
            }
        }
        return Math.max(Math.max(evenCount, oddCount), alternateCount);
    }
}


        