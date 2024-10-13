package br.com.cesarschool.poo.titulos.repositorios;
import  br.com.cesarschool.poo.titulos.entidades.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProgramaTeste {
    public static void main(String[] args) {
        RepositorioAcao repositorioAcao = new RepositorioAcao();
        RepositorioEntidadeOperadora repositorioEntidadeOperadora = new RepositorioEntidadeOperadora();
        RepositorioTituloDivida repositorioTituloDivida = new RepositorioTituloDivida();
        RepositorioTransacao repo = new RepositorioTransacao();
        /*
        Acao acao1 = new Acao(1, "Petrobras", LocalDate.of(2024, 12, 12), 30.33);
        Acao acao2 = new Acao(2, "Banco do Brasil", LocalDate.of(2026, 1, 1), 21.21);
        Acao acao3 = new Acao(3, "Correios", LocalDate.of(2027, 11, 11), 6.12);
        Acao acao4 = new Acao(3, "Banco Central", LocalDate.of(2000, 10, 19), 19.12);

        repositorioAcao.incluir(acao1);
        repositorioAcao.incluir(acao2);
        repositorioAcao.incluir(acao3);

        Acao acaoEncontrada = repositorioAcao.buscar(3);
        System.out.println(acaoEncontrada.getNome());

        //repositorioAcao.excluir(2);

        repositorioAcao.alterar(acao4);*/

        /*
        EntidadeOperadora entidadeOperadora1 = new EntidadeOperadora(2192,"0BCB",true,0.00,
        1890220034.0);
        EntidadeOperadora entidadeOperadora2 = new EntidadeOperadora(1112,"BOFA",true,
                12900000210.00,3564234127.0);
        EntidadeOperadora entidadeOperadora3 = new EntidadeOperadora(1112,"BBC",false,
                123456789.00,2021232425.0);

        repositorioEntidadeOperadora.incluir(entidadeOperadora1);
        repositorioEntidadeOperadora.incluir(entidadeOperadora2);

        repositorioEntidadeOperadora.excluir(2192);
        EntidadeOperadora entidadeOperadora4 = repositorioEntidadeOperadora.buscar(1112);
        System.out.print(entidadeOperadora4.getNome());
        repositorioEntidadeOperadora.alterar(entidadeOperadora3);*/

        /*
        TituloDivida tituloDivida1 = new TituloDivida(1,"BRASIL",LocalDate.of(2024,12,12),10.5);
        TituloDivida tituloDivida2 = new TituloDivida(2,"EUA",LocalDate.of(2026,1,1),30.9);
        TituloDivida tituloDivida3 = new TituloDivida(3,"FRANCA",LocalDate.of(2027,11,11),2.5);

        repositorioTituloDivida.incluir(tituloDivida1);
        repositorioTituloDivida.incluir(tituloDivida2);
        repositorioTituloDivida.incluir(tituloDivida3);

        TituloDivida tituloDividaEncontrada = repositorioTituloDivida.buscar(1);
        System.out.println(tituloDividaEncontrada.getNome());

        //repositorioTituloDivida.excluir(3);
        TituloDivida tituloDivida4 = new TituloDivida(2,"INGLATERRA",LocalDate.of(2028,12,10),9.9);
        repositorioTituloDivida.alterar(tituloDivida4);*/


        EntidadeOperadora entidadeCredito = new EntidadeOperadora(2192, "BCB", true, 0.00, 1890220034.0);
        EntidadeOperadora entidadeDebito = new EntidadeOperadora(1112, "BOFA", true, 12900000210.00, 3564234127.0);
        Acao acao = new Acao(1, "PETROBRAS", LocalDate.of(2024, 12, 12), 30.33);
        TituloDivida tituloDivida = null;
        LocalDateTime dataHoraOperacao = LocalDateTime.now();

        Transacao transacao1 = new Transacao(entidadeCredito, entidadeDebito, acao, tituloDivida, 100000.0, dataHoraOperacao);

        repo.incluir(transacao1);

        Transacao[] transacoes = repo.buscarPorEntidadeCredora(2192); // Exemplo de identificador

        for (Transacao transacao : transacoes) {
            System.out.println(transacao);
        }

    }
}
