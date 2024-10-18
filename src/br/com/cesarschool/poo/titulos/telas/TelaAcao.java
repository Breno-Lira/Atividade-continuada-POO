package br.com.cesarschool.poo.titulos.telas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import br.com.cesarschool.poo.titulos.entidades.Acao;
import br.com.cesarschool.poo.titulos.mediators.MediatorAcao;

import java.awt.Color;
import java.awt.EventQueue;


public class TelaAcao extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField AddIdentificador;
	private JTextField AddNome;
	private JTextField AddData;
	private JTextField AddValor;
	private JTextField AltIdentificador;
	private JTextField AltNome;
	private JTextField AltData;
	private JTextField AltValor;
	private JTextField DeleteIdt;
	private JTextField BuscarIdt;
	MediatorAcao mediatorAcao = MediatorAcao.getInstance();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAcao frame = new TelaAcao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaAcao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaMenu frame = new TelaMenu();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 563, 85, 21);
		contentPane.add(btnNewButton);
		
		//INICIO ADICIONAR
		JPanel panel = new JPanel();
		panel.setBounds(0, 46, 490, 167);
		contentPane.add(panel);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		
		AddIdentificador = new JTextField();
        AddIdentificador.setBounds(104, 33, 96, 19);
        panel.add(AddIdentificador);
        AddIdentificador.setColumns(10);

        JLabel lblIdentificador = new JLabel("Identificador");
        lblIdentificador.setBounds(10, 36, 84, 13);
        panel.add(lblIdentificador);

        JLabel lblTitulo = new JLabel("ADICIONAR");
        lblTitulo.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 10));
        lblTitulo.setBounds(10, 10, 84, 13);
        panel.add(lblTitulo);

        AddNome = new JTextField();
        AddNome.setColumns(10);
        AddNome.setBounds(104, 62, 96, 19);
        panel.add(AddNome);

        JLabel lblNome = new JLabel("Nome");
        lblNome.setBounds(10, 65, 84, 13);
        panel.add(lblNome);

        JLabel lblDataValidade = new JLabel("Data de validade");
        lblDataValidade.setBounds(10, 94, 94, 13);
        panel.add(lblDataValidade);

        AddData = new JTextField();
        AddData.setBounds(114, 91, 96, 19);
        panel.add(AddData);
        AddData.setColumns(10);

        JLabel lblValorUnitario = new JLabel("Valor Unitário");
        lblValorUnitario.setBounds(10, 126, 84, 13);
        panel.add(lblValorUnitario);

        AddValor = new JTextField();
        AddValor.setColumns(10);
        AddValor.setBounds(104, 120, 96, 19);
        panel.add(AddValor);

        JButton btnADD = new JButton("Adicionar");
        btnADD.setBounds(395, 136, 85, 21);
        panel.add(btnADD);

      
        btnADD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    int identificador = Integer.parseInt(AddIdentificador.getText());
                    String nome = AddNome.getText();
                    
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate dataDeValidade = LocalDate.parse(AddData.getText(), formatter);
                    
                    double valorUnitario = Double.parseDouble(AddValor.getText());

                    Acao novaAcao = new Acao(identificador, nome, dataDeValidade, valorUnitario);             
                    String incluir = mediatorAcao.incluir(novaAcao);
                    
                    if (incluir != null) {
                    	JOptionPane.showMessageDialog(null, incluir);
                    }
                    else {
                    	JOptionPane.showMessageDialog(null, "Ação incluida com sucesso!");
                    	AddIdentificador.setText("");
                        AddNome.setText("");
                        AddData.setText("");
                        AddValor.setText("");
                    }
                                      

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: Verifique se o identificador e o valor unitário estão corretos!", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: Data de validade inválida. Use o formato dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        //FIM DE ADICIONAR
        
        //INICIO ALTERAR
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 223, 490, 167);
		contentPane.add(panel_1);
		
		AltIdentificador = new JTextField();
		AltIdentificador.setColumns(10);
		AltIdentificador.setBounds(104, 33, 96, 19);
		panel_1.add(AltIdentificador);
		
		JLabel lblNewLabel_4 = new JLabel("Identificador");
		lblNewLabel_4.setBounds(10, 36, 84, 13);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_1 = new JLabel("ALTERAR");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1_1.setBounds(10, 10, 84, 13);
		panel_1.add(lblNewLabel_1_1);
		
		AltNome = new JTextField();
		AltNome.setColumns(10);
		AltNome.setBounds(104, 62, 96, 19);
		panel_1.add(AltNome);
		
		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setBounds(10, 65, 84, 13);
		panel_1.add(lblNome_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Data de validade");
		lblNewLabel_3_1.setBounds(10, 94, 84, 13);
		panel_1.add(lblNewLabel_3_1);
		
		AltData = new JTextField();
		AltData.setColumns(10);
		AltData.setBounds(104, 91, 96, 19);
		panel_1.add(AltData);
		
		JLabel lblNewLabel_2_1 = new JLabel("Valor Unitario");
		lblNewLabel_2_1.setBounds(10, 126, 84, 13);
		panel_1.add(lblNewLabel_2_1);
		
		AltValor = new JTextField();
		AltValor.setColumns(10);
		AltValor.setBounds(104, 120, 96, 19);
		panel_1.add(AltValor);
		
		JButton btnALT = new JButton("Alterar");
		btnALT.setBounds(395, 136, 85, 21);
		panel_1.add(btnALT);
		
		btnALT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    int idntAlt = Integer.parseInt(AltIdentificador.getText());
                    String nomeAlt = AltNome.getText();
                    
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate validadeAlt = LocalDate.parse(AltData.getText(), formatter);
                    
                    double valorUnitarioAlt = Double.parseDouble(AltValor.getText());

                    Acao novaAcao2 = new Acao(idntAlt,nomeAlt, validadeAlt, valorUnitarioAlt);              
                    String alterar = mediatorAcao.alterar(novaAcao2);
                    
                    if (alterar != null) {
                    	JOptionPane.showMessageDialog(null, alterar);
                    }
                    else {
                    	JOptionPane.showMessageDialog(null, "Ação alterada com sucesso!");
                    	AltIdentificador.setText("");
                        AltNome.setText("");
                        AltData.setText("");
                        AltValor.setText("");
                    }
                    
                    

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: Verifique se o identificador e o valor unitário estão corretos!", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: Data de validade inválida. Use o formato dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
		//FIM ALTERAR
		
		//INICIO DE EXCLUIR
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(0, 400, 490, 62);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("EXCLUIR");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_5.setBounds(10, 10, 45, 13);
		panel_2.add(lblNewLabel_5);
		
		DeleteIdt = new JTextField();
		DeleteIdt.setColumns(10);
		DeleteIdt.setBounds(104, 33, 96, 19);
		panel_2.add(DeleteIdt);
		
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
                    
                    int idntDelete = Integer.parseInt(DeleteIdt.getText());
                                            
                    String excluir = mediatorAcao.excluir(idntDelete);
                    
                    if (excluir != null) {
                    	JOptionPane.showMessageDialog(null, excluir);
                    }
                    else {
                    	JOptionPane.showMessageDialog(null, "Ação excluida com sucesso!");
                    	DeleteIdt.setText("");
                    }
                    
                   
                    

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: Verifique se o identificador está preenchido!", "Erro", JOptionPane.ERROR_MESSAGE);
                } 
            }
        });
		//FIM DE EXCLUIR
		
		//INICIO DE BUSCAR 
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_1.setBounds(0, 472, 490, 62);
		contentPane.add(panel_2_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("BUSCAR");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_5_1.setBounds(10, 10, 45, 13);
		panel_2_1.add(lblNewLabel_5_1);
		
		BuscarIdt = new JTextField();
		BuscarIdt.setColumns(10);
		BuscarIdt.setBounds(104, 33, 96, 19);
		panel_2_1.add(BuscarIdt);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Identificador");
		lblNewLabel_4_1_1.setBounds(10, 36, 84, 13);
		panel_2_1.add(lblNewLabel_4_1_1);
		
		JButton btnBUSCAR = new JButton("Buscar");
		btnBUSCAR.setBounds(395, 32, 85, 21);
		panel_2_1.add(btnBUSCAR);
		
		JLabel lblNewLabel_6 = new JLabel("Ação");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(225, 10, 59, 25);
		contentPane.add(lblNewLabel_6);
		
		btnBUSCAR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    int idBuscar = Integer.parseInt(BuscarIdt.getText());
                                            
                    Acao buscar = mediatorAcao.buscar(idBuscar);
                    
                    if (buscar != null) {
                    	JOptionPane.showMessageDialog(null, buscar.getIdentificador() + ";"+ buscar.getNome()+";"+buscar.getDataDeValidade()+";"+ buscar.getValorUnitario());
                    	BuscarIdt.setText("");
                    }
                    else {
                    	JOptionPane.showMessageDialog(null, "Ação não encontrada!");
                    }
                    
                   BuscarIdt.setText("");
                    

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: Verifique se o identificador está preenchido!", "Erro", JOptionPane.ERROR_MESSAGE);
                } 
            }
        });
		//FIM DE BUSCAR
	}
}
