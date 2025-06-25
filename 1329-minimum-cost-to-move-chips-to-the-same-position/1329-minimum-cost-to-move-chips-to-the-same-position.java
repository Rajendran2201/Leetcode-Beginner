class Solution {
    public int minCostToMoveChips(int[] position) {
        int odd =0, even =0;
        for(int num: position){
            if((num & 1) == 0) even++;
            else odd++;
        }
        return Math.min(odd,even);
    }
}