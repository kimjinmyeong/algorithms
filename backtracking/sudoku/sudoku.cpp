#include <iostream>
using namespace std;
int board[4][4];
void sudoku(int row, int col);
bool checkSudoku(int row, int col, int val);
void printSudoku();
int main(){
    int numOfCase;
    cin >> numOfCase;
    for(int c = 0; c < numOfCase; c++) {
        for(int i = 0; i < 4; i++)
            for(int j = 0; j < 4; j++)
                cin >> board[i][j];
        sudoku(0, 0);
        printSudoku();
    }
}

void sudoku(int row, int col){
    if (col == 4) {
        row++;
        col = 0;
    }
    if (board[row][col] != 0)
        return sudoku(row, col + 1);

    for(int val = 1; val <= 4; val++){
        if(checkSudoku(row, col, val)) {
            board[row][col] = val;
            sudoku(row, col + 1);
        }
    }
}

bool checkSudoku(int row, int col, int val){
    for(int i = 0; i < 4; i++){
        if(board[row][i] == val) {
            return false;
        }
    }
    for(int j = 0; j < 4; j++)
        if(board[j][col] == val) {
            return false;
        }

    int startRow = row - row % 2,
            startCol = col - col % 2;
    for(int r = 0; r < 2; r++)
        for(int c = 0; c < 2; c++)
            if(board[r + startRow][c + startCol] == val) {
                return false;
            }
    return true;
}

void printSudoku(){
    for(int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++)
            cout << board[i][j] << " ";
        cout << endl;
    }
}