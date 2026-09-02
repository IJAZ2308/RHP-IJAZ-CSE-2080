#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int r, c;

    void dfs(vector<vector<char>>& g, int i, int j) {

        if (i < 0 || j < 0 || i >= r || j >= c || g[i][j] == '0')
            return;

        g[i][j] = '0';

        dfs(g, i + 1, j);
        dfs(g, i - 1, j);
        dfs(g, i, j + 1);
        dfs(g, i, j - 1);
    }

    int solve(vector<vector<char>>& g) {

        r = g.size();
        c = g[0].size();

        int cnt = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (g[i][j] == '1') {
                    cnt++;
                    dfs(g, i, j);
                }
            }
        }

        return cnt;
    }
};

int main() {

    int r, c;
    cin >> r >> c;

    vector<vector<char>> g(r, vector<char>(c));

    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            cin >> g[i][j];
        }
    }

    Solution s;
    cout << s.solve(g);

    return 0;
}