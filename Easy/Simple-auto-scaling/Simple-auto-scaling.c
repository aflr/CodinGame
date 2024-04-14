#include <math.h>
#include <stdio.h>

int main() {
    int S, M;
    scanf("%d%d", &S, &M);
    int cpi[S], ms[M+1][S];
    for (int i = 0; i < S; (*ms)[i++] = 0)
        scanf("%d", cpi + i);
    for (int i = 0; i < M; i++)
        for (int j = 0; j < S; j++)
            scanf("%d", ms[i+1] + j),
            printf("%d%s", (int)(ceil(ms[i+1][j] * 1.0 / cpi[j])
                    - ceil(ms[i][j] * 1.0 / cpi[j])), j == S - 1 ? "\n" : " ");
    return 0;
}
