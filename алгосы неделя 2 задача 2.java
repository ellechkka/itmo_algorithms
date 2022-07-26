import java.io.*;
import java.util.Scanner;
import java.util.regex.*;
import java.util.Arrays;


public class Main {
    public static long merge(int[] arr, int lo, int mid, int hi) {
        int lo_size = mid - lo + 1;
        int hi_size = hi - mid;
        int[] lo_arr = new int[lo_size];
        int[] hi_arr = new int[hi_size];

        for (int i = 0; i < lo_size; i++)
            lo_arr[i] = arr[lo + i];
        for(int j = 0; j < hi_size; j++)
            hi_arr[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = lo;
        long swaps = 0;

        while ((i < lo_size) && (j < hi_size)) {
            if (lo_arr[i] <= hi_arr[j])
                arr[k++] = lo_arr[i++];
            else {
                arr[k++] = hi_arr[j++];
                swaps += (mid + 1) - (lo + i);
            }
        }

        while (i < lo_size)
            arr[k++] = lo_arr[i++];
        while (j < hi_size)
            arr[k++] = hi_arr[j++];

        return swaps;
    }

    public static long merge_sort(int[] arr, int lo, int hi) {
        long count = 0;
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            count += merge_sort(arr, lo, mid);
            count += merge_sort(arr, mid + 1, hi);

            count += merge(arr, lo, mid, hi);
        }
        return count;
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

        long c;
        c = merge_sort(arr, 0, arr.length - 1);
        writer.println(c);
        writer.close();
    }
}
