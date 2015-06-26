package gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.FlowLayout;
<<<<<<< HEAD

import javax.swing.JComboBox;
import javax.swing.JLabel;
=======
>>>>>>> branch 'master' of https://github.com/ColdanR/medienverwaltung.git

public class Startfenster extends JFrame implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	Container cp;
<<<<<<< HEAD
	
	private Font 	fontStd = new Font("Tahoma", Font.PLAIN, 14);
	private JPanel 	buttonPanel;
	private JLabel 	lblMusik;
	private JLabel 	lblKuenstler;
	private JButton btnMNeu;
	private JButton btnMAnzeigen;
	private JButton btnKNeu;
	private JButton btnKAnzeigen;
	
					
=======
>>>>>>> branch 'master' of https://github.com/ColdanR/medienverwaltung.git

	public Startfenster()							
	{
		super("Medien Verwaltung");
		cp = getContentPane();
		cp.setLayout(new BorderLayout());
				
<<<<<<< HEAD
		buttonPanel = new JPanel();
		buttonPanel.setAlignmentY(Component.TOP_ALIGNMENT);
=======
		JPanel buttonPanel = new JPanel();
		
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		gbl_buttonPanel.columnWidths = new int[] {100, 0};
		gbl_buttonPanel.rowHeights = new int[] {0, 0, 0, 30, 0};
		gbl_buttonPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_buttonPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		buttonPanel.setLayout(gbl_buttonPanel);
		
		JButton btnMusik = new JButton("Musik");
		btnMusik.setPreferredSize(new Dimension(100, 25));
		btnMusik.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_btnMusik = new GridBagConstraints();
		gbc_btnMusik.anchor = GridBagConstraints.WEST;
		gbc_btnMusik.insets = new Insets(10, 10, 10, 10);
		gbc_btnMusik.gridx = 0;
		gbc_btnMusik.gridy = 0;
		buttonPanel.add(btnMusik, gbc_btnMusik);		
		
		JButton btnVideo = new JButton("Video");
		btnVideo.setPreferredSize(new Dimension(100, 25));
		btnVideo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_btnVideo = new GridBagConstraints();
		gbc_btnVideo.anchor = GridBagConstraints.WEST;
		gbc_btnVideo.insets = new Insets(0, 10, 10, 10);
		gbc_btnVideo.gridx = 0;
		gbc_btnVideo.gridy = 1;
		buttonPanel.add(btnVideo, gbc_btnVideo);		
		
		JButton btnBuecher = new JButton("Bï¿½cher");
		btnBuecher.setPreferredSize(new Dimension(100, 25));
		btnBuecher.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 10, 10, 10);
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		buttonPanel.add(btnBuecher, gbc_btnNewButton);
		
		
>>>>>>> branch 'master' of https://github.com/ColdanR/medienverwaltung.git
		cp.add(buttonPanel, BorderLayout.WEST);
