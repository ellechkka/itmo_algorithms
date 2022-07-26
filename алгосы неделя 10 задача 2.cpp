#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <climits>
#include <string>
#include <set>
#include <unordered_set>
#include <map>
#include <unordered_map>
#include <math.h>
 
using namespace std;
 
string s;
int n, m, f;
const unsigned int MAX_N = 1000000 + 50;
vector<int> z(MAX_N, 0);
ifstream in("input.txt");
ofstream out("output.txt");
 
void get_z() {
    int l = 0, r = 0;
 
    for (int i = 1; i < s.length(); ++i) {
        z[i] = min(r - i, z[i - l]);
        if (z[i] < 0)
            z[i] = 0;
        while (i + z[i] < s.length() && s[z[i]] == s[i + z[i]])
            z[i]++;
        if (i + z[i] - 1> r) {
            l = i;
            r = i + z[i];
        }
    }
}
 
 
void input() {
    in >> s;
}
 
 
void solve() {
    get_z();
}
 
 
void output() {
    for (int i = 1; i < s.length(); ++i)
        out << z[i] << " ";
}
 
int main() {
    input();
    solve();
    output();
    return 0;
}
