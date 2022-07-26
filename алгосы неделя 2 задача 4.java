import java.io.*;
import java.util.Scanner;
import java.util.regex.*;

public class Main {
    static int split(int[] array, int l, int r) {
        int m = array[(l + r) / 2];
        int l_index = l;
        int r_index = r;
        int t;

        while (l_index <= r_index) {
            while (array[l_index] < m)
                l_index++;
            while (array[r_index] > m)
                r_index--;

            if (l_index <= r_index) {
                t = array[l_index];
                array[l_index] = array[r_index];
                array[r_index] = t;
                l_index++;
                r_index--;
            }
        }
        return l_index;
    }
    static void quicksort(int[] a, int l, int r, int k1, int k2, int n) {
        if (l == r || l > k2 || r < k1)
            return;
        int m = split(a, l, r);
        quicksort(a, l, m - 1, k1, k2, n);
        quicksort(a, m, r, k1, k2, n);
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
        int k1 = Integer.parseInt(sn[1]);
        int k2 = Integer.parseInt(sn[2]);
        int[] array = new int[n + 1];

        str = scan.nextLine();
        sn = pat.split(str);
        int A = Integer.parseInt(sn[0]);
        int B = Integer.parseInt(sn[1]);
        int C = Integer.parseInt(sn[2]);
        array[1] = Integer.parseInt(sn[3]);
        array[2] = Integer.parseInt(sn[4]);
        scan.close();

        for (int i = 3; i <= n; i++) {
            array[i] = A * array[i - 2] + B * array[i - 1] + C;
        }
        
        quicksort(array, 1, n, k1, k2, n);

        for (int i = k1; i <= k2; i++) {
            writer.print(array[i]);
            writer.print(" ");
        }
        writer.close();
    }
}