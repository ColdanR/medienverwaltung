/**
 * 
 */
package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import enums.ErrorMessage;
import gui.StaticComponents;
import javax.swing.border.MatteBorder;
import java.awt.Dimension;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 * Zeigt eine Liste von Fehlern an
 * @author Bernd Schmidt
 * @author Jens Wiede (design)
 *
 */
public class FehlerDialog extends JDialog implements ActionListener 
{
	private static final long serialVersionUID = 1L;
	JButton btnOk;
	
	public FehlerDialog (Window parent, List<ErrorMessage> errors)
	{
		super(parent, "Fehler", Dialog.ModalityType.APPLICATION_MODAL);
		setMinimumSize(new Dimension(200, 200));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       	setResizable(false);
       	
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		// Creating Panels
		JPanel pnlNorth = new JPanel();
		JPanel pnlCenter = new JPanel();
		JPanel pnlSouth = new JPanel();
		
		pnlNorth.setBorder(StaticComponents.BORDER_PANEL);
		pnlCenter.setBorder(new CompoundBorder(new MatteBorder(0, 1, 0, 1, StaticComponents.BORDER_COLOR), 
											   new EmptyBorder(10, 10, 10, 10)));
		pnlSouth.setBorder(StaticComponents.BORDER_PANEL);
		
		cp.add(pnlNorth, BorderLayout.NORTH);
		cp.add(pnlCenter, BorderLayout.CENTER);
		cp.add(pnlSouth, BorderLayout.SOUTH);
		
		// creating BorderLayout.NORTH Components
		JLabel lblErrorTitle = new JLabel("Es sind Fehler aufgetreten");
		StaticComponents.setFontLabelRed(lblErrorTitle);
		pnlNorth.add(lblErrorTitle);
		
		// creating BorderLayout.CENTER Components
		GridLayout gl_pnlCenter = new GridLayout(0,1);
		pnlCenter.setLayout(gl_pnlCenter);
		
		for (ErrorMessage error : errors)
		{
			pnlCenter.add(new JLabel(error.getErrorMessage()));
		}
					
		// creating BorderLayout.SOUTH Components
		FlowLayout flowLayout = (FlowLayout) pnlSouth.getLayout();
		flowLayout.setAlignment(FlowLayout.CENTER);
				
		btnOk = new JButton("Schliessen");
		btnOk.setFont(StaticComponents.FONT_BUTTON);
		pnlSouth.add(btnOk);
		
		btnOk.addActionListener(this);
		
		pack();
		setLocationRelativeTo(parent);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {
			this.dispose();
		}
	}
}
