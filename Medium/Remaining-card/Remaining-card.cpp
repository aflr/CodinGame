#include<iostream>

int main() {
  int n;
  std::cin >> n;
  std::cout << (n-1?2*(n-(1<<31-__builtin_clz(n-1))):1) << std::endl;
}
