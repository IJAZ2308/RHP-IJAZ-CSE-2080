#include<iostream>
#include<algorithm>
#include<vector>
#define ll long long
using namespace std;

void solve(){
    int n;
    cin>>n;
    vector<int> a(n+1);
    for(int i=1;i<=n;i++) cin>>a[i];

    ll bal=0;
    bool ok=true;

    for(int stk=1;stk<=n;stk++){
        if(a[stk]>=stk) bal+=(a[stk]-stk);
        else{
            ll needed=stk-a[stk];
            if(bal>=needed) bal-=needed;
            else{
                ok=false;
                break;
            }
        }
    }

    cout<<(ok?"YES":"NO")<<endl;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin>>t;
    while(t--){
        solve();
    }
}
