package code._4_student_effort;

import java.util.ArrayList;
import java.util.List;

public class Challenge_1 {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(3);
        myList.add(6);
        myList.add(4);
        myList.add(5);
        myList.add(3);
        myList.add(2);
        System.out.println(countLeaders(myList));

    }

    public static int countLeaders(List<Integer> myList) {
        int max, cnt;

        for (int i = 0; i < myList.size() / 2; i++) {
            Integer temp = myList.get(i);
            myList.set(i, myList.get(myList.size() - i - 1));
            myList.set(myList.size() - i - 1, temp);
        }

        max = Integer.MIN_VALUE;
        cnt = 0;
        for (Integer i : myList) {
            if (i > max) {
                max = i ;
                cnt++;
            }
        }

        return cnt;
    }
}
