package br.com.cesarschool.poo.titulos.entidades;

import java.time.LocalDate;

/*
 * Esta classe deve herdar de Ativo.  FEITO
 * E deve ter os seguintes atributos:  FEITO
 * taxaJuros, do tipo double.  FEITO
 * 
 * Deve ter um construtor p�blico que inicializa os atributos, FEITO
 * e m�todos set/get p�blicos para os atributos.  FEITO
 * 
 * Deve ter um m�todo p�blico double calcularPrecoTransacao(double montante): o pre�o  FEITO
 * da transa��o � montante vezes (1 - taxaJuros/100.0).  FEITO
 */
public class TituloDivida extends Ativo{
    private double taxaJuros;

    public TituloDivida(int identificador, String nome, LocalDate dataDeValidade, double taxaJuros) {
        super(identificador, nome, dataDeValidade);
        this.taxaJuros = taxaJuros;
    }

    public double calcularPrecoTransacao(double montante){
        return montante * (1 - taxaJuros / 100.0);
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }
}
