package br.com.cesarschool.poo.titulos.entidades;
import java.time.LocalDateTime;

/*
 * Esta classe deve ter os seguintes atributos:  FEITO
 * entidadeCredito, do tipo EntidadeOperadora  FEITO
 * entidadeDebito, do tipo EntidadeOperadora  FEITO
 * acao, do tipo Acao  FEITO
 * tituloDivida, do tipo TituloDivida  FEITO
 * valorOperacao, do tipo double  FEITO
 * dataHoraOperacao, do tipo LocalDateTime  FEITO
 *  
 * Deve ter um construtor publico que inicializa os atributos.  FEITO
 * Deve ter metodos get/set publicos para todos os atributos, que FEITO
 * sao read-only fora da classe.  FEITO
 * 
 *  
 */ 
public class Transacao {
    private EntidadeOperadora entidadeCredito;
    private EntidadeOperadora entidadeDebito;
    private Acao acao;
    private TituloDivida tituloDivida;
    private double valorOperacao;
    private LocalDateTime dataHoraOperacao;

    public Transacao(EntidadeOperadora entidadeCredito, EntidadeOperadora entidadeDebito, Acao acao, TituloDivida tituloDivida, double valorOperacao, LocalDateTime dataHoraOperacao) {
        this.entidadeCredito = entidadeCredito;
        this.entidadeDebito = entidadeDebito;
        this.acao = acao;
        this.tituloDivida = tituloDivida;
        this.valorOperacao = valorOperacao;
        this.dataHoraOperacao = dataHoraOperacao;
    }

    public EntidadeOperadora getEntidadeCredito() {
        return entidadeCredito;
    }

    private void setEntidadeCredito(EntidadeOperadora entidadeCredito) {
        this.entidadeCredito = entidadeCredito;
    }

    public EntidadeOperadora getEntidadeDebito() {
        return entidadeDebito;
    }

    private void setEntidadeDebito(EntidadeOperadora entidadeDebito) {
        this.entidadeDebito = entidadeDebito;
    }

    public Acao getAcao() {
        return acao;
    }

    private void setAcao(Acao acao) {
        this.acao = acao;
    }

    public TituloDivida getTituloDivida() {
        return tituloDivida;
    }

    private void setTituloDivida(TituloDivida tituloDivida) {
        this.tituloDivida = tituloDivida;
    }

    public double getValorOperacao() {
        return valorOperacao;
    }

    private void setValorOperacao(double valorOperacao) {
        this.valorOperacao = valorOperacao;
    }

    public LocalDateTime getDataHoraOperacao() {
        return dataHoraOperacao;
    }

    private void setDataHoraOperacao(LocalDateTime dataHoraOperacao) {
        this.dataHoraOperacao = dataHoraOperacao;
    }

}
