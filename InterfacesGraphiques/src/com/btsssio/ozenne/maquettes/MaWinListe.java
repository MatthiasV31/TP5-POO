package com.btsssio.ozenne.maquettes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Color;

public class MaWinListe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textSaisie;
	private JList liste;
	private DefaultListModel modele;

	private void ajouterElement() {
		String nouvelElement = textSaisie.getText();
		if (!nouvelElement.isEmpty()) {
			modele.addElement(nouvelElement);
			textSaisie.setText("");
		}
	}
	
	private void supprimerElement() {
		modele.removeElement(liste.getSelectedValue());
	}
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MaWinListe frame = new MaWinListe();
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
	public MaWinListe() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		liste = new JList();
		liste.setBounds(98, 40, 219, 123);
		contentPane.add(liste);
		
		modele = new DefaultListModel<>();
		
		liste.setModel(modele);
		
		textSaisie = new JTextField();
		textSaisie.setBounds(98, 174, 219, 20);
		contentPane.add(textSaisie);
		textSaisie.setColumns(10);
		
		JButton btnAjouter = new JButton("Ajouter");
		getRootPane().setDefaultButton(btnAjouter);
		
		
		
		
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouterElement();
				
			}
		});
		
		
		
		
		
		btnAjouter.setBounds(98, 205, 89, 23);
		contentPane.add(btnAjouter);
		
		JButton btnSupprimer = new JButton("Supprimer");
		
		
		
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supprimerElement();
			}
		});
		
		
		btnSupprimer.setBounds(228, 205, 89, 23);
		contentPane.add(btnSupprimer);
		
		JRadioButton rdbtnRouge = new JRadioButton("Rouge");
		rdbtnRouge.setForeground(Color.RED);
		rdbtnRouge.setBounds(98, 10, 89, 23);
		contentPane.add(rdbtnRouge);
		
		JRadioButton rdbtnBleu = new JRadioButton("Bleu");
		rdbtnBleu.setForeground(Color.BLUE);
		rdbtnBleu.setBounds(228, 10, 65, 23);
		contentPane.add(rdbtnBleu);
		
		
		// Création d'un objet ButtonGroup
		
		ButtonGroup groupeCouleurs = new ButtonGroup();
		
		// Ajout des boutons radio au groupe 
		
		groupeCouleurs.add(rdbtnRouge);
		groupeCouleurs.add(rdbtnBleu);
		
		//Initialisation de la couleur séléctionnée
		rdbtnBleu.setSelected(true);
		
		rdbtnBleu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textSaisie.setForeground(Color.BLUE);
				liste.setForeground(Color.BLUE);
			}
		});
		
		rdbtnRouge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textSaisie.setForeground(Color.RED);
				liste.setForeground(Color.RED);
			}
		});
		
	}
}
