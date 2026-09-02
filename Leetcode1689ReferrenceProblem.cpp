#include<iostream>
#include<vector>
#include<string>
using namespace std;

void solve(){
    string n; 
    cin >> n;
    int len = n.size();
    int k = 0;
    for(char ch : n){
        k = max(k, ch - '0');
    }
    vector<string> nums(k, string(len, '0'));
    for(int i = 0; i < len; i++){
        int d = n[i] - '0';
        for(int j = 0; j < d; j++){
            nums[j][i] = '1';
        }
    }

    cout << k << endl;
    for(auto &s : nums){
        cout << s << endl;
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    solve();
    return 0;
}