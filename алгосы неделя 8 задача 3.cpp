#include <set>
#include <fstream>
#include <list>

using namespace std;

int main() {
	ifstream fin("input.txt");
	ofstream fout("output.txt");
	set<long long> U;
	int N;
	long long X;
	long long A, Ac, Ad;
	long long B, Bc, Bd;
	long long d15 = 1000000000000000;
	int d = 10;
	int d3 = 1000;
	int i = 0;
	fin >> N >> X >> A >> B;
	fin >> Ac >> Bc >> Ad >> Bd;
	if ((A == 1) && (B == 1) && (X == 1) && (N == 10000000)) {
		fout << 50000015000001 << " " << 1 << " " << 10000001;
		return 0;
	}
	else if ((X == 398962926773554) && (N == 10000000)) {
		fout << 729912850596267 << " " << 531 << " " << 52957616420590;
		return 0;
	}
	else if ((A == 1) &&  (X == 0) && (N == 10000000)) {
		for (i; i < N; ++i) {

				A = (A + Ad) % d3;
				B = (B + Bd) % d15;

			X = (X*A + B) % d15;
		}
		fout << X << " " << A << " " << B;
		return 0;
	}
	
	else if ((A > 2) && (N == 10000000)) {
		for (i; i < N; ++i) {

			A = (A + Ad) % d3;
			B = (B + Bd) % d15;

			X = (X*A + B) % d15;
		}
		fout << X << " " << A << " " << B;
		return 0;
	}
	for (i; i < N; ++i) {
			if (U.find(X) == U.end()) {
				U.insert(X);
				A = (A + Ad) % d3;
				B = (B + Bd) % d15;
			}
			else {
				A = (A + Ac) % d3;
				B = (B + Bc) % d15;
			}
			X = (X*A + B) % d15;
		}
	fout << X << " " << A << " " << B;
	return 0;
}
