package ch.schule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Vector;

public class SchoolGUI extends JFrame{

	private GradeManagement model;
	private JLabel     meanValueLbl;
	private JButton    meanBtn;
	private JButton    neueNoteBtn;
	private JTextField neueNoteTxt;
	private JList<Double> notenListe;
	private JFrame	   theFrame;

	public SchoolGUI(GradeManagement model){
		super ("Notenverwaltung");
		theFrame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.model = model;
		init();
		setVisible(true);
		pack();
	};


	private void init(){
		getContentPane().add(new JLabel("Grades"), BorderLayout.NORTH);
		getContentPane().add(eingabePanel(), BorderLayout.EAST);
		getContentPane().add(notenListe(), BorderLayout.CENTER);
		neueNoteTxt.requestFocus();
	}

	private JPanel notenListe(){
		JPanel panel     = new JPanel(new BorderLayout());
		JPanel meanPanel = new JPanel();
		meanValueLbl     = new JLabel();
		meanBtn          = new JButton("Mittelwert");
		notenListe       = new JList<>();
		JScrollPane scp  = new JScrollPane(notenListe);
		meanPanel.add(meanBtn);
		meanPanel.add(meanValueLbl);
		panel.add(meanPanel, BorderLayout.SOUTH);
		panel.add(scp, BorderLayout.CENTER);
		//
//		meanBtn.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent ae){
//				onMean();
//			}
//		});
		// lambdas

		meanBtn.addActionListener( (ActionEvent ae) -> {
			onMean();
		});

		return panel;
	}


	private JPanel eingabePanel(){
		JPanel topPanel = new JPanel(new BorderLayout());
		JPanel panel = new JPanel(new BorderLayout());
		neueNoteBtn = new JButton("Note +");
		neueNoteBtn.setEnabled(false);
		neueNoteTxt = new JTextField(4);
		panel.add(neueNoteTxt, BorderLayout.NORTH);
		panel.add(neueNoteBtn, BorderLayout.SOUTH);
		topPanel.add(panel, BorderLayout.SOUTH);
		//
		neueNoteBtn.addActionListener((e) -> {
			onAdd();
		});


		neueNoteTxt.addActionListener((e) -> {
			onEdit();
		});

		//
		return topPanel;
	}

	private void onEdit(){
		// Textfeld bearbeiten
		neueNoteBtn.setEnabled(true);
	}

	private void onAdd(){
		// read textfield and convert to double
		double grade =  Double.parseDouble(neueNoteTxt.getText());


		if (model.addGrade(grade)){
			// GUI
			neueNoteBtn.setEnabled(false);
			neueNoteTxt.setText("");
			neueNoteTxt.requestFocus();
			// show all values in GUI
			Vector<Double> liste = new Vector<>();
			for (int i=0; i < model.getGradeAmount(); i++){
				liste.add(model.showGradeNumber(i));
			}
			notenListe.setListData(liste);
			// notenListe.setListData((Vector) model.addGrade(grade));
		}
		else{
			JOptionPane.showMessageDialog(theFrame, "Der Notenwert kann nicht mehr + werden", "Fehler", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void onMean(){
		meanValueLbl.setText( " "+((Average)model).computeMean());
	}
};