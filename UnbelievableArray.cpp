#include <iostream>
#include <vector>

#include <map>
using namespace std;

int find(vector<int>& ldr, int node) {
    if (ldr[node] != node) {
        ldr[node] = find(ldr, ldr[node]);
    }
    return ldr[node];
}

void join(vector<int>& ldr, int lt, int rt) {
    int ldrlt = find(ldr, lt);
    int ldrrt = find(ldr, rt);
    ldr[ldrrt] = ldrlt;
}

void solve() {

    int n, q;
    cin >> n >> q;
    vector<int> a(n + 1), ldr(n + 1);
    map<int, int> vl, lv; // valueToLeader, LeaderToValue

    for (int i = 1; i <= n; i++) {
        cin >> a[i];
        if (vl.find(a[i]) == vl.end()) {
            vl[a[i]] = i;
            lv[i] = a[i];
        }
        ldr[i] = vl[a[i]];
    }

    while (q--) {
        int qt; cin >> qt;
        if (qt == 1) {
            int x, y; cin >> x >> y;
            if (x == y) continue;
            if (vl.find(x) == vl.end()) continue;

            if (vl.find(y) != vl.end()) {
                // both x and y are present -> merge, keep y's identity as the surviving root
                join(ldr, vl[y], vl[x]);
                lv.erase(vl[x]);
                vl.erase(x);
            } else {
                int xldr = vl[x];
                lv[xldr] = y;
                vl.erase(x);
                vl[y] = xldr;
            }
        } else {
            int idx; cin >> idx;
            int uldr = find(ldr, ldr[idx]);
            cout << lv[uldr] << endl;
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int tc = 1, id = 1;
    cin >> tc;
    while (tc--) {
        cout << "Case " << id++ << ":" << endl;
        solve();
    }
}