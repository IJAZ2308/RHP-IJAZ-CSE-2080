#include <bits/stdc++.h>
using namespace std;

int N;
long long K;

vector<long long> A;

void dfs(int pos, long long rem) {

    // Last position
    if (pos == N) {

        if (rem % N != 0)
            return;

        A[pos - 1] = rem / N;

        for (int i = 0; i < N; i++) {
            if (i > 0)
                cout << ' ';

            cout << A[i];
        }

        cout << '\n';

        return;
    }

    /*
        We choose A[pos-1].

        pos * A[pos-1] <= rem

        So:

        A[pos-1] <= rem / pos
    */

    for (long long x = 0; x * pos <= rem; x++) {

        long long newRem = rem - x * pos;

        /*
            Remaining coefficients are:

            pos+1, pos+2, ..., N

            Their gcd is pos+1.

            Therefore newRem must be divisible
            by pos+1.
        */

        if (newRem % (pos + 1) != 0)
            continue;

        A[pos - 1] = x;

        dfs(pos + 1, newRem);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> K;

    A.resize(N);

    dfs(1, K);

    return 0;
}