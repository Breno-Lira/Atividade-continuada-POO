package br.com.cesarschool.poo.titulos.entidades;

import java.time.LocalDate;

/*
 * Esta classe deve herdar de Ativo.  FEITO
 * E deve ter os seguintes atributos:  FEITO
 * taxaJuros, do tipo double.  FEITO
 * 
 * Deve ter um construtor publico que inicializa os atributos, FEITO
 * e metodos set/get publicos para os atributos.  FEITO
 * 
 * Deve ter um metodo publico double calcularPrecoTransacao(double montante): o preco  FEITO
 * da transacao e montante vezes (1 - taxaJuros/100.0).  FEITO
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
