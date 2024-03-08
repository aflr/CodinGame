#include <stdio.h>

int main() {
  int N;
  scanf("%d", &N);
  printf("%d\n", N - 1 ? 2 * (N - (1 << 31 - __builtin_clz(N - 1))) : 1);
  return 0;
}
