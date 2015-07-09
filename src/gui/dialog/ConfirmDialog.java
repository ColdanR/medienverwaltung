package gui.dialog;

import gui.ReturningDialog;
import gui.StaticComponents;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ConfirmDialog extends ReturningDialog<Boolean> {
	
	private JButton btnOk;
	private JButton btnNo;
	private String text;
	
	public ConfirmDialog(Window parent) {
		super(parent, "Person ausw\00E4hlen", 600, 400);
		createDialogContent();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == btnOk) {
			setObject(Boolean.TRUE);
			dialog.dispose();
		} else if (source == btnNo) {
			setObject(Boolean.FALSE);
			dialog.dispose();
		}
	}


	@Override
	protected JPanel createDialogContent() {
		JPanel ret = new JPanel();
		ret.setLayout(new BorderLayout());
		
		JPanel pnlText = new JPanel();
		JPanel pnlButton = new JPanel();
		
		pnlText.setBorder(StaticComponents.BORDER_PANEL);
		pnlButton.setBorder(StaticComponents.BORDER_PANEL);
		
		ret.add(pnlText, BorderLayout.CENTER);
		ret.add(pnlButton, BorderLayout.SOUTH);
		
		// CENTER panel objects	
		JLabel lblText = new JLabel(text);
		lblText.setHorizontalAlignment(SwingConstants.CENTER);
		pnlText.add(lblText);
		
		// SOUTH panel objects
		FlowLayout fl_pnlButton = (FlowLayout) pnlButton.getLayout();
		fl_pnlButton.setVgap(10);
		fl_pnlButton.setHgap(10);
		fl_pnlButton.setAlignment(FlowLayout.RIGHT);
				
		btnOk = new JButton("OK");
		btnOk.setFont(StaticComponents.FONT_BUTTON);
		btnNo = new JButton("Abbrechen");
		btnNo.setFont(StaticComponents.FONT_BUTTON);

		
		pnlButton.add(btnOk);
		pnlButton.add(btnNo);
		
		// add to listener
		btnOk.addActionListener(this);
		btnNo.addActionListener(this);
			
		dialog.setMinimumSize(new Dimension(200, 150));
		dialog.setLocationRelativeTo(null);
		return null;
	}
	
	public void setText(String text) {
		this.text = text;
	}
}