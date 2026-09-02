#include<iostream>
#include<vector>
#include<algorithm>
#include<set>
#include<map>
using namespace std;

void solve(){
  int N,M;cin>>N>>M;
  vector<int> chw(N+1),chl(N+1),bxw(M+1),bxl(M+1);
    vector<pair<int,int>> wv;
  for(int i = 1;i<=N;i++){
    int chocw; cin>>chocw;
    wv.emplace_back(make_pair(chocw,-i));
    
}for(int i = 1;i<=N;i++) cin>> chl[i];
for(int i = 1;i<=M;i++){
  int boxw;cin>>boxw;
  wv.emplace_back(make_pair(boxw,i));
}
for(int i=1;i<=M;i++)cin>>bxl[i];
sort(wv.begin(),wv.end(),greater<>());
multiset<int> ms;
for(auto[w,idx]: wv){
  if(idx>0){
    ms.insert(bxl[idx]);
  }else{
    auto it = ms.lower_bound(chl[-idx]);
    if(it != ms.end()){
      ms.erase(it);
    }else{
      cout<<"No";return;
    }
  }
}
cout<<"Yes";
}
int main(){
  solve();
  return 0;
}