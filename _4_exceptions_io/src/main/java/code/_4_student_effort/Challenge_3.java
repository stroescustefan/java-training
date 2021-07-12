package code._4_student_effort;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Challenge_3 {
    private static final String OUTPUT_FILE = "_4_exceptions_io\\_test_files\\out\\myanagram.txt";

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> result = new ArrayList<>();
        String givenWord = "listen";
        MyScanner scanner = new MyScanner("_4_exceptions_io\\_test_files\\in\\big_list.txt");

        String sortedWord = sortString(givenWord);
        String line = scanner.nextLine();
        while (line != null) {
            if (sortString(line).equals(sortedWord)) {
                result.add(line);
            }
            line = scanner.nextLine();
        }
        writeOutput(result);
    }

    public static String sortString(String inputString) {
        char tempArray[] = inputString.toCharArray();

        Arrays.sort(tempArray);

        return new String(tempArray);
    }

    public static void writeOutput(ArrayList<String> anagrams) {
        try {
            PrintWriter pw = new PrintWriter(new File(OUTPUT_FILE));
            for (String anagram : anagrams) {
                pw.println(anagram);
            }
            pw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
