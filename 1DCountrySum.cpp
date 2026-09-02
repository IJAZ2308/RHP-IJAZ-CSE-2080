#include<iostream>
#include<vector>
#include<algorithm>
#define ll long long int
using namespace std;

void solve() {
    int n;
    cin >> n;
    vector<int> loc(n);
    vector<long long> sum(n + 1, 0);
    for (int i = 0; i < n; i++)
        cin >> loc[i];
    for (int i = 1; i <= n; i++) {
        int ppl;
        cin >> ppl;
        sum[i] = sum[i - 1] + ppl;
    }
    int q;
    cin >> q;
    while (q--) {
        int l, r;
        cin >> l >> r;
        int lt = lower_bound(loc.begin(), loc.end(), l) - loc.begin();
        int rt = upper_bound(loc.begin(), loc.end(), r) - loc.begin();
        cout << sum[rt] - sum[lt] << '\n';
    }
}
    int main(){
        ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        int t; cin>>t;
        while(t--){
            solve();
        }}
