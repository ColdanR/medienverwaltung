package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class Speicherort extends JDialog implements ActionListener
{
	 private static final long serialVersionUID = 1L;

	    Container cp = getContentPane();
	    private JTextField txfFormat;
	    private JTextField txfDatentraeger;
	    private JTextField txfPfad;
	    private JTextField txfDateiformat;
	    private Font fontStd = new Font("Tahoma", Font.PLAIN, 14);
	    private BevelBorder brdBevel = new BevelBorder(BevelBorder.LOWERED);
	    private JLabel lblDateiformat, lblQualitaet;
	    private GridBagConstraints gbc_lblDateiformat;
	    private GridBagConstraints gbc_txfDateiformat;
	    private GridBagConstraints gbc_lblQualitaet;
		
	    
	    public Speicherort()
	    {
	    	setTitle("Speicherort");
	    	setModal(true);
	       	setLocationRelativeTo(null);
			setResizable(false);
	    	
	    	cp.setLayout(new BorderLayout());
	    	
	    	JPanel pnlNorth = new JPanel();
	    	FlowLayout fl_pnlNorth = new FlowLayout();
	    	fl_pnlNorth.setAlignment(FlowLayout.CENTER);
			pnlNorth.setLayout(fl_pnlNorth);
			JLabel lblInterpret = new JLabel("Speicherort");
	    	lblInterpret.setFont(new Font("Tahoma", Font.BOLD, 16));
	    	pnlNorth.add(lblInterpret);
			cp.add(pnlNorth, BorderLayout.NORTH);
			
			GridBagLayout gbl = new GridBagLayout();
	    	gbl.columnWidths = new int[] {30, 0, 200, 30};
	    	gbl.rowHeights = new int[] {30, 0, 0, 0, 0, 0, 0, 30};
	    	gbl.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
	    	gbl.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	    	
	    	JPanel pnlCenter = new JPanel();
	    	pnlCenter.setLayout(gbl);
	    	    	
//	    	JLabel lblFormat = new JLabel("Format");
//	    	lblFormat.setFont(fontStd);
//	    	GridBagConstraints gbc_lblFormat = new GridBagConstraints();
//	    	gbc_lblFormat.anchor = GridBagConstraints.WEST;
//	    	gbc_lblFormat.insets = new Insets(0, 0, 10, 10);
//	    	gbc_lblFormat.gridx = 1;
//	    	gbc_lblFormat.gridy = 1;
//	    	pnlCenter.add(lblFormat, gbc_lblFormat);
//	    	
//	    	txfFormat = new JTextField();
//	    	txfFormat.setBorder(brdBevel);
//	    	txfFormat.setFont(fontStd);
//	    	GridBagConstraints gbc_txfFormat = new GridBagConstraints();
//	    	gbc_txfFormat.fill = GridBagConstraints.HORIZONTAL;
//	    	gbc_txfFormat.insets = new Insets(0, 0, 10, 10);
//	    	gbc_txfFormat.gridx = 2;
//	    	gbc_txfFormat.gridy = 1;
//	    	pnlCenter.add(txfFormat, gbc_txfFormat);
	    	
	    	
	    	JLabel lblDatentraeger = new JLabel("Datentr\u00E4ger");
	    	lblDatentraeger.setFont(fontStd);
	    	GridBagConstraints gbc_lblDatentraeger = new GridBagConstraints();
	    	gbc_lblDatentraeger.anchor = GridBagConstraints.WEST;
	    	gbc_lblDatentraeger.insets = new Insets(0, 0, 10, 10);
	    	gbc_lblDatentraeger.gridx = 1;
	    	gbc_lblDatentraeger.gridy = 2;
	    	pnlCenter.add(lblDatentraeger, gbc_lblDatentraeger);
	    	
	    	txfDatentraeger = new JTextField();
	    	txfDatentraeger.setBorder(brdBevel);
	    	txfDatentraeger.setFont(fontStd);
	    	GridBagConstraints gbc_txfDatentraeger = new GridBagConstraints();
	    	gbc_txfDatentraeger.fill = GridBagConstraints.HORIZONTAL;
	    	gbc_txfDatentraeger.insets = new Insets(0, 0, 10, 10);
	    	gbc_txfDatentraeger.gridx = 2;
	    	gbc_txfDatentraeger.gridy = 2;
	    	pnlCenter.add(txfDatentraeger, gbc_txfDatentraeger);
	    	
	    	JLabel lblPfad = new JLabel("Pfad");
	    	lblPfad.setFont(fontStd);
	    	GridBagConstraints gbc_lblPfad = new GridBagConstraints();
	    	gbc_lblPfad.anchor = GridBagConstraints.WEST;
	    	gbc_lblPfad.insets = new Insets(0, 0, 10, 10);
	    	gbc_lblPfad.gridx = 1;
	    	gbc_lblPfad.gridy = 3;
	    	pnlCenter.add(lblPfad, gbc_lblPfad);
	    	
	    	txfPfad = new JTextField();
	    	txfPfad.setBorder(brdBevel);
	    	txfPfad.setFont(fontStd);
	    	GridBagConstraints gbc_txfPfad = new GridBagConstraints();
	    	gbc_txfPfad.fill = GridBagConstraints.HORIZONTAL;
	    	gbc_txfPfad.insets = new Insets(0, 0, 10, 10);
	    	gbc_txfPfad.gridx = 2;
	    	gbc_txfPfad.gridy = 3;
	    	pnlCenter.add(txfPfad, gbc_txfPfad);
	    	
	    	
	    	lblDateiformat = new JLabel("Dateiformat");
	    	lblDateiformat.setFont(fontStd);
	    	gbc_lblDateiformat = new GridBagConstraints();
	    	gbc_lblDateiformat.anchor = GridBagConstraints.WEST;
	    	gbc_lblDateiformat.insets = new Insets(0, 0, 10, 10);
	    	gbc_lblDateiformat.gridx = 1;
	    	gbc_lblDateiformat.gridy = 4;
	    	pnlCenter.add(lblDateiformat, gbc_lblDateiformat);
	    	
	    	txfDateiformat = new JTextField();
	    	txfDateiformat.setBorder(brdBevel);
	    	txfDateiformat.setFont(fontStd);
	    	gbc_txfDateiformat = new GridBagConstraints();
	    	gbc_txfDateiformat.fill = GridBagConstraints.HORIZONTAL;
	    	gbc_txfDateiformat.insets = new Insets(0, 0, 10, 10);
	    	gbc_txfDateiformat.gridx = 2;
	    	gbc_txfDateiformat.gridy = 4;
	    	pnlCenter.add(txfDateiformat, gbc_txfDateiformat);
	    	
	    	lblQualitaet = new JLabel("Qualität");
	    	lblQualitaet.setFont(fontStd);
	    	gbc_lblQualitaet = new GridBagConstraints();
	    	gbc_lblQualitaet.anchor = GridBagConstraints.WEST;
	    	gbc_lblQualitaet.insets = new Insets(0, 0, 10, 10);
	    	gbc_lblQualitaet.gridx = 1;
	    	gbc_lblQualitaet.gridy = 5;
	    	pnlCenter.add(lblQualitaet, gbc_lblQualitaet);
	    	
	    	txfDateiformat = new JTextField();
	    	txfDateiformat.setBorder(brdBevel);
	    	txfDateiformat.setFont(fontStd);
	    	gbc_txfDateiformat = new GridBagConstraints();
	    	gbc_txfDateiformat.fill = GridBagConstraints.HORIZONTAL;
	    	gbc_txfDateiformat.insets = new Insets(0, 0, 10, 10);
	    	gbc_txfDateiformat.gridx = 2;
	    	gbc_txfDateiformat.gridy = 5;
	    	pnlCenter.add(txfDateiformat, gbc_txfDateiformat);
	    	    	
	    	cp.add(pnlCenter, BorderLayout.CENTER);
	    	
	    	    	
	    	JPanel pnlSouth = new JPanel();
	    	FlowLayout fl_pnlSouth = new FlowLayout();
	    	fl_pnlSouth.setVgap(10);
	    	fl_pnlSouth.setHgap(10);
	    	fl_pnlSouth.setAlignment(FlowLayout.RIGHT);
	    	
	    	pnlSouth.setLayout(fl_pnlSouth);
	    				
			JButton btnSpeichern = new JButton("speichern");
			pnlSouth.add(btnSpeichern);
			
			JButton btnAbbrechen = new JButton("abbrechen");
			pnlSouth.add(btnAbbrechen);
			
			cp.add(pnlSouth, BorderLayout.SOUTH);
	    }

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
}
