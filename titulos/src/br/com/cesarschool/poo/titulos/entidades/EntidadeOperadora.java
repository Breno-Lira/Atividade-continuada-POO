package br.com.cesarschool.poo.titulos.entidades;
/*
 * Esta classe deve ter os seguintes atributos:
 * identificador, do tipo long  FEITO
 * nome, do tipo String  FEITO
 * autorizadoAcao, do tipo double  FEITO
 * saldoAcao, do tipo double FEITO
 * saldoTituloDivida, do tipo double  FEITO
 * 
 * Deve ter um construtor publico que inicializa os atributos identificador, nome   FEITO
 * e autorizadoAcao. Deve ter metodos set/get publicos para os atributos identificador, nome  FEITO
 * e autorizadoAcao. O atributo identificador e read-only fora da classe.  FEITO
 * 
 * Os atributos saldoAcao e saldoTituloDivida devem ter apenas metodos get publicos.  FEITO
 * 
 * Outros metodos publicos:
 * 
 *  void creditarSaldoAcao(double valor): deve adicionar valor ao saldoAcao  FEITO
 *  void debitarSaldoAcao(double valor): deve diminuir valor de saldoAcao  FEITO
 *  void creditarSaldoTituloDivida(double valor): deve adicionar valor ao saldoTituloDivida FEITO
 *  void debitarSaldoTituloDivida(double valor): deve diminuir valor de saldoTituloDivida   FEITO
 */
public class EntidadeOperadora {
    private long identificador;
    private String nome;
    private boolean autorizadoAcao;
    private double saldoAcao;
    private double saldoTituloDivida;

    public EntidadeOperadora(long identificador, String nome, boolean autorizadoAcao, double saldoAcao, double saldoTituloDivida){
        this.identificador=identificador;
        this.nome=nome;
        this.autorizadoAcao=autorizadoAcao;
        this.saldoAcao=saldoAcao;
        this.saldoTituloDivida=saldoTituloDivida;
    }

    public void creditarSaldoAcao(double valor){
        saldoAcao += valor;
    }

    public void debitarSaldoAcao(double valor){
        saldoAcao -= valor;
    }

    public void creditarSaldoTituloDivida(double valor){
        saldoTituloDivida += valor;
    }

    public void debitarSaldoTituloDivida(double valor){
        saldoTituloDivida -= valor;
    }

    public long getIdentificador() {
        return identificador;
    }

    private void setIdentificador(long identificador) {
        this.identificador = identificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getAutorizadoAcao() {
        return autorizadoAcao;
    }

    public void setAutorizadoAcao(boolean autorizadoAcao) {
        this.autorizadoAcao = autorizadoAcao;
    }

    public double getSaldoAcao() {
        return saldoAcao;
    }

    public double getSaldoTituloDivida() {
        return saldoTituloDivida;
    }
}
