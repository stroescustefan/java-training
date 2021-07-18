package code._4_student_effort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Challenge_4 {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(4, 3, 7, 8, 6, 2, 1);
        zigZag(myList);
        System.out.println(myList);
    }

    public static void zigZag(List<Integer> arr) {
        boolean flag;
        int aux;

        flag = true;
        for (int i = 0; i < arr.size() - 1; i++) {
            if (flag) {
                if (arr.get(i) > arr.get(i + 1)) {
                    aux = arr.get(i);
                    arr.set(i, arr.get(i + 1));
                    arr.set(i + 1, aux);
                }
            } else {
                if (arr.get(i) < arr.get(i + 1)) {
                    aux = arr.get(i);
                    arr.set(i, arr.get(i + 1));
                    arr.set(i + 1, aux);
                }
            }
            flag = !flag;
        }
    }
}