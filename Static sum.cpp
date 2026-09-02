#include <iostream>
#include <vector>
using namespace std;

int main() {
    vector<int> A = {2, 4, 6, 8, 10, 12};

    int n = A.size();

    vector<int> prefix(n);
    prefix[0] = A[0];

    for (int i = 1; i < n; i++) {
        prefix[i] = prefix[i - 1] + A[i];
    }

    int L = 1;
    int R = 4;

    int sum;

    if (L == 0)
        sum = prefix[R];
    else
        sum = prefix[R] - prefix[L - 1];

    cout << sum;

    return 0;
}