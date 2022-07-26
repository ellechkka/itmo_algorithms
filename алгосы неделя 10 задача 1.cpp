#include <fstream>
#include <string>
#include <vector>

using namespace std;

vector<int> Prefix(string &T)
{
	vector<int> res;
	res.push_back(0);
	for (int i = 1; i < T.length(); ++i)
	{
		int k = res[i - 1];
		while (k > 0 && T[i] != T[k])
			k = res[k - 1];
		if (T[i] == T[k])
			k++;
		res.push_back(k);
	}
	return res;
}
int main()
{
	ifstream fin("input.txt");
	ofstream fout("output.txt");
	string S;
	fin >> S;
	vector<int> res = Prefix(S);
	for (int i = 0; i < res.size(); ++i)
		fout << res[i] << " ";
	return 0;
}
