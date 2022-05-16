package ch.schule;

import java.util.List;

/**
*	Schnittstelle Notenverwaltung.
*	Die Schnittstelle deklariert alle Methden die nötig sind,
*	um Datenwert, welche im GUI eingegeben werden, der Daten-
*	verarbeitungsklasse zu übergeben.
*/
public interface GradeManagement{
	final int SIZE = 10;

	/**
	 * Implementation der Schnittstelle Notenverwaltung.
	 * F�gt den �bergebenen Notenwert dem Array zu. Der Notenwert
	 * (1..6) wird nicht �berwacht!
	 * Es k�nnen maximal SIZE Werte eingef�gt werden. Kponnte der Wert
	 * zugef�gt weredn, liefert die Methdeo den Wert true, sonst den
	 * Wert false.
	 * @param die Note wird �bergeben
	 * @return gibt zur�ck ob die Note eingef�gt wurde
	 *
	*/
	public boolean addGrade(double grade);

	/**
	 * Implementation der Schnittstelle Notenverwaltung.
	 * Die Methode liefert die durch index markierte Note.
	 * Liegt der index ausserhalb des erlaubten Bereichs,
	 * gibt die Methode den Wert 0 zur�ck.
	 *
	 * @param Index der Note die zur�ckgegeben wird
	 * @return Note die zur�ckgegeben wird
	*/
	public double showGradeNumber(int index);

	/**
	 * Implementation der Schnittstelle Notenverwaltung.
	 * Liefert den aktuellen Wert des Index-Z�hlers.
	 * @return anzahl der noten wird zur�ckgegeben
	 *
	*/
	public int getGradeAmount();

	/**
	 * liefert alle noten zur�ck
	 * @return
	 */
	public List<Double> getGrade();
}
