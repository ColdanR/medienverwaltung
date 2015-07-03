package gui.dialog;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConfirmDialog extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JButton btnOk;
	private JButton btnNo;

	public ConfirmDialog(String text) {
		this.setTitle("Bitte bestätigen");
		JLabel textLabel = new JLabel(text);
		textLabel.setAlignmentX(CENTER_ALIGNMENT);
		this.setLayout(new BorderLayout());
		this.add(textLabel, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout());
		this.add(buttonPanel, BorderLayout.SOUTH);
		btnOk = new JButton("Ok.");
		btnNo = new JButton("Abbrechen");
		buttonPanel.add(btnOk, BorderLayout.EAST);
		buttonPanel.add(btnNo, BorderLayout.WEST);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}