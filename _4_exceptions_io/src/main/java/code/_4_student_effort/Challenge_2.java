package code._4_student_effort;

import java.io.FileNotFoundException;

public class Challenge_2 {
    public static void main(String[] args) throws FileNotFoundException {
        MyScanner scanner = new MyScanner("_4_exceptions_io\\_test_files\\in\\message.txt");
        StringBuilder decoding = new StringBuilder();

        String line = scanner.nextLine();
        while (line != null) {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) >= 65 && line.charAt(i) <= 90) {
                    if (line.charAt(i) == 'X') {
                        decoding.append(' ');
                    } else {
                        decoding.append(line.charAt(i));
                    }
                }
            }
            line = scanner.nextLine();
        }

        System.out.println(decoding);
    }
}
