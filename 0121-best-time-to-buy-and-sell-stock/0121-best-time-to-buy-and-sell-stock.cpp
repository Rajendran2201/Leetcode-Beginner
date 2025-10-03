class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int profit = 0;
        int mini = prices[0];

        for(int &price : prices){
            int cost = price - mini;
            profit = max(profit, cost);
            mini = min(mini, price);
        }

        return profit;
    }
};