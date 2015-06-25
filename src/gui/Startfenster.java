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
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class Startfenster extends JFrame implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	Container cp;
	private String[] selectMusik = {"anzeigen","anlegen"};
	private Font fontStd = new Font("Tahoma", Font.PLAIN, 14);
	private JPanel 	buttonPanel, southPanel;
	private JButton btnSpeichern, btnAbbrechen;
	private JComboBox cbxMusik;
	private JLabel lblMusik;
					

	public Startfenster()							
	{
		super("Medien Verwaltung");
		cp = getContentPane();
		cp.setLayout(new BorderLayout());
				
		buttonPanel = new JPanel();
		
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		gbl_buttonPanel.columnWidths = new int[] {100, 0};
		gbl_buttonPanel.rowHeights = new int[] {0, 0, 0, 30, 0};
		gbl_buttonPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_buttonPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		buttonPanel.setLayout(gbl_buttonPanel);
		
//		JButton btnMusik = new JButton("Musik");
//		btnMusik.setPreferredSize(new Dimension(100, 25));
//		btnMusik.setFont(fontStd);
//		GridBagConstraints gbc_btnMusik = new GridBagConstraints();
//		gbc_btnMusik.anchor = GridBagConstraints.WEST;
//		gbc_btnMusik.insets = new Insets(10, 10, 10, 10);
//		gbc_btnMusik.gridx = 0;
//		gbc_btnMusik.gridy = 0;
//		buttonPanel.add(btnMusik, gbc_btnMusik);		
		
//		JButton btnVideo = new JButton("Video");
//		btnVideo.setPreferredSize(new Dimension(100, 25));
//		btnVideo.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		GridBagConstraints gbc_btnVideo = new GridBagConstraints();
//		gbc_btnVideo.anchor = GridBagConstraints.WEST;
//		gbc_btnVideo.insets = new Insets(0, 10, 10, 10);
//		gbc_btnVideo.gridx = 0;
//		gbc_btnVideo.gridy = 1;
//		buttonPanel.add(btnVideo, gbc_btnVideo);		
//		
//		JButton btnBuecher = new JButton("Bücher");
//		btnBuecher.setPreferredSize(new Dimension(100, 25));
//		btnBuecher.setFont(new Font("Tahoma", Font.PLAIN, 12));
//		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
//		gbc_btnNewButton.insets = new Insets(0, 10, 10, 10);
//		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
//		gbc_btnNewButton.gridx = 0;
//		gbc_btnNewButton.gridy = 2;
//		buttonPanel.add(btnBuecher, gbc_btnNewButton);
		
		
		cp.add(buttonPanel, BorderLayout.WEST);
		
		lblMusik = new JLabel("Musik");
		lblMusik.setFont(fontStd);
		GridBagConstraints gbc_lblMusik = new GridBagConstraints();
		gbc_lblMusik.insets = new Insets(0, 10, 10, 10);
		gbc_lblMusik.gridx = 0;
		gbc_lblMusik.gridy = 1;
		buttonPanel.add(lblMusik, gbc_lblMusik);
		
		
		cbxMusik = new JComboBox(selectMusik);
		cbxMusik.setFont(fontStd);
		
		GridBagConstraints gbc_cbxMusik = new GridBagConstraints();
		gbc_cbxMusik.insets = new Insets(0, 10, 10, 10);
		gbc_cbxMusik.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxMusik.gridx = 0;
		gbc_cbxMusik.gridy = 2;
		buttonPanel.add(cbxMusik, gbc_cbxMusik);
		
		
		InputPanel input = new InputPanel();
		input.setAlignmentY(Component.TOP_ALIGNMENT);
		cp.add(input, BorderLayout.CENTER);
		
		southPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) southPanel.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		
		
		btnSpeichern = new JButton("speichern");
		southPanel.add(btnSpeichern);
		
		btnAbbrechen = new JButton("abbrechen");
		southPanel.add(btnAbbrechen);
		
		cp.add(southPanel, BorderLayout.SOUTH);
				
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
	public void actionPerformed(ActionEvent arg0) 
	{
		//  XXX (JW) Auto-generated method stub
	}

}