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

public class InputPanel extends JPanel implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	
	private JTextField txfTitel;
	private JTextField txfInterpret;
	private JTextField txfMitwirkende;
	private JTextField txfAlbum;
	private JTextField txfErsterscheinung;
	private JTextField txfGenre;
	
	
	public InputPanel()
	{
		//super();
		setAlignmentY(Component.TOP_ALIGNMENT);
		
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "CD",TitledBorder.LEADING , TitledBorder.TOP, null, null));		
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWidths = new int[]{30, 0, 0, 0, 0};
		gbl.rowHeights = new int[] {30, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl);
		
		JLabel lblTitel = new JLabel("Titel");
		lblTitel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblTitel = new GridBagConstraints();
		gbc_lblTitel.insets = new Insets(0, 0, 10, 10);
		gbc_lblTitel.anchor = GridBagConstraints.WEST;
		gbc_lblTitel.gridx = 1;
		gbc_lblTitel.gridy = 1;
		add(lblTitel, gbc_lblTitel);
		
		txfTitel = new JTextField();
		txfTitel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_txfTitel = new GridBagConstraints();
		gbc_txfTitel.anchor = GridBagConstraints.WEST;
		gbc_txfTitel.insets = new Insets(0, 0, 10, 10);
		gbc_txfTitel.gridx = 2;
		gbc_txfTitel.gridy = 1;
		txfTitel.setColumns(20);
		add(txfTitel, gbc_txfTitel);
		
		
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
		
		JLabel lblMitwirkende = new JLabel("Mitwirkende");
		lblMitwirkende.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblMitwirkende = new GridBagConstraints();
		gbc_lblMitwirkende.anchor = GridBagConstraints.WEST;
		gbc_lblMitwirkende.insets = new Insets(0, 0, 10, 10);
		gbc_lblMitwirkende.gridx = 1;
		gbc_lblMitwirkende.gridy = 3;
		add(lblMitwirkende, gbc_lblMitwirkende);
		
		txfMitwirkende = new JTextField();
		txfMitwirkende.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_txfMitwirkende = new GridBagConstraints();
		gbc_txfMitwirkende.anchor = GridBagConstraints.WEST;
		gbc_txfMitwirkende.insets = new Insets(0,0,10,10);
		gbc_txfMitwirkende.gridx = 2;
		gbc_txfMitwirkende.gridy = 3;
		txfMitwirkende.setColumns(20);
		add(txfMitwirkende, gbc_txfMitwirkende);
		
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
		
		JLabel lblErsterscheinung = new JLabel("Erstausgabe");
		lblErsterscheinung.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblErsterscheinung = new GridBagConstraints();
		gbc_lblErsterscheinung.anchor = GridBagConstraints.WEST;
		gbc_lblErsterscheinung.insets = new Insets(0, 0, 10, 10);
		gbc_lblErsterscheinung.gridx = 1;
		gbc_lblErsterscheinung.gridy = 6;
		add(lblErsterscheinung, gbc_lblErsterscheinung);
		
		txfErsterscheinung = new JTextField();
		txfErsterscheinung.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_txfErsterscheinung = new GridBagConstraints();
		gbc_txfErsterscheinung.anchor = GridBagConstraints.WEST;
		gbc_txfErsterscheinung.insets = new Insets(0, 0, 10, 10);
		gbc_txfErsterscheinung.gridx = 2;
		gbc_txfErsterscheinung.gridy = 6;
		add(txfErsterscheinung, gbc_txfErsterscheinung);
		txfErsterscheinung.setColumns(20);
		
		JCheckBox chkbxLive = new JCheckBox("Live?");
		chkbxLive.setActionCommand("Live");
		chkbxLive.setFont(new Font("Tahoma", Font.PLAIN, 12));
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
