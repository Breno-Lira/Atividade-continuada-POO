package br.com.cesarschool.poo.titulos.telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenu frame = new TelaMenu();
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
	public TelaMenu() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escolha o tipo de operação");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(157, 10, 195, 25);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1_1 = new JButton("Titulos divida");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaTituloDivida novatela = new TelaTituloDivida();
				novatela.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setBounds(82, 153, 102, 43);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Ação");
		btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaAcao novatela = new TelaAcao();
				novatela.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_1.setBounds(82, 78, 102, 43);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_2 = new JButton("Entidade");
		btnNewButton_1_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaEntidadeOperadora novatela = new TelaEntidadeOperadora();
				novatela.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_2.setBounds(298, 78, 102, 43);
		contentPane.add(btnNewButton_1_1_2);
		
		JButton btnNewButton_1_1_3 = new JButton("Operações");
		btnNewButton_1_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaOperacao novatela = new TelaOperacao();
				novatela.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1_3.setBounds(298, 153, 102, 43);
		contentPane.add(btnNewButton_1_1_3);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Transações");
		btnNewButton_1_1_1_1.setBounds(189, 223, 102, 43);
		contentPane.add(btnNewButton_1_1_1_1);
		btnNewButton_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaTransacao novatela = new TelaTransacao();
				novatela.setVisible(true);
				dispose();
			}
		});
	}
	
}
