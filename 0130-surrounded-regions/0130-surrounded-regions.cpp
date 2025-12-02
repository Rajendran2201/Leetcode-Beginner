class Solution {
private:
    void dfs(int i, int j, vector<vector<char>>& board, vector<vector<int>>& vis){
        int n = board.size(), m = board[0].size();
        vis[i][j] = 1;

        vector<pair<int, int>> pr = {{1,0},{0,1},{-1,0},{0,-1}};

        for(pair<int,int> p : pr){
            int nrow = i + p.first;
            int ncol = j + p.second;

            if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && !vis[nrow][ncol] && board[nrow][ncol] == 'O')
                dfs(nrow, ncol, board, vis);
        }
    }
public:
    void solve(vector<vector<char>>& board) {
        int n = board.size();
        int m = board[0].size();

        vector<vector<int>> vis(n, vector<int>(m, 0));

        // traverse through the boundaries, look for a 'O' and keep the region intact
        
        // traverse first row and last row
        for(int j=0; j<m; j++){
            if(!vis[0][j] && board[0][j] == 'O')
                dfs(0, j, board, vis);
            
            if(!vis[n-1][j] && board[n-1][j] == 'O')
                dfs(n-1, j, board, vis);
        }

         // traverse first column and last column
       for(int i=0; i<n; i++){
        if(!vis[i][0] && board[i][0] == 'O')
            dfs(i, 0, board, vis);
        if(!vis[i][m-1] && board[i][m-1] == 'O')
            dfs(i, m-1, board, vis);
       }

       for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(!vis[i][j] && board[i][j] == 'O')
                board[i][j] = 'X';
        }
       }
    }
};