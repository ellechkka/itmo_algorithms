#include <iostream>

using namespace std;

struct node {
    node* left = nullptr;
    node* parent = nullptr;
    node* right = nullptr;
    int key;
};

node* root = nullptr;

int mx = 0;

struct input {
    int k = 0;
    int l = 0;
    int r = 0;
};

node* init(input* in, int i) {
    node* n = new node;
    n->key = in[i].k;
    if(in[i].l != 0) {
        n->left = init(in, in[i].l - 1);
    }
    if(in[i].r != 0) {
        n->right = init(in, in[i].r - 1);
    }
    return n;
}

void height(node* t, int h) {
    if(t == nullptr) return;
    if(h > mx) mx = h;
    if(t->left != nullptr) {
        height(t->left, h + 1);
    }
    if(t->right != nullptr) {
        height(t->right, h + 1);
    }
}

int main() {

    ios::sync_with_stdio(false);

    freopen("input.txt", "rt", stdin);
    freopen("output.txt", "wt", stdout);

    int n;
    cin >> n;

    if(n == 0) {
        cout << 0;
        return 0;
    }

    input* in = new input[n];

    for(int i = 0; i < n; i++) {
        cin >> in[i].k >> in[i].l >> in[i].r;
    }

    root = init(in, 0);
    height(root, 1);
    cout << mx;

    return 0;
}
