#include<iostream>
#include<algorithm>
#include<vector>
#include<set>
#define ll long long 
using namespace std;

int find(vector<int>& ldr,int node){ //using to find the leader
	if(ldr[node] != node){
		ldr[node] = find(ldr,ldr[node]);
	}
	return ldr[node];
}
void join(vector<int>& ldr , int lt, int rt){ // joint is used to assign ultimate leader and leader
	int ldrlt = find(ldr,lt);
	int ldrrt = find(ldr,rt);
	ldr[ldrlt] = ldrrt;
}

void solve(){
	int N,M; cin>>N>>M;
	vector<int> ldr(N+1);
	for(int i = 1; i<=N;i++) ldr[i] = i;
	for(int e = 1;e<=M;e++){
		int lt,rt; cin>>lt>>rt;
		join(ldr,lt,rt);
	}
	set<int> st;
	for(int i = 1;i<=N;i++){
	
		cout<<find(ldr,i)<<" ";
		st.insert(find(ldr,i));// we are using find instead of directly using index because it will return wrong answer because we using lazy update
	}
	
	for(const auto& val : st){
		cout<<val<<" ";
	}
	cout<<st.size();
	
}
int main(){
	solve();
	return 0;
}
