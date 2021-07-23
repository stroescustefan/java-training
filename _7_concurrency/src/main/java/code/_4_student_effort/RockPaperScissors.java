package code._4_student_effort;

import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) throws InterruptedException {
        Player p1 = new Player();
        Player p2 = new Player();

        p1.start();
        p2.start();

        p1.join();
        p2.join();

        displayWinner(p1, p2);


    }

    static void displayWinner(Player p1, Player p2) {
        String o1 = p1.getObject();
        String o2 = p2.getObject();

        if (o1.equalsIgnoreCase(o2)) {
            System.out.println(o1 + " vs " + o2 + " => EQUALITY");
        } else if (
                o1.equalsIgnoreCase("paper") && o2.equalsIgnoreCase("rock") ||
                        o1.equalsIgnoreCase("rock") && o2.equalsIgnoreCase("scissors") ||
                        o1.equalsIgnoreCase("scissors") && o2.equalsIgnoreCase("paper")
        ) {
            System.out.println(o1 + " vs " + o2 + " => P1 WINS");
        } else {
            System.out.println(o1 + " vs " + o2 + " => P2 WINS");
        }
    }
}

class Player extends Thread {
    private String object;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public void run() {
        Random random = new Random();

        int randVal = random.nextInt(3);

        if (randVal == 0) {
            object = "Rock";
        } else if (randVal == 1) {
            object = "Paper";
        } else {
            object = "Scissors";
        }
    }
}
