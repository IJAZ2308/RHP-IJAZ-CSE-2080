#include<iostream>
#include<vector>
#include<algorithm>
#include<map>
#define ll long long int
using namespace std;
void solve(){
	int n;cin>>n;
	vector<int> a(n),prev(n+1,0);
	
	
	for(int i=0;i<n;i++) cin>>a[i];
	ll sum = 0,last = 0;
	for(int i = n-1;i>=0;i--){
	
		last -= prev[a[i]];
		last += (prev[a[i]] = n-i);
		sum += last;
	}
	cout<<sum;
}
int main(){
ios_base::sync_with_stdio(false);
        cin.tie(NULL);
        int t; cin>>t;
        while(t--){
            solve();
}
}
