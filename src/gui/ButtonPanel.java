package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Component;

public class ButtonPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ButtonPanel()
	{
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		gbl_buttonPanel.columnWidths = new int[] {100, 0};
		gbl_buttonPanel.rowHeights = new int[] {0, 0, 0, 30, 0};
		gbl_buttonPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_buttonPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_buttonPanel);
		
		JButton btnMusik = new JButton("Musik");
		btnMusik.setPreferredSize(new Dimension(100, 25));
		btnMusik.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_btnMusik = new GridBagConstraints();
		gbc_btnMusik.anchor = GridBagConstraints.WEST;
		gbc_btnMusik.insets = new Insets(10, 10, 10, 10);
		gbc_btnMusik.gridx = 0;
		gbc_btnMusik.gridy = 0;
		add(btnMusik, gbc_btnMusik);		
		
		JButton btnVideo = new JButton("Video");
		btnVideo.setPreferredSize(new Dimension(100, 25));
		btnVideo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_btnVideo = new GridBagConstraints();
		gbc_btnVideo.anchor = GridBagConstraints.WEST;
		gbc_btnVideo.insets = new Insets(0, 10, 10, 10);
		gbc_btnVideo.gridx = 0;
		gbc_btnVideo.gridy = 1;
		add(btnVideo, gbc_btnVideo);		
		
		JButton btnBuecher = new JButton("Bücher");
		btnBuecher.setPreferredSize(new Dimension(100, 25));
		btnBuecher.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 10, 10, 10);
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		add(btnBuecher, gbc_btnNewButton);
	}
}
