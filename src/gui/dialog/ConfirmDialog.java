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
		
		cp.setLayout(new BorderLayout());
		
		JPanel pnlText = new JPanel();
		JPanel pnlButton = new JPanel();
		
		pnlText.setBorder(StaticComponents.BORDER_PANEL);
		pnlButton.setBorder(StaticComponents.BORDER_PANEL);
		
		cp.add(pnlText, BorderLayout.CENTER);
		cp.add(pnlButton, BorderLayout.SOUTH);
		
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
		btnNo = new JButton("Abbrechen");
		
		pnlButton.add(btnOk);
		pnlButton.add(btnNo);
		
		// add to listener
		btnOk.addActionListener(this);
		btnNo.addActionListener(this);
			
		this.setMinimumSize(new Dimension(200, 150));
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