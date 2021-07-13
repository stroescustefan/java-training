package clean.code.design_patterns.requirements;

import java.util.ArrayList;
import java.util.Collections;

class Course {
    public String name;
    public Teacher teacher;
    public ArrayList<Assistant> assistants;
    public ArrayList<Grade> grades;
    public Strategy strategy;

    private Course(CourseBuilder builder) {
        this.name = builder.name;
        this.teacher = builder.teacher;
        this.assistants = builder.assistants;
        this.grades = builder.grades;
        this.strategy = builder.strategy;
    }

    @Override
    public String toString() {
        return "Course: " + name + '\'';

    }

    public Student getBestStudent() {
        return strategy.getBestStudent(grades);
    }

    public static class CourseBuilder {
        private String name;
        private Teacher teacher;
        private ArrayList<Assistant> assistants;
        private ArrayList<Grade> grades;
        private Strategy strategy;


        public CourseBuilder(String name) {
            assistants = new ArrayList<>();
            grades = new ArrayList<>();
            this.name = name;
        }

        public CourseBuilder teacher(Teacher teacher) {
            this.teacher = teacher;
            return this;
        }

        public CourseBuilder assistant(Assistant assistant) {
            assistants.add(assistant);
            return this;
        }

        public CourseBuilder grade(Grade grade) {
            this.grades.add(grade);
            Collections.sort(grades);
            return this;
        }

        public CourseBuilder strategy(Strategy strategy) {
            this.strategy = strategy;
            return this;
        }

        public Course build() {
            return new Course(this);
        }
    }
}