<<<<<<< HEAD
		
		
		GridLayout gl = new GridLayout(2,1);
		JPanel pnlGl1 = new JPanel();
		JPanel pnlGl2 = new JPanel();
		buttonPanel.setLayout(gl);
		buttonPanel.add(pnlGl1);
		buttonPanel.add(pnlGl2);
				
		
		GridBagLayout gbl_pnlGl1 = new GridBagLayout();
		gbl_pnlGl1.columnWidths = new int[] {100, 0};
		gbl_pnlGl1.rowHeights = new int[] {30, 0, 0, 0, 0};
		gbl_pnlGl1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlGl1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE, 0.0};
		pnlGl1.setLayout(gbl_pnlGl1);
		
		GridBagLayout gbl_pnlGl2 = new GridBagLayout();
		gbl_pnlGl2.columnWidths = new int[] {100, 0};
		gbl_pnlGl2.rowHeights = new int[] {30, 0, 0, 0, 0};
		gbl_pnlGl2.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlGl2.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE, 0.0};
		pnlGl2.setLayout(gbl_pnlGl2);
		
				
		lblMusik = new JLabel("Musik");
		lblMusik.setFont(fontStd);
		GridBagConstraints gbc_lblMusik = new GridBagConstraints();
		gbc_lblMusik.insets = new Insets(0, 10, 10, 10);
		gbc_lblMusik.gridx = 0;
		gbc_lblMusik.gridy = 1;
		pnlGl1.add(lblMusik, gbc_lblMusik);
		
		btnMNeu = new JButton("neu");
		btnMNeu.setPreferredSize(new Dimension(83, 25));
		btnMNeu.setFont(fontStd);
		GridBagConstraints gbc_btnMNeu = new GridBagConstraints();
		gbc_btnMNeu.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMNeu.insets = new Insets(0, 10, 10, 10);
		gbc_btnMNeu.gridx = 0;
		gbc_btnMNeu.gridy = 2;
		pnlGl1.add(btnMNeu, gbc_btnMNeu);
		
		btnMAnzeigen = new JButton("anzeigen");
		btnMAnzeigen.setFont(fontStd);
		GridBagConstraints gbc_btnMAnzeigen = new GridBagConstraints();
		gbc_btnMAnzeigen.anchor = GridBagConstraints.NORTH;
		gbc_btnMAnzeigen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMAnzeigen.insets = new Insets(0, 10, 10, 10);
		gbc_btnMAnzeigen.gridx = 0;
		gbc_btnMAnzeigen.gridy = 3;
		pnlGl1.add(btnMAnzeigen, gbc_btnMAnzeigen);
		
		lblKuenstler = new JLabel("Künstler");
		lblKuenstler.setFont(fontStd);
		GridBagConstraints gbc_lblKuenstler = new GridBagConstraints();
		gbc_lblKuenstler.insets = new Insets(0, 10, 10, 10);
		gbc_lblKuenstler.gridx = 0;
		gbc_lblKuenstler.gridy = 1;
		pnlGl2.add(lblKuenstler, gbc_lblKuenstler);
		
		btnKNeu = new JButton("neu");
		btnKNeu.setPreferredSize(new Dimension(83, 25));
		btnKNeu.setFont(fontStd);
		GridBagConstraints gbc_btnKNeu = new GridBagConstraints();
		gbc_btnKNeu.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnKNeu.insets = new Insets(0, 10, 10, 10);
		gbc_btnKNeu.gridx = 0;
		gbc_btnKNeu.gridy = 2;
		pnlGl2.add(btnKNeu, gbc_btnKNeu);
		
		btnKAnzeigen = new JButton("anzeigen");
		btnKAnzeigen.setFont(fontStd);
		GridBagConstraints gbc_btnKAnzeigen = new GridBagConstraints();
		gbc_btnKAnzeigen.anchor = GridBagConstraints.NORTH;
		gbc_btnKAnzeigen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnKAnzeigen.insets = new Insets(0, 10, 10, 10);
		gbc_btnKAnzeigen.gridx = 0;
		gbc_btnKAnzeigen.gridy = 3;
		pnlGl2.add(btnKAnzeigen, gbc_btnKAnzeigen);
=======
>>>>>>> branch 'master' of https://github.com/ColdanR/medienverwaltung.git
		
		
		InputPanel input = new InputPanel();
		input.setAlignmentY(Component.TOP_ALIGNMENT);
		cp.add(input, BorderLayout.CENTER);
		
<<<<<<< HEAD
//		southPanel = new JPanel();
//		FlowLayout flowLayout = (FlowLayout) southPanel.getLayout();
//		flowLayout.setVgap(10);
//		flowLayout.setHgap(10);
//		flowLayout.setAlignment(FlowLayout.RIGHT);
//			
//		btnSpeichern = new JButton("speichern");
//		southPanel.add(btnSpeichern);
//		
//		btnAbbrechen = new JButton("abbrechen");
//		southPanel.add(btnAbbrechen);
//		
//		cp.add(southPanel, BorderLayout.SOUTH);
=======
		JPanel southPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) southPanel.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		
		
		JButton btnSpeichern = new JButton("speichern");
		southPanel.add(btnSpeichern);
		
		JButton btnAbbrechen = new JButton("abbrechen");
		southPanel.add(btnAbbrechen);
		
		cp.add(southPanel, BorderLayout.SOUTH);
>>>>>>> branch 'master' of https://github.com/ColdanR/medienverwaltung.git
				
	}
	
	
	public static void main(String[] args) 
	{
		Startfenster mv = new Startfenster();
		mv.pack();
		mv.setVisible(true);
		mv.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mv.setLocationRelativeTo(null);
		mv.setResizable(false);
		
	

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//  XXX (JW) Auto-generated method stub
	}

}
