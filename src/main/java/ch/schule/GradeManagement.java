package ch.schule;

import java.util.List;

public interface GradeManagement {
    final int SIZE = 10;

    public boolean addGrade(double grade);

    public double showGradeNumber(int index);

    public int getGradeAmount();

    public List<Double> getGrade();
}
