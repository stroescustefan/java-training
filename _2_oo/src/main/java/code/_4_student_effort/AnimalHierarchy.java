package code._4_student_effort;

public class AnimalHierarchy {
    public static void main(String[] args) {
        Fish d = new Fish();
        Cat c = new Cat("Fluffy");
        Animal a = new Fish();
        Animal e = new Spider();
        Pet p = new Cat("Bastan");

        a.walk();
        c.eat();
        d.walk();
        e.walk();
        ((Cat) p).eat();
    }
}

interface Pet {
    String getName();

    void setName(String name);

    void play();
}


abstract class Animal {
    protected int legs;

    protected Animal(int legs) {
        this.legs = legs;
    }

    protected Animal() {
        this(0);
    }

    public abstract void eat();

    public void walk() {
        System.out.println("Animal with " + legs + " legs is walking.");
    }
}

class Cat extends Animal implements Pet {
    private String name;

    public Cat(String name) {
        super(4);
        this.name = name;
    }

    public Cat() {
        this("");
    }

    @Override
    public void eat() {
        System.out.println("Cat " + name + " is eating.");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println("Cat " + name + " is playing.");
    }
}

class Spider extends Animal {
    public Spider() {
        super(8);
    }

    @Override
    public void eat() {
        System.out.println("Spider is eating.");
    }
}

class Fish extends Animal implements Pet {
    private String name;

    public Fish() {
        super(0);
    }

    @Override
    public void eat() {
        System.out.println("Fish is eating.");
    }

    @Override
    public void walk() {
        System.out.println("Fish can't walk.");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println("Fish is playing.");
    }
}
