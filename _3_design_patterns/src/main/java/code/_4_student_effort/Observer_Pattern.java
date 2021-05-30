package code._4_student_effort;

import java.util.ArrayList;

public class Observer_Pattern {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        Learner s01 = new Learner("Popescu");
        Learner s02 = new Learner("Ionescu");
        Learner s03 = new Learner("Dragomirescu");

        s01.listenTo(teacher);
        s02.listenTo(teacher);
        s03.listenTo(teacher);

        String[] javaTopics = new String[]{
                "basics",
                "oo",
                "design patterns"
        };
        for (int i = 0; i < javaTopics.length; i++) {
            teacher.teach(javaTopics[i]);
        }
    }
}

interface ObservedSubject {
    void register(Observer obj);

    void unregister(Observer obj);

    void notifyObservers(String message);
}

interface Observer {
    void update(String message);
}

class Learner implements Observer {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Learner(String name) {
        this.name = name;
    }

    public void listenTo(Teacher teacher) {
        teacher.register(this);
    }

    @Override
    public void update(String message) {
        System.out.println("Student " + name + " learned about " + message + ".");
    }
}

class Teacher implements ObservedSubject {
    private ArrayList<Observer> observers;

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }

    public Teacher() {
        observers = new ArrayList<>();
    }

    @Override
    public void register(Observer obj) {
        observers.add(obj);
    }

    @Override
    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer obs : observers) {
            obs.update(message);
        }
    }

    public void teach(String message) {
        for (Observer obs : observers) {
            obs.update(message);
        }
    }
}