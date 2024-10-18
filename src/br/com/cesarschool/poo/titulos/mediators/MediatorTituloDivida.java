package br.com.cesarschool.poo.titulos.mediators;

import br.com.cesarschool.poo.titulos.entidades.Acao;
import br.com.cesarschool.poo.titulos.entidades.TituloDivida;
import br.com.cesarschool.poo.titulos.repositorios.RepositorioTituloDivida;

import java.time.LocalDate;

public class MediatorTituloDivida {
    private static MediatorTituloDivida instance;
    public static MediatorTituloDivida getInstance() {
        if (instance == null) {
            instance = new MediatorTituloDivida();
        }
        return instance;
    }
    RepositorioTituloDivida repositorioTituloDivida = new RepositorioTituloDivida();

    private String validar(TituloDivida titulo){
        if (titulo.getIdentificador() < 1 || titulo.getIdentificador() >= 100000){
            return "Identificador deve estar entre 1 e 99999.";
        }
        else if (titulo.getNome() == null || titulo.getNome().isEmpty()){
            return "Nome deve ser preenchido";
        }
        else if (titulo.getNome().length() < 10 || titulo.getNome().length() > 100){
            return "Nome deve ter entre 10 e 100 caracteres.";
        }
        LocalDate dataHoje = LocalDate.now();
        LocalDate dataLimite = dataHoje.plusDays(180);
        boolean validade = titulo.getDataDeValidade().isAfter(dataLimite);
        if (!validade){
            return "Data de validade deve ter pelo menos 180 dias na frente da data atual.";
        }
        else if (titulo.getTaxaJuros() < 0){
            return "Taxa de juros deve ser maior ou igual a zero.";
        }

        return null;
    }

    public String incluir (TituloDivida titulo){
        String validacao = validar(titulo);

        if (validacao != null){
            return validacao;
        }

        boolean incluida = repositorioTituloDivida.incluir(titulo);

        if (incluida){
            return null;
        }

        return "Titulo ja existente";
    }

    public String alterar(TituloDivida titulo){
        String validacao = validar(titulo);

        if (validacao != null){
            return validacao;
        }

        boolean incluida = repositorioTituloDivida.alterar(titulo);

        if (incluida){
            return null;
        }

        return "Titulo inexistente";
    }

    public String excluir(int identificador){
        if (identificador >= 1 && identificador <= 100){
            boolean excluida = repositorioTituloDivida.excluir(identificador);
            if (excluida){
                return null;
            }
            return "Titulo inexistente";
        }
        return "Titulo inexistente";
    }

    public TituloDivida buscar(int identificador){
        if (identificador >= 1 && identificador < 100000){
            return repositorioTituloDivida.buscar(identificador);
        }
        return null;
    }

}
