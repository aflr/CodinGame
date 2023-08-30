#include <iostream>
using namespace std;

int main() {
  while (1) {
    string enemy_1; // name of enemy 1
    cin >> enemy_1; cin.ignore();
    int dist_1; // distance to enemy 1
    cin >> dist_1; cin.ignore();
    string enemy_2; // name of enemy 2
    cin >> enemy_2; cin.ignore();
    int dist_2; // distance to enemy 2
    cin >> dist_2; cin.ignore();
    cout << ((dist_1 < dist_2) ? enemy_1 : enemy_2) << endl;
  }
}
