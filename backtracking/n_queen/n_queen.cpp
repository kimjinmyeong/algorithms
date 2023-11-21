#include <iostream>
#include <cmath>
using namespace std;
int board[16];
int N;
bool isEnd;
void nQueens(int row);
bool isPromising(int col);
void printNQueens();
int main(){
    int numOfCase;
    cin >> numOfCase;
    for(int c = 0; c < numOfCase; c++) {
        cin >> N;
        isEnd = false;
        for(int i = 0; i < N && isEnd == false; i++){
            board[0] = i;
            nQueens(0);
        }
    }
}

void nQueens(int row){
    if(isEnd) return;
    if(isPromising(row))
        if(row == N - 1) {
            if(isEnd == false) printNQueens();
            isEnd = true;
        }
        else {
            for (int i = 0; i < N; i++) {
                board[row + 1] = i;
                nQueens(row + 1);
            }
        }
}

bool isPromising(int row){
    bool promising = true;
    for(int i = 0; i < row && promising; i++){
        if(board[i] == board[row] || (row - i) == abs(board[i] - board[row]))
            promising = false;
    }
    return promising;
}
void printNQueens(){
    for(int i = 0; i < N; i++)
        cout << board[i] << " ";
    cout << endl;
}