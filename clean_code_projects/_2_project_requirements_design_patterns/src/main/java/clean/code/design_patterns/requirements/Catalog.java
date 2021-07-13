package clean.code.design_patterns.requirements;

import java.util.ArrayList;

interface Observer {
    void update(Notification notification);
}

interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Grade grade);
}

class Notification {
    String name;

    public Notification(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Notification: " + name + "\n";
    }
}

class Catalog  implements Subject{
    public ArrayList<Course> courses;
    private static Catalog instance = new Catalog();
    public ArrayList<Observer> observers;

    private Catalog() {
        courses = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static Catalog getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "Catalog: \n" +  courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public Course getCourse(String name){
        for(Course course : courses){
            if(name.equals(course.name)){
                return course;
            }
        }
        return null;
    }
    public Grade getGrade(String name){
        for(Grade grade : getCourse(name).grades){
            if(name.equals(grade.getCourse())){
                return grade;
            }
        }
        return null;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Grade grade) {
        for(Observer observer : observers)
            if(grade.getStudent().isParent(observer))
                observer.update(new Notification("Nota: " + grade));
    }
}
