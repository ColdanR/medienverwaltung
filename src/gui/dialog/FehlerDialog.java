/**
 * 
 */
package gui.dialog;

import java.awt.Container;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import enums.ErrorMessage;

/**
 * Zeigt eine Liste von Fehlern an
 * @author Bernd Schmidt
 *
 */
public class FehlerDialog extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	JButton okButton;
	
	public FehlerDialog (Window parent, List<ErrorMessage> errors) {
		super(parent, "Leider sind Fehler aufgetreten", Dialog.ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       	setResizable(false);
       	
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(0, 1));
		for (ErrorMessage error : errors) {
			cp.add(new JLabel(error.getErrorMessage()));
		}
		okButton = new JButton("Schliessen");
		cp.add(okButton);
		okButton.addActionListener(this);
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton) {
			this.dispose();
		}
	}
}
