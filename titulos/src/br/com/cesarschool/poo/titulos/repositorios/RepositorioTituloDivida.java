package br.com.cesarschool.poo.titulos.repositorios;

import br.com.cesarschool.poo.titulos.entidades.Acao;
import br.com.cesarschool.poo.titulos.entidades.TituloDivida;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Scanner;


public class RepositorioTituloDivida {

	private static final String FILE_NAME = "TituloDivida.txt";
	private static final String TEMP_FILE_NAME = "TituloDivida_temp.txt";

	public boolean incluir(TituloDivida tituloDivida) {

		try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
			while (scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				String[] dividirLinha = linha.split(";");
				if (Long.parseLong(dividirLinha[0]) == tituloDivida.getIdentificador()) {
					return false;
				}
			}
		}
		catch (FileNotFoundException e) {
			// Arquivo não existe
		}
		try (FileWriter fw = new FileWriter(FILE_NAME, true); PrintWriter pw = new PrintWriter(fw)) {
			String linha = tituloDivida.getIdentificador() + ";" + tituloDivida.getNome() + ";" + tituloDivida.getDataDeValidade() + ";"
					+ tituloDivida.getTaxaJuros();
			pw.println(linha);
			pw.flush();
			pw.close();
			fw.close();
			return true;
		}
		catch (IOException e) {
			return false;
		}
	}

	public boolean alterar(TituloDivida tituloDivida) {

		File inputFile = new File(FILE_NAME);
		File tempFile = new File(TEMP_FILE_NAME);
		boolean linhaAlterada = false;

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			 BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

			String linha;
			while ((linha = reader.readLine()) != null) {
				String[] partes = linha.split(";");
				int idArquivo = Integer.parseInt(partes[0]);

				if (idArquivo != tituloDivida.getIdentificador()) {
					writer.write(linha + System.lineSeparator());
				} else {
					String linhaNova = tituloDivida.getIdentificador() + ";" + tituloDivida.getNome() + ";" + tituloDivida.getDataDeValidade() + ";"
							+ tituloDivida.getTaxaJuros();
					writer.write(linhaNova + System.lineSeparator());
					linhaAlterada = true;
				}
			}
		}
		catch (IOException e) {
			return false;
		}

		if (linhaAlterada) {
			try {
				Files.delete(Paths.get(FILE_NAME)); // Apaga o arquivo original
				Files.move(Paths.get(TEMP_FILE_NAME), Paths.get(FILE_NAME)); // Renomeia o temporário
			}
			catch (IOException e) {
				return false;
			}
			return true;
		}
		else {
			tempFile.delete();
			return false;
		}
	}

	public boolean excluir(int identificador) {

		File inputFile = new File(FILE_NAME);
		File tempFile = new File(TEMP_FILE_NAME);
		boolean linhaExcluida = false;

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			 BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

			String linha;
			while ((linha = reader.readLine()) != null) {
				String[] partes = linha.split(";");
				int idArquivo = Integer.parseInt(partes[0]);

				if (idArquivo != identificador) {
					writer.write(linha + System.lineSeparator());
				} else {
					linhaExcluida = true;
				}
			}
		}
		catch (IOException e) {
			return false;
		}

		if (linhaExcluida) {
			try {
				Files.delete(Paths.get(FILE_NAME));
				Files.move(Paths.get(TEMP_FILE_NAME), Paths.get(FILE_NAME));
			}
			catch (IOException e) {
				return false;
			}
			return true;
		}
		else {
			tempFile.delete();
			return false;
		}
	}
	public TituloDivida buscar(int identificador) {

		try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
			while (scanner.hasNextLine()) {
				String linha = scanner.nextLine();
				String[] partes = linha.split(";");
				int idArquivo = Integer.parseInt(partes[0]);
				if (idArquivo == identificador) {
					String nome = partes[1];
					LocalDate dataValidade = LocalDate.parse(partes[2]);
					double taxaJuros = Double.parseDouble(partes[3]);
					return new TituloDivida(idArquivo, nome, dataValidade, taxaJuros);
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado: " + FILE_NAME);
		}
		return null;
	}
}