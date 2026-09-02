#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int r, c;
    vector<vector<int>> dp;

    int dfs(vector<vector<int>>& a, int i, int j) {

        if (dp[i][j] != -1)
            return dp[i][j];

        int ans = 1;

        int d[4][2] = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        for (auto &x : d) {
            int ni = i + x[0];
            int nj = j + x[1];

            if (ni >= 0 && ni < r &&
                nj >= 0 && nj < c &&
                a[ni][nj] > a[i][j]) {

                ans = max(ans, 1 + dfs(a, ni, nj));
            }
        }

        return dp[i][j] = ans;
    }

    int solve(vector<vector<int>>& a) {

        r = a.size();
        c = a[0].size();

        dp.assign(r, vector<int>(c, -1));

        int res = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res = max(res, dfs(a, i, j));
            }
        }

        return res;
    }
};

int main() {

    int r, c;
    cin >> r >> c;

    vector<vector<int>> a(r, vector<int>(c));

    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            cin >> a[i][j];
        }
    }

    Solution s;
    cout << s.solve(a);

    return 0;
}