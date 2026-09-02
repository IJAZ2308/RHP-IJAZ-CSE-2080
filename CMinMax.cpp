#include<iostream>
#include<vector>
#define ll long long int
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N; 
    cin >> N;

    vector<int> a(N + 1);
    for(int i = 1; i <= N; i++) cin >> a[i];

    int same = 0, exchg = 0;
    for(int i = 1; i <= N; i++){
        if(i == a[i]) same++;
        else if(i == a[a[i]]) exchg++;
    }

    ll ans = exchg / 2 + (1LL * same * (same - 1)) / 2;
    cout << ans << endl;

    return 0;
}