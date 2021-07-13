package clean.code.design_patterns.requirements;

public class TestingApp {
    public static void main(String[] args) {
        // testare Factory
        User studentA = UserFactory.createUser("Student", "A", "Popescu");
        User studentB = UserFactory.createUser("Student", "B", "Ionescu");
        User studentC = UserFactory.createUser("Student", "C", "Ionescu");

        User mother = UserFactory.createUser("Parent", "M_AC", "Ionescu");
        User father = UserFactory.createUser("Parent", "T_AC", "Ionescu");

        User teacher = UserFactory.createUser("Teacher", "Teacher", "Georgescu");
        User assistant = UserFactory.createUser("Assistant", "Assistant", "Popescu");


        //testare Builder + Strategy
        Course course = new Course.CourseBuilder("POO").teacher((Teacher) teacher)
                .assistant((Assistant) assistant).grade(new Grade("POO", (Student) studentA, 4d,5d))
                .grade(new Grade("POO", (Student) studentB,3d,3d)).strategy(new BestExamScore()).build();
        System.out.println("Curs: "+ course);
        System.out.println("Best Student:" + course.getBestStudent());


        //testare Singleton + Builder + Strategy
        Catalog catalog = Catalog.getInstance();
        catalog.addCourse(course);


        //testare Observer
        ((Student) studentB).setMother((Parent) mother);
        ((Student) studentB).setFather((Parent) father);
        ((Student) studentC).setMother((Parent) mother);

        catalog.addObserver((Parent) mother);
        catalog.addObserver((Parent) father);
        catalog.notifyObservers(new Grade("POO", (Student)studentB,2.5d,3d));
        catalog.notifyObservers(new Grade("POO", (Student)studentC,2.7d,4d));
        System.out.println(((Parent) mother).notifications);
        System.out.println(((Parent) father).notifications);
    }
}
