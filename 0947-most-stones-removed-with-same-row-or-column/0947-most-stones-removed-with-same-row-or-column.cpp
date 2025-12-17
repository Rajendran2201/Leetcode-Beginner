class DisjointSet{
public:
    vector<int> parent, rank;

    DisjointSet(int n){
        parent.resize(n);
        rank.resize(n, 0);
        for(int i=0; i<n; i++)
            parent[i] = i;
    }

    int find(int x) {
        if(parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    void unite(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px == py) return;

        if(rank[px] < rank[py])
            parent[px] = py;
        else if(parent[py] < rank[px])
            parent[py] = px;
        else{
            parent[py] = px;
            rank[px]++;
        }
    }
};

class Solution {
public:
    int removeStones(vector<vector<int>>& stones) {
        // ans = n - no of connected components
        int n = stones.size();
        DisjointSet dsu(n);

        // unite stones sharing row and column
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])
                    dsu.unite(i, j);
            }
        }

        // count the connected components 
        unordered_set<int> components; 
        for(int i=0; i<n; i++)
            components.insert(dsu.find(i));

        return n - components.size();
    }
};