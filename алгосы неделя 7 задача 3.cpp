#include <iostream>
#include <vector>

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

int diff(node* t) {
    mx = 0;
    height(t->left, 1);
    int l = mx;
    mx = 0;
    height(t->right, 1);
    return l - mx;
}

node* rotateLeft(node* a) {
    node* b = a->right;
    a->right = b->left;
    b->left = a;
    return b;
}

node* rotateRight(node* a) {
    node* b = a->left;
    a->left = b->right;
    b->right = a;
    return b;
}

node* balance(node* t) {
    if(diff(t) == -2) {
        if(diff(t->right) == 1) {
            t->right = rotateRight(t->right);
        }
        return rotateLeft(t);
    }
    if(diff(t) == 2) {
        if(diff(t->left) == -1) {
            t->left = rotateLeft(t->left);
        }
        return rotateRight(t);
    }
    return t;
}

node* insert(node* t, int k) {
    if(t == nullptr) {
        node* a = new node;
        a->key = k;
        a->left = 0;
        a->right = 0;
        return a;
    }
    if(k < t->key) {
        t->left = insert(t->left, k);
    } else {
        t->right = insert(t->right, k);
    }
    return balance(t);
}

vector<input> ans;

int print(node* t) {
    input o;
    o.k = t->key;
    o.l = 0;
    o.r = 0;
    ans.push_back(o);
    int r = ans.size();
    if(t->left != nullptr) {
        int a = print(t->left);
        ans[r - 1].l = a;
    }
    if(t->right != nullptr) {
        int a = print(t->right);
        ans[r - 1].r = a;
    }
    return r;
}

int main() {

    ios::sync_with_stdio(false);

    freopen("input.txt", "rt", stdin);
    freopen("output.txt", "wt", stdout);

    int n, k;
    cin >> n;

    input* in = new input[n];

    for(int i = 0; i < n; i++) {
        cin >> in[i].k >> in[i].l >> in[i].r;
    }

    cin >> k;

    if(n > 0) {
        root = init(in, 0);
    }

    root = insert(root, k);

    print(root);

    cout << ans.size() << endl;

    for(auto it : ans) {
        cout << it.k << " " << it.l << " " << it.r << endl;
    }

    return 0;
}