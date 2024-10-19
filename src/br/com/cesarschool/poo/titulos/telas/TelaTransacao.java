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
import java.time.LocalDateTime;

import javax.swing.border.LineBorder;

import br.com.cesarschool.poo.titulos.entidades.Acao;
import br.com.cesarschool.poo.titulos.entidades.EntidadeOperadora;
import br.com.cesarschool.poo.titulos.entidades.TituloDivida;
import br.com.cesarschool.poo.titulos.entidades.Transacao;
import br.com.cesarschool.poo.titulos.mediators.MediatorAcao;
import br.com.cesarschool.poo.titulos.mediators.MediatorEntidadeOperadora;
import br.com.cesarschool.poo.titulos.mediators.MediatorTituloDivida;
import br.com.cesarschool.poo.titulos.repositorios.RepositorioTransacao;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class TelaTransacao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField AddEntidadeC;
	private JTextField AddEntidadeD;
	private JTextField AddTitulo;
	private JTextField AddValor;
	private JTextField AddAcao;
	private JTextField BuscarC;
	private JTextField BuscarD;
	MediatorEntidadeOperadora mediatorEntidades = MediatorEntidadeOperadora.getInstance();
	MediatorAcao mediatorAcao = MediatorAcao.getInstance();
	MediatorTituloDivida mediatorTitulo = MediatorTituloDivida.getInstance();
	RepositorioTransacao repositorio = new RepositorioTransacao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTransacao frame = new TelaTransacao();
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
	public TelaTransacao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Transações");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(191, 10, 106, 13);
		contentPane.add(lblNewLabel);
		
		//INICIO ADICIONAR
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 39, 490, 192);
		contentPane.add(panel);
		
		AddEntidadeC = new JTextField();
		AddEntidadeC.setColumns(10);
		AddEntidadeC.setBounds(137, 33, 96, 19);
		panel.add(AddEntidadeC);
		
		JLabel lblEntidadeCredora = new JLabel("Entidade Credora(Id)");
		lblEntidadeCredora.setBounds(10, 36, 143, 13);
		panel.add(lblEntidadeCredora);
		
		JLabel lblTitulo = new JLabel("ADICIONAR");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTitulo.setBounds(10, 10, 84, 13);
		panel.add(lblTitulo);
		
		AddEntidadeD = new JTextField();
		AddEntidadeD.setColumns(10);
		AddEntidadeD.setBounds(158, 62, 96, 19);
		panel.add(AddEntidadeD);
		
		JLabel lblEntidadeDevedora = new JLabel("Entdidade Devedora(Id)");
		lblEntidadeDevedora.setBounds(10, 65, 153, 13);
		panel.add(lblEntidadeDevedora);
		
		JLabel lblAoid = new JLabel("Ação(Id)");
		lblAoid.setBounds(10, 94, 94, 13);
		panel.add(lblAoid);
		
		JLabel lblTituloDividaid = new JLabel("Titulo divida(Id)");
		lblTituloDividaid.setBounds(232, 94, 96, 13);
		panel.add(lblTituloDividaid);
		
		AddTitulo = new JTextField();
		AddTitulo.setColumns(10);
		AddTitulo.setBounds(326, 91, 96, 19);
		panel.add(AddTitulo);
		
		JButton btnADD = new JButton("Adicionar");
		btnADD.setBounds(395, 161, 85, 21);
		panel.add(btnADD);
		
		JLabel lblNewLabel_1 = new JLabel("Valor Operação");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setBounds(10, 132, 94, 13);
		panel.add(lblNewLabel_1);
		
		AddValor = new JTextField();
		AddValor.setColumns(10);
		AddValor.setBounds(114, 129, 96, 19);
		panel.add(AddValor);
		
		AddAcao = new JTextField();
		AddAcao.setColumns(10);
		AddAcao.setBounds(68, 91, 96, 19);
		panel.add(AddAcao);
		
		btnADD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    long identificadorC = Long.parseLong(AddEntidadeC.getText());
                    EntidadeOperadora entidadeCredito =  mediatorEntidades.buscar(identificadorC);
                    
                    long identificadorD = Long.parseLong(AddEntidadeD.getText());
                    EntidadeOperadora entidadeDebito = mediatorEntidades.buscar(identificadorD);
                    
                    Acao acao = null; 
                    int cont = 0;
                    if (!AddAcao.getText().isEmpty()) {
                        int identificadorA = Integer.parseInt(AddAcao.getText());
                        acao = mediatorAcao.buscar(identificadorA);
                        if (acao == null) {
                        	JOptionPane.showMessageDialog(null, "Erro: Acao não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE); 
                        	cont =1;
                        }
                    } 

                    TituloDivida titulo = null;
                    if (!AddTitulo.getText().isEmpty()) {
                        int identificadorT = Integer.parseInt(AddTitulo.getText());
                        titulo = mediatorTitulo.buscar(identificadorT);
                        if (titulo == null) {
                        	JOptionPane.showMessageDialog(null, "Erro: Titulo não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                        	cont=1;
                        }
                    }
                    
                    double valor = Double.parseDouble(AddValor.getText());
                    LocalDateTime dataHoraOperacao = LocalDateTime.now();
                    

                    Transacao novaTransacao = new Transacao(entidadeCredito, entidadeDebito, acao, titulo, valor, dataHoraOperacao);
                                
                    
                    if(entidadeCredito == null) {
                    	JOptionPane.showMessageDialog(null, "Erro: Entidade credito não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(entidadeDebito == null) {
                    	JOptionPane.showMessageDialog(null, "Erro: Entidade debito não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    else if (acao != null && titulo != null && cont==0) {
                        JOptionPane.showMessageDialog(null, "Erro: Somente uma Ação ou um Título pode ser selecionado, não ambos.", "Erro", JOptionPane.ERROR_MESSAGE);
                    } 
                    
                    else if (acao == null && titulo == null && cont ==0) {
                        JOptionPane.showMessageDialog(null, "Erro: Você deve preencher ao menos um campo, Ação ou Título.", "Erro", JOptionPane.ERROR_MESSAGE);
                    } 
                    
                    else if (cont==0){
                        repositorio.incluir(novaTransacao);
                        JOptionPane.showMessageDialog(null, "Transação salva com sucesso!");
                        AddEntidadeC.setText("");
	                    AddEntidadeD.setText("");
	                    AddAcao.setText("");
	                    AddTitulo.setText("");
	                    AddValor.setText("");
                    }
                                                       
                 
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: Verifique se o valor operação, entidade credito e a entidade debito estão corretos!", "Erro", JOptionPane.ERROR_MESSAGE);
                } 
            }
        });
		//FIM ADICIONAR
		
		//INICIO BUSCAR CREDITO
		JLabel lblNewLabel_2 = new JLabel("ou");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(195, 93, 27, 13);
		panel.add(lblNewLabel_2); 
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_1.setBounds(0, 241, 490, 62);
		contentPane.add(panel_2_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("BUSCAR ENTIDADE CREDORA");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_5_1.setBounds(10, 10, 164, 13);
		panel_2_1.add(lblNewLabel_5_1);
		
		BuscarC = new JTextField();
		BuscarC.setColumns(10);
		BuscarC.setBounds(104, 33, 96, 19);
		panel_2_1.add(BuscarC);
		
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
                    
                    long idBuscar = Long.parseLong(BuscarC.getText());
                    Transacao[] transacoes = repositorio.buscarPorEntidadeCredora(idBuscar);
                                                               
                    
                    if (transacoes.length != 0) {
                    	StringBuilder mensagem = new StringBuilder();
                    	for (Transacao transacao : transacoes) {
                    	    if (transacao.getTituloDivida() == null) {
                    	        mensagem.append(transacao.getEntidadeCredito().getIdentificador())
                    	                .append(";").append(transacao.getEntidadeCredito().getNome())
                    	                .append(";").append(transacao.getEntidadeCredito().getAutorizadoAcao())
                    	                .append(";").append(transacao.getEntidadeCredito().getSaldoAcao())
                    	                .append(";").append(transacao.getEntidadeCredito().getSaldoTituloDivida())
                    	                .append(";").append(transacao.getEntidadeDebito().getIdentificador())
                    	                .append(";").append(transacao.getEntidadeDebito().getNome())
                    	                .append(";").append(transacao.getEntidadeDebito().getAutorizadoAcao())
                    	                .append(";").append(transacao.getEntidadeDebito().getSaldoAcao())
                    	                .append(";").append(transacao.getEntidadeDebito().getSaldoTituloDivida())
                    	                .append(";").append(transacao.getAcao().getIdentificador())
                    	                .append(";").append(transacao.getAcao().getNome())
                    	                .append(";").append(transacao.getAcao().getDataDeValidade())
                    	                .append(";").append(transacao.getAcao().getValorUnitario())
                    	                .append(";null").append(";")
                    	                .append(transacao.getValorOperacao())
                    	                .append(";").append(transacao.getDataHoraOperacao())
                    	                .append("\n");
                    	    } 
                    	    else {
                    	        mensagem.append(transacao.getEntidadeCredito().getIdentificador())
                    	                .append(";").append(transacao.getEntidadeCredito().getNome())
                    	                .append(";").append(transacao.getEntidadeCredito().getAutorizadoAcao())
                    	                .append(";").append(transacao.getEntidadeCredito().getSaldoAcao())
                    	                .append(";").append(transacao.getEntidadeCredito().getSaldoTituloDivida())
                    	                .append(";").append(transacao.getEntidadeDebito().getIdentificador())
                    	                .append(";").append(transacao.getEntidadeDebito().getNome())
                    	                .append(";").append(transacao.getEntidadeDebito().getAutorizadoAcao())
                    	                .append(";").append(transacao.getEntidadeDebito().getSaldoAcao())
                    	                .append(";").append(transacao.getEntidadeDebito().getSaldoTituloDivida())
                    	                .append(";null").append(";")
                    	                .append(transacao.getTituloDivida().getIdentificador())
                    	                .append(";").append(transacao.getTituloDivida().getNome())
                    	                .append(";").append(transacao.getTituloDivida().getDataDeValidade())
                    	                .append(";").append(transacao.getTituloDivida().getTaxaJuros())
                    	                .append(";").append(transacao.getValorOperacao())
                    	                .append(";").append(transacao.getDataHoraOperacao())
                    	                .append("\n");
                    	    }
                    	}
                    	JOptionPane.showMessageDialog(null, mensagem.toString());                    	
                    	BuscarC.setText("");
                    }
                    else {
                    	JOptionPane.showMessageDialog(null, "Entidade não possui transações como entidade credora!");
                    }
                                                    

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: Verifique se o identificador está preenchido!", "Erro", JOptionPane.ERROR_MESSAGE);
                } 
            }
        });
		//FIM BUSCAR CREDITO
		
		//INICIO BUSCAR DEBITO
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_1_1.setBounds(0, 313, 490, 62);
		contentPane.add(panel_2_1_1);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("BUSCAR ENTIDADE DEVEDORA");
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_5_1_1.setBounds(10, 10, 164, 13);
		panel_2_1_1.add(lblNewLabel_5_1_1);
		
		BuscarD = new JTextField();
		BuscarD.setColumns(10);
		BuscarD.setBounds(104, 33, 96, 19);
		panel_2_1_1.add(BuscarD);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Identificador");
		lblNewLabel_4_1_1_1.setBounds(10, 36, 84, 13);
		panel_2_1_1.add(lblNewLabel_4_1_1_1);
		
		JButton btnBUSCAR_1 = new JButton("Buscar");
		btnBUSCAR_1.setBounds(395, 32, 85, 21);
		panel_2_1_1.add(btnBUSCAR_1);
		
		btnBUSCAR_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    long idBuscar = Long.parseLong(BuscarD.getText());
                    Transacao[] transacoes = repositorio.buscarPorEntidadeCredoraD(idBuscar);
                                                               
                    
                    if (transacoes.length != 0) {
                    	StringBuilder mensagem = new StringBuilder();
                    	for (Transacao transacao : transacoes) {
                    	    if (transacao.getTituloDivida() == null) {
                    	        mensagem.append(transacao.getEntidadeCredito().getIdentificador())
                    	                .append(";").append(transacao.getEntidadeCredito().getNome())
                    	                .append(";").append(transacao.getEntidadeCredito().getAutorizadoAcao())
                    	                .append(";").append(transacao.getEntidadeCredito().getSaldoAcao())
                    	                .append(";").append(transacao.getEntidadeCredito().getSaldoTituloDivida())
                    	                .append(";").append(transacao.getEntidadeDebito().getIdentificador())
                    	                .append(";").append(transacao.getEntidadeDebito().getNome())
                    	                .append(";").append(transacao.getEntidadeDebito().getAutorizadoAcao())
                    	                .append(";").append(transacao.getEntidadeDebito().getSaldoAcao())
                    	                .append(";").append(transacao.getEntidadeDebito().getSaldoTituloDivida())
                    	                .append(";").append(transacao.getAcao().getIdentificador())
                    	                .append(";").append(transacao.getAcao().getNome())
                    	                .append(";").append(transacao.getAcao().getDataDeValidade())
                    	                .append(";").append(transacao.getAcao().getValorUnitario())
                    	                .append(";null").append(";")
                    	                .append(transacao.getValorOperacao())
                    	                .append(";").append(transacao.getDataHoraOperacao())
                    	                .append("\n");
                    	    } 
                    	    else {
                    	        mensagem.append(transacao.getEntidadeCredito().getIdentificador())
                    	                .append(";").append(transacao.getEntidadeCredito().getNome())
                    	                .append(";").append(transacao.getEntidadeCredito().getAutorizadoAcao())
                    	                .append(";").append(transacao.getEntidadeCredito().getSaldoAcao())
                    	                .append(";").append(transacao.getEntidadeCredito().getSaldoTituloDivida())
                    	                .append(";").append(transacao.getEntidadeDebito().getIdentificador())
                    	                .append(";").append(transacao.getEntidadeDebito().getNome())
                    	                .append(";").append(transacao.getEntidadeDebito().getAutorizadoAcao())
                    	                .append(";").append(transacao.getEntidadeDebito().getSaldoAcao())
                    	                .append(";").append(transacao.getEntidadeDebito().getSaldoTituloDivida())
                    	                .append(";null").append(";")
                    	                .append(transacao.getTituloDivida().getIdentificador())
                    	                .append(";").append(transacao.getTituloDivida().getNome())
                    	                .append(";").append(transacao.getTituloDivida().getDataDeValidade())
                    	                .append(";").append(transacao.getTituloDivida().getTaxaJuros())
                    	                .append(";").append(transacao.getValorOperacao())
                    	                .append(";").append(transacao.getDataHoraOperacao())
                    	                .append("\n");
                    	    }
                    	}
                    	JOptionPane.showMessageDialog(null, mensagem.toString());                    	
                    	BuscarC.setText("");
                    }
                    else {
                    	JOptionPane.showMessageDialog(null, "Entidade não possui transações como entidade devedora!");
                    }
                                                    

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: Verifique se o identificador está preenchido!", "Erro", JOptionPane.ERROR_MESSAGE);
                } 
            }
        });		
		//FIM BUSCAR DEBITO
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setBounds(10, 394, 85, 21);
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
