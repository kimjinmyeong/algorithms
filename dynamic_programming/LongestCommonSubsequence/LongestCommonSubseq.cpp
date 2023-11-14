#include <iostream>
#include <string>
using namespace std;
#define MAX(a,b) ((a)>(b)?(a):(b))
#define  MAX_LENGTH 101
void printLCS(string s, string t, int m, int n);
int lengthLCS(string s1, string s2, int m, int n);
int L[MAX_LENGTH][MAX_LENGTH], S[MAX_LENGTH][MAX_LENGTH];
int main()
{
    int numOfCase;
    cin >> numOfCase;
    string s1, s2;
    int m, n;
    for(int i = 0; i < numOfCase; i++){
        cin >> s1;
        cin >> s2;
        m = s1.length();
        n = s2.length();
        // base case
        for(int t = 0; t <= m; t++)
            for (int j = 0; j <= n; j++) {
                L[t][j] = 0;
                S[t][j] = -1;
            }
        lengthLCS(s1, s2, s1.length(), s2.length());
        cout << endl;
    }
    return 0;
}

int lengthLCS(string s1, string s2, int m, int n){
    for(int r = 1; r <= m; r++)
        for(int c = 1; c <= n; c++){
            if(s1[r - 1] == s2[c - 1]){
                L[r][c] = L[r - 1][c - 1] + 1;
                S[r][c] = 0;
            }
            else{
                int a = L[r][c - 1];
                int b = L[r - 1][c];
                L[r][c] = MAX(a, b);
                if(L[r][c] == L[r][c - 1])
                    S[r][c] = 1;
                else
                    S[r][c] = 2;
            }
        }
    cout << L[m][n] << " ";
    printLCS(s1, s2, m, n);
}

void printLCS(string s, string t, int m, int n) {
    if(m==0 || n==0)
        return;
    if(S[m][n] == 0) {
        printLCS(s, t, m - 1, n - 1);
        printf("%c", s[m - 1]); }
    else if(S[m][n] == 1)
        printLCS(s, t, m, n - 1);
    else if(S[m][n] == 2)
        printLCS(s, t, m - 1, n);
}
