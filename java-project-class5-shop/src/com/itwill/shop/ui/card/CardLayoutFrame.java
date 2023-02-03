package com.itwill.shop.ui.card;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CardLayoutFrame extends JFrame {

	private JPanel contentPane;
	private JPanel parentPanel;
	private CardLayout cardLayout;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardLayoutFrame frame = new CardLayoutFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CardLayoutFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		parentPanel = new JPanel();
		contentPane.add(parentPanel, BorderLayout.CENTER);
		cardLayout=new CardLayout();
		parentPanel.setLayout(cardLayout);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.GRAY);
		parentPanel.add(panel1, "1");
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.ORANGE);
		parentPanel.add(panel2, "2");
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.CYAN);
		parentPanel.add(panel3, "3");
		
		JPanel panel4 = new JPanel();
		panel4.setBackground(new Color(0, 255, 127));
		parentPanel.add(panel4, "4");
		
		JPanel southMenuPanel = new JPanel();
		contentPane.add(southMenuPanel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(parentPanel, "1");
			}
		});
		southMenuPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(parentPanel, "2");
			}
		});
		southMenuPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("3");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(parentPanel, "3");
			}
		});
		southMenuPanel.add(btnNewButton_2);
	}
}
