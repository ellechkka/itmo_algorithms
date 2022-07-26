#include <fstream>
using namespace std;
int main() {
    ifstream in("input.txt");
    ofstream out("output.txt");
    int number;
    int length;
    int phases;
    in >> number >> length >> phases;
    int* ind = new int[number];
    string* strings = new std::string[length];
    for (int i = 0; i < number; i++) {
        ind[i] = i;
    }
    for (int i = 0; i < length; i++) {
        in >> strings[i];
    }
    for (int i = 0; i < phases; i++) {
        unsigned letters[26] = { 0 };
        int* newIndex = new int[number];
        for (int j = 0; j < number; j++) {
            letters[strings[length - i - 1][j] - 'a']++;
        }
        for (char j = 0; j < 25; j++) {
            letters[j + 1] += letters[j];
        }
        for (char j = 25; j > 0; j--) {
            letters[j] = letters[j - 1];
        }
        letters[0] = 0;
        for (int j = 0; j < number; j++) {
            newIndex[letters[strings[length - i - 1][ind[j]] - 'a']++] = ind[j];
        }
        delete[] ind;
        ind = newIndex;
    }
    for (int i = 0; i < number; i++) {
        out << ind[i] + 1 << ' ';
    }
}
