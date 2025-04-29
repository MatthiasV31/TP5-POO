package com.btsssio.ozenne.maquettes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PremierFenetre extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textSaisi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PremierFenetre frame = new PremierFenetre();
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
	public PremierFenetre() {
		setTitle("PremierFenetre");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			
			
			
			
			public void actionPerformed(ActionEvent e) {
				
				// JOptionPane.showMessageDialog(btnValider, "Vous avez saisi \"" +textSaisi.getText() +"\"");
				textSaisi.setText("");
				textSaisi.requestFocus();
			}
		});
		
		
		
		btnValider.setBounds(168, 183, 106, 67);
		contentPane.add(btnValider);
		
		textSaisi = new JTextField();
		textSaisi.setHorizontalAlignment(SwingConstants.LEFT);
		textSaisi.setBounds(93, 76, 228, 20);
		contentPane.add(textSaisi);
		textSaisi.setColumns(10);
		
		JLabel lblMessage = new JLabel("Saisissez un message");
		lblMessage.setFont(new Font("Georgia", Font.PLAIN, 25));
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setForeground(Color.RED);
		lblMessage.setBounds(68, 21, 287, 40);
		contentPane.add(lblMessage);
	}
}
