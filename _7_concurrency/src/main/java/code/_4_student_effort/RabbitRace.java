package code._4_student_effort;

public class RabbitRace {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread rabbit;

            if (i % 2 == 0) {
                rabbit = RabbitRace.createThread(i);
            } else {
                rabbit = RabbitRace.createRunnable(i);
            }

            rabbit.start();
        }
    }

    public static Thread createThread(int i) {
        return new RabbitThread(i);
    }

    public static Thread createRunnable(int i) {
        RabbitRunnable runnable = new RabbitRunnable(i);
        return new Thread(runnable);
    }
}

class RabbitThread extends Thread {
    private int nr;

    public RabbitThread(int nr) {
        this.nr = nr;
    }

    @Override
    public void run() {
        System.out.printf("Rabbit %s is running \n", nr);
    }
}

class RabbitRunnable implements Runnable {
    private int nr;

    public RabbitRunnable(int nr) {
        this.nr = nr;
    }

    @Override
    public void run() {
        System.out.printf("Rabbit %s is running \n", nr);
    }
}
