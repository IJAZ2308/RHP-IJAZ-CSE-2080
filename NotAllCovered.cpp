#include<map>
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
void solve(){
  
  int N,T;
  cin>> N>>T;
  vector<int>walls(N+2,0);
  while(T--){
    int l, r;
    cin>> l >>r;
  walls[l]++;
  walls[r+1]--;
  }
  int res = 2000000;
  for(int w = 1 ; w<=N;w++){
    walls[w] += walls[w-1];
    res = min(res,walls[w]);
  }
  cout<<res<<endl;
  
}
int main(){
  solve();
  return 0;
}