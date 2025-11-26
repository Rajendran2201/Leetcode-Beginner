class Solution {
public:
    int alternatingSum(vector<int>& nums) {
        int x = 1;
        int res = 0;
        for(int num : nums){
            res += x * num;
            x = -1 * x;
        }
        return res;
    }
};