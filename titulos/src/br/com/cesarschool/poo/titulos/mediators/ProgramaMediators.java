package br.com.cesarschool.poo.titulos.mediators;

import br.com.cesarschool.poo.titulos.entidades.TituloDivida;

import java.time.LocalDate;

public class ProgramaMediators {
    public static void main(String[] args) {
        MediatorAcao mediator = MediatorAcao.getInstance();
        MediatorEntidadeOperadora mediator2 = MediatorEntidadeOperadora.getInstance();
        MediatorTituloDivida mediator3 = MediatorTituloDivida.getInstance();

        /*
        Acao acaoValida = new Acao(1, "acao-teste", LocalDate.now().plusDays(39), 10);
        Acao acaoValida2 = new Acao(1, "acao-teste2", LocalDate.now().plusDays(37), 140);
        String resultadoIncluirValida = mediator.incluir(acaoValida);
        String alterar = mediator.alterar(acaoValida2);
        String excluir = mediator.excluir(3);
        Acao buscar = mediator.buscar(3);*/

        /*
        if (resultadoIncluirValida == null) {
            System.out.println("Ação válida incluída com sucesso!");
        } else {
            System.out.println("Erro ao incluir ação válida: " + resultadoIncluirValida);
        }*/

        /*if (alterar == null) {
            System.out.println("Ação válida alterada com sucesso!");
        } else {
            System.out.println("Erro ao alterar ação válida: " + alterar);
        }*/
        /*
        if (excluir == null) {
            System.out.println("Ação válida excluida com sucesso!");
        } else {
            System.out.println("Erro ao alterar ação válida: " + excluir);
        }*/

        /*
        if (buscar != null) {
            System.out.println("Ação válida excluida com sucesso! " + buscar.getNome());
        } else {
            System.out.println("Erro ao alterar ação válida: " + buscar);
        }*/
        /*
        EntidadeOperadora entidade1 = new EntidadeOperadora(100, "ASDFG", true, 0.00, 1890220034.0);
        EntidadeOperadora entidade2 = new EntidadeOperadora(100, "BOFAA", true, 12900000210.00, 3564234127.0);
        String entidadeIncluir = mediator2.incluir(entidade1);
        String entidadealterar = mediator2.alterar(entidade2);
        //String entidadeExcluir = mediator2.excluir(100);
        EntidadeOperadora entidadeBuscar = mediator2.buscar(190);

        if (entidadeBuscar != null) {
            System.out.println("Ação válida com sucesso! " + entidadeBuscar.getNome());
        } else {
            System.out.println("Erro ao incluir ação válida: " + entidadeBuscar);
        }*/

        TituloDivida tituloDivida1 = new TituloDivida(1,"BRASILoouuu",LocalDate.of(2025,12,12),19.8);
        TituloDivida tituloDivida2 = new TituloDivida(2,"EUA",LocalDate.of(2026,1,1),30.9);
        TituloDivida tituloDivida3 = new TituloDivida(1,"FRANCAAAAAA",LocalDate.of(2027,11,11),2.5);
        String tituloIncluir = mediator3.incluir(tituloDivida1);
        String tituloAlterar = mediator3.alterar(tituloDivida3);
        //String tituloExcluir = mediator3.excluir(1);
        TituloDivida tituloBuscar = mediator3.buscar(5);


        if (tituloBuscar != null) {
            System.out.println("Ação válida com sucesso! " + tituloBuscar.getNome());
        } else {
            System.out.println("Erro ao incluir ação válida: " + tituloBuscar);
        }

    }
}
