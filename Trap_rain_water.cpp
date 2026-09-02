#include <iostream>
#include <vector>

using namespace std;

int main() {

    int n;
    cin >> n;

    vector<int> h(n);

    for (int i = 0; i < n; i++) {
        cin >> h[i];
    }

    int l = 0;
    int r = n - 1;

    int lm = 0;
    int rm = 0;

    int ans = 0;

    while (l < r) {

        if (h[l] < h[r]) {

            if (h[l] >= lm)
                lm = h[l];
            else
                ans += lm - h[l];

            l++;
        }
        else {

            if (h[r] >= rm)
                rm = h[r];
            else
                ans += rm - h[r];

            r--;
        }
    }

    cout << ans;

    return 0;
}
