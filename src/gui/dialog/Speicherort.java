package gui.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.SpeicherFormatInterface;
import data.speicherformate.logic.SpeicherFormateLogik;
import gui.ReturningDialog;
import gui.StaticComponents;

/**
 * Dialog zur Eingabe eines neuen Speicherformates
 * @author Bernd Schmidt Logikimplementierung
 * @author Jens Design
 *
 */
public class Speicherort extends ReturningDialog<SpeicherFormatInterface> {
	private	JTextField	txfDatentraeger;
	private	JTextField	txfPfad;
	private	JTextField	txfDateiformat;
	private	JTextField	txfQualitaet;
	private	JButton		btnSpeichern;
	private	JButton		btnAbbrechen;
	private	int			titelId;
	
	public Speicherort(Window parent, int titelId) {
		super(parent, "Speicherort", 400, 400);
		this.titelId = titelId;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAbbrechen) {
			dialog.dispose();
		} else if (arg0.getSource() == btnSpeichern) {
			SpeicherFormateLogik logik = new SpeicherFormateLogik();
			logik.setTitelId(titelId);
			boolean errors = false;
			if (logik.createDigitalMusik(txfDatentraeger.getText(), txfPfad.getText(), txfDateiformat.getText(), txfQualitaet.getText())) {
				if (logik.write()) {
					setObject(logik.getObject());
					dialog.dispose();
				} else {
					errors = true;
				}
			} else {
				errors = true;
			}
			if (errors) {
				FehlerDialog fehlerDialog = new FehlerDialog(null, logik.getErrors());
				fehlerDialog.setAlwaysOnTop(true);
				fehlerDialog.setVisible(true);
			}
		}
	}

	@Override
	protected JPanel createDialogContent() {
		JPanel display = new JPanel();
		display.setLayout(new BorderLayout());
		
		// Creating and adding main Components
		JPanel pnlNorth		=	new JPanel();
		JPanel pnlCenter	=	new JPanel();
		JPanel pnlSouth		=	new JPanel();
		display.add(pnlNorth, BorderLayout.NORTH);
		display.add(pnlCenter, BorderLayout.CENTER);
		display.add(pnlSouth, BorderLayout.SOUTH);
		
		// Header
		FlowLayout fl_pnlNorth = new FlowLayout();
		fl_pnlNorth.setAlignment(FlowLayout.CENTER);
		pnlNorth.setLayout(fl_pnlNorth);
		
		JLabel lblHeader = new JLabel("Speicherort");
		lblHeader.setFont(StaticComponents.FONT_BOLD);
		pnlNorth.add(lblHeader);
		
		// Main
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWidths = new int[] {30, 0, 200, 30};
		gbl.rowHeights = new int[] {30, 0, 0, 0, 0, 0, 0, 30};
		gbl.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlCenter.setLayout(gbl);
		
		JLabel lblDatentraeger = new JLabel("Datentr\u00E4ger");
		lblDatentraeger.setFont(StaticComponents.FONT_STD);
		GridBagConstraints gbc_lblDatentraeger = new GridBagConstraints();
		gbc_lblDatentraeger.anchor = GridBagConstraints.WEST;
		gbc_lblDatentraeger.insets = new Insets(0, 0, 10, 10);
		gbc_lblDatentraeger.gridx = 1;
		gbc_lblDatentraeger.gridy = 2;
		pnlCenter.add(lblDatentraeger, gbc_lblDatentraeger);
		
		txfDatentraeger = new JTextField();
		txfDatentraeger.setBorder(StaticComponents.BORDER_TEXTFIELDS_STD);
		txfDatentraeger.setFont(StaticComponents.FONT_STD);
		GridBagConstraints gbc_txfDatentraeger = new GridBagConstraints();
		gbc_txfDatentraeger.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfDatentraeger.insets = new Insets(0, 0, 10, 10);
		gbc_txfDatentraeger.gridx = 2;
		gbc_txfDatentraeger.gridy = 2;
		pnlCenter.add(txfDatentraeger, gbc_txfDatentraeger);
		
		JLabel lblPfad = new JLabel("Pfad");
		lblPfad.setFont(StaticComponents.FONT_STD);
		GridBagConstraints gbc_lblPfad = new GridBagConstraints();
		gbc_lblPfad.anchor = GridBagConstraints.WEST;
		gbc_lblPfad.insets = new Insets(0, 0, 10, 10);
		gbc_lblPfad.gridx = 1;
		gbc_lblPfad.gridy = 3;
		pnlCenter.add(lblPfad, gbc_lblPfad);
		
		txfPfad = new JTextField();
		txfPfad.setBorder(StaticComponents.BORDER_TEXTFIELDS_STD);
		txfPfad.setFont(StaticComponents.FONT_STD);
		GridBagConstraints gbc_txfPfad = new GridBagConstraints();
		gbc_txfPfad.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfPfad.insets = new Insets(0, 0, 10, 10);
		gbc_txfPfad.gridx = 2;
		gbc_txfPfad.gridy = 3;
		pnlCenter.add(txfPfad, gbc_txfPfad);
		
		JLabel lblDateiformat = new JLabel("Dateiformat");
		lblDateiformat.setFont(StaticComponents.FONT_STD);
		GridBagConstraints gbc_lblDateiformat = new GridBagConstraints();
		gbc_lblDateiformat.anchor = GridBagConstraints.WEST;
		gbc_lblDateiformat.insets = new Insets(0, 0, 10, 10);
		gbc_lblDateiformat.gridx = 1;
		gbc_lblDateiformat.gridy = 4;
		pnlCenter.add(lblDateiformat, gbc_lblDateiformat);
		
		txfDateiformat = new JTextField();
		txfDateiformat.setBorder(StaticComponents.BORDER_TEXTFIELDS_STD);
		txfDateiformat.setFont(StaticComponents.FONT_STD);
		GridBagConstraints gbc_txfDateiformat = new GridBagConstraints();
		gbc_txfDateiformat.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfDateiformat.insets = new Insets(0, 0, 10, 10);
		gbc_txfDateiformat.gridx = 2;
		gbc_txfDateiformat.gridy = 4;
		pnlCenter.add(txfDateiformat, gbc_txfDateiformat);
		
		JLabel lblQualitaet = new JLabel("Qualität");
		lblQualitaet.setFont(StaticComponents.FONT_STD);
		GridBagConstraints gbc_lblQualitaet = new GridBagConstraints();
		gbc_lblQualitaet.anchor = GridBagConstraints.WEST;
		gbc_lblQualitaet.insets = new Insets(0, 0, 10, 10);
		gbc_lblQualitaet.gridx = 1;
		gbc_lblQualitaet.gridy = 5;
		pnlCenter.add(lblQualitaet, gbc_lblQualitaet);
		
		txfQualitaet = new JTextField();
		txfQualitaet.setBorder(StaticComponents.BORDER_TEXTFIELDS_STD);
		txfQualitaet.setFont(StaticComponents.FONT_STD);
		gbc_txfDateiformat = new GridBagConstraints();
		gbc_txfDateiformat.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfDateiformat.insets = new Insets(0, 0, 10, 10);
		gbc_txfDateiformat.gridx = 2;
		gbc_txfDateiformat.gridy = 5;
		pnlCenter.add(txfQualitaet, gbc_txfDateiformat);
		
		// Buttons
		FlowLayout fl_pnlSouth = new FlowLayout();
		fl_pnlSouth.setVgap(10);
		fl_pnlSouth.setHgap(10);
		fl_pnlSouth.setAlignment(FlowLayout.RIGHT);
		pnlSouth.setLayout(fl_pnlSouth);
		
		btnSpeichern = new JButton("Speichern");
		pnlSouth.add(btnSpeichern);
		btnAbbrechen = new JButton("Abbrechen");
		pnlSouth.add(btnAbbrechen);
		
		// Event Listener
		btnSpeichern.addActionListener(this);
		btnAbbrechen.addActionListener(this);
		
		return display;
	}
}
