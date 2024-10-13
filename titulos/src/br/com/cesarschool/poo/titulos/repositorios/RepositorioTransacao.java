package br.com.cesarschool.poo.titulos.repositorios;

import br.com.cesarschool.poo.titulos.entidades.EntidadeOperadora;
import br.com.cesarschool.poo.titulos.entidades.TituloDivida;
import br.com.cesarschool.poo.titulos.entidades.Transacao;
import br.com.cesarschool.poo.titulos.entidades.Acao;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/*
 * Deve gravar em e ler de um arquivo texto chamado Transacao.txt os dados dos objetos do tipo
 * Transacao. Seguem abaixo exemplos de linhas 
 * De entidadeCredito: identificador, nome, autorizadoAcao, saldoAcao, saldoTituloDivida.
 * De entidadeDebito: identificador, nome, autorizadoAcao, saldoAcao, saldoTituloDivida.
 * De acao: identificador, nome, dataValidade, valorUnitario OU null
 * De tituloDivida: identificador, nome, dataValidade, taxaJuros OU null. 
 * valorOperacao, dataHoraOperacao
 *
 *   002192;BCB;true;0.00;1890220034.0;001112;BOFA;true;12900000210.00;3564234127.0;1;PETROBRAS;2024-12-12;30.33;null;100000.0;2024-01-01 12:22:21 
 *   002192;BCB;false;0.00;1890220034.0;001112;BOFA;true;12900000210.00;3564234127.0;null;3;FRANCA;2027-11-11;2.5;100000.0;2024-01-01 12:22:21
 *
 * (FEITO) A inclusao deve adicionar uma nova linha ao arquivo.
 * 
 * (FEITO) A busca deve retornar um array de transacoes cuja entidadeCredito tenha identificador igual ao
 * recebido como parametro.
 */
public class RepositorioTransacao {
	private static final String FILE_NAME = "Transacao.txt";

	public void incluir(Transacao transacao) {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {

			String entidadeCreditoStr = String.format(Locale.US, "%s;%s;%b;%.2f;%.2f",
					transacao.getEntidadeCredito().getIdentificador(),
					transacao.getEntidadeCredito().getNome(),
					transacao.getEntidadeCredito().getAutorizadoAcao(),
					transacao.getEntidadeCredito().getSaldoAcao(),
					transacao.getEntidadeCredito().getSaldoTituloDivida());

			String entidadeDebitoStr = String.format(Locale.US, "%s;%s;%b;%.2f;%.2f",
					transacao.getEntidadeDebito().getIdentificador(),
					transacao.getEntidadeDebito().getNome(),
					transacao.getEntidadeDebito().getAutorizadoAcao(),
					transacao.getEntidadeDebito().getSaldoAcao(),
					transacao.getEntidadeDebito().getSaldoTituloDivida());

			String acaoStr = transacao.getAcao() != null ? String.format(Locale.US, "%d;%s;%s;%.2f",
					transacao.getAcao().getIdentificador(),
					transacao.getAcao().getNome(),
					transacao.getAcao().getDataDeValidade(),
					transacao.getAcao().getValorUnitario()
			) : "null";

			String tituloDividaStr = transacao.getTituloDivida() != null ? String.format(Locale.US, "%d;%s;%s;%.2f",
					transacao.getTituloDivida().getIdentificador(),
					transacao.getTituloDivida().getNome(),
					transacao.getTituloDivida().getDataDeValidade(),
					transacao.getTituloDivida().getTaxaJuros()
			) : "null";

			String valorOperacaoStr = String.format(Locale.US, "%.2f", transacao.getValorOperacao());
			String dataHoraOperacaoStr = transacao.getDataHoraOperacao()
					.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

			String linha = String.format("%s;%s;%s;%s;%s;%s", entidadeCreditoStr, entidadeDebitoStr, acaoStr,
					tituloDividaStr, valorOperacaoStr, dataHoraOperacaoStr);

			writer.write(linha);
			writer.newLine();

		} catch (IOException e) {
			System.out.println("Ocorreu um erro");
		}
	}


	public Transacao[] buscarPorEntidadeCredora(int identificadorEntidadeCredito) {
		List<Transacao> transacoesEncontradas = new ArrayList<>();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
			String linha;

			while ((linha = reader.readLine()) != null) {
				String[] partes = linha.split(";");
				String idCredito = partes[0];
				if (Integer.parseInt(idCredito) == identificadorEntidadeCredito) {
					String nomeCredito = partes[1];
					boolean autorizadoAcaoCredito = Boolean.parseBoolean(partes[2]);
					double saldoAcaoCredito = Double.parseDouble(partes[3]);
					double saldoTituloDividaCredito = Double.parseDouble(partes[4]);
					String idDebito = partes[5];
					String nomeDebito = partes[6];
					boolean autorizadoAcaoDebito = Boolean.parseBoolean(partes[7]);
					double saldoAcaoDebito = Double.parseDouble(partes[8]);
					double saldoTituloDividaDebito = Double.parseDouble(partes[9]);

					// Extraindo os dados de Acao (ou null)
					Acao acao = null;
					if (!partes[10].equals("null")) {
						int idAcao = Integer.parseInt(partes[10]);
						String nomeAcao = partes[11];
						LocalDate dataValidadeAcao = LocalDate.parse(partes[12], dateFormatter);
						double valorUnitarioAcao = Double.parseDouble(partes[13]);
						acao = new Acao(idAcao, nomeAcao, dataValidadeAcao, valorUnitarioAcao);
					}

					// Extraindo os dados de TituloDivida (ou null)
					TituloDivida tituloDivida = null;
					if (!partes[14].equals("null")) {
						int idTitulo = Integer.parseInt(partes[14]);
						String nomeTitulo = partes[15];
						LocalDate dataValidadeTitulo = LocalDate.parse(partes[16], dateFormatter);
						double taxaJuros = Double.parseDouble(partes[17]);
						tituloDivida = new TituloDivida(idTitulo, nomeTitulo, dataValidadeTitulo, taxaJuros);
					}


					double valorOperacao = Double.parseDouble(partes[partes.length-2]);
					LocalDateTime dataHoraOperacao = LocalDateTime.parse(partes[partes.length-1], dateTimeFormatter);


					EntidadeOperadora entidadeCredito = new EntidadeOperadora(Long.parseLong(idCredito), nomeCredito, autorizadoAcaoCredito, saldoAcaoCredito, saldoTituloDividaCredito);
					EntidadeOperadora entidadeDebito = new EntidadeOperadora(Long.parseLong(idDebito), nomeDebito, autorizadoAcaoDebito, saldoAcaoDebito, saldoTituloDividaDebito);
					Transacao transacao = new Transacao(entidadeCredito, entidadeDebito, acao, tituloDivida, valorOperacao, dataHoraOperacao);
					transacoesEncontradas.add(transacao);
				}
			}
		} catch (IOException e) {
			return null;
		}

		return transacoesEncontradas.toArray(new Transacao[0]);
	}
}
