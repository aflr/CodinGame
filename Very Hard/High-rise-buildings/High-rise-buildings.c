#include <stdio.h>
#include <stdlib.h>

int solve();
int valid(int k, int i, int j);
int validVis(int *array, int *mustStayD, int vis);
int notInArray(int *array, int num);
int countVis(int *array);
void printGrid();

int n;
int **grid;
int **clues;
int **mustStay;

int main() {
  scanf("%d", &n);

  // Read clues
  clues = (int **)malloc(sizeof(int *) * 4);
  for (int i = 0; i < 4; i++) {
    clues[i] = (int *)malloc(sizeof(int) * n);
    for (int j = 0; j < n; j++) {
      scanf("%d", clues[i] + j);
    }
  }

  // Read initial grid
  grid = (int **)malloc(sizeof(int *) * n);
  mustStay = (int **)malloc(sizeof(int *) * n);
  for (int i = 0; i < n; i++) {
    grid[i] = (int *)malloc(sizeof(int) * n);
    mustStay[i] = (int *)malloc(sizeof(int) * n);
    for (int j = 0; j < n; j++) {
      scanf("%d", grid[i] + j);
      mustStay[i][j] = (grid[i][j] != 0);
    }
  }

  solve();
  printGrid();
}

int solve() {
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      if (grid[i][j] != 0)
        continue;
      for (int k = 1; k <= n; k++) {
        if (valid(k, i, j)) {
          grid[i][j] = k;
          if (solve()) {
            return 1;
          } else if (!mustStay[i][j]) {
            grid[i][j] = 0;
          }
        }
      }
      return 0;
    }
  }
  return 1;
}

int valid(int k, int i, int j) {
  for (int z = 0; z < n; z++) {
    if (grid[z][j] == k)
      return 0;
    if (grid[i][z] == k)
      return 0;
  }
  int N = clues[0][j];
  int arrayN[n];
  int mustStayN[n];
  for (int z = 0; z < n; z++) {
    arrayN[z] = (z == i) ? k : grid[z][j];
    mustStayN[z] = arrayN[z] != 0;
  }
  if (!validVis(arrayN, mustStayN, N))
    return 0;

  int S = clues[3][j];
  int arrayS[n];
  int mustStayS[n];
  for (int z = 0; z < n; z++) {
    arrayS[z] = (z == n - 1 - i) ? k : grid[n - 1 - z][j];
    mustStayS[z] = arrayS[z] != 0;
  }
  if (!validVis(arrayS, mustStayS, S))
    return 0;

  int W = clues[1][i];
  int arrayW[n];
  int mustStayW[n];
  for (int z = 0; z < n; z++) {
    arrayW[z] = (z == j) ? k : grid[i][z];
    mustStayW[z] = arrayW[z] != 0;
  }
  if (!validVis(arrayW, mustStayW, W))
    return 0;

  int E = clues[2][i];
  int arrayE[n];
  int mustStayE[n];
  for (int z = 0; z < n; z++) {
    arrayE[z] = (z == n - 1 - j) ? k : grid[i][n - 1 - z];
    mustStayE[z] = arrayE[z] != 0;
  }
  if (!validVis(arrayE, mustStayE, E))
    return 0;
  return 1;
}

int validVis(int *array, int *mustStayD, int vis) {
  for (int i = 0; i < n; i++) {
    if (array[i] != 0)
      continue;
    for (int j = 1; j <= n; j++)
      if (notInArray(array, j)) {
        array[i] = j;
        if (validVis(array, mustStayD, vis))
          return 1;
        else if (!mustStayD[i])
          array[i] = 0;
      }
    return 0;
  }
  return vis == countVis(array);
}

int notInArray(int *array, int num) {
  for (int i = 0; i < n; i++)
    if (array[i] == num)
      return 0;
  return 1;
}

int countVis(int *array) {
  int count = 0, max = -1;
  for (int i = 0; i < n; i++)
    if (array[i] > max) {
      count++;
      max = array[i];
    }
  return count;
}

void printGrid() {
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      printf("%d", grid[i][j]);
      if (j != n - 1)
        printf(" ");
    }
    printf("\n");
  }
}
