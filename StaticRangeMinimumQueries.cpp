#include<iostream>
#include<algorithm>
#include<vector>
#include<set>
#define ll long long 
using namespace std;

void solve(){
	int N,Q; cin>>N>>Q;
 vector<ll>sum(N+1,0);
 
    for(int i = 1;i<=n;i++){
        int curr;cin>>curr;
        psum[i] = psum[i-1] + curr;
    }
    for(int i = 0;i <= Q; i++){
    	int l,r; cin>>l>>r;
    	int res = 
	}
}

int main(){
	solve();
	return 0;
}