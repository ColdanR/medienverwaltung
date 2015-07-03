package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class InputPanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField txfTitel;
	private JTextField txfMitwirkende;
	private JTextField txfErsterscheinung;
	private JCheckBox chkbxLive;
	private EtchedBorder brdEtched = new EtchedBorder(EtchedBorder.LOWERED, null, null);
	private TitledBorder brdTitel = new TitledBorder((brdEtched), "Musik",TitledBorder.LEADING , TitledBorder.TOP, null, null);
	private JButton btnSpeicherort;
	private JButton btnInterpret;
	private JButton btnAbbrechen;
	private JButton btnSpeichern;
	
	public InputPanel() {
		setAlignmentY(Component.TOP_ALIGNMENT);
		
		setBorder(brdTitel);		
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWidths = new int[] {30, 0, 0, 30, 30, 0};
		gbl.rowHeights = new int[] {30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl);
		
		JLabel lblTitel = new JLabel("Titel");
		lblTitel.setFont(StaticComponents.FONT_STD);
		GridBagConstraints gbc_lblTitel = new GridBagConstraints();
		gbc_lblTitel.gridwidth = 3;
		gbc_lblTitel.insets = new Insets(0, 0, 5, 10);
		gbc_lblTitel.anchor = GridBagConstraints.WEST;
		gbc_lblTitel.gridx = 1;
		gbc_lblTitel.gridy = 1;
		add(lblTitel, gbc_lblTitel);
		
		txfTitel = new JTextField();
		txfTitel.setFont(StaticComponents.FONT_STD);
		GridBagConstraints gbc_txfTitel = new GridBagConstraints();
		gbc_txfTitel.gridwidth = 3;
		gbc_txfTitel.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfTitel.anchor = GridBagConstraints.WEST;
		gbc_txfTitel.insets = new Insets(0, 0, 10, 10);
		gbc_txfTitel.gridx = 1;
		gbc_txfTitel.gridy = 2;
		add(txfTitel, gbc_txfTitel);
		
		JLabel lblMitwirkende = new JLabel("Mitwirkende");
		lblMitwirkende.setFont(StaticComponents.FONT_STD);
		GridBagConstraints gbc_lblMitwirkende = new GridBagConstraints();
		gbc_lblMitwirkende.gridwidth = 3;
		gbc_lblMitwirkende.anchor = GridBagConstraints.WEST;
		gbc_lblMitwirkende.insets = new Insets(0, 0, 5, 10);
		gbc_lblMitwirkende.gridx = 1;
		gbc_lblMitwirkende.gridy = 3;
		add(lblMitwirkende, gbc_lblMitwirkende);
		
		txfMitwirkende = new JTextField();
		txfMitwirkende.setFont(StaticComponents.FONT_STD);
		GridBagConstraints gbc_txfMitwirkende = new GridBagConstraints();
		gbc_txfMitwirkende.gridwidth = 3;
		gbc_txfMitwirkende.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfMitwirkende.anchor = GridBagConstraints.WEST;
		gbc_txfMitwirkende.insets = new Insets(0,0,10,10);
		gbc_txfMitwirkende.gridx = 1;
		gbc_txfMitwirkende.gridy = 4;
		
		add(txfMitwirkende, gbc_txfMitwirkende);
		
		JLabel lblErsterscheinung = new JLabel("Erstausgabe");
		lblErsterscheinung.setFont(StaticComponents.FONT_STD);
		GridBagConstraints gbc_lblErsterscheinung = new GridBagConstraints();
		gbc_lblErsterscheinung.gridwidth = 2;
		gbc_lblErsterscheinung.anchor = GridBagConstraints.WEST;
		gbc_lblErsterscheinung.insets = new Insets(0, 0, 5, 10);
		gbc_lblErsterscheinung.gridx = 1;
		gbc_lblErsterscheinung.gridy = 5;
		add(lblErsterscheinung, gbc_lblErsterscheinung);
		
		txfErsterscheinung = new JTextField();
		txfErsterscheinung.setFont(StaticComponents.FONT_STD);
		GridBagConstraints gbc_txfErsterscheinung = new GridBagConstraints();
		gbc_txfErsterscheinung.gridwidth = 2;
		gbc_txfErsterscheinung.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfErsterscheinung.anchor = GridBagConstraints.WEST;
		gbc_txfErsterscheinung.insets = new Insets(0, 0, 10, 10);
		gbc_txfErsterscheinung.gridx = 1;
		gbc_txfErsterscheinung.gridy = 6;
		add(txfErsterscheinung, gbc_txfErsterscheinung);
		txfErsterscheinung.setColumns(20);
		
		btnInterpret = new JButton("Interpret");
		btnInterpret.setFont(StaticComponents.FONT_STD);
		GridBagConstraints gbc_btnInterpret = new GridBagConstraints();
		gbc_btnInterpret.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInterpret.insets = new Insets(0, 0, 10, 10);
		gbc_btnInterpret.gridx = 3;
		gbc_btnInterpret.gridy = 6;
		add(btnInterpret, gbc_btnInterpret);
		
		chkbxLive = new JCheckBox("Live");
		chkbxLive.setMargin(new Insets(2, 0, 2, 2));
		chkbxLive.setIconTextGap(10);
		chkbxLive.setHorizontalTextPosition(SwingConstants.LEFT);
		chkbxLive.setActionCommand("Live");
		chkbxLive.setFont(StaticComponents.FONT_STD);
		GridBagConstraints gbc_chkbxLive = new GridBagConstraints();
		gbc_chkbxLive.anchor = GridBagConstraints.WEST;
		gbc_chkbxLive.insets = new Insets(0, 0, 30, 10);
		gbc_chkbxLive.gridx = 1;
		gbc_chkbxLive.gridy = 7;
		add(chkbxLive, gbc_chkbxLive);
		
		btnSpeicherort = new JButton("Speicherort");
		btnSpeicherort.setFont(StaticComponents.FONT_STD);
		GridBagConstraints gbc_btnSpeicherformat = new GridBagConstraints();
		gbc_btnSpeicherformat.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSpeicherformat.insets = new Insets(0, 0, 30, 10);
		gbc_btnSpeicherformat.gridx = 3;
		gbc_btnSpeicherformat.gridy = 7;
		add(btnSpeicherort, gbc_btnSpeicherformat);
		
		btnSpeichern = new JButton("speichern");
		btnSpeichern.setFont(StaticComponents.FONT_STD);
		GridBagConstraints gbc_btnSpeichern = new GridBagConstraints();
		gbc_btnSpeichern.anchor = GridBagConstraints.EAST;
		gbc_btnSpeichern.insets = new Insets(0, 0, 10, 10);
		gbc_btnSpeichern.gridx = 2;
		gbc_btnSpeichern.gridy = 8;
		add(btnSpeichern, gbc_btnSpeichern);
		
		btnAbbrechen = new JButton("abbrechen");
		btnAbbrechen.setFont(StaticComponents.FONT_STD);
		GridBagConstraints gbc_btnAbbrechen = new GridBagConstraints();
		gbc_btnAbbrechen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAbbrechen.insets = new Insets(0, 0, 10, 10);
		gbc_btnAbbrechen.gridx = 3;
		gbc_btnAbbrechen.gridy = 8;
		add(btnAbbrechen, gbc_btnAbbrechen);
		
		btnSpeicherort.addActionListener(this);
		btnSpeichern.addActionListener(this);
		btnAbbrechen.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
