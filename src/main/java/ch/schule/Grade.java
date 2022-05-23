package ch.schule;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Grade implements GradeManagement, Average {
    private List<Double> gradeList;
    private int index = 0;

    public Grade() {
        this.gradeList = new ArrayList<>();
    }

    @Override
    public double computeMean() {
        //compute mean
        AtomicReference<Double> sum = new AtomicReference<>((double) 0);
        gradeList.forEach(grade -> sum.updateAndGet(v -> v + grade));
        return sum.get() / gradeList.size();
    }

    @Override
    public boolean addGrade(double grade) {
        if (grade >= 1 && grade <= 6) {
            gradeList.add(grade);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double showGradeNumber(int index) {
        return gradeList.get(index);
    }

    @Override
    public int getGradeAmount() {
        return gradeList.size();
    }

    @Override
    public List<Double> getGrade() {
        return gradeList;
    }
}
