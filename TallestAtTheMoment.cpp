#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main(){
	int N;
	cin>>N;
	vector<pair<int,int> > a(N);
	for(int i = 0;i<N;i++){
		int ht,lvt;cin>>ht>>lvt;
		a[i] = make_pair(ht,lvt);
		
	}
	sort(a.begin() ,a.end() , greater<pair<int,int> >() );
	vector<int> tarr,harr;
	int till = 0;
	for (const auto &p : a) {
    int ht = p.first;
    int lvt = p.second;

    if (lvt <= till)
        continue;

    till = lvt;
    tarr.push_back(lvt);
    harr.push_back(ht);
}
	int q; cin>>q;
	while(q--){
		int qt ; cin>>qt;
		auto it = upper_bound(tarr.begin(),tarr.end(),qt);
		int d = it-tarr.begin();
		cout<<harr[d]<<endl;
	}
}
