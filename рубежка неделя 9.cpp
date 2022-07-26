#include <fstream>
#include <vector>
using namespace std;

vector <int> func(const string& str) {
	int n = str.length();
	vector <int> pr(n);
	pr[0] = 0;
	for (int i = 1; i < n; i++) {
		int a = pr[i - 1];
		while (a > 0 && str[i] != str[a]) {
			a = pr[a - 1];
		}
		if (str[i] == str[a]) {
			a++;
		}
		pr[i] = a;
	}
	return pr;
}

vector <int> itog(const string& p, const string& t) {
	vector <int> ans;
	int psize = p.length();
	int tsize = t.length();
	vector <int> pr = func(p + "#" + t);
	for (int i = psize; i < psize + 1 + tsize; i++) {
		if (pr[i] == psize) {
			ans.push_back(i - 2 * psize + 1);
		}
	}
	return ans;
}

int main() {
	ifstream in("input.txt");
	ofstream out("output.txt");
	string p, t;
	in >> p >> t;
	vector <int> ans = itog(p, t);
	out << ans.size() << endl;
	for (int i = 0; i < ans.size(); i++) {
		out << ans[i] << " ";
	}
	return 0;
}