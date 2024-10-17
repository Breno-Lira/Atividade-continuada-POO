package br.com.cesarschool.poo.titulos.telas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;


public class AcaoTela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	public AcaoTela(String nomeBotao) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAo = new JLabel(nomeBotao);
		lblAo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAo.setBounds(219, 10, 88, 25);
		contentPane.add(lblAo);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaInicial frame = new TelaInicial();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 563, 85, 21);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 45, 490, 167);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(104, 33, 96, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Identificador");
		lblNewLabel.setBounds(10, 36, 84, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ADICIONAR");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setBounds(10, 10, 84, 13);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(104, 62, 96, 19);
		panel.add(textField_1);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 65, 84, 13);
		panel.add(lblNome);
		
		JLabel lblNewLabel_3 = new JLabel("Data de validade");
		lblNewLabel_3.setBounds(10, 94, 94, 13);
		panel.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(114, 91, 96, 19);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Valor Unitario");
		lblNewLabel_2.setBounds(10, 126, 84, 13);
		panel.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(104, 120, 96, 19);
		panel.add(textField_3);
		
		JButton btnNewButton_1 = new JButton("Adicionar");
		btnNewButton_1.setBounds(395, 136, 85, 21);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 223, 490, 167);
		contentPane.add(panel_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(104, 33, 96, 19);
		panel_1.add(textField_4);
		
		JLabel lblNewLabel_4 = new JLabel("Identificador");
		lblNewLabel_4.setBounds(10, 36, 84, 13);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_1 = new JLabel("ALTERAR");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_1.setBounds(10, 10, 84, 13);
		panel_1.add(lblNewLabel_1_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(104, 62, 96, 19);
		panel_1.add(textField_5);
		
		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setBounds(10, 65, 84, 13);
		panel_1.add(lblNome_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Data de validade");
		lblNewLabel_3_1.setBounds(10, 94, 84, 13);
		panel_1.add(lblNewLabel_3_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(104, 91, 96, 19);
		panel_1.add(textField_6);
		
		JLabel lblNewLabel_2_1 = new JLabel("Valor Unitario");
		lblNewLabel_2_1.setBounds(10, 126, 84, 13);
		panel_1.add(lblNewLabel_2_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(104, 120, 96, 19);
		panel_1.add(textField_7);
		
		JButton btnNewButton_1_4 = new JButton("Alterar");
		btnNewButton_1_4.setBounds(395, 136, 85, 21);
		panel_1.add(btnNewButton_1_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(0, 400, 490, 62);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("EXCLUIR");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_5.setBounds(10, 10, 45, 13);
		panel_2.add(lblNewLabel_5);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(104, 33, 96, 19);
		panel_2.add(textField_8);
		
		JLabel lblNewLabel_4_1 = new JLabel("Identificador");
		lblNewLabel_4_1.setBounds(10, 36, 84, 13);
		panel_2.add(lblNewLabel_4_1);
		
		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.setBounds(395, 32, 85, 21);
		panel_2.add(btnNewButton_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_1.setBounds(0, 472, 490, 62);
		contentPane.add(panel_2_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("BUSCAR");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_5_1.setBounds(10, 10, 45, 13);
		panel_2_1.add(lblNewLabel_5_1);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(104, 33, 96, 19);
		panel_2_1.add(textField_9);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Identificador");
		lblNewLabel_4_1_1.setBounds(10, 36, 84, 13);
		panel_2_1.add(lblNewLabel_4_1_1);
		
		JButton btnNewButton_2_1 = new JButton("Buscar");
		btnNewButton_2_1.setBounds(395, 32, 85, 21);
		panel_2_1.add(btnNewButton_2_1);
	}
}
