package code._4_student_effort;


public class Challenge_2 {
    public static void main(String[] args) {
        Running runningShoe1 = new Running("RED", 41);
        Running runningShoe2 = new Running("RED", 41);
        Pair<Running> pairOK = new Pair<>(runningShoe1, runningShoe2);


        Running runningShoe3 = new Running("RED", 41);
        Running runningShoe4 = new Running("RED", 42);
        Pair<Running> pair1 = new Pair<>(runningShoe3, runningShoe4);
    }
}

class Pair<T extends Shoe> {
    private T first;
    private T second;

    public Pair() {
        this(null, null);
    }

    public Pair(T first, T second) {

        this.first = first;
        this.second = second;

        if (!first.getColor().equalsIgnoreCase(second.getColor())) {
            throw new ColorsMatchException("Colors do not match.");
        }
        if (first.getSize() != second.getSize()) {
            throw new SizeMatchException("Sizes do not match.");
        }
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

}

class ColorsMatchException extends RuntimeException {
    public ColorsMatchException(String message) {
        super(message);
    }
}

class SizeMatchException extends RuntimeException {
    public SizeMatchException(String message) {
        super(message);
    }
}


interface Shoe {
    String getColor();

    double getSize();
}

class Running implements Shoe {
    private String color;
    private int size;

    public Running() {
        this(null, 0);
    }

    public Running(String color, int size) {
        this.color = color;
        this.size = size;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public double getSize() {
        return size;
    }
}

class Heels implements Shoe {
    private String color;
    private double size;

    public Heels() {
        this(null, 0);
    }

    public Heels(String color, double size) {
        this.color = color;
        this.size = size;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public double getSize() {
        return size;
    }
}

class Boot implements Shoe {
    private String color;
    private double size;

    public Boot() {
        this(null, 0);
    }

    public Boot(String color, double size) {
        this.color = color;
        this.size = size;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public double getSize() {
        return size;
    }
}
