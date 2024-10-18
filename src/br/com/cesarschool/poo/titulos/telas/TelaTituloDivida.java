package br.com.cesarschool.poo.titulos.telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import br.com.cesarschool.poo.titulos.entidades.Acao;
import br.com.cesarschool.poo.titulos.entidades.TituloDivida;
import br.com.cesarschool.poo.titulos.mediators.MediatorTituloDivida;

import java.awt.Color;
import javax.swing.JTextField;
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

import javax.swing.JButton;

public class TelaTituloDivida extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField AddId;
	private JTextField AddNome;
	private JTextField AddValidade;
	private JTextField AddJuros;
	private JTextField AltId;
	private JTextField AltNome;
	private JTextField AltValidade;
	private JTextField AltJuros;
	private JTextField DeleteId;
	private JTextField BuscarId;
	MediatorTituloDivida mediatorTitulo = MediatorTituloDivida.getInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTituloDivida frame = new TelaTituloDivida();
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
	public TelaTituloDivida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 629);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Titulo Divida");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(179, 10, 138, 13);
		contentPane.add(lblNewLabel);
		
		
		//INICIO ADICIONAR
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 42, 490, 167);
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
		
		JLabel lblDataValidade = new JLabel("Data de validade");
		lblDataValidade.setBounds(10, 94, 94, 13);
		panel.add(lblDataValidade);
		
		AddValidade = new JTextField();
		AddValidade.setColumns(10);
		AddValidade.setBounds(114, 91, 96, 19);
		panel.add(AddValidade);
		
		JLabel lblTaxaJuros = new JLabel("Taxa Juros");
		lblTaxaJuros.setBounds(10, 126, 84, 13);
		panel.add(lblTaxaJuros);
		
		AddJuros = new JTextField();
		AddJuros.setColumns(10);
		AddJuros.setBounds(104, 120, 96, 19);
		panel.add(AddJuros);
		
		JButton btnADD = new JButton("Adicionar");
		btnADD.setBounds(395, 136, 85, 21);
		panel.add(btnADD);
		
		 btnADD.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                try {
	                    
	                    int identificador = Integer.parseInt(AddId.getText());
	                    String nome = AddNome.getText();
	                    
	                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	                    LocalDate dataDeValidade = LocalDate.parse(AddValidade.getText(), formatter);
	                    
	                    double taxaJuros = Double.parseDouble(AddJuros.getText());

	                    TituloDivida novoTitulo = new TituloDivida(identificador, nome, dataDeValidade, taxaJuros);             
	                    String incluir = mediatorTitulo.incluir(novoTitulo);
	                    
	                    if (incluir != null) {
	                    	JOptionPane.showMessageDialog(null, incluir);
	                    }
	                    else {
	                    	JOptionPane.showMessageDialog(null, "Titulo incluido com sucesso!");
	                    	AddId.setText("");
		                    AddNome.setText("");
		                    AddValidade.setText("");
		                    AddJuros.setText("");
	                    }
	                    
	                 
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(null, "Erro: Verifique se o identificador e o taxa juros estão corretos!", "Erro", JOptionPane.ERROR_MESSAGE);
	                } catch (DateTimeParseException ex) {
	                    JOptionPane.showMessageDialog(null, "Erro: Data de validade inválida. Use o formato dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        });
		//FIM ADICIONAR
		
		//INICIO ALTERAR 
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 219, 490, 167);
		contentPane.add(panel_1);
		
		AltId = new JTextField();
		AltId.setColumns(10);
		AltId.setBounds(104, 33, 96, 19);
		panel_1.add(AltId);
		
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
		
		AltValidade = new JTextField();
		AltValidade.setColumns(10);
		AltValidade.setBounds(104, 91, 96, 19);
		panel_1.add(AltValidade);
		
		JLabel lblNewLabel_2_1 = new JLabel("Taxa Juros");
		lblNewLabel_2_1.setBounds(10, 126, 84, 13);
		panel_1.add(lblNewLabel_2_1);
		
		AltJuros = new JTextField();
		AltJuros.setColumns(10);
		AltJuros.setBounds(104, 120, 96, 19);
		panel_1.add(AltJuros);
		
		
		JButton btnALT = new JButton("Alterar");
		btnALT.setBounds(395, 136, 85, 21);
		panel_1.add(btnALT);
		
		btnALT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    int idntAlt = Integer.parseInt(AltId.getText());
                    String nomeAlt = AltNome.getText();
                    
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate validadeAlt = LocalDate.parse(AltValidade.getText(), formatter);
                    
                    double jurosAlt = Double.parseDouble(AltJuros.getText());

                    TituloDivida novoTitulo2 = new TituloDivida(idntAlt,nomeAlt, validadeAlt, jurosAlt);              
                    String alterar = mediatorTitulo.alterar(novoTitulo2);
                    
                    if (alterar != null) {
                    	JOptionPane.showMessageDialog(null, alterar);
                    }
                    else {
                    	JOptionPane.showMessageDialog(null, "Titulo alterada com sucesso!");
                    	AltId.setText("");
                        AltNome.setText("");
                        AltValidade.setText("");
                        AltJuros.setText("");
                    }
                                        

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: Verifique se o identificador e o taxa juros estão corretos!", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: Data de validade inválida. Use o formato dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
		//FIM ALTERAR
		
		//INICIO EXCLUIR
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(0, 396, 490, 62);
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
                    
                    int idntDelete = Integer.parseInt(DeleteId.getText());
                                            
                    String excluir = mediatorTitulo.excluir(idntDelete);
                    
                    if (excluir != null) {
                    	JOptionPane.showMessageDialog(null, excluir);
                    }
                    else {
                    	JOptionPane.showMessageDialog(null, "Titulo excluida com sucesso!");
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
		panel_2_1.setBounds(0, 468, 490, 62);
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
                    
                    int idBuscar = Integer.parseInt(BuscarId.getText());
                                            
                    TituloDivida buscar = mediatorTitulo.buscar(idBuscar);
                    
                    if (buscar != null) {
                    	JOptionPane.showMessageDialog(null, buscar.getIdentificador() + ";"+ buscar.getNome()+";"+buscar.getDataDeValidade()+";"+ buscar.getTaxaJuros());
                    	BuscarId.setText("");
                    }
                    else {
                    	JOptionPane.showMessageDialog(null, "Titulo não encontrado!");
                    }
                                   
                    

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: Verifique se o identificador está preenchido!", "Erro", JOptionPane.ERROR_MESSAGE);
                } 
            }
        });
		//FIM BUSCAR
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setBounds(10, 561, 85, 21);
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
