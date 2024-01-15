#include <iostream>
#include <vector>

using namespace std;

bool solve(vector<vector<int>>& board, vector<vector<bool>>& mustStay);

bool valid(int k, const vector<vector<int>>& board, int i, int j);
bool validRow(int k, const vector<vector<int>>& board, int row);
bool validCol(int k, const vector<vector<int>>& board, int col);
bool validSquare(int k, const vector<vector<int>>& board, int row, int col);

void printBoard(const vector<vector<int>>& board);

int main() {
    vector<vector<int>> board(9, vector<int>(9));
    vector<vector<bool>> mustStay(9, vector<bool>(9));

    for (int i = 0; i < 9; i++) {
        string line;
        getline(cin, line);
        for (int j = 0; j < 9; j++) {
            board[i][j] = line[j] - '0';
            mustStay[i][j] = board[i][j] != 0;
        }
    }

    solve(board, mustStay);
    printBoard(board);

    return 0;
}

bool solve(vector<vector<int>>& board, vector<vector<bool>>& mustStay) {
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if (board[i][j] != 0)
                continue;
            for (int k = 1; k <= 9; k++) {
                if (valid(k, board, i, j)) {
                    board[i][j] = k;
                    if (solve(board, mustStay))
                        return true;
                    else if (!mustStay[i][j])
                        board[i][j] = 0;
                }
            }
            return false;
        }
    }
    return true;
}

bool valid(int k, const vector<vector<int>>& board, int i, int j) {
    return validRow(k, board, i) && validCol(k, board, j) && validSquare(k, board, i, j);
}

bool validRow(int k, const vector<vector<int>>& board, int row) {
    for (int i = 0; i < 9; i++)
        if (board[row][i] == k)
            return false;
    return true;
}

bool validCol(int k, const vector<vector<int>>& board, int col) {
    for (int i = 0; i < 9; i++) {
        if (board[i][col] == k)
            return false;
    }
    return true;
}

bool validSquare(int k, const vector<vector<int>>& board, int row, int col) {
    for (int i = 0; i < 3; i++)
        for (int j = 0; j < 3; j++)
            if (board[row / 3 * 3 + i][col / 3 * 3 + j] == k)
                return false;
    return true;
}

void printBoard(const vector<vector<int>>& board) {
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++)
            cout << board[i][j];
        cout << endl;
    }
}
