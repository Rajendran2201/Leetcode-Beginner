class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(n+1, -1);
        return max(helper(0, nums, dp), helper(1, nums, dp));
    }
    int helper(int i, vector<int>& nums, vector<int>& dp){
        if(i < 0 || i >= nums.size())
            return 0;
        
        if(dp[i] != -1)
            return dp[i];
        
        dp[i] = nums[i] + max(helper(i+2, nums, dp), helper(i+3, nums, dp));
        return dp[i];
    }
};