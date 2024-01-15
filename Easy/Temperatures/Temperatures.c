#include <stdlib.h>
#include <stdio.h>
#include <math.h>

int main()
{
    int n, res = 0;
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        int t;
        scanf("%d", &t);
        res = !i ? t : res;
        res = abs(t) < abs(res) ? t : res;
        res = abs(t) == abs(res) ? fmax(t, res) : res;
    }
    printf("%d\n", res);
    return 0;
}
