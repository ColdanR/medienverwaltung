package gui.dialog;

import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JButton;

import data.Person;
import data.logic.PersonLogik;
import gui.ReturningDialog;
import gui.StaticComponents;

public class PersonEingabeDialog extends ReturningDialog<Person> {
    private	JTextField	txfNachname;
    private	JTextField	txfVorname;
    private	JTextField	txfKuenstlername;
    private	JButton		btnSpeichern;
    private	JButton		btnAbbrechen;
    private Person		person;
    
	public PersonEingabeDialog(Window parent) {
		super(parent, "Interpret anlegen", 400, 250);
		createDialogContent();
    }

	@Override
	public void actionPerformed(ActionEvent aEvent) 
	{
		if (aEvent.getSource() == btnSpeichern) 
		{
			PersonLogik logik = new PersonLogik();
			boolean errors = false;
			if (logik.createNew(txfNachname.getText(), txfVorname.getText(), txfKuenstlername.getText())) 
			{
				if (logik.write()) {
					setObject(logik.getObject());
					dialog.dispose();
				} else {
					errors = true;
				}
			} 
			else 
			{
				errors = true;
			}
			if (errors) 
			{
				FehlerDialog fehlerDialog = new FehlerDialog(null, logik.getErrors());
				fehlerDialog.setAlwaysOnTop(true);
				fehlerDialog.setVisible(true);
			}
		} 
		else if (aEvent.getSource() == btnAbbrechen) 
		{
			txfKuenstlername.setText("");
			txfNachname.setText("");
			txfVorname.setText("");
			dialog.dispose();
		}
	}

	@Override
	protected JPanel createDialogContent() 
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		// Header Panel
    	JPanel pnlNorth = new JPanel();
    	FlowLayout fl_pnlNorth = new FlowLayout();
    	fl_pnlNorth.setAlignment(FlowLayout.CENTER);
		pnlNorth.setLayout(fl_pnlNorth);
		
		JLabel lblInterpret = new JLabel("Interpret");
    	lblInterpret.setFont(StaticComponents.FONT_TITLE);
    	pnlNorth.add(lblInterpret);
    	
    	panel.add(pnlNorth, BorderLayout.NORTH);
		
    	GridBagLayout gbl = new GridBagLayout();
    	gbl.columnWidths = new int[] {30, 0, 200, 30};
    	gbl.rowHeights = new int[] {30, 0, 0, 0, 30};
    	gbl.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
    	gbl.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    	
    	// Main Panel
    	JPanel pnlCenter = new JPanel();
    	pnlCenter.setLayout(gbl);
    	JLabel lblNachname = new JLabel("Nachname");
    	lblNachname.setFont(StaticComponents.FONT_LABEL);
    	GridBagConstraints gbc_lblNachname = new GridBagConstraints();
    	gbc_lblNachname.anchor = GridBagConstraints.WEST;
    	gbc_lblNachname.insets = new Insets(0, 0, 10, 10);
    	gbc_lblNachname.gridx = 1;
    	gbc_lblNachname.gridy = 1;
    	pnlCenter.add(lblNachname, gbc_lblNachname);
    	
    	txfNachname = new JTextField();
    	StaticComponents.setFontBorderTextField(txfNachname);
    	GridBagConstraints gbc_txfNachname = new GridBagConstraints();
    	gbc_txfNachname.fill = GridBagConstraints.HORIZONTAL;
    	gbc_txfNachname.insets = new Insets(0, 0, 10, 10);
    	gbc_txfNachname.gridx = 2;
    	gbc_txfNachname.gridy = 1;
    	pnlCenter.add(txfNachname, gbc_txfNachname);
    	
    	if (person != null) {
    		txfNachname.setText(person.getNachname());
    	}
    	
    	JLabel lblVorname = new JLabel("Vorname");
    	lblVorname.setFont(StaticComponents.FONT_LABEL);
    	GridBagConstraints gbc_lblVorname = new GridBagConstraints();
    	gbc_lblVorname.anchor = GridBagConstraints.WEST;
    	gbc_lblVorname.insets = new Insets(0, 0, 10, 10);
    	gbc_lblVorname.gridx = 1;
    	gbc_lblVorname.gridy = 2;
    	pnlCenter.add(lblVorname, gbc_lblVorname);
    	
    	txfVorname = new JTextField();
    	StaticComponents.setFontBorderTextField(txfVorname);
    	GridBagConstraints gbc_txfVorname = new GridBagConstraints();
    	gbc_txfVorname.fill = GridBagConstraints.HORIZONTAL;
    	gbc_txfVorname.insets = new Insets(0, 0, 10, 10);
    	gbc_txfVorname.gridx = 2;
    	gbc_txfVorname.gridy = 2;
    	pnlCenter.add(txfVorname, gbc_txfVorname);
    	
    	if (person != null) {
    		txfVorname.setText(person.getVorname());
    	}
    	
    	JLabel lblKuenstlername = new JLabel("K\u00FCnstlername");
    	lblKuenstlername.setFont(StaticComponents.FONT_LABEL);
    	GridBagConstraints gbc_lblKuenstlername = new GridBagConstraints();
    	gbc_lblKuenstlername.anchor = GridBagConstraints.WEST;
    	gbc_lblKuenstlername.insets = new Insets(0, 0, 10, 10);
    	gbc_lblKuenstlername.gridx = 1;
    	gbc_lblKuenstlername.gridy = 3;
    	pnlCenter.add(lblKuenstlername, gbc_lblKuenstlername);
    	
    	txfKuenstlername = new JTextField();
    	StaticComponents.setFontBorderTextField(txfKuenstlername);
    	GridBagConstraints gbc_txfKuenstlername = new GridBagConstraints();
    	gbc_txfKuenstlername.fill = GridBagConstraints.HORIZONTAL;
    	gbc_txfKuenstlername.insets = new Insets(0, 0, 10, 10);
    	gbc_txfKuenstlername.gridx = 2;
    	gbc_txfKuenstlername.gridy = 3;
    	pnlCenter.add(txfKuenstlername, gbc_txfKuenstlername);
    	
    	if (person != null) {
    		txfKuenstlername.setText(person.getKuenstlername());
    	}
    	
    	panel.add(pnlCenter, BorderLayout.CENTER);

    	// Button Panel
    	JPanel pnlSouth = new JPanel();
    	FlowLayout fl_pnlSouth = new FlowLayout();
    	fl_pnlSouth.setVgap(10);
    	fl_pnlSouth.setHgap(10);
    	fl_pnlSouth.setAlignment(FlowLayout.RIGHT);
    	pnlSouth.setLayout(fl_pnlSouth);		
		btnSpeichern = new JButton("speichern");
		pnlSouth.add(btnSpeichern);
		btnAbbrechen = new JButton("abbrechen");
		pnlSouth.add(btnAbbrechen);
		
		panel.add(pnlSouth, BorderLayout.SOUTH);
		
		btnSpeichern.addActionListener(this);
		btnAbbrechen.addActionListener(this);
		return panel;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}