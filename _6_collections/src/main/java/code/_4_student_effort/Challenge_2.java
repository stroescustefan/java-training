package code._4_student_effort;

import java.util.ArrayList;
import java.util.List;

public class Challenge_2 {
    public static void main(String[] args) {

        System.out.println(generatePascal(5));
    }

    public static List<List<Integer>> generatePascal(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        curr.add(1);
        curr.add(1);

        if (n == 1) {
            List<Integer> aux = new ArrayList<>();
            aux.add(1);
            result.add(aux);
            return result;
        } else {
            List<Integer> aux = new ArrayList<>();
            aux.add(1);

            List<Integer> aux2 = new ArrayList<>();
            aux2.add(1);
            aux2.add(1);

            result.add(aux);
            result.add(aux2);

            for (int i = 3; i <= n; i++) {
                List<Integer> temp = new ArrayList<>();


                for (int j = 0; j <= curr.size(); j++) {
                    if (j == 0 || j == curr.size()) {
                        temp.add(1);
                    } else {
                        int total = curr.get(j) + curr.get(j - 1);
                        temp.add(total);
                    }
                }

                result.add(temp);
                curr.clear();
                curr.addAll(temp);
            }
            return result;
        }
    }
}

