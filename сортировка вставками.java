import java.io.*;
import java.util.Scanner;
import java.util.regex.*;
//import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        File input_file = new File("input.txt");
        File output_file = new File("output.txt");
        Pattern pat = Pattern.compile("[\\s\\t]+");

        PrintWriter writer = new PrintWriter(output_file);
        Scanner scan = new Scanner(input_file);

        String str = scan.nextLine();
        String[] sn = pat.split(str);
        int a = Integer.parseInt(sn[0]);
        str = scan.nextLine();
        sn = pat.split(str);
        int[] arr = new int[a];
        for (int i = 0; i < a; i++) {
            arr[i] = Integer.parseInt(sn[i]);
        }
        scan.close();
//        for (int i = 0; i < a; i++) {
//            writer.print(arr[i]);
//            writer.print(" ");
//        }
//        writer.println();

//        for (int i = 1; i < a; i++) {
//            int j = i - 1;
//            while ((j > 0) & (arr[j] > arr[j + 1])) {
//                int t = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j + 1] = t;
//                j--;
//            }
//        }
        int[] index = new int[a];
        index[0] = 1;
        for (int i = 1; i < a; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && current < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
            index[i] = j + 2;
        }

        for (int i = 0; i < a; i++) {
            writer.print(index[i]);
            writer.print(" ");
        }
        writer.println();
        for (int i = 0; i < a; i++) {
            writer.print(arr[i]);
            writer.print(" ");
        }
        writer.close();
    }
}
