import java.io.*;

public class Main {
    public static int binSearch(int[] a, int x) {
        int l = -1;
        int r = a.length;
        while (r - l > 1) {
            int m = (r - l) / 2 + l;
            if (a[m] >= x) {
                r = m;
            } else {
                l = m;
            }
        }
        return r;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(new File("input.txt")));
        BufferedWriter out = new BufferedWriter(new FileWriter(new File("output.txt")));
        int n = Integer.parseInt(in.readLine());
        int[] a = new int[n];
        String[] s = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        int m = Integer.parseInt(in.readLine());
        s = in.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int t = Integer.parseInt(s[i]);
            int ans1 = binSearch(a, t);
            if (ans1 < a.length && t == a[ans1]) {
                int ans2 = binSearch(a, t + 1);
                out.write((ans1 + 1) + " " + ans2);
                out.newLine();
            } else {
                out.write("-1 -1");
                out.newLine();
            }
        }
        in.close();
        out.close();
    }

}
