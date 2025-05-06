package com.btsssio.ozenne.maquettes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class WinCinoche extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox cbHoraire;
	private JComboBox cbJour;
	private JCheckBox ckbMajoration3D;
	private JCheckBox ckbCouponReduc;
	private JCheckBox ckbTarifCE;
	private JLabel lblTarifApplicable;
	private JRadioButton rdbPleinTarif;
	private JRadioButton rdbTarifEtudiant;
	private JRadioButton rdbTarifReduit;
	private JPanel panelTarif;
	
	
	public double calculTarif() {
		double tarif = 0;
		panelTarif.setVisible(true);
		
		if (rdbPleinTarif.isSelected()) {
			tarif = 14.60;
		}
		if (rdbTarifEtudiant.isSelected()) {
			tarif = 11.20;
		}
		if (rdbTarifReduit.isSelected()) {
			tarif = 7.90;
		}
		
		if (cbHoraire.getSelectedItem() == "11h10") {
			tarif = 7.90;
			panelTarif.setVisible(false);
		}
		else {
			if (cbJour.getSelectedItem() == "Lundi") {
				tarif = 8.90;
				panelTarif.setVisible(false);
			}
			if (ckbTarifCE.isSelected()) {
				tarif = 8.90;
				panelTarif.setVisible(false);
			}
			
		}
		if (ckbMajoration3D.isSelected()) {
			tarif += 2;
		}
		if (ckbCouponReduc.isSelected()) {
			tarif -= 1;
		}
		return tarif;
	}
	
	public void changerPrix() {
		String prix = String.valueOf(calculTarif());
		lblTarifApplicable.setText(prix+" €");
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinCinoche frame = new WinCinoche();
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
	public WinCinoche() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 477);
		contentPane = new JPanel();
		contentPane.setName("");

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChoixHoraire = new JLabel("Choisir l'horaire:");
		lblChoixHoraire.setBounds(10, 11, 98, 25);
		contentPane.add(lblChoixHoraire);
		
		JLabel lblChoixJour = new JLabel("Choisir le jour:");
		lblChoixJour.setBounds(10, 54, 98, 14);
		contentPane.add(lblChoixJour);
		
		JLabel lblTarif11h = new JLabel("(7,90 € à 11h10)");
		lblTarif11h.setBounds(211, 16, 117, 14);
		contentPane.add(lblTarif11h);
		
		JLabel lblTarifLundi = new JLabel("(8,90 € le lundi)");
		lblTarifLundi.setBounds(211, 54, 117, 14);
		contentPane.add(lblTarifLundi);
		
		cbHoraire = new JComboBox();
		cbHoraire.setModel(new DefaultComboBoxModel(new String[] {"11h10", "15h10", "17h15", "19h15", "20h30", "22h20"}));
		cbHoraire.setBounds(118, 12, 83, 22);
		contentPane.add(cbHoraire);
		
		cbHoraire.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	changerPrix();
		    }
		});
		
		cbJour = new JComboBox();
		cbJour.setModel(new DefaultComboBoxModel(new String[] {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"}));
		cbJour.setBounds(117, 50, 84, 22);
		contentPane.add(cbJour);
		
		cbJour.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	changerPrix();
		    }
		});
		
		ckbTarifCE = new JCheckBox("Tarif spécial CE: 8,90€");
		ckbTarifCE.setBounds(11, 110, 190, 23);
		contentPane.add(ckbTarifCE);
		
		ckbTarifCE.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	changerPrix();
		    }
		});
		
		ckbMajoration3D = new JCheckBox("Majoration 3D: +2.00€");
		ckbMajoration3D.setBounds(10, 347, 158, 23);
		contentPane.add(ckbMajoration3D);
		
		ckbMajoration3D.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	changerPrix();
		    }
		});
		
		ckbCouponReduc = new JCheckBox("Coupon de réduction: -1.00€");
		ckbCouponReduc.setBounds(10, 380, 191, 23);
		contentPane.add(ckbCouponReduc);
		
		ckbCouponReduc.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	changerPrix();
		    }
		});
		
		JButton btnCalculerTarif = new JButton("TarifApplicable");
		btnCalculerTarif.setFont(new Font("Arial", Font.BOLD, 16));
		btnCalculerTarif.setForeground(Color.RED);
		btnCalculerTarif.setBounds(344, 378, 158, 23);
		contentPane.add(btnCalculerTarif);
		
		btnCalculerTarif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changerPrix();
			}
		});		
		lblTarifApplicable = new JLabel("New label");
		lblTarifApplicable.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTarifApplicable.setForeground(Color.BLACK);
		lblTarifApplicable.setFont(new Font("Georgia", Font.BOLD, 20));
		lblTarifApplicable.setBackground(new Color(255, 0, 51));
		lblTarifApplicable.setOpaque(true);
		lblTarifApplicable.setBounds(542, 372, 83, 39);
		lblTarifApplicable.setText("");
		contentPane.add(lblTarifApplicable);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(WinCinoche.class.getResource("/com/btssio/ozenne/maquettes/ticket.jpg")));
		lblNewLabel.setBounds(344, 110, 225, 223);
		contentPane.add(lblNewLabel);
		
		panelTarif = new JPanel();
		panelTarif.setBackground(Color.WHITE);
		panelTarif.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tarif", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelTarif.setBounds(21, 140, 195, 200);
		contentPane.add(panelTarif);
		panelTarif.setLayout(null);
		
		
		
		rdbPleinTarif = new JRadioButton("Plein Tarif 14,60€");
		rdbPleinTarif.setBounds(11, 24, 143, 23);
		panelTarif.add(rdbPleinTarif);
		rdbPleinTarif.setBackground(Color.LIGHT_GRAY);
		
		rdbPleinTarif.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	changerPrix();
		    }
		});
		
		rdbTarifEtudiant = new JRadioButton("Tarif Étudiant 11,20€");
		rdbTarifEtudiant.setBounds(11, 50, 157, 23);
		panelTarif.add(rdbTarifEtudiant);
		rdbTarifEtudiant.setBackground(Color.LIGHT_GRAY);
		
		rdbTarifEtudiant.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	changerPrix();
		    }
		});
		
		rdbTarifReduit = new JRadioButton("Tarif Réduit autre 7,90€");
		rdbTarifReduit.setBounds(11, 76, 165, 23);
		panelTarif.add(rdbTarifReduit);
		rdbTarifReduit.setBackground(Color.LIGHT_GRAY);
		rdbTarifReduit.setForeground(new Color(0, 0, 0));
		
		rdbTarifReduit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	changerPrix();
		    }
		});
		
		// Groupe de boutons radio
		// Création de l'objet ButtonGroup
		ButtonGroup groupeTarif = new ButtonGroup();
		
		// Ajout des boutons au groupe 
		groupeTarif.add(rdbPleinTarif);
		groupeTarif.add(rdbTarifEtudiant);
		groupeTarif.add(rdbTarifReduit);
		
		rdbPleinTarif.setSelected(true);
		
		
		JLabel lblTarifReduit = new JLabel("(enfant - de 14 ans, \r\ncarte vermeil,\r\nfamille nombreuse...)");
		lblTarifReduit.setHorizontalAlignment(SwingConstants.LEFT);
		lblTarifReduit.setVerticalAlignment(SwingConstants.TOP);
		lblTarifReduit.setBounds(11, 106, 174, 83);
		panelTarif.add(lblTarifReduit);
		
		
		
		
	}
	
	
}

