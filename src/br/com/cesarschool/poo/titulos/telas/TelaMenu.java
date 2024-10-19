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
import java.awt.Color;

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

		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setFont(new Font("Wide Latin", Font.BOLD, 18));
		lblNewLabel.setBounds(189, 10, 112, 34);
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
		btnNewButton_1_1.setBounds(189, 230, 102, 34);
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
		btnNewButton_1_1_1.setBounds(186, 54, 102, 34);
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
		btnNewButton_1_1_2.setBounds(186, 98, 102, 34);
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
		btnNewButton_1_1_3.setBounds(189, 142, 102, 34);
		contentPane.add(btnNewButton_1_1_3);

		JButton btnNewButton_1_1_1_1 = new JButton("Transações");
		btnNewButton_1_1_1_1.setBounds(189, 186, 102, 34);
		contentPane.add(btnNewButton_1_1_1_1);

		JButton btnSair = new JButton("Sair");
		btnSair.setForeground(new Color(255, 255, 255));
		btnSair.setBackground(new Color(128, 0, 0));
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});


		btnSair.setBounds(199, 274, 76, 21);
		contentPane.add(btnSair);
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
