import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    private static int[] array = new int[1000000];
    private static int top = 0;

//    private static boolean isEmpty() {
//        if (top == 0)
//            return true;
//        return false;
//    }

    private static void add(int[] array, int number) throws Exception {
//        if (top == array.length) {
//            throw new Exception ("Overflow");
//        } else {
            top++;
            array[top] = number;
//        }
    }

    private static void remove(int[] array, PrintStream out) throws Exception {
//        if (isEmpty()) {
//            throw new Exception ("Underflow");
//        } else {
            out.println(array[top]);
            top--;
//        }
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("input.txt"));
        FileOutputStream fos = new FileOutputStream("output.txt");
        PrintStream out = new PrintStream(fos);

        int commandsCount = in.nextInt();

        for(int i = 0; i <= commandsCount; i++) {
            String command = new String();
            command = in.nextLine();
            if (command.startsWith("+")) {
                command = command.substring(2, command.length());
                int number = Integer.parseInt(command);
                add(array, number);
            } else if(command.startsWith("-")) {
                remove(array, out);
            }
        }
        in.close();
        out.close();
    }
}
