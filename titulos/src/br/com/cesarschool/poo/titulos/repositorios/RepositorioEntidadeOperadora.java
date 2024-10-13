package br.com.cesarschool.poo.titulos.repositorios;

import br.com.cesarschool.poo.titulos.entidades.EntidadeOperadora;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Scanner;

/*
 * Deve gravar em e ler de um arquivo texto chamado Acao.txt os dados dos objetos do tipo
 * Acao. Seguem abaixo exemplos de linhas.
 *
    1;PETROBRAS;2024-12-12;30.33
    2;BANCO DO BRASIL;2026-01-01;21.21
    3;CORREIOS;2027-11-11;6.12 
 * 
 * A inclusao deve adicionar uma nova linha ao arquivo. Nao e permitido incluir
 * identificador repetido. Neste caso, o metodo deve retornar false. Inclusao com
 * sucesso, retorno true.
 * 
 * A alteracao deve substituir a linha atual por uma nova linha. A linha deve ser
 * localizada por identificador que, quando nao encontrado, enseja retorno false.
 * Alteracao com sucesso, retorno true.
 *   
 * A exclusao deve apagar a linha atual do arquivo. A linha deve ser
 * localizada por identificador que, quando nao encontrado, enseja retorno false.
 * Exclusao com sucesso, retorno true.
 * 
 * A busca deve localizar uma linha por identificador, materializar e retornar um 
 * objeto. Caso o identificador nao seja encontrado no arquivo, retornar null.
 */
public class RepositorioEntidadeOperadora {
    private static final String FILE_NAME = "EntidadeOperadora.txt";
    private static final String TEMP_FILE_NAME = "EntidadeOperadora_temp.txt";

    public boolean incluir(EntidadeOperadora entidadeOperadora) {

        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] dividirLinha = linha.split(";");
                if (Long.parseLong(dividirLinha[0]) == entidadeOperadora.getIdentificador()) {
                    return false;
                }
            }
        }
        catch (FileNotFoundException e) {
            // Arquivo não existe
        }
        try (FileWriter fw = new FileWriter(FILE_NAME, true); PrintWriter pw = new PrintWriter(fw)) {
            String linha = entidadeOperadora.getIdentificador() + ";" + entidadeOperadora.getNome() + ";" + entidadeOperadora.getAutorizadoAcao() + ";"
                    + entidadeOperadora.getSaldoAcao() +";" + entidadeOperadora.getSaldoTituloDivida();
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

    public boolean alterar(EntidadeOperadora entidadeOperadora) {

        File inputFile = new File(FILE_NAME);
        File tempFile = new File(TEMP_FILE_NAME);
        boolean linhaAlterada = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                int idArquivo = Integer.parseInt(partes[0]);

                if (idArquivo != entidadeOperadora.getIdentificador()) {
                    writer.write(linha + System.lineSeparator());
                } else {
                    String linhaNova = entidadeOperadora.getIdentificador() + ";" + entidadeOperadora.getNome() + ";" + entidadeOperadora.getAutorizadoAcao() + ";"
                            + entidadeOperadora.getSaldoAcao() +";" + entidadeOperadora.getSaldoTituloDivida();
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

    public EntidadeOperadora buscar(int identificador) {

        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] partes = linha.split(";");
                int idArquivo = Integer.parseInt(partes[0]);
                if (idArquivo == identificador) {
                    String nome = partes[1];
                    boolean autorizadoAcao = Boolean.parseBoolean(partes[2]);
                    double saldoAcao = Double.parseDouble(partes[3]);
                    double saldoTituloDivida = Double.parseDouble(partes[4]);
                    return new EntidadeOperadora(idArquivo, nome, autorizadoAcao, saldoAcao, saldoTituloDivida);
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + FILE_NAME);
        }

        return null;
    }

}
