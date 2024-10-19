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
import br.com.cesarschool.poo.titulos.mediators.MediatorOperacao;
import br.com.cesarschool.poo.titulos.mediators.MediatorTituloDivida;
import br.com.cesarschool.poo.titulos.repositorios.RepositorioTransacao;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class TelaOperacao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField opC;
	private JTextField opD;
	private JTextField opT;
	private JTextField opV;
	private JTextField opA;
	private JTextField ExId;
	MediatorOperacao mediatorOperacao = MediatorOperacao.getInstance();
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
					TelaOperacao frame = new TelaOperacao();
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
	public TelaOperacao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Operações");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(200, 10, 83, 17);
		contentPane.add(lblNewLabel);
		
		//INICIO OPERAÇÃO
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 37, 490, 192);
		contentPane.add(panel);
		
		opC = new JTextField();
		opC.setColumns(10);
		opC.setBounds(140, 33, 96, 19);
		panel.add(opC);
		
		JLabel lblEntidadeCredora = new JLabel("Entidade Credora(Id)");
		lblEntidadeCredora.setBounds(10, 36, 129, 13);
		panel.add(lblEntidadeCredora);
		
		JLabel lblRealizarOperao = new JLabel("REALIZAR OPERAÇÃO");
		lblRealizarOperao.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblRealizarOperao.setBounds(10, 10, 129, 13);
		panel.add(lblRealizarOperao);
		
		opD = new JTextField();
		opD.setColumns(10);
		opD.setBounds(150, 62, 96, 19);
		panel.add(opD);
		
		JLabel lblEntidadeDevedora = new JLabel("Entdidade Devedora(Id)");
		lblEntidadeDevedora.setBounds(10, 65, 143, 13);
		panel.add(lblEntidadeDevedora);
		
		JLabel textfiledA = new JLabel("Ação(Id)");
		textfiledA.setBounds(10, 94, 94, 13);
		panel.add(textfiledA);
		
		JLabel lblTituloDividaid = new JLabel("Titulo divida(Id)");
		lblTituloDividaid.setBounds(232, 94, 96, 13);
		panel.add(lblTituloDividaid);
		
		opT = new JTextField();
		opT.setColumns(10);
		opT.setBounds(326, 91, 96, 19);
		panel.add(opT);
		
		JButton btnRealizar = new JButton("Realizar");
		btnRealizar.setBounds(395, 161, 85, 21);
		panel.add(btnRealizar);
		
		JLabel lblNewLabel_1 = new JLabel("Valor Operação");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setBounds(10, 132, 94, 13);
		panel.add(lblNewLabel_1);
		
		opV = new JTextField();
		opV.setColumns(10);
		opV.setBounds(114, 129, 96, 19);
		panel.add(opV);
		
		opA = new JTextField();
		opA.setColumns(10);
		opA.setBounds(68, 91, 96, 19);
		panel.add(opA);
		
		JLabel lblNewLabel_2 = new JLabel("ou");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(195, 93, 27, 13);
		panel.add(lblNewLabel_2);
		
		btnRealizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    long identificadorC = Long.parseLong(opC.getText());
                    EntidadeOperadora entidadeCredito =  mediatorEntidades.buscar(identificadorC);
                    
                    long identificadorD = Long.parseLong(opD.getText());
                    EntidadeOperadora entidadeDebito = mediatorEntidades.buscar(identificadorD);
                    
                    boolean ehAcao = true;
                    Acao acao = null; 
                    int cont = 0;
                    int identificadorA=0;
                    if (!opA.getText().isEmpty()) {         
                    	identificadorA = Integer.parseInt(opA.getText());
                        acao = mediatorAcao.buscar(identificadorA);                       
                        if (acao == null) {
                        	JOptionPane.showMessageDialog(null, "Erro: Acao não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE); 
                        	cont =1;
                        }
                        else {
                        	ehAcao = true;
                        }
                    } 
                    	
                    TituloDivida titulo = null;
                    int identificadorT=0;
                    if (!opT.getText().isEmpty()) {   
                    	identificadorT = Integer.parseInt(opT.getText());
                        titulo = mediatorTitulo.buscar(identificadorT);                         
                        if (titulo == null) {
                        	JOptionPane.showMessageDialog(null, "Erro: Titulo não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
                        	cont=1;
                        }
                        else {
                        	ehAcao = false;
                        }
                    }
                    
                    double valor = Double.parseDouble(opV.getText());
                                                                                                         
               
                    if (acao != null && titulo != null && cont==0) {
                        JOptionPane.showMessageDialog(null, "Erro: Somente uma Ação ou um Título pode ser selecionado, não ambos.", "Erro", JOptionPane.ERROR_MESSAGE);
                    } 
                    
                    else if (acao == null && titulo == null && cont ==0) {
                        JOptionPane.showMessageDialog(null, "Erro: Você deve preencher ao menos um campo, Ação ou Título.", "Erro", JOptionPane.ERROR_MESSAGE);
                    } 
                    
                    else if (cont==0){
                    	if(ehAcao == true) {
	                        String resultado = mediatorOperacao.realizarOperacao(ehAcao , identificadorC, identificadorD, identificadorA , valor);
	                        JOptionPane.showMessageDialog(null, resultado);
                    	}
                    	else {
                    		String resultado2 = mediatorOperacao.realizarOperacao(ehAcao , identificadorC, identificadorD, identificadorT , valor);
                            JOptionPane.showMessageDialog(null, resultado2);
                    	}
                    	
                    
                        opC.setText("");
	                    opD.setText("");
	                    opA.setText("");
	                    opT.setText("");
	                    opV.setText("");
                    }
                                                       
                 
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: Verifique se o valor operação, entidade credito e a entidade debito estão corretos!", "Erro", JOptionPane.ERROR_MESSAGE);
                } 
            }
        });
		//FIM OPERAÇÃO
		
		//INICIO EXTRATO
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_1.setBounds(10, 253, 490, 62);
		contentPane.add(panel_2_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("GERAR EXTRATO");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_5_1.setBounds(10, 10, 164, 13);
		panel_2_1.add(lblNewLabel_5_1);
		
		ExId = new JTextField();
		ExId.setColumns(10);
		ExId.setBounds(104, 33, 96, 19);
		panel_2_1.add(ExId);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Entidade (Id)");
		lblNewLabel_4_1_1.setBounds(10, 36, 84, 13);
		panel_2_1.add(lblNewLabel_4_1_1);
		
		JButton btnGerar = new JButton("Gerar");
		btnGerar.setBounds(395, 32, 85, 21);
		panel_2_1.add(btnGerar);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setBounds(10, 339, 85, 21);
		contentPane.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaMenu frame = new TelaMenu();
				frame.setVisible(true);
				dispose();
			}
		});
		
		btnGerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    int idBuscar = Integer.parseInt(ExId.getText());
                    Transacao[] transacoes = mediatorOperacao.gerarExtrato(idBuscar);
                                                               
                    
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
                    	ExId.setText("");
                    }
                    else {
                    	JOptionPane.showMessageDialog(null, "Entidade não possui transações!");
                    }
                                                    

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: Verifique se o identificador está preenchido!", "Erro", JOptionPane.ERROR_MESSAGE);
                } 
            }
        });
		//FIM EXTRATO
	}

}
