package gui.dialog;

import gui.StaticComponents;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ConfirmDialog extends JDialog implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	private JButton btnOk;
	private JButton btnNo;

	public ConfirmDialog(String text) 
	{
		Container cp = getContentPane();
		this.setTitle("Bitte bestätigen");
		
		JPanel pnlText = new JPanel();
		cp.setLayout(new BorderLayout());
		pnlText.setBorder(StaticComponents.BORDER_PANEL);
		cp.add(pnlText, BorderLayout.CENTER);
		
		JLabel lblText = new JLabel(text);
		lblText.setHorizontalAlignment(SwingConstants.CENTER);
		pnlText.add(lblText);
		
		JPanel pnlButton = new JPanel();
		FlowLayout fl_pnlButton = (FlowLayout) pnlButton.getLayout();
		fl_pnlButton.setVgap(10);
		fl_pnlButton.setHgap(10);
		fl_pnlButton.setAlignment(FlowLayout.RIGHT);
		pnlButton.setBorder(StaticComponents.BORDER_PANEL);
		cp.add(pnlButton, BorderLayout.SOUTH);
		
		btnOk = new JButton("OK");
		btnNo = new JButton("Abbrechen");
		
		pnlButton.add(btnOk);
		pnlButton.add(btnNo);
		
		btnOk.addActionListener(this);
		btnNo.addActionListener(this);
			
		this.setMinimumSize(new Dimension(200, 200));
		this.setLocationRelativeTo(null);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		
		if (source == btnOk)
		{
			
		}
		else if (source == btnNo)
		{
			
		}
		else
		{
			System.exit(1);
		}
	}

}