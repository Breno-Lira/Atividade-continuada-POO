package br.com.cesarschool.poo.titulos.mediators;

import br.com.cesarschool.poo.titulos.entidades.Acao;
import br.com.cesarschool.poo.titulos.entidades.EntidadeOperadora;
import br.com.cesarschool.poo.titulos.entidades.TituloDivida;
import br.com.cesarschool.poo.titulos.entidades.Transacao;
import br.com.cesarschool.poo.titulos.repositorios.RepositorioTransacao;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

public class MediatorOperacao {
    private static MediatorOperacao instance;
    public static MediatorOperacao getInstance() {
        if (instance == null) {
            instance = new MediatorOperacao();
        }
        return instance;
    }
    private MediatorAcao mediatorAcao = new MediatorAcao();
    private MediatorTituloDivida mediatorTituloDivida = new MediatorTituloDivida();
    private MediatorEntidadeOperadora mediatorEntidadeOperadora = new MediatorEntidadeOperadora();
    private RepositorioTransacao repositorioTransacao = new RepositorioTransacao();

    public String realizarOperacao(boolean ehAcao, int entidadeCredito, int idEntidadeDebito,int idAcaoOuTitulo, double valor){
        if (valor <= 0){
            return "Valor invalido";
        }
        EntidadeOperadora entidadeC = mediatorEntidadeOperadora.buscar(entidadeCredito);
        if (entidadeC == null){
            return "Entidade crédito inexistente";
        }
        EntidadeOperadora entidadeD = mediatorEntidadeOperadora.buscar(idEntidadeDebito);
        if (entidadeD == null){
            return "Entidade débito inexistente";
        }

        if (ehAcao && !entidadeC.getAutorizadoAcao()){
            return "Entidade de crédito não autorizada para ação";
        }
        if (ehAcao && !entidadeD.getAutorizadoAcao()){
            return "Entidade de debito não autorizada para ação";
        }

        if(ehAcao){
            Acao acao = mediatorAcao.buscar(idAcaoOuTitulo);
            if (entidadeD.getSaldoAcao() < valor){
                return "Saldo da entidade débito insuficiente";
            }
            if(acao.getValorUnitario() > valor){
                return "Valor da operação e menor do que o valor unitário da ação";
            }
            double valorOperacao = valor;
            entidadeC.creditarSaldoAcao(valorOperacao);
            entidadeD.debitarSaldoAcao(valorOperacao);

            String alterarC = mediatorEntidadeOperadora.alterar(entidadeC);
            if(alterarC != null){
                return alterarC;
            }
            String alterarD = mediatorEntidadeOperadora.alterar(entidadeD);
            if(alterarD != null){
                return alterarD;
            }

            Transacao transacao = new Transacao(entidadeC, entidadeD, acao, null, valorOperacao, LocalDateTime.now());
            repositorioTransacao.incluir(transacao);
        }

        else{
            TituloDivida tituloDivida = mediatorTituloDivida.buscar(idAcaoOuTitulo);
            if (entidadeD.getSaldoTituloDivida() < valor){
                return "Saldo da entidade débito insuficiente";
            }
            double valorOperacao = tituloDivida.calcularPrecoTransacao(valor);
            entidadeC.creditarSaldoTituloDivida(valorOperacao);
            entidadeD.debitarSaldoTituloDivida(valorOperacao);

            String alterarC = mediatorEntidadeOperadora.alterar(entidadeC);
            if(alterarC != null){
                return alterarC;
            }
            String alterarD = mediatorEntidadeOperadora.alterar(entidadeD);
            if(alterarD != null){
                return alterarD;
            }

            Transacao transacao = new Transacao(entidadeC, entidadeD, null, tituloDivida, valorOperacao, LocalDateTime.now());
            repositorioTransacao.incluir(transacao);
        }
        return "Operacao realizada com sucesso!";
    }

    public Transacao[] gerarExtrato(int entidade){
        Transacao[] transacoesCredoras = repositorioTransacao.buscarPorEntidadeCredora(entidade);
        Transacao[] transacoesDevedoras = repositorioTransacao.buscarPorEntidadeCredoraD(entidade);

        int tamanhoTotal = transacoesCredoras.length + transacoesDevedoras.length;

        Transacao[] todasTransacoes = new Transacao[tamanhoTotal];

        System.arraycopy(transacoesCredoras, 0, todasTransacoes, 0, transacoesCredoras.length);
        System.arraycopy(transacoesDevedoras, 0, todasTransacoes, transacoesCredoras.length, transacoesDevedoras.length);

        Arrays.sort(todasTransacoes, new Comparator<Transacao>() {
            @Override
            public int compare(Transacao t1, Transacao t2) {
                return t2.getDataHoraOperacao().compareTo(t1.getDataHoraOperacao());
            }
        });
        return  todasTransacoes;
    }

}
