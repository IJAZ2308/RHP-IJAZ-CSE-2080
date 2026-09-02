#include <iostream>
#include <unordered_map>

using namespace std;

int main() {

    string s;
    cin >> s;

    unordered_map<int, int> mp;

    int sum = 0;
    int ans = 0;

    mp[0] = -1;

    for (int i = 0; i < s.length(); i++) {

        if (s[i] == '1')
            sum++;
        else
            sum--;

        if (mp.find(sum) != mp.end()) {

            int len = i - mp[sum];

            if (len > ans)
                ans = len;
        }
        else {

            mp[sum] = i;
        }
    }

    cout << ans;

    return 0;
}
