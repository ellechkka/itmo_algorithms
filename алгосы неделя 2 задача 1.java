import java.io.*;
import java.util.Scanner;
import java.util.regex.*;
import java.util.Arrays;


public class Main {
    public static void print_array(int[] arr, PrintWriter writer) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            writer.print(arr[i]);
            writer.print(" ");
        }
    }

    public static void merge(int[] arr, int lo, int mid, int hi, PrintWriter writer) {
        int lo_size = mid - lo + 1;
        int hi_size = hi - mid;
        int[] lo_arr = new int[lo_size];
        int[] hi_arr = new int[hi_size];

        for (int i = 0; i < lo_size; i++)
            lo_arr[i] = arr[lo + i];
        for(int j = 0; j < hi_size; j++)
            hi_arr[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = lo;

        while (i < lo_size && j < hi_size) {
             if (lo_arr[i] <= hi_arr[j])
                 arr[k++] = lo_arr[i++];
             else
                 arr[k++] = hi_arr[j++];
        }

        while (i < lo_size)
            arr[k++] = lo_arr[i++];
        while (j < hi_size)
            arr[k++] = hi_arr[j++];

        writer.print(lo + 1);
        writer.print(" ");
        writer.print(hi + 1);
        writer.print(" ");
        writer.print(arr[lo]);
        writer.print(" ");
        writer.print(arr[hi]);
        writer.print(" ");
        writer.println();
    }

    public static void merge_sort(int[] arr, int lo, int hi, PrintWriter writer) {
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        merge_sort(arr, lo, mid, writer);
        merge_sort(arr, mid + 1, hi, writer);

        merge(arr, lo, mid, hi, writer);
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

        str = scan.nextLine();
        sn = pat.split(str);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sn[i]);
        }
        scan.close();
        merge_sort(arr, 0, arr.length - 1, writer);

        writer.println();
        print_array(arr, writer);
        writer.close();
    }
}
