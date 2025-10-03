class Solution {
public:
    int numDistinct(string s, string t) {
        int n = s.size(), m = t.size();
        vector<vector<int>> dp(n+1, vector<int>(m+1, -1));
        return helper(s, t, n-1, m-1, dp);
    }

    int helper(string s1, string s2, int i, int j, vector<vector<int>>& dp){
        if(j < 0) return 1;   // s2 got exhausted, which mean we found the subsequence
        if(i < 0) return 0; // s1 got exhauseted but s2 is not completely matched

        if(dp[i][j] != -1)
            return dp[i][j];

        if(s1[i] == s2[j])
            return dp[i][j] = helper(s1, s2, i-1, j-1, dp) + helper(s1, s2, i-1, j, dp);
        else
            return dp[i][j] = helper(s1, s2, i-1, j, dp);

    }
};