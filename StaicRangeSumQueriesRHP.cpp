#include<iostream>
#include<vector>
#define ll long long 
using namespace std;
void solve(){
    int n,q ;
    cin>>n>>q;
    vector<ll>psum(n+1,0);
    for(int i = 1;i<=n;i++){
        int curr;cin>>curr;
        psum[i] = psum[i-1] + curr;

    }
    while(q--){
        int l,r ; 
        cin>>l>>r;
        cout<<psum[r] - psum[l-1]<<endl;
    }

}
int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int tc = 1;
    while(tc--){
        solve();
    }
}