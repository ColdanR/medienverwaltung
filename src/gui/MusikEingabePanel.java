package gui;

import gui.dialog.FehlerDialog;
import gui.dialog.PersonAuswahlDialog;
import gui.dialog.Speicherort;
import gui.renderer.SpeicherortListRenderer;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.ListModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;

import javax.swing.JList;

import data.Person;
import data.SpeicherFormatInterface;
import data.medien.Musik;
import data.medien.logic.MusikLogik;
import data.speicherformate.DigitalMusik;
import data.speicherformate.logic.SpeicherFormateLogik;
import enums.ErrorMessage;
import enums.ErrorsGUI;

import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;

public class MusikEingabePanel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private Startfenster					source;
	private JTextField 						txfTitel;
	private JTextField 						txfErsterscheinung;
	private JCheckBox 						chkbxLive;
	private JButton 						btnNeu;
	private JButton 						btnLoeschen;
	private JButton 						btnAbbrechen;
	private JButton 						btnSpeichern;
	private	JButton							btnInterpret;
	private	JLabel							lblInterpretAnzeige;
	private JList<SpeicherFormatInterface>	lstSpeicherort;
	private Person							interpret;
	private Musik							musik;
	private static DateTimeFormatter		formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	
	
	public MusikEingabePanel(Startfenster source, Musik musik) {
		this.musik = musik;
		this.source = source;
		setAlignmentY(Component.TOP_ALIGNMENT);
		createMusikEingabePanel();
		btnNeu.addActionListener(this);
		btnLoeschen.addActionListener(this);
		btnSpeichern.addActionListener(this);
		btnAbbrechen.addActionListener(this);
		btnInterpret.addActionListener(this);
	}
	
	private void createMusikEingabePanel()	{
		
		this.setMinimumSize(StaticComponents.MAIN_PANEL);
		this.setLayout(new BorderLayout());
		
		JPanel pnlNorth		= new JPanel();
		JPanel pnlCenter	= new JPanel();
		JPanel pnlSouth		= new JPanel();
		
		pnlNorth.setBorder(StaticComponents.BORDER_PANEL);
		pnlCenter.setBorder(StaticComponents.BORDER_PANEL);
		pnlSouth.setBorder(StaticComponents.BORDER_PANEL);
		
		this.add(pnlNorth, BorderLayout.NORTH);
		this.add(pnlCenter, BorderLayout.CENTER);
		this.add(pnlSouth, BorderLayout.SOUTH);
		
		// Header
		JLabel lblMusikEingabe = new JLabel("Musik Eingabe");
		lblMusikEingabe.setFont(StaticComponents.FONT_TITLE);
		pnlNorth.add(lblMusikEingabe);
			
		// creating BorderLayout.CENTER Components
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWidths = new int[] {30, 0, 0, 0, 0, 30, 0};
		gbl.rowHeights = new int[] {30, 0, 0, 0, 0, 0, 0, 30, 0};
		gbl.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		if (musik != null) {
			txfTitel.setText(musik.getTitel());
		}
		StaticComponents.setFontBorderTextField(txfTitel);
		GridBagConstraints gbc_txfTitel = new GridBagConstraints();
		gbc_txfTitel.gridwidth = 3;
		gbc_txfTitel.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfTitel.anchor = GridBagConstraints.WEST;
		gbc_txfTitel.insets = new Insets(0, 0, 10, 5);
		gbc_txfTitel.gridx = 2;
		gbc_txfTitel.gridy = 1;
		pnlCenter.add(txfTitel, gbc_txfTitel);
		
		JLabel lblErsterscheinung = new JLabel("Erstausgabe");
		StaticComponents.setFontLabel(lblErsterscheinung);
		GridBagConstraints gbc_lblErsterscheinung = new GridBagConstraints();
		gbc_lblErsterscheinung.anchor = GridBagConstraints.WEST;
		gbc_lblErsterscheinung.insets = new Insets(0, 0, 10, 10);
		gbc_lblErsterscheinung.gridx = 1;
		gbc_lblErsterscheinung.gridy = 2;
		pnlCenter.add(lblErsterscheinung, gbc_lblErsterscheinung);
		
		txfErsterscheinung = new JTextField();
		if (musik != null) {
			txfErsterscheinung.setText(formatter.format(musik.getErsterscheinung()));
		}
		txfErsterscheinung.setColumns(15);
		StaticComponents.setFontBorderTextField(txfErsterscheinung);
		GridBagConstraints gbc_txfErsterscheinung = new GridBagConstraints();
		gbc_txfErsterscheinung.anchor = GridBagConstraints.WEST;
		gbc_txfErsterscheinung.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfErsterscheinung.insets = new Insets(0, 0, 10, 10);
		gbc_txfErsterscheinung.gridx = 2;
		gbc_txfErsterscheinung.gridy = 2;
		pnlCenter.add(txfErsterscheinung, gbc_txfErsterscheinung);
		
		
		chkbxLive = new JCheckBox("Live");
		if (musik != null) {
			chkbxLive.setSelected(musik.isLive());
		}
		chkbxLive.setMargin(new Insets(2, 0, 2, 2));
		chkbxLive.setIconTextGap(10);
		chkbxLive.setHorizontalTextPosition(SwingConstants.LEFT);
		chkbxLive.setActionCommand("Live");
		StaticComponents.setFontLabel(chkbxLive);
		GridBagConstraints gbc_chkbxLive = new GridBagConstraints();
		gbc_chkbxLive.anchor = GridBagConstraints.WEST;
		gbc_chkbxLive.insets = new Insets(0, 0, 10, 5);
		gbc_chkbxLive.gridx = 4;
		gbc_chkbxLive.gridy = 2;
		pnlCenter.add(chkbxLive, gbc_chkbxLive);
		
		JLabel lblInterpret = new JLabel("Interpret");
		StaticComponents.setFontLabel(lblInterpret);
		GridBagConstraints gbc_lblInterpret = new GridBagConstraints();
		gbc_lblInterpret.anchor = GridBagConstraints.WEST;
		gbc_lblInterpret.insets = new Insets(0, 0, 10, 10);
		gbc_lblInterpret.gridx = 1;
		gbc_lblInterpret.gridy = 3;
		pnlCenter.add(lblInterpret, gbc_lblInterpret);
		
		lblInterpretAnzeige = new JLabel();
		StaticComponents.setFontBorderLabel(lblInterpretAnzeige);
		GridBagConstraints gbc_lblInterpretAnzeige = new GridBagConstraints();
		gbc_lblInterpretAnzeige.gridwidth = 2;
		gbc_lblInterpretAnzeige.anchor = GridBagConstraints.WEST;
		gbc_lblInterpretAnzeige.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblInterpretAnzeige.insets = new Insets(0, 0, 10, 10);
		gbc_lblInterpretAnzeige.gridx = 2;
		gbc_lblInterpretAnzeige.gridy = 3;
		pnlCenter.add(lblInterpretAnzeige, gbc_lblInterpretAnzeige);
		if (musik != null) {
			interpret = musik.getInterpret();
		}
		setInterpretLabel();
		
		btnInterpret = new JButton("Ausw\u00E4hlen");
		btnInterpret.setFont(StaticComponents.FONT_BUTTON);
		GridBagConstraints gbc_btnInterpret = new GridBagConstraints();
		gbc_btnInterpret.anchor = GridBagConstraints.WEST;
		gbc_btnInterpret.insets = new Insets(0, 0, 10, 5);
		gbc_btnInterpret.gridx = 4;
		gbc_btnInterpret.gridy = 3;
		pnlCenter.add(btnInterpret, gbc_btnInterpret);
		
		JLabel lblSpeicherort = new JLabel("Speicherort");
		StaticComponents.setFontLabel(lblSpeicherort);
		GridBagConstraints gbc_lblSpeicherort = new GridBagConstraints();
		gbc_lblSpeicherort.anchor = GridBagConstraints.WEST;
		gbc_lblSpeicherort.insets = new Insets(0, 0, 10, 10);
		gbc_lblSpeicherort.gridx = 1;
		gbc_lblSpeicherort.gridy = 4;
		pnlCenter.add(lblSpeicherort, gbc_lblSpeicherort);
		
		lstSpeicherort = new JList<SpeicherFormatInterface>();
		lstSpeicherort.setCellRenderer(new SpeicherortListRenderer());
		lstSpeicherort.setVisibleRowCount(5);
		lstSpeicherort.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		if (musik != null) {
			lstSpeicherort.setListData(musik.getSpeicherformate().toArray(new SpeicherFormatInterface[]{}));
		}
		JScrollPane scp_lst = new JScrollPane();
		scp_lst.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scp_lst.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scp_lst.setAlignmentX(Component.LEFT_ALIGNMENT);
		scp_lst.setViewportView(lstSpeicherort);
		GridBagConstraints gbc_scp_lst = new GridBagConstraints();
		gbc_scp_lst.anchor = GridBagConstraints.WEST;
		gbc_scp_lst.gridwidth = 3;
		gbc_scp_lst.insets = new Insets(0, 0, 10, 10);
		gbc_scp_lst.fill = GridBagConstraints.HORIZONTAL;
		gbc_scp_lst.gridx = 1;
		gbc_scp_lst.gridy = 5;
		gbc_scp_lst.gridwidth = 2;
		pnlCenter.add(scp_lst, gbc_scp_lst);
		
		btnNeu = new JButton("Neu");
		btnNeu.setFont(StaticComponents.FONT_BUTTON);
		GridBagConstraints gbc_btnNeu = new GridBagConstraints();
		gbc_btnNeu.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNeu.insets = new Insets(0, 0, 5, 10);
		gbc_btnNeu.gridx = 1;
		gbc_btnNeu.gridy = 6;
		pnlCenter.add(btnNeu, gbc_btnNeu);
		
		btnLoeschen = new JButton("L\u00F6schen");
		btnLoeschen.setFont(StaticComponents.FONT_BUTTON);
		GridBagConstraints gbc_btnLoeschen = new GridBagConstraints();
		gbc_btnLoeschen.anchor = GridBagConstraints.WEST;
		gbc_btnLoeschen.insets = new Insets(0, 0, 5, 10);
		gbc_btnLoeschen.gridx = 2;
		gbc_btnLoeschen.gridy = 6;
		pnlCenter.add(btnLoeschen, gbc_btnLoeschen);
				
		// creating BorderLayout.SOUTH Components
		FlowLayout fl_pnlSouth = (FlowLayout) pnlSouth.getLayout();
		fl_pnlSouth.setVgap(10);
		fl_pnlSouth.setHgap(10);
		fl_pnlSouth.setAlignment(FlowLayout.RIGHT);
		pnlSouth.setBorder(StaticComponents.BORDER_PANEL);
		
		btnSpeichern = new JButton("Speichern");
		btnSpeichern.setFont(StaticComponents.FONT_BUTTON);
		pnlSouth.add(btnSpeichern);
		
		btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setFont(StaticComponents.FONT_BUTTON);
		pnlSouth.add(btnAbbrechen);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == btnNeu) {
			Speicherort dialog = new Speicherort(this.source);
			if (musik != null) {
				dialog.setMusicId(musik.getId());
			}
			dialog.display();

			List<SpeicherFormatInterface> list = new ArrayList<SpeicherFormatInterface>();
			ListModel<SpeicherFormatInterface> modell = lstSpeicherort.getModel();
			for (int i = 0; i < modell.getSize(); i++) {
				list.add(modell.getElementAt(i));
			}
			list.add(dialog.getObject());
			lstSpeicherort.setListData(list.toArray(new SpeicherFormatInterface[]{}));
			lstSpeicherort.revalidate();
			lstSpeicherort.repaint();
		} else if (source == btnLoeschen) {
			List<ErrorMessage> errors = new ArrayList<ErrorMessage>();
			if (lstSpeicherort.getSelectedValue() == null) {
				errors.add(ErrorsGUI.NoSelection);
			} else {
				SpeicherFormateLogik logik = new SpeicherFormateLogik();
				SpeicherFormatInterface object = lstSpeicherort.getSelectedValue();
				switch (object.getType()) {
				case DigitalMusik:
					if (object instanceof DigitalMusik) {
						DigitalMusik musik = (DigitalMusik) object;
						if (logik.loadObject(musik.getId()) && logik.delete()) {
							List<SpeicherFormatInterface> list = new ArrayList<SpeicherFormatInterface>();
							ListModel<SpeicherFormatInterface> modell = lstSpeicherort.getModel();
							for (int i = 0; i < modell.getSize(); i++) {
								list.add(modell.getElementAt(i));
							}
							list.remove(object);
							lstSpeicherort.setListData(list.toArray(new SpeicherFormatInterface[]{}));
							lstSpeicherort.revalidate();
							lstSpeicherort.repaint();
						}
					}
					break;
				default:
					throw new UnsupportedOperationException("Nicht implementiert!");
				}
				if (logik.getErrors().size() > 0) {
					errors.addAll(logik.getErrors());
				}
			}
			if (errors.size() > 0) {
				FehlerDialog fehlerDialog = new FehlerDialog(this.source, errors);
				fehlerDialog.setAlwaysOnTop(true);
				fehlerDialog.setVisible(true);
			}
		} else if (source == btnSpeichern) {
			List<ErrorMessage> errors = new ArrayList<ErrorMessage>();
			MusikLogik logik  = new MusikLogik();
			List<SpeicherFormatInterface> list = new ArrayList<SpeicherFormatInterface>();
			ListModel<SpeicherFormatInterface> modell = lstSpeicherort.getModel();
			for (int i = 0; i < modell.getSize(); i++) {
				list.add(modell.getElementAt(i));
			}
			LocalDate date = null;
			try {
				 date = LocalDate.from(formatter.parse(txfErsterscheinung.getText()));
			} catch (DateTimeException ex) {
				errors.add(ErrorsGUI.NoDateFormat);
			}
			boolean operationOk = false;
			String titel = txfTitel.getText();
			boolean live = chkbxLive.isSelected();
			if (musik == null) {
				operationOk = logik.createNew(titel, interpret, date, list, live);
			} else {
				operationOk = logik.loadObject(musik.getId()) && logik.editLoaded(titel, interpret, date, list, live);
			}
			if (errors.size() == 0 && operationOk) {
				if (logik.write()) {
					// XXX Rückführung angepasst
					if (musik == null) {
						this.source.setPanel(new StartPanel());
					} else {
						this.source.setPanel(new MusikListPanel(this.source));
					}
				}
			}
			if (errors.size() > 0 || logik.getErrors().size() > 0) {
				errors.addAll(logik.getErrors());
				FehlerDialog fehlerDialog = new FehlerDialog(this.source, errors);
				fehlerDialog.setAlwaysOnTop(true);
				fehlerDialog.setVisible(true);
			}
		} else if (source == btnAbbrechen) {
			// XXX Rückführung angepasst
			if (musik == null) {
				this.source.setPanel(new StartPanel());
			} else {
				this.source.setPanel(new MusikListPanel(this.source));
			}
		} else if (source == btnInterpret) {
			PersonAuswahlDialog dialog = new PersonAuswahlDialog(this.source.getOwner());
			dialog.display();
			interpret = dialog.getObject();
			setInterpretLabel();
		}
	}

	public Musik getMusik() {
		return musik;
	}

	public void setMusik(Musik musik) {
		this.musik = musik;
	}
	
	private void setInterpretLabel() {
		StringBuilder	text	=	new StringBuilder();
		if (interpret != null) {
			text.append(interpret.getKuenstlername());
			if (interpret.getNachname().length() > 0 || interpret.getVorname().length() > 0) {
				text.append(" (");
				if (interpret.getNachname().length() > 0) {
					text.append(interpret.getNachname());
				}
				if (interpret.getNachname().length() > 0 && interpret.getVorname().length() > 0) {
					text.append(", ");
				}
				if (interpret.getVorname().length() > 0) {
					text.append(interpret.getVorname());
				}
				text.append(")");
			}
		} else {
			text.append(" ");
		}
		lblInterpretAnzeige.setText(text.toString());
	}
}
