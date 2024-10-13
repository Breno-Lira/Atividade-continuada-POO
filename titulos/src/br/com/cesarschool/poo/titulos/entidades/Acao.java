package br.com.cesarschool.poo.titulos.entidades;

import java.time.LocalDate;

/*
 * Esta classe deve herdar de Ativo. FEITO
 * E deve ter os seguintes atributos: FEITO
 * valorUnitario, do tipo double.  FEITO
 * 
 * Deve ter um construtor publico que inicializa os atributos, FEITO
 * e metodos set/get publicos para os atributos.  FEITO
 * 
 * Deve ter um metodo publico double calcularPrecoTransacao(double montante): o preco  FEITO
 * da transacao e o produto do montante pelo valorUnitario.  FEITO
 */
public class Acao extends Ativo{
    private double valorUnitario;

    public Acao(int identificador, String nome, LocalDate dataDeValidade, double valorUnitario) {
        super(identificador, nome, dataDeValidade);
        this.valorUnitario = valorUnitario;
    }

    public double calcularPrecoTransacao(double montante){
        return montante * valorUnitario;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

}
