package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JCheckBox;
import java.awt.Component;
<<<<<<< HEAD
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
=======
>>>>>>> branch 'master' of https://github.com/ColdanR/medienverwaltung.git

public class InputPanel extends JPanel implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	
	private JTextField txfTitel;
	private JTextField txfMitwirkende;
	private JTextField txfErsterscheinung;
<<<<<<< HEAD
	private JCheckBox chkbxLive;
	private Font fontStd = new Font("Tahoma", Font.PLAIN, 14);
	private BevelBorder brdBevel = new BevelBorder(BevelBorder.LOWERED);
	private EtchedBorder brdEtched = new EtchedBorder(EtchedBorder.LOWERED, null, null);
	private TitledBorder brdTitel = new TitledBorder((brdEtched), "Musik",TitledBorder.LEADING , TitledBorder.TOP, null, null);
	private JButton btnSpeicherort;
	private JButton btnInterpret;
	private JButton btnAbbrechen;
	private JButton btnSpeichern;
=======
	private JTextField txfGenre;
>>>>>>> branch 'master' of https://github.com/ColdanR/medienverwaltung.git
	
	
	public InputPanel()
	{
		//super();
		setAlignmentY(Component.TOP_ALIGNMENT);
		
<<<<<<< HEAD
		setBorder(brdTitel);		
=======
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "CD",TitledBorder.LEADING , TitledBorder.TOP, null, null));		
>>>>>>> branch 'master' of https://github.com/ColdanR/medienverwaltung.git
		GridBagLayout gbl = new GridBagLayout();
<<<<<<< HEAD
		gbl.columnWidths = new int[] {30, 0, 0, 30, 30, 0};
		gbl.rowHeights = new int[] {30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
=======
		gbl.columnWidths = new int[]{30, 0, 0, 0, 0};
		gbl.rowHeights = new int[] {30, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
>>>>>>> branch 'master' of https://github.com/ColdanR/medienverwaltung.git
		setLayout(gbl);
		
		JLabel lblTitel = new JLabel("Titel");
		lblTitel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblTitel = new GridBagConstraints();
		gbc_lblTitel.gridwidth = 3;
		gbc_lblTitel.insets = new Insets(0, 0, 5, 10);
		gbc_lblTitel.anchor = GridBagConstraints.WEST;
		gbc_lblTitel.gridx = 1;
		gbc_lblTitel.gridy = 1;
		add(lblTitel, gbc_lblTitel);
		
		txfTitel = new JTextField();
		txfTitel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_txfTitel = new GridBagConstraints();
<<<<<<< HEAD
		gbc_txfTitel.gridwidth = 3;
		gbc_txfTitel.fill = GridBagConstraints.HORIZONTAL;
=======
>>>>>>> branch 'master' of https://github.com/ColdanR/medienverwaltung.git
		gbc_txfTitel.anchor = GridBagConstraints.WEST;
		gbc_txfTitel.insets = new Insets(0, 0, 10, 10);
<<<<<<< HEAD
		gbc_txfTitel.gridx = 1;
		gbc_txfTitel.gridy = 2;
=======
		gbc_txfTitel.gridx = 2;
		gbc_txfTitel.gridy = 1;
		txfTitel.setColumns(20);
>>>>>>> branch 'master' of https://github.com/ColdanR/medienverwaltung.git
		add(txfTitel, gbc_txfTitel);
		
<<<<<<< HEAD
=======
		
		JLabel lblInterpret = new JLabel("Interpret");
		lblInterpret.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblInterpret = new GridBagConstraints();
		gbc_lblInterpret.insets = new Insets(0, 0, 10, 10);
		gbc_lblInterpret.anchor = GridBagConstraints.WEST;
		gbc_lblInterpret.gridx = 1;
		gbc_lblInterpret.gridy = 2;
		add(lblInterpret, gbc_lblInterpret);
		
		txfInterpret = new JTextField();
		txfInterpret.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_txfInterpret = new GridBagConstraints();
		gbc_txfInterpret.anchor = GridBagConstraints.WEST;
		gbc_txfInterpret.insets = new Insets(0, 0, 10, 10);
		gbc_txfInterpret.gridx = 2;
		gbc_txfInterpret.gridy = 2;
		add(txfInterpret, gbc_txfInterpret);
		txfInterpret.setColumns(20);
>>>>>>> branch 'master' of https://github.com/ColdanR/medienverwaltung.git
		
		JLabel lblMitwirkende = new JLabel("Mitwirkende");
		lblMitwirkende.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblMitwirkende = new GridBagConstraints();
		gbc_lblMitwirkende.gridwidth = 3;
		gbc_lblMitwirkende.anchor = GridBagConstraints.WEST;
		gbc_lblMitwirkende.insets = new Insets(0, 0, 5, 10);
		gbc_lblMitwirkende.gridx = 1;
		gbc_lblMitwirkende.gridy = 3;
		add(lblMitwirkende, gbc_lblMitwirkende);
		
		txfMitwirkende = new JTextField();
		txfMitwirkende.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_txfMitwirkende = new GridBagConstraints();
<<<<<<< HEAD
		gbc_txfMitwirkende.gridwidth = 3;
		gbc_txfMitwirkende.fill = GridBagConstraints.HORIZONTAL;
=======
>>>>>>> branch 'master' of https://github.com/ColdanR/medienverwaltung.git
		gbc_txfMitwirkende.anchor = GridBagConstraints.WEST;
		gbc_txfMitwirkende.insets = new Insets(0,0,10,10);
<<<<<<< HEAD
		gbc_txfMitwirkende.gridx = 1;
		gbc_txfMitwirkende.gridy = 4;
		
=======
		gbc_txfMitwirkende.gridx = 2;
		gbc_txfMitwirkende.gridy = 3;
		txfMitwirkende.setColumns(20);
>>>>>>> branch 'master' of https://github.com/ColdanR/medienverwaltung.git
		add(txfMitwirkende, gbc_txfMitwirkende);
<<<<<<< HEAD
=======
		
		JLabel lblAlbum = new JLabel("Album");
		lblAlbum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblAlbum = new GridBagConstraints();
		gbc_lblAlbum.insets = new Insets(0, 0, 10, 10);
		gbc_lblAlbum.anchor = GridBagConstraints.WEST;
		gbc_lblAlbum.gridx = 1;
		gbc_lblAlbum.gridy = 4;
		add(lblAlbum, gbc_lblAlbum);
		
		txfAlbum = new JTextField();
		txfAlbum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_txfAlbum = new GridBagConstraints();
		gbc_txfAlbum.anchor = GridBagConstraints.WEST;
		gbc_txfAlbum.insets = new Insets(0, 0, 10, 10);
		gbc_txfAlbum.gridx = 2;
		gbc_txfAlbum.gridy = 4;
		add(txfAlbum, gbc_txfAlbum);
		txfAlbum.setColumns(20);
		
				
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblGenre = new GridBagConstraints();
		gbc_lblGenre.anchor = GridBagConstraints.WEST;
		gbc_lblGenre.insets = new Insets(0, 0, 10, 10);
		gbc_lblGenre.gridx = 1;
		gbc_lblGenre.gridy = 5;
		add(lblGenre, gbc_lblGenre);
		
		txfGenre = new JTextField();
		txfGenre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_txfGenre = new GridBagConstraints();
		gbc_txfGenre.anchor = GridBagConstraints.WEST;
		gbc_txfGenre.insets = new Insets(0, 0, 10, 10);
		gbc_txfGenre.gridx = 2;
		gbc_txfGenre.gridy = 5;
		add(txfGenre, gbc_txfGenre);
		txfGenre.setColumns(20);
>>>>>>> branch 'master' of https://github.com/ColdanR/medienverwaltung.git
		
		JLabel lblErsterscheinung = new JLabel("Erstausgabe");
		lblErsterscheinung.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblErsterscheinung = new GridBagConstraints();
		gbc_lblErsterscheinung.gridwidth = 2;
		gbc_lblErsterscheinung.anchor = GridBagConstraints.WEST;
		gbc_lblErsterscheinung.insets = new Insets(0, 0, 5, 10);
		gbc_lblErsterscheinung.gridx = 1;
		gbc_lblErsterscheinung.gridy = 5;
		add(lblErsterscheinung, gbc_lblErsterscheinung);
		
		txfErsterscheinung = new JTextField();
		txfErsterscheinung.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_txfErsterscheinung = new GridBagConstraints();
<<<<<<< HEAD
		gbc_txfErsterscheinung.gridwidth = 2;
		gbc_txfErsterscheinung.fill = GridBagConstraints.HORIZONTAL;
=======
>>>>>>> branch 'master' of https://github.com/ColdanR/medienverwaltung.git
		gbc_txfErsterscheinung.anchor = GridBagConstraints.WEST;
		gbc_txfErsterscheinung.insets = new Insets(0, 0, 10, 10);
		gbc_txfErsterscheinung.gridx = 1;
		gbc_txfErsterscheinung.gridy = 6;
		add(txfErsterscheinung, gbc_txfErsterscheinung);
		txfErsterscheinung.setColumns(20);
		
<<<<<<< HEAD
		btnInterpret = new JButton("Interpret");
		btnInterpret.setFont(fontStd);
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
=======
		JCheckBox chkbxLive = new JCheckBox("Live?");
>>>>>>> branch 'master' of https://github.com/ColdanR/medienverwaltung.git
		chkbxLive.setActionCommand("Live");
		chkbxLive.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_chkbxLive = new GridBagConstraints();
		gbc_chkbxLive.anchor = GridBagConstraints.WEST;
		gbc_chkbxLive.insets = new Insets(0, 0, 30, 10);
		gbc_chkbxLive.gridx = 1;
		gbc_chkbxLive.gridy = 7;
		add(chkbxLive, gbc_chkbxLive);
		
		btnSpeicherort = new JButton("Speicherort");
		btnSpeicherort.setFont(fontStd);
		GridBagConstraints gbc_btnSpeicherformat = new GridBagConstraints();
		gbc_btnSpeicherformat.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSpeicherformat.insets = new Insets(0, 0, 30, 10);
		gbc_btnSpeicherformat.gridx = 3;
		gbc_btnSpeicherformat.gridy = 7;
		add(btnSpeicherort, gbc_btnSpeicherformat);
		
		btnSpeichern = new JButton("speichern");
		btnSpeichern.setFont(fontStd);
		GridBagConstraints gbc_btnSpeichern = new GridBagConstraints();
		gbc_btnSpeichern.anchor = GridBagConstraints.EAST;
		gbc_btnSpeichern.insets = new Insets(0, 0, 10, 10);
		gbc_btnSpeichern.gridx = 2;
		gbc_btnSpeichern.gridy = 8;
		add(btnSpeichern, gbc_btnSpeichern);
		
		btnAbbrechen = new JButton("abbrechen");
		btnAbbrechen.setFont(fontStd);
		GridBagConstraints gbc_btnAbbrechen = new GridBagConstraints();
		gbc_btnAbbrechen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAbbrechen.insets = new Insets(0, 0, 10, 10);
		gbc_btnAbbrechen.gridx = 3;
		gbc_btnAbbrechen.gridy = 8;
		add(btnAbbrechen, gbc_btnAbbrechen);
		
		
		txfTitel.addActionListener(this);
		txfMitwirkende.addActionListener(this);
		txfErsterscheinung.addActionListener(this);
		chkbxLive.addActionListener(this);
		btnSpeicherort.addActionListener(this);
		btnSpeichern.addActionListener(this);
		btnAbbrechen.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
//		Object source = e.getSource();
//		
//		try
//		{
//			switch (source)
//			{
//			case txfTitel:
//				String titel = txfTitel.getText();
//				break;
//			}	
//				
//				
//			
//		}
//		catch
//		{
//			
//		}
	}
}
