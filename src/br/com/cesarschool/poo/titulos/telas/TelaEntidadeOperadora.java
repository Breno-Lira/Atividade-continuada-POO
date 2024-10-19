package br.com.cesarschool.poo.titulos.telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.border.LineBorder;

import br.com.cesarschool.poo.titulos.entidades.EntidadeOperadora;
import br.com.cesarschool.poo.titulos.entidades.TituloDivida;
import br.com.cesarschool.poo.titulos.mediators.MediatorEntidadeOperadora;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class TelaEntidadeOperadora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField AddId;
	private JTextField AddNome;
	private JTextField AddSaldoA;
	private JTextField AddSaldoT;
	private JTextField AltId;
	private JTextField AltNome;
	private JTextField AltSaldoA;
	private JTextField AltSaldoT;
	private JTextField DeleteId;
	private JTextField BuscarId;
	MediatorEntidadeOperadora mediatorEntidade = MediatorEntidadeOperadora.getInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEntidadeOperadora frame = new TelaEntidadeOperadora();
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
	public TelaEntidadeOperadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 654);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Entidade Operadora");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(164, 10, 176, 17);
		contentPane.add(lblNewLabel);
		
		//INICIO ADICIONAR
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 34, 490, 192);
		contentPane.add(panel);
		
		AddId = new JTextField();
		AddId.setColumns(10);
		AddId.setBounds(104, 33, 96, 19);
		panel.add(AddId);
		
		JLabel lblIdentificador = new JLabel("Identificador");
		lblIdentificador.setBounds(10, 36, 84, 13);
		panel.add(lblIdentificador);
		
		JLabel lblTitulo = new JLabel("ADICIONAR");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTitulo.setBounds(10, 10, 84, 13);
		panel.add(lblTitulo);
		
		AddNome = new JTextField();
		AddNome.setColumns(10);
		AddNome.setBounds(104, 62, 96, 19);
		panel.add(AddNome);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 65, 84, 13);
		panel.add(lblNome);
		
		JLabel lblAutorizadoAo = new JLabel("Autorizado Ação");
		lblAutorizadoAo.setBounds(10, 94, 94, 13);
		panel.add(lblAutorizadoAo);
		
		JLabel lblTaxaJuros = new JLabel("Saldo Ação");
		lblTaxaJuros.setBounds(10, 126, 84, 13);
		panel.add(lblTaxaJuros);
		
		AddSaldoA = new JTextField();
		AddSaldoA.setColumns(10);
		AddSaldoA.setBounds(104, 120, 96, 19);
		panel.add(AddSaldoA);
		
		JButton btnADD = new JButton("Adicionar");
		btnADD.setBounds(395, 161, 85, 21);
		panel.add(btnADD);
		
		JComboBox<Boolean> AddAutorizado = new JComboBox<>();
		AddAutorizado.setBounds(114, 91, 86, 21);
		panel.add(AddAutorizado);
		AddAutorizado.addItem(true);
		AddAutorizado.addItem(false); 
		
		JLabel lblNewLabel_1 = new JLabel("Saldo Titulo Divida");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setBounds(10, 149, 94, 13);
		panel.add(lblNewLabel_1);
		
		AddSaldoT = new JTextField();
		AddSaldoT.setBounds(114, 149, 96, 19);
		panel.add(AddSaldoT);
		AddSaldoT.setColumns(10);
		
		btnADD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    long identificador = Long.parseLong(AddId.getText());
                    String nome = AddNome.getText();
                    
                    boolean autorizacao = (Boolean) AddAutorizado.getSelectedItem();
                    
                    double saldoAcao = Double.parseDouble(AddSaldoA.getText());
                    double saldoTitulo = Double.parseDouble(AddSaldoT.getText());

                    EntidadeOperadora novaEntidade = new EntidadeOperadora(identificador, nome, autorizacao, saldoAcao, saldoTitulo);             
                    String incluir = mediatorEntidade.incluir(novaEntidade);
                    
                    if (incluir != null) {
                    	JOptionPane.showMessageDialog(null, incluir);
                    }
                    else {
                    	JOptionPane.showMessageDialog(null, "Entidade incluida com sucesso!");
                    	AddId.setText("");
	                    AddNome.setText("");
	                    AddSaldoA.setText("");
	                    AddSaldoT.setText("");
                    }
                    
                 
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: Verifique se o identificador, saldo ação e o saldo titulo estão corretos!", "Erro", JOptionPane.ERROR_MESSAGE);
                } 
            }
        });
		//FIM ADICIONAR
		
		//INICIO ALTERAR
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 236, 490, 192);
		contentPane.add(panel_1);
		
		AltId = new JTextField();
		AltId.setColumns(10);
		AltId.setBounds(104, 33, 96, 19);
		panel_1.add(AltId);
		
		JLabel lblIdentificador_1 = new JLabel("Identificador");
		lblIdentificador_1.setBounds(10, 36, 84, 13);
		panel_1.add(lblIdentificador_1);
		
		JLabel lblAlterar = new JLabel("ALTERAR");
		lblAlterar.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblAlterar.setBounds(10, 10, 84, 13);
		panel_1.add(lblAlterar);
		
		AltNome = new JTextField();
		AltNome.setColumns(10);
		AltNome.setBounds(104, 62, 96, 19);
		panel_1.add(AltNome);
		
		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setBounds(10, 65, 84, 13);
		panel_1.add(lblNome_1);
		
		JLabel lblAutorizadoAo_1 = new JLabel("Autorizado Ação");
		lblAutorizadoAo_1.setBounds(10, 94, 94, 13);
		panel_1.add(lblAutorizadoAo_1);
		
		JLabel lblTaxaJuros_1 = new JLabel("Saldo Ação");
		lblTaxaJuros_1.setBounds(10, 126, 84, 13);
		panel_1.add(lblTaxaJuros_1);
		
		AltSaldoA = new JTextField();
		AltSaldoA.setColumns(10);
		AltSaldoA.setBounds(104, 120, 96, 19);
		panel_1.add(AltSaldoA);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(395, 161, 85, 21);
		panel_1.add(btnAlterar);
		
		JComboBox<Boolean> AltAutorizado = new JComboBox<Boolean>();
		AltAutorizado.setBounds(114, 91, 86, 21);
		panel_1.add(AltAutorizado);
		AltAutorizado.addItem(true);
		AltAutorizado.addItem(false);
		
		JLabel lblNewLabel_1_1 = new JLabel("Saldo Titulo Divida");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_1.setBounds(10, 149, 94, 13);
		panel_1.add(lblNewLabel_1_1);
		
		AltSaldoT = new JTextField();
		AltSaldoT.setColumns(10);
		AltSaldoT.setBounds(114, 149, 96, 19);
		panel_1.add(AltSaldoT);
		
		btnAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    long identificador = Long.parseLong(AltId.getText());
                    String nome = AltNome.getText();
                    
                    boolean autorizacao = (Boolean) AltAutorizado.getSelectedItem();;
                    
                    double saldoAcao = Double.parseDouble(AltSaldoA.getText());
                    double saldoTitulo = Double.parseDouble(AltSaldoT.getText());

                    EntidadeOperadora novaEntidade = new EntidadeOperadora(identificador, nome, autorizacao, saldoAcao, saldoTitulo);             
                    String alterar = mediatorEntidade.alterar(novaEntidade);
                    
                    if (alterar != null) {
                    	JOptionPane.showMessageDialog(null, alterar);
                    }
                    else {
                    	JOptionPane.showMessageDialog(null, "Entidade alterada com sucesso!");
                    	AltId.setText("");
	                    AltNome.setText("");
	                    AltSaldoA.setText("");
	                    AltSaldoT.setText("");
                    }
                    
                 
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: Verifique se o identificador, saldo ação e o saldo titulo estão corretos!", "Erro", JOptionPane.ERROR_MESSAGE);
                } 
            }
        });
		//FIM ALTERAR
		
		//INICIO EXCLUIR
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(0, 438, 490, 62);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_5 = new JLabel("EXCLUIR");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_5.setBounds(10, 10, 45, 13);
		panel_2.add(lblNewLabel_5);
		
		DeleteId = new JTextField();
		DeleteId.setColumns(10);
		DeleteId.setBounds(104, 33, 96, 19);
		panel_2.add(DeleteId);
		
		JLabel lblNewLabel_4_1 = new JLabel("Identificador");
		lblNewLabel_4_1.setBounds(10, 36, 84, 13);
		panel_2.add(lblNewLabel_4_1);
		
		JButton btnDELETE = new JButton("Excluir");
		btnDELETE.setBounds(395, 32, 85, 21);
		panel_2.add(btnDELETE);
		btnDELETE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    long idntDelete = Long.parseLong(DeleteId.getText());
                                            
                    String excluir = mediatorEntidade.excluir(idntDelete);
                    
                    if (excluir != null) {
                    	JOptionPane.showMessageDialog(null, excluir);
                    }
                    else {
                    	JOptionPane.showMessageDialog(null, "Entidade excluida com sucesso!");
                    	DeleteId.setText("");
                    }
                                      

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: Verifique se o identificador está preenchido!", "Erro", JOptionPane.ERROR_MESSAGE);
                } 
            }
        });
		//FIM EXCLUIR
		
		//INICIO BUSCAR
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_1.setBounds(0, 507, 490, 62);
		contentPane.add(panel_2_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("BUSCAR");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_5_1.setBounds(10, 10, 45, 13);
		panel_2_1.add(lblNewLabel_5_1);
		
		BuscarId = new JTextField();
		BuscarId.setColumns(10);
		BuscarId.setBounds(104, 33, 96, 19);
		panel_2_1.add(BuscarId);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Identificador");
		lblNewLabel_4_1_1.setBounds(10, 36, 84, 13);
		panel_2_1.add(lblNewLabel_4_1_1);
		
		JButton btnBUSCAR = new JButton("Buscar");
		btnBUSCAR.setBounds(395, 32, 85, 21);
		panel_2_1.add(btnBUSCAR);
			
		btnBUSCAR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    long idBuscar = Long.parseLong(BuscarId.getText());
                                            
                    EntidadeOperadora buscar = mediatorEntidade.buscar(idBuscar);
                    
                    if (buscar != null) {
                    	JOptionPane.showMessageDialog(null, buscar.getIdentificador() + ";"+ buscar.getNome()+";"+buscar.getAutorizadoAcao()+";"+ buscar.getSaldoAcao()+";"
                    +buscar.getSaldoTituloDivida());
                    	BuscarId.setText("");
                    }
                    else {
                    	JOptionPane.showMessageDialog(null, "Entidade não encontrada!");
                    }
                                   
                    

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: Verifique se o identificador está preenchido!", "Erro", JOptionPane.ERROR_MESSAGE);
                } 
            }
        });
		//FIM BUSCAR
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setBounds(10, 586, 85, 21);
		contentPane.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaMenu frame = new TelaMenu();
				frame.setVisible(true);
				dispose();
			}
		});
		
		
	}
}
