import java.io.*;
import java.util.Scanner;
import java.util.regex.*;
import java.math.*;

public class Sum {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File input_file = new File("input.txt");
        File output_file = new File("output.txt");
        PrintWriter writer = new PrintWriter(output_file);
        Scanner scan = new Scanner(input_file);
        Pattern pat = Pattern.compile("[\\s\\t]+");
        String str = scan.nextLine();
        String [] sn = pat.split(str);
        long a = Long.parseLong(sn[0]);
        long b = Long.parseLong(sn[1]);
        long sum = a + b * b;
        scan.close();
        writer.println(sum);
        writer.close();
    }
}

