package code._4_student_effort;

import com.sun.source.tree.Tree;

import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Challenge_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text: ");
        TreeMap<String, Integer> result = new TreeMap<>(Collections.reverseOrder());

        String line = scanner.nextLine();
        while (!line.equalsIgnoreCase("exit")) {
            String words[] = line.split("\\s+");

            for (String str : words) {
                if (result.containsKey(str)) {
                    result.put(str, result.get(str) + 1);
                } else {
                    result.put(str, 1);
                }
            }
            line = scanner.nextLine();
        }

        int limit = 10;
        int cnt = 0;
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            if (cnt < limit) {
                if (entry.getValue() == 1) {
                    System.out.println("Word: " + "\"" + entry.getKey() + "\"" + ", appears " + entry.getValue() + " time.");
                } else {
                    System.out.println("Word " + "\"" + entry.getKey() + "\"" + ", appears " + entry.getValue() + " times.");
                }
                cnt++;
            } else {
                break;
            }
        }
    }
}
