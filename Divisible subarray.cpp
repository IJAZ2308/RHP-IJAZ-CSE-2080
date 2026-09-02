#include <bits/stdc++.h>
using namespace std;

int main() {
    int N;
    cin >> N;

    vector<long long> a(N);

    for (int i = 0; i < N; i++) {
        cin >> a[i];
    }

    vector<long long> cnt(N + 1, 0);

    long long prefix = 0;
    long long answer = 0;

    cnt[0] = 1;

    for (int i = 0; i < N; i++) {
        prefix += a[i];

        int rem = prefix % N;

        if (rem < 0)
            rem += N;

        answer += cnt[rem];
        cnt[rem]++;
    }

    cout << answer << endl;

    return 0;
}