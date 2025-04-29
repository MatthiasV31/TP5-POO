package com.btsssio.ozenne.maquettes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class MonWinDiapoZoo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList listAnimaux;
	private JLabel lblAnimal;

	
	
	private void changerImage() {
		String image = (String) listAnimaux.getSelectedValue();
		String chemin = "/com/btssio/ozenne/maquettes/" + image +".jpg";
		lblAnimal.setIcon(new ImageIcon(MonWinDiapoZoo.class.getResource(chemin)));
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MonWinDiapoZoo frame = new MonWinDiapoZoo();
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
	public MonWinDiapoZoo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		listAnimaux = new JList();
		
		
		listAnimaux.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				changerImage();
				
			}
		});
		
		
		listAnimaux.setModel(new AbstractListModel() {
			String[] values = new String[] {"Ara", "Autruche", "Casoar", "Chameau", "Chimpanze", "Colobe", "Elephant", "Fennec", "Gibbon", "Girafe", "Lion", "Lynx", "Murien", "Ours", "Pelican", "Zebre"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listAnimaux.setBounds(24, 59, 82, 274);
		contentPane.add(listAnimaux);
		
		JLabel lblTitre = new JLabel("Les animaux du Zoo");
		lblTitre.setForeground(Color.MAGENTA);
		lblTitre.setFont(new Font("Georgia", Font.BOLD, 26));
		lblTitre.setBounds(184, 15, 313, 33);
		contentPane.add(lblTitre);
		
		lblAnimal = new JLabel("");
		lblAnimal.setIcon(new ImageIcon(MonWinDiapoZoo.class.getResource("/com/btssio/ozenne/maquettes/animaux_du_zoo.gif")));
		lblAnimal.setBounds(132, 63, 390, 270);
		contentPane.add(lblAnimal);
	}
}
