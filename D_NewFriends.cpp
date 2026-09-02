#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int find(vector<int>& ldr,int val){ 
	if(ldr[node] != val){
		ldr[node] = find(ldr,ldr[val]);
	}
	return ldr[node];
}
void join(vector<int>& ldr , int lt, int rt){ 
	int ldrlt = find(ldr,lt);
	int ldrrt = find(ldr,rt);
	ldr[ldrrt] = ldrlt;
}

void solve(){
int N,M ; cin>>N>>M;
vector<int> ldr(N+1,0);
int res = 0;
for(int i = 1;i<=N;i++) ldr[i] = i;
for(int e = 1; e<= M ; e++){
	int fr1,fr2;cin>>fr1>>fr2;	
	join(ldr,fr1,fr2);
}
vector<int>gcnt(N+1,0);

for(int i =)


}
int main(){
	solve();
	return 0;
}
