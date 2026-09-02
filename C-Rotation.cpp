#include<iostream>
#include<string>

using namespace std;
void solve(){
  int N,Q; cin>>N>>Q;
  string str;
  cin>>str;
 int index= N-1;
 while(Q--){
   int op, pos; cin>>op>>pos;
   pos = pos%N;
   if(op == 1){
     index = index - pos;
     if(index < 0) index += N;
     
   }else{
     cout<<str[(index + pos)%N]<<endl;
   }
 }
    
  }

int main(){
  solve();
  return 0;
}