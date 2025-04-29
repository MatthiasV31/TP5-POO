package com.btsssio.ozenne.maquettes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class MaWinCalculette extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textResultat;
	private JTextField textNombre1;
	private JTextField textNombre2;
	private JComboBox cbxOperateur;
	private JLabel lblMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MaWinCalculette frame = new MaWinCalculette();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void calculer() {
		double nb1, nb2;
		double resultat = 0;
		String operateur;
		String messageErreur = "";
		
		if (textNombre1.getText().isEmpty() || textNombre2.getText().isEmpty()) {
			// Si l'un des nombres n'est pas remplis
			messageErreur = "Toutes les données ne sont pas saisies";
			textResultat.setText("Err !!!");
		}
		else {	
			nb1 = Double.parseDouble(textNombre1.getText());
			nb2 = Double.parseDouble(textNombre2.getText());
			operateur = cbxOperateur.getSelectedItem().toString();
				
			switch (operateur) {
				case "+":
					resultat = nb1 + nb2;
					break;
				case "-":
					resultat = nb1 - nb2;
					break;
				case "*":
					resultat = nb1 * nb2;
					break;
				case "/":
					if (nb2 != 0) {
						// Si on essaye de diviser par 0
						resultat = nb1 / nb2;
					}
					else {
						messageErreur = "La division par 0 n'est pas possible !!!";
						textResultat.setText("Err !!!");
					}
					break;
			}
		}
		if (messageErreur == "") {
			textResultat.setText(String.valueOf(resultat));
		}
			
		lblMessage.setText(messageErreur);
	}

	/**
	 * Create the frame.
	 */
	public MaWinCalculette() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCalculer = new JButton("Calculer");
		btnCalculer.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				calculer();
			}
		});
		
		
		btnCalculer.setBounds(200, 114, 89, 23);
		contentPane.add(btnCalculer);
		
		textResultat = new JTextField();
		textResultat.setBounds(317, 115, 86, 20);
		contentPane.add(textResultat);
		textResultat.setColumns(10);
		
		textNombre1 = new JTextField();
		textNombre1.setBounds(89, 85, 86, 20);
		contentPane.add(textNombre1);
		textNombre1.setColumns(10);
		
		textNombre2 = new JTextField();
		textNombre2.setBounds(89, 147, 86, 20);
		contentPane.add(textNombre2);
		textNombre2.setColumns(10);
		
		cbxOperateur = new JComboBox();
		cbxOperateur.setModel(new DefaultComboBoxModel(new String[] {"+", "*", "-", "/"}));
		cbxOperateur.setBounds(129, 114, 46, 22);
		contentPane.add(cbxOperateur);
		
		lblMessage = new JLabel("");
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setForeground(new Color(255, 0, 0));
		lblMessage.setBackground(Color.CYAN);
		lblMessage.setBounds(33, 197, 370, 53);
		lblMessage.setOpaque(true);
		contentPane.add(lblMessage);
		
		JLabel lblNewLabel = new JLabel("Calculatrice");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		lblNewLabel.setBounds(147, 11, 165, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre 1");
		lblNewLabel_1.setBounds(33, 88, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Opérateur");
		lblNewLabel_2.setBounds(33, 118, 56, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre 2");
		lblNewLabel_3.setBounds(33, 150, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Résultat");
		lblNewLabel_4.setBounds(317, 88, 46, 14);
		contentPane.add(lblNewLabel_4);
	}
}
