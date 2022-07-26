import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br;
    StringTokenizer in;
    PrintWriter out;
    final double eps = 0.0000000001;

    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        new Main().run(inputFile, outputFile);
    }

    public String nextToken() throws IOException {
        while (in == null || !in.hasMoreTokens()) {
            in = new StringTokenizer(br.readLine());
        }
        return in.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    public void solve() throws IOException {
        int n = nextInt();
        double A = nextDouble();
        double[] array = new double[n];
        array[0] = A;

        double B = binarySearch(array, n);
        out.print(String.format(Locale.US, "%.10f", B));
    }

    public void run(String inputFile, String outputFile) {
        try {

            br = new BufferedReader(new FileReader(inputFile));
            out = new PrintWriter(outputFile);

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    double binarySearch(double[] a, int n) {
        double l = 0, r = a[0];

        while (r - l > eps) {
            a[1] = (l + r) / 2;
            boolean flag = true;
            for (int i = 2; i < n; i++) {
                a[i] = 2 * a[i - 1] - a[i - 2] + 2;
                if (a[i] < 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                r = a[1];
            }
            else {
                l = a[1];
            }
        }
        return a[n - 1];

    }
}
