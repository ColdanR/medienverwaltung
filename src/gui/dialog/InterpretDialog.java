package gui.dialog;

import java.awt.Container;
import java.awt.GridBagLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

public class InterpretDialog extends JDialog implements ActionListener
{
			
    private static final long serialVersionUID = 1L;

    Container cp = getContentPane();
    private JTextField txfNachname;
    private JTextField txfVorname;
    private JTextField txfKuenstlername;
    private Font fontStd = new Font("Tahoma", Font.PLAIN, 14);
    private BevelBorder brdBevel = new BevelBorder(BevelBorder.LOWERED);
    
	public InterpretDialog()
    {
    	setTitle("Interpret anlegen");
    	setModal(true);
       	setLocationRelativeTo(null);
		setResizable(false);
    	
    	cp.setLayout(new BorderLayout());
    	
    	JPanel pnlNorth = new JPanel();
    	FlowLayout fl_pnlNorth = new FlowLayout();
    	fl_pnlNorth.setAlignment(FlowLayout.CENTER);
		pnlNorth.setLayout(fl_pnlNorth);
		JLabel lblInterpret = new JLabel("Interpret");
    	lblInterpret.setFont(new Font("Tahoma", Font.BOLD, 16));
    	pnlNorth.add(lblInterpret);
		cp.add(pnlNorth, BorderLayout.NORTH);
		
		GridBagLayout gbl = new GridBagLayout();
    	gbl.columnWidths = new int[] {30, 0, 200, 30};
    	gbl.rowHeights = new int[] {30, 0, 0, 0, 30};
    	gbl.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
    	gbl.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    	
    	JPanel pnlCenter = new JPanel();
    	pnlCenter.setLayout(gbl);
    	    	
    	JLabel lblNachname = new JLabel("Nachname");
    	lblNachname.setFont(fontStd);
    	GridBagConstraints gbc_lblNachname = new GridBagConstraints();
    	gbc_lblNachname.anchor = GridBagConstraints.WEST;
    	gbc_lblNachname.insets = new Insets(0, 0, 10, 10);
    	gbc_lblNachname.gridx = 1;
    	gbc_lblNachname.gridy = 1;
    	pnlCenter.add(lblNachname, gbc_lblNachname);
    	
    	txfNachname = new JTextField();
    	txfNachname.setBorder(brdBevel);
    	txfNachname.setFont(fontStd);
    	GridBagConstraints gbc_txfNachname = new GridBagConstraints();
    	gbc_txfNachname.fill = GridBagConstraints.HORIZONTAL;
    	gbc_txfNachname.insets = new Insets(0, 0, 10, 10);
    	gbc_txfNachname.gridx = 2;
    	gbc_txfNachname.gridy = 1;
    	pnlCenter.add(txfNachname, gbc_txfNachname);
    	
    	
    	JLabel lblVorname = new JLabel("Vorname");
    	lblVorname.setFont(fontStd);
    	GridBagConstraints gbc_lblVorname = new GridBagConstraints();
    	gbc_lblVorname.anchor = GridBagConstraints.WEST;
    	gbc_lblVorname.insets = new Insets(0, 0, 10, 10);
    	gbc_lblVorname.gridx = 1;
    	gbc_lblVorname.gridy = 2;
    	pnlCenter.add(lblVorname, gbc_lblVorname);
    	
    	txfVorname = new JTextField();
    	txfVorname.setBorder(brdBevel);
    	GridBagConstraints gbc_txfVorname = new GridBagConstraints();
    	gbc_txfVorname.fill = GridBagConstraints.HORIZONTAL;
    	gbc_txfVorname.insets = new Insets(0, 0, 10, 10);
    	gbc_txfVorname.gridx = 2;
    	gbc_txfVorname.gridy = 2;
    	pnlCenter.add(txfVorname, gbc_txfVorname);
    	
    	JLabel lblKuenstlername = new JLabel("K\u00FCnstlername");
    	lblKuenstlername.setFont(fontStd);
    	GridBagConstraints gbc_lblKuenstlername = new GridBagConstraints();
    	gbc_lblKuenstlername.anchor = GridBagConstraints.WEST;
    	gbc_lblKuenstlername.insets = new Insets(0, 0, 10, 10);
    	gbc_lblKuenstlername.gridx = 1;
    	gbc_lblKuenstlername.gridy = 3;
    	pnlCenter.add(lblKuenstlername, gbc_lblKuenstlername);
    	
    	txfKuenstlername = new JTextField();
    	txfKuenstlername.setBorder(brdBevel);
    	GridBagConstraints gbc_txfKuenstlername = new GridBagConstraints();
    	gbc_txfKuenstlername.fill = GridBagConstraints.HORIZONTAL;
    	gbc_txfKuenstlername.insets = new Insets(0, 0, 10, 10);
    	gbc_txfKuenstlername.gridx = 2;
    	gbc_txfKuenstlername.gridy = 3;
    	pnlCenter.add(txfKuenstlername, gbc_txfKuenstlername);
    	    	
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
	
//	public static void setGbc(GridBagConstraints x)
//	{
//		x = new GridBagConstraints();
//		x.fill = GridBagConstraints.HORIZONTAL;
//		x.insets = new Insets(0, 0, 10, 10);
//	}
	
//	public static void main(String[] args)
//	{
//		InterpretDialog interpretDialog = new InterpretDialog();
//		
//		interpretDialog.pack();
//		interpretDialog.setVisible(true);
//		interpretDialog.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
//		
//	}
}


