import java.io.*;
import java.util.Scanner;
import java.util.regex.*;

public class Main {
    static boolean check(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            if (a[i] < a[i - 1])
                return true;
        }
        return false;
    }

    static int split(int[] array, int l, int r, int k) {
        int x = array[l];
        int l_index = l;
        int r_index = r;
        int t;

        while (l_index <= r_index) {
            while (array[l_index] < x)
                l_index += k;
            while (array[r_index] > x)
                r_index -= k;

            if (l_index <= r_index) {
                t = array[l_index];
                array[l_index] = array[r_index];
                array[r_index] = t;
                l_index += k;
                r_index -= k;
            }
        }
        return l_index;
    }

    static void quicksort(int[] array, int l, int r, int k) {
        if (l == r)
            return;
        int m = split(array, l, r, k);

        quicksort(array, l, m - k, k);
        quicksort(array, m, r, k);
    }

    static void pugalo(int[] array, int n, int k) {
        if (k >= n)
            return;
        int r = ((int)(n - 1) / k) * k;
        for (int i = 0; i < k; i++) {
            quicksort(array, i, r, k);
            r++;
            if (r > n - 1)
                r -= k;
        }
    }

    public static void main(String[] args) throws IOException {
        File input_file = new File("input.txt");
        File output_file = new File("output.txt");
        Pattern pat = Pattern.compile("[\\s\\t]+");
        PrintWriter writer = new PrintWriter(output_file);

        Scanner scan = new Scanner(input_file);

        String str = scan.nextLine();
        String[] sn = pat.split(str);
        int n = Integer.parseInt(sn[0]);
        int k = Integer.parseInt(sn[1]);

        str = scan.nextLine();
        sn = pat.split(str);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sn[i]);
        }
        scan.close();
        pugalo(arr, n, k);
        if (check(arr, n))
            writer.print("NO");
        else
            writer.print("YES");
        writer.close();
    }
}