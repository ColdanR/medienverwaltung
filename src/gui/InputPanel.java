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
import javax.swing.border.BevelBorder;

public class InputPanel extends JPanel implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	
	private JTextField txfTitel;
	private JTextField txfInterpret;
	private JTextField txfMitwirkende;
	private JTextField txfAlbum;
	private JTextField txfErsterscheinung;
	private JTextField txfGenre;
	private JCheckBox chkbxLive;
	private Font fontStd = new Font("Tahoma", Font.PLAIN, 14);
	private BevelBorder brdBevel = new BevelBorder(BevelBorder.LOWERED);
	
	
	public InputPanel()
	{
		setAlignmentY(Component.TOP_ALIGNMENT);
		
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Musik",TitledBorder.LEADING , TitledBorder.TOP, null, null));		
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWidths = new int[] {30, 0, 200, 30, 0};
		gbl.rowHeights = new int[] {30, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl);
		
		JLabel lblTitel = new JLabel("Titel");
		lblTitel.setFont(fontStd);
		GridBagConstraints gbc_lblTitel = new GridBagConstraints();
		gbc_lblTitel.insets = new Insets(0, 0, 10, 10);
		gbc_lblTitel.anchor = GridBagConstraints.WEST;
		gbc_lblTitel.gridx = 1;
		gbc_lblTitel.gridy = 1;
		add(lblTitel, gbc_lblTitel);
		
		txfTitel = new JTextField();
		txfTitel.setBorder(brdBevel);
		txfTitel.setFont(fontStd);
		GridBagConstraints gbc_txfTitel = new GridBagConstraints();
		gbc_txfTitel.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfTitel.anchor = GridBagConstraints.WEST;
		gbc_txfTitel.insets = new Insets(0, 0, 10, 10);
		gbc_txfTitel.gridx = 2;
		gbc_txfTitel.gridy = 1;
		add(txfTitel, gbc_txfTitel);
		
		
		JLabel lblInterpret = new JLabel("Interpret");
		lblInterpret.setFont(fontStd);
		GridBagConstraints gbc_lblInterpret = new GridBagConstraints();
		gbc_lblInterpret.insets = new Insets(0, 0, 10, 10);
		gbc_lblInterpret.anchor = GridBagConstraints.WEST;
		gbc_lblInterpret.gridx = 1;
		gbc_lblInterpret.gridy = 2;
		add(lblInterpret, gbc_lblInterpret);
		
		txfInterpret = new JTextField();
		txfInterpret.setBorder(brdBevel);
		txfInterpret.setFont(fontStd);
		GridBagConstraints gbc_txfInterpret = new GridBagConstraints();
		gbc_txfInterpret.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfInterpret.anchor = GridBagConstraints.WEST;
		gbc_txfInterpret.insets = new Insets(0, 0, 10, 10);
		gbc_txfInterpret.gridx = 2;
		gbc_txfInterpret.gridy = 2;
		add(txfInterpret, gbc_txfInterpret);
		
		
		JLabel lblMitwirkende = new JLabel("Mitwirkende");
		lblMitwirkende.setFont(fontStd);
		GridBagConstraints gbc_lblMitwirkende = new GridBagConstraints();
		gbc_lblMitwirkende.anchor = GridBagConstraints.WEST;
		gbc_lblMitwirkende.insets = new Insets(0, 0, 10, 10);
		gbc_lblMitwirkende.gridx = 1;
		gbc_lblMitwirkende.gridy = 3;
		add(lblMitwirkende, gbc_lblMitwirkende);
		
		txfMitwirkende = new JTextField();
		txfMitwirkende.setBorder(brdBevel);
		txfMitwirkende.setFont(fontStd);
		GridBagConstraints gbc_txfMitwirkende = new GridBagConstraints();
		gbc_txfMitwirkende.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfMitwirkende.anchor = GridBagConstraints.WEST;
		gbc_txfMitwirkende.insets = new Insets(0,0,10,10);
		gbc_txfMitwirkende.gridx = 2;
		gbc_txfMitwirkende.gridy = 3;
		
		add(txfMitwirkende, gbc_txfMitwirkende);
		
		JLabel lblAlbum = new JLabel("Album");
		lblAlbum.setFont(fontStd);
		GridBagConstraints gbc_lblAlbum = new GridBagConstraints();
		gbc_lblAlbum.insets = new Insets(0, 0, 10, 10);
		gbc_lblAlbum.anchor = GridBagConstraints.WEST;
		gbc_lblAlbum.gridx = 1;
		gbc_lblAlbum.gridy = 4;
		add(lblAlbum, gbc_lblAlbum);
		
		txfAlbum = new JTextField();
		txfAlbum.setBorder(brdBevel);
		txfAlbum.setFont(fontStd);
		GridBagConstraints gbc_txfAlbum = new GridBagConstraints();
		gbc_txfAlbum.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfAlbum.anchor = GridBagConstraints.WEST;
		gbc_txfAlbum.insets = new Insets(0, 0, 10, 10);
		gbc_txfAlbum.gridx = 2;
		gbc_txfAlbum.gridy = 4;
		add(txfAlbum, gbc_txfAlbum);
		txfAlbum.setColumns(20);
		
				
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setFont(fontStd);
		GridBagConstraints gbc_lblGenre = new GridBagConstraints();
		gbc_lblGenre.anchor = GridBagConstraints.WEST;
		gbc_lblGenre.insets = new Insets(0, 0, 10, 10);
		gbc_lblGenre.gridx = 1;
		gbc_lblGenre.gridy = 5;
		add(lblGenre, gbc_lblGenre);
		
		txfGenre = new JTextField();
		txfGenre.setBorder(brdBevel);
		txfGenre.setFont(fontStd);
		GridBagConstraints gbc_txfGenre = new GridBagConstraints();
		gbc_txfGenre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfGenre.anchor = GridBagConstraints.WEST;
		gbc_txfGenre.insets = new Insets(0, 0, 10, 10);
		gbc_txfGenre.gridx = 2;
		gbc_txfGenre.gridy = 5;
		add(txfGenre, gbc_txfGenre);
		txfGenre.setColumns(20);
		
		JLabel lblErsterscheinung = new JLabel("Erstausgabe");
		lblErsterscheinung.setFont(fontStd);
		GridBagConstraints gbc_lblErsterscheinung = new GridBagConstraints();
		gbc_lblErsterscheinung.anchor = GridBagConstraints.WEST;
		gbc_lblErsterscheinung.insets = new Insets(0, 0, 10, 10);
		gbc_lblErsterscheinung.gridx = 1;
		gbc_lblErsterscheinung.gridy = 6;
		add(lblErsterscheinung, gbc_lblErsterscheinung);
		
		txfErsterscheinung = new JTextField();
		txfErsterscheinung.setBorder(brdBevel);
		txfErsterscheinung.setFont(fontStd);
		GridBagConstraints gbc_txfErsterscheinung = new GridBagConstraints();
		gbc_txfErsterscheinung.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfErsterscheinung.anchor = GridBagConstraints.WEST;
		gbc_txfErsterscheinung.insets = new Insets(0, 0, 10, 10);
		gbc_txfErsterscheinung.gridx = 2;
		gbc_txfErsterscheinung.gridy = 6;
		add(txfErsterscheinung, gbc_txfErsterscheinung);
		txfErsterscheinung.setColumns(20);
		
		chkbxLive = new JCheckBox("Live?");
		chkbxLive.setActionCommand("Live");
		chkbxLive.setFont(fontStd);
		GridBagConstraints gbc_chkbxLive = new GridBagConstraints();
		gbc_chkbxLive.anchor = GridBagConstraints.WEST;
		gbc_chkbxLive.insets = new Insets(0, 0, 10, 10);
		gbc_chkbxLive.gridx = 2;
		gbc_chkbxLive.gridy = 7;
		add(chkbxLive, gbc_chkbxLive);
		
		txfTitel.addActionListener(this);
		txfInterpret.addActionListener(this);
		txfMitwirkende.addActionListener(this);
		txfAlbum.addActionListener(this);
		txfErsterscheinung.addActionListener(this);
		txfGenre.addActionListener(this);
		chkbxLive.addActionListener(this);
		
		
		
		
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
