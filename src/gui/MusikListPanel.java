package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import data.medien.Musik;
import data.medien.logic.MusikLogik;
import enums.ErrorMessage;
import gui.renderer.MusikListRenderer;

public class MusikListPanel extends JPanel implements ActionListener {
	private JLabel			lblHeader;
	private JList<Musik>	lstMusikList;
	private JButton			btnBearbeiten;
	private JButton			btnLoeschen;
	private JScrollPane scrollPane;

	public MusikListPanel() {
		setAlignmentY(Component.TOP_ALIGNMENT);
		creatMusikListPanel();
		
		btnBearbeiten.addActionListener(this);
		btnLoeschen.addActionListener(this);
	}
	
	public void creatMusikListPanel(){
		this.setMinimumSize(new Dimension (300, 300));
		this.setLayout(new BorderLayout());
		
		JPanel pnlNorth		= new JPanel();
		JPanel pnlCenter	= new JPanel();
		JPanel pnlSouth		= new JPanel();

		pnlNorth.setBorder(StaticComponents.BORDER_PANEL);
		pnlSouth.setBorder(StaticComponents.BORDER_PANEL);
		pnlCenter.setBorder(StaticComponents.BORDER_PANEL);
		
		this.add(pnlNorth, BorderLayout.NORTH);
		this.add(pnlCenter, BorderLayout.CENTER);
		this.add(pnlSouth, BorderLayout.SOUTH);
		
		//Header
		lblHeader = new JLabel("Musik anzeige");
		lblHeader.setFont(StaticComponents.FONT_TITLE);
		pnlNorth.add(lblHeader);
		
		//Center
		// Main
		MusikLogik		logik		=	new MusikLogik();
		List<Musik>		listData	=	logik.getAll();
		
		if (logik.getErrors().isEmpty()) 
		{
			lstMusikList = new JList<Musik>(listData.toArray(new Musik[]{}));
			lstMusikList.setCellRenderer(new MusikListRenderer());
			lstMusikList.setVisibleRowCount(5);
			lstMusikList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane = new JScrollPane(lstMusikList,
					ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
		            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			pnlCenter.add(scrollPane);
		} 
		else 
		{
			pnlCenter.add(new JLabel("Leider sind Fehler aufgetreten"));
			for (ErrorMessage error : logik.getErrors()) 
			{
				pnlCenter.add(new JLabel(error.getErrorMessage()));
			}
		}
		
		
		//Footer
		btnBearbeiten = new JButton("Bearbeiten");
		btnBearbeiten.setFont(StaticComponents.FONT_BUTTON);
		pnlSouth.add(btnBearbeiten);
		btnLoeschen = new JButton("Löschen");
		btnLoeschen.setFont(StaticComponents.FONT_BUTTON);
		pnlSouth.add(btnLoeschen);
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		
		if (source == btnLoeschen)
		{
			Musik selected = lstMusikList.getSelectedValue();
		}
		else if (source == btnBearbeiten)
		{
			Musik selecte = lstMusikList.getSelectedValue();
		}
	}

}
