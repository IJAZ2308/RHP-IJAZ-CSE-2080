#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int H, W, K;
    cin >> H >> W >> K;

    vector<string> S(H);

    for (int i = 0; i < H; i++) {
        cin >> S[i];
    }

    // Check whether each row contains a bomb
    vector<bool> rowBomb(H, false);

    // Check whether each column contains a bomb
    vector<bool> colBomb(W, false);

    for (int i = 0; i < H; i++) {
        for (int j = 0; j < W; j++) {
            if (S[i][j] == '#') {
                rowBomb[i] = true;
                colBomb[j] = true;
            }
        }
    }

    // Distance from nearest safe cell
    vector<vector<int>> dist(H, vector<int>(W, -1));

    queue<pair<int, int>> q;

    // Add all safe cells as BFS sources
    for (int i = 0; i < H; i++) {
        for (int j = 0; j < W; j++) {

            if (S[i][j] == '.' &&
                !rowBomb[i] &&
                !colBomb[j]) {

                dist[i][j] = 0;
                q.push({i, j});
            }
        }
    }

    int dx[] = {-1, 1, 0, 0};
    int dy[] = {0, 0, -1, 1};

    // Multi-source BFS
    while (!q.empty()) {
        auto [x, y] = q.front();
        q.pop();

        for (int d = 0; d < 4; d++) {

            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= H ||
                ny < 0 || ny >= W)
                continue;

            if (S[nx][ny] == '#')
                continue;

            if (dist[nx][ny] != -1)
                continue;

            dist[nx][ny] = dist[x][y] + 1;

            q.push({nx, ny});
        }
    }

    long long answer = 0;

    for (int i = 0; i < H; i++) {
        for (int j = 0; j < W; j++) {

            if (S[i][j] == '.' &&
                dist[i][j] != -1 &&
                dist[i][j] <= K) {

                answer++;
            }
        }
    }

    cout << answer << '\n';

    return 0;
}