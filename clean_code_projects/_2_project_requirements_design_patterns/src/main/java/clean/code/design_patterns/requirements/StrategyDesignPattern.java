package clean.code.design_patterns.requirements;

import java.util.Collection;

interface Strategy {
    Student getBestStudent(Collection<Grade> grades);
}

class BestPartialScore implements Strategy {
    @Override
    public Student getBestStudent(Collection<Grade> grades) {
        Double max = 0d;
        Student best_choice = null;

        for(Grade grade : grades)
            if(grade.getPartialScore() > max) {
                max = grade.getPartialScore();
                best_choice = grade.getStudent();
            }

        return best_choice;
    }
}

class BestExamScore implements Strategy {
    @Override
    public Student getBestStudent(Collection<Grade> grades) {
        Double max = 0d;
        Student best_choice = null;

        for(Grade grade : grades)
            if(grade.getExamScore() > max) {
                max = grade.getExamScore();
                best_choice = grade.getStudent();
            }

        return best_choice;

    }
}

class BestTotalScore implements Strategy {
    @Override
    public Student getBestStudent(Collection<Grade> grades) {
        Double max = 0d;
        Student best_choice = null;

        for(Grade grade : grades)
            if(grade.getTotal() > max) {
                max = grade.getTotal();
                best_choice = grade.getStudent();
            }

        return best_choice;
    }
}