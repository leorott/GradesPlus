package ch.schule;

public class SchuleApp{
	public static void main(String[] args){
		// Datenverwaltungsklasse erzeugen
		Grade n = new Grade();
		// GUI erzeugen
		SchoolGUI g = new SchoolGUI(n);
	}
};