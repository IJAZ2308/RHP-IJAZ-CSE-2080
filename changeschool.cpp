#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, K;
    cin >> N >> K;

    vector<int> cnt(K + 1, 0);

    for (int i = 0; i < N; i++) {
        int x;
        cin >> x;
        cnt[x]++;
    }

    // Maximum number of students in any class
    int mx = 0;

    for (int i = 1; i <= K; i++) {
        mx = max(mx, cnt[i]);
    }

    int answer = 0;

    for (int i = 1; i <= K; i++) {

        // Takahashi joins this class
        int newSize = cnt[i] + 1;

        if (newSize >= mx) {
            answer++;
        }
    }

    cout << answer << '\n';

    return 0;
}