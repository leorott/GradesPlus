package ch.schule;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Grade implements GradeManagement, Average {
    // attribute
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

    /**
     * Implementation der Schnittstelle Notenverwaltung.
     * F�gt den �bergebenen Notenwert dem Array zu. Der Notenwert
     * (1..6) wird nicht �berwacht!e
     * Es k�nnen maximal SIZE Werte eingef�gt werden. Kponnte der Wert
     * zugef�gt weredn, liefert die Methdeo den Wert true, sonst den
     * Wert false.
     *
     * @param die Note wird �bergeben
     * @return gibt zur�ck ob die Note eingef�gt wurde
     */
    @Override
    public boolean addGrade(double grade) {
		if(grade >= 1 && grade <= 6) {
			gradeList.add(grade);
			return true;
		}else {
			return false;
		}
    }

    /**
     * Implementation der Schnittstelle Notenverwaltung.
     * Die Methode liefert die durch index markierte Note.
     * Liegt der index ausserhalb des erlaubten Bereichs,
     * gibt die Methode den Wert 0 zur�ck.
     *
     * @param Index der Note die zur�ckgegeben wird
     * @return Note die zur�ckgegeben wird
     */
    @Override
    public double showGradeNumber(int index) {
        return gradeList.get(index);
    }

    /**
     * Implementation der Schnittstelle Notenverwaltung.
     * Liefert den aktuellen Wert des Index-Z�hlers.
     *
     * @return anzahl der noten wird zur�ckgegeben
     */
    @Override
    public int getGradeAmount() {
        return gradeList.size();
    }

    /**
     * gib alle noten zurück
     *
     * @return
     */

    @Override
    public List<Double> getGrade() {
        return gradeList;
    }


}