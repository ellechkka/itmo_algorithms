import java.io.*;
import java.util.Scanner;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        File output_file = new File("output.txt");
        PrintWriter writer = new PrintWriter(output_file);
        Pattern pat = Pattern.compile("[\\s\\t]+");
        String str = scan.nextLine();
        String[] sn = pat.split(str);

        int n = Integer.parseInt(sn[0]);
        int[] a = new int[n];
        int tail = 0;
        int head = 0;

        for(int i = 1; i <= n; i++) {
            str = scan.nextLine();
            sn = pat.split(str);
            char command;
            int number;
            command = sn[0].charAt(0);

            if (command == 43) {
                number = Integer.parseInt(sn[1]);
                tail++;
                a[tail - 1] = number;
            }
            else if(command == 45) {
                if (head != tail) {
                    writer.println(a[head]);
                    head++;
                }
            }
        }
        scan.close();
        writer.close();
    }
}
