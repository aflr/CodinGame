#include <iostream>
#include <climits>
#include <vector>

using namespace std;

int main() {
    int n; cin >> n;
    vector<int> horses(n);
    for (int i = 0, pi; i < n; i++)
        cin >> horses[i];
    sort(horses.begin(), horses.end());
    int m = INT_MAX;
    for (int i = 1; i < n; i++)
        m = min(m, horses[i] - horses[i - 1]);
    cout << m << endl;
}
