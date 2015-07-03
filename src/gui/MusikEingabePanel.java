package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class MusikEingabePanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField 		txfTitel;
	private JTextField 		txfMitwirkende;
	private JTextField 		txfErsterscheinung;
	private JCheckBox 		chkbxLive;
	private JButton 		btnSpeicherort;
	private JButton 		btnInterpret;
	private JButton 		btnAbbrechen;
	private JButton 		btnSpeichern;
	private JLabel			lblMusikEingabe;
	private JLabel 			lblInterpret;
	private JLabel 			lblSpeicherort;
	
	public MusikEingabePanel() {
		setAlignmentY(Component.TOP_ALIGNMENT);
		createMusikEingabePanel();

		
		btnInterpret.addActionListener(this);
		btnSpeicherort.addActionListener(this);
		btnSpeichern.addActionListener(this);
		btnAbbrechen.addActionListener(this);
	}
	
	private void createMusikEingabePanel()	{
		
		this.setLayout(new BorderLayout());
		
		JPanel pnlNorth		= new JPanel();
		JPanel pnlCenter	= new JPanel();
		JPanel pnlSouth		= new JPanel();
		
		pnlNorth.setBorder(StaticComponents.BORDER_PANEL);
		pnlCenter.setBorder(StaticComponents.BORDER_PANEL);
		
		this.add(pnlNorth, BorderLayout.NORTH);
		this.add(pnlCenter, BorderLayout.CENTER);
		this.add(pnlSouth, BorderLayout.SOUTH);
		
		// Header
		lblMusikEingabe = new JLabel("Musik Eingabe");
		lblMusikEingabe.setFont(StaticComponents.FONT_TITLE);
		pnlNorth.add(lblMusikEingabe);
			
		// creating BorderLayout.CENTER Components
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWidths = new int[] {30, 0, 0, 0, 30, 0};
		gbl.rowHeights = new int[] {30, 0, 0, 0, 0, 0, 0, 0};
		gbl.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlCenter.setLayout(gbl);
		
		JLabel lblTitel = new JLabel("Titel");
		StaticComponents.setFontLabel(lblTitel);
		GridBagConstraints gbc_lblTitel = new GridBagConstraints();
		gbc_lblTitel.insets = new Insets(0, 0, 10, 10);
		gbc_lblTitel.anchor = GridBagConstraints.WEST;
		gbc_lblTitel.gridx = 1;
		gbc_lblTitel.gridy = 1;
		pnlCenter.add(lblTitel, gbc_lblTitel);
		
		txfTitel = new JTextField();
		StaticComponents.setFontBorderTextField(txfTitel);
		GridBagConstraints gbc_txfTitel = new GridBagConstraints();
		gbc_txfTitel.gridwidth = 2;
		gbc_txfTitel.fill = GridBagConstraints.BOTH;
		gbc_txfTitel.anchor = GridBagConstraints.WEST;
		gbc_txfTitel.insets = new Insets(0, 0, 10, 10);
		gbc_txfTitel.gridx = 2;
		gbc_txfTitel.gridy = 1;
		pnlCenter.add(txfTitel, gbc_txfTitel);
		
		JLabel lblMitwirkende = new JLabel("Mitwirkende");
		StaticComponents.setFontLabel(lblMitwirkende);
		GridBagConstraints gbc_lblMitwirkende = new GridBagConstraints();
		gbc_lblMitwirkende.anchor = GridBagConstraints.WEST;
		gbc_lblMitwirkende.insets = new Insets(0, 0, 10, 10);
		gbc_lblMitwirkende.gridx = 1;
		gbc_lblMitwirkende.gridy = 2;
		pnlCenter.add(lblMitwirkende, gbc_lblMitwirkende);
		
		txfMitwirkende = new JTextField();
		StaticComponents.setFontBorderTextField(txfMitwirkende);
		GridBagConstraints gbc_txfMitwirkende = new GridBagConstraints();
		gbc_txfMitwirkende.gridwidth = 2;
		gbc_txfMitwirkende.fill = GridBagConstraints.BOTH;
		gbc_txfMitwirkende.anchor = GridBagConstraints.WEST;
		gbc_txfMitwirkende.insets = new Insets(0,0,10,10);
		gbc_txfMitwirkende.gridx = 2;
		gbc_txfMitwirkende.gridy = 2;
		pnlCenter.add(txfMitwirkende, gbc_txfMitwirkende);
		
		JLabel lblErsterscheinung = new JLabel("Erstausgabe");
		StaticComponents.setFontLabel(lblErsterscheinung);
		GridBagConstraints gbc_lblErsterscheinung = new GridBagConstraints();
		gbc_lblErsterscheinung.anchor = GridBagConstraints.WEST;
		gbc_lblErsterscheinung.insets = new Insets(0, 0, 10, 10);
		gbc_lblErsterscheinung.gridx = 1;
		gbc_lblErsterscheinung.gridy = 3;
		pnlCenter.add(lblErsterscheinung, gbc_lblErsterscheinung);
		
		txfErsterscheinung = new JTextField();
		StaticComponents.setFontBorderTextField(txfErsterscheinung);
		GridBagConstraints gbc_txfErsterscheinung = new GridBagConstraints();
		gbc_txfErsterscheinung.fill = GridBagConstraints.BOTH;
		gbc_txfErsterscheinung.anchor = GridBagConstraints.WEST;
		gbc_txfErsterscheinung.insets = new Insets(0, 0, 10, 10);
		gbc_txfErsterscheinung.gridx = 2;
		gbc_txfErsterscheinung.gridy = 3;
		pnlCenter.add(txfErsterscheinung, gbc_txfErsterscheinung);
		txfErsterscheinung.setColumns(15);
		
		chkbxLive = new JCheckBox("Live");
		chkbxLive.setMargin(new Insets(2, 0, 2, 2));
		chkbxLive.setIconTextGap(10);
		chkbxLive.setHorizontalTextPosition(SwingConstants.LEFT);
		chkbxLive.setActionCommand("Live");
		StaticComponents.setFontLabel(chkbxLive);
		GridBagConstraints gbc_chkbxLive = new GridBagConstraints();
		gbc_chkbxLive.anchor = GridBagConstraints.WEST;
		gbc_chkbxLive.insets = new Insets(0, 0, 10, 10);
		gbc_chkbxLive.gridx = 3;
		gbc_chkbxLive.gridy = 3;
		pnlCenter.add(chkbxLive, gbc_chkbxLive);
		
		btnInterpret = new JButton("Interpret");
		btnInterpret.setFont(StaticComponents.FONT_BUTTON);
		GridBagConstraints gbc_btnInterpret = new GridBagConstraints();
		gbc_btnInterpret.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInterpret.insets = new Insets(0, 0, 10, 10);
		gbc_btnInterpret.gridx = 1;
		gbc_btnInterpret.gridy = 4;
		pnlCenter.add(btnInterpret, gbc_btnInterpret);
		
		lblInterpret = new JLabel();
		StaticComponents.setFontBorderLabel(lblInterpret);
		GridBagConstraints gbc_lblInterpret = new GridBagConstraints();
		gbc_lblInterpret.gridwidth = 2;
		gbc_lblInterpret.fill = GridBagConstraints.BOTH;
		gbc_lblInterpret.anchor = GridBagConstraints.WEST;
		gbc_lblInterpret.insets = new Insets(0, 0, 10, 10);
		gbc_lblInterpret.gridx = 2;
		gbc_lblInterpret.gridy = 4;
		pnlCenter.add(lblInterpret, gbc_lblInterpret);
		
		btnSpeicherort = new JButton("Speicherort");
		btnSpeicherort.setFont(StaticComponents.FONT_BUTTON);
		GridBagConstraints gbc_btnSpeicherformat = new GridBagConstraints();
		gbc_btnSpeicherformat.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSpeicherformat.insets = new Insets(0, 0, 10, 10);
		gbc_btnSpeicherformat.gridx = 1;
		gbc_btnSpeicherformat.gridy = 5;
		pnlCenter.add(btnSpeicherort, gbc_btnSpeicherformat);
		
		lblSpeicherort = new JLabel();
		StaticComponents.setFontBorderLabel(lblSpeicherort);
		GridBagConstraints gbc_lblSpeicherort = new GridBagConstraints();
		gbc_lblSpeicherort.gridwidth = 2;
		gbc_lblSpeicherort.fill = GridBagConstraints.BOTH;
		gbc_lblSpeicherort.anchor = GridBagConstraints.WEST;
		gbc_lblSpeicherort.insets = new Insets(0, 0, 10, 10);
		gbc_lblSpeicherort.gridx = 2;
		gbc_lblSpeicherort.gridy = 5;
		pnlCenter.add(lblSpeicherort, gbc_lblSpeicherort);
				
		// creating BorderLayout.SOUTH Components
		FlowLayout fl_pnlSouth = (FlowLayout) pnlSouth.getLayout();
		fl_pnlSouth.setVgap(10);
		fl_pnlSouth.setHgap(10);
		fl_pnlSouth.setAlignment(FlowLayout.RIGHT);
		pnlSouth.setBorder(StaticComponents.BORDER_PANEL);
		
		btnSpeichern = new JButton("speichern");
		btnSpeichern.setFont(StaticComponents.FONT_BUTTON);
		pnlSouth.add(btnSpeichern);
		
		btnAbbrechen = new JButton("abbrechen");
		btnAbbrechen.setFont(StaticComponents.FONT_BUTTON);
		pnlSouth.add(btnAbbrechen);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		
		if (source == btnInterpret)
		{
			
		}
		else if (source == btnSpeicherort)
		{
			
		}
		else if (source == btnSpeichern)
		{
			
		}
		else if (source == btnAbbrechen)
		{
			
		}
		
	}
}
