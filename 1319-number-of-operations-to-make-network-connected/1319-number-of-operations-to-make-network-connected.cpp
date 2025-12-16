class DisjointSet {
    vector<int> parent, rank;

public:
    DisjointSet(int n) {
        parent.resize(n);
        rank.resize(n, 0);
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    int findParent(int node) {
        if (node == parent[node])
            return node;
        return parent[node] = findParent(parent[node]); // path compression
    }

    void unionByRank(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);

        if (pu == pv) return;

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pv] < rank[pu]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }
    }
};

class Solution {
public:
    int makeConnected(int n, vector<vector<int>>& connections) {
        // find the number of connected components (nc)
        // ans = nc - 1
        // we have to take out an edge and replace it somewhere else
        // count the extra edges 
        // if (extraEdges >= ans) return ans
        // else return -1 

        if(connections.size() < n - 1) return -1;

        DisjointSet ds(n);
        for(auto c : connections)
            ds.unionByRank(c[0], c[1]);

        int components = 0;
        for(int i=0; i<n; i++){
            if(ds.findParent(i) == i)
                components++;
        }

        return components - 1;

    }
};