package br.com.cesarschool.poo.titulos.entidades;
import java.time.LocalDate;

/*
 * Esta classe deve ter os seguintes atributos: FEITO
 * identificador, do tipo int  FEITO
 * nome, do tipo String  FEITO
 * data de validade, do tipo LocalDate  FEITO
 * 
 * Deve ter um construtor publico que inicializa os atributos, FEITO
 * e metodos set/get publicos para os atributos. O atributo identificador  FEITO
 * e read-only fora da classe. FEITO
 */
public class Ativo {
    private int identificador;
    private String nome;
    private LocalDate dataDeValidade;

    public Ativo(int identificador, String nome, LocalDate dataDeValidade){
        this.identificador = identificador;
        this.nome = nome;
        this.dataDeValidade = dataDeValidade;
    }

    public int getIdentificador(){
        return identificador;
    }

    private void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public LocalDate getDataDeValidade() {
        return dataDeValidade;
    }

    public void setDataDeValidade(LocalDate dataDeValidade) {
        this.dataDeValidade = dataDeValidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
