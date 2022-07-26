import java.io.*;
import java.util.Scanner;
import java.util.regex.*;


public class Main {

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

        if (n <= 47) {
            sort_v(n, arr, writer);
        }
        else {
            int low = 0;
            int high = n - 1;

            quickSort(arr, low, high, writer);
        }
//        for (int i = 0; i < n; i++) {
//            writer.print(index[i]);
//            writer.print(" ");
//        }
//        writer.println();

        writer.println("No more swaps needed.");
        print_array(arr, n, writer);

//        writer.print(index[0]);
//        writer.print(" ");
//        writer.print(index[(n - 1) / 2]);
//        writer.print(" ");
//        writer.print(index[n - 1]);
        writer.close();
    }
    public static void print_array(int[] arr, int n, PrintWriter writer) {
        for (int i = 0; i < n; i++) {
            writer.print(arr[i]);
            writer.print(" ");
        }
    }

    public static void sort_v(int n, int[] arr, PrintWriter writer) {
        for (int i = 1; i < n; i++) {
            int current = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > current) {
                arr[j] = arr[j - 1];
                writer.print("Swap elements at indices " +j+ " and " +(j + 1)+ ".\n");
                j--;
            }
            arr[j] = current;
        }
    }

    public static void quickSort(int[] array, int first, int last, PrintWriter writer) {
        int middle = array[first + (last - first) / 2];

        int i = first;
        int j = last;
        while (i <= j) {
            while (array[i] < middle) {
                i++;
            }

            while (array[j] > middle) {
                j--;
            }

            if (i <= j) {//меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i != j) {
                    writer.print("Swap elements at indices " + (i + 1) + " and " + (j + 1) + ".\n");
                }
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (first < j)
            quickSort(array, first, j, writer);

        if (last > i)
            quickSort(array, i, last, writer);
    }
}
