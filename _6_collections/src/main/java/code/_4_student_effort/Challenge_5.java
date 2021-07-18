package code._4_student_effort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Challenge_5 {
    public static void main(String[] args) {
        List<Integer> first = Arrays.asList(1, 5, 6);
        List<Integer> second = Arrays.asList(2, 3, 4);
        System.out.println(merge(first, second));
    }

    public static List<Integer> merge(List<Integer> first, List<Integer> second) {

        if (first.size() == 0) {
            return second;
        } else if (second.size() == 0) {
            return first;
        } else {
            List<Integer> result = new ArrayList<>();
            int i, j;

            i = j = 0;
            while (i < first.size() && j < second.size()) {
                if (first.get(i) < second.get(j)) {
                    result.add(first.get(i));
                    i++;
                } else {
                    result.add(second.get(j));
                    j++;
                }
            }

            if (i < first.size()) {
                while (i < first.size()) {
                    result.add(first.get(i));
                    i++;
                }
            }

            if (j < second.size()) {
                while (j < second.size()) {
                    result.add(second.get(j));
                    j++;
                }
            }
            return result;
        }
    }
}
