package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import data.medien.Musik;
import data.medien.logic.MusikLogik;
import enums.ErrorMessage;
import enums.ErrorsGUI;
import gui.dialog.FehlerDialog;
import gui.renderer.MusikListRenderer;

public class MusikListPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -715456937252986232L;
	private JLabel			lblHeader;
	private JList<Musik>	lstMusikList;
	private JButton			btnBearbeiten;
	private JButton			btnLoeschen;
	private JScrollPane 	scrollPane;
	private JPanel 			pnlCenter;
	private Startfenster	parent;

	public MusikListPanel(Startfenster parent) {
		this.parent = parent;
		setAlignmentY(Component.TOP_ALIGNMENT);
		creatMusikListPanel();
		
		btnBearbeiten.addActionListener(this);
		btnLoeschen.addActionListener(this);
	}
	
	public void creatMusikListPanel(){
		this.setMinimumSize(StaticComponents.MAIN_PANEL);
		this.setLayout(new BorderLayout());
		
		JPanel pnlNorth		= new JPanel();
			   pnlCenter	= new JPanel();
		JPanel pnlSouth		= new JPanel();
		
		pnlCenter.setLayout(new BorderLayout());
		
		pnlNorth.setBorder(StaticComponents.BORDER_PANEL);
		pnlCenter.setBorder(new CompoundBorder(StaticComponents.BORDER_PANEL, new EmptyBorder(10, 10, 10, 10)));
		pnlSouth.setBorder(StaticComponents.BORDER_PANEL);
			
		this.add(pnlNorth, BorderLayout.NORTH);
		this.add(pnlCenter, BorderLayout.CENTER);
		this.add(pnlSouth, BorderLayout.SOUTH);
		
		//Header
		lblHeader = new JLabel("Musik anzeigen");
		lblHeader.setFont(StaticComponents.FONT_TITLE);
		pnlNorth.add(lblHeader);
		
		//Center
		generateList();
		
		
		//Footer
		pnlSouth.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		
		btnBearbeiten = new JButton("Bearbeiten");
		btnBearbeiten.setFont(StaticComponents.FONT_BUTTON);
		pnlSouth.add(btnBearbeiten);
		
		btnLoeschen = new JButton("L\u00F6schen");
		btnLoeschen.setFont(StaticComponents.FONT_BUTTON);
		pnlSouth.add(btnLoeschen);
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == btnLoeschen)
		{
			if (lstMusikList.isSelectionEmpty()) {
				List<ErrorMessage> errors = new ArrayList<ErrorMessage>();
				errors.add(ErrorsGUI.NoSelection);
				JDialog	errorDialog = new FehlerDialog(null, errors);
				errorDialog.setVisible(true);
				return;
			}
			Musik selected = lstMusikList.getSelectedValue();
			MusikLogik logik = new MusikLogik();
			if (logik.loadObject(selected.getId()) && logik.delete()) {
				generateList();
			} else {
				FehlerDialog dialogFehler = new FehlerDialog(null, logik.getErrors());
				dialogFehler.setVisible(true);
			}
		}
		else if (source == btnBearbeiten)
		{
			if (lstMusikList.isSelectionEmpty()) {
				List<ErrorMessage> errors = new ArrayList<ErrorMessage>();
				errors.add(ErrorsGUI.NoSelection);
				JDialog	errorDialog = new FehlerDialog(null, errors);
				errorDialog.setVisible(true);
				return;
			}
			Musik selected = lstMusikList.getSelectedValue();
			MusikEingabePanel panel = new MusikEingabePanel(parent, selected);
			parent.setPanel(panel);
			parent.setPreferredSize(getMaximumSize());
			generateList();
		}
	}
	private void generateList() {
		MusikLogik		logik		=	new MusikLogik();
		List<Musik>		listData	=	logik.getAll();
		if (scrollPane != null) {
			pnlCenter.remove(scrollPane);
		}
		if (logik.getErrors().isEmpty()) 
		{
			lstMusikList = new JList<Musik>(listData.toArray(new Musik[]{}));
			lstMusikList.setCellRenderer(new MusikListRenderer());
			lstMusikList.setVisibleRowCount(5);
			lstMusikList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			scrollPane = new JScrollPane(lstMusikList,
					ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
		            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			
			pnlCenter.add(scrollPane, BorderLayout.CENTER);
		} 
		else 
		{
			pnlCenter.removeAll();
			pnlCenter.add(new JLabel("Leider sind Fehler aufgetreten"));
			for (ErrorMessage error : logik.getErrors()) 
			{
				pnlCenter.add(new JLabel(error.getErrorMessage()));
			}
		}
		pnlCenter.revalidate();
		pnlCenter.repaint();
	}
}
