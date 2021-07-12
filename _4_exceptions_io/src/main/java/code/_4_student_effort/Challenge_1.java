package code._4_student_effort;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class Challenge_1 {
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, String> entrys = new HashMap<>();
        ArrayList<String> persons = new ArrayList<>();
        persons.add("Abbey");
        persons.add("Abdul");

        MyScanner scanner = new MyScanner("_4_exceptions_io\\_test_files\\in\\phonebook.txt");
        String line = scanner.nextLine();
        while (line != null ) {
            String[] content = line.split("\\s+");
            if (!entrys.containsKey(content[0])) {
                entrys.put(content[0], content[1]);
            } else {
                entrys.replace(content[0], content[1]);
            }
            line = scanner.nextLine();
        }

        for (String name : persons) {
            if (entrys.containsKey(name)) {
                System.out.print(entrys.get(name) + " ");
            }
        }
    }
}