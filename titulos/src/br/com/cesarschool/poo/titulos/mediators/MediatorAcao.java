package br.com.cesarschool.poo.titulos.mediators;

import br.com.cesarschool.poo.titulos.entidades.Acao;
import br.com.cesarschool.poo.titulos.repositorios.RepositorioAcao;
import br.com.cesarschool.poo.titulos.repositorios.RepositorioEntidadeOperadora;

import java.time.LocalDate;


public class MediatorAcao {
    private static MediatorAcao instance;
    private RepositorioAcao repositorioAcao= new RepositorioAcao();

    private String validar (Acao acao){
        if (acao.getIdentificador() <= 0 || acao.getIdentificador() > 100000){
            return "Identificador deve estar entre 1 e 99999.";
        }
        else if (acao.getNome() == null || acao.getNome().isEmpty()){
            return "Nome deve ser preenchido";
        }
        else if (acao.getNome().length() < 10 || acao.getNome().length() > 100){
            return "Nome deve ter entre 10 e 100 caracteres.";
        }
        LocalDate dataHoje = LocalDate.now();
        LocalDate dataLimite = dataHoje.plusDays(30);
        boolean validade = acao.getDataDeValidade().isAfter(dataLimite);
        if (!validade){
            return "Data de validade deve ter pelo menos 30 dias na frente da data atual.";
        }
        if (acao.getValorUnitario() <= 0){
            return "Valor unitário deve ser maior que zero.";
        }
        return null;
    }

    public String incluir (Acao acao){
        String validacao = validar(acao);

        if (validacao != null){
            return validacao;
        }

        boolean incluida = repositorioAcao.incluir(acao);

        if (incluida){
            return null;
        }

        return "Acao ja existente";
    }

    public String alterar(Acao acao){
        String validacao = validar(acao);

        if (validacao != null){
            return validacao;
        }

        boolean incluida = repositorioAcao.alterar(acao);

        if (incluida){
            return null;
        }

        return "Acao inexistente";
    }

    public String excluir(int identificador){
        if (identificador >= 1 && identificador <= 100){
            boolean excluida = repositorioAcao.excluir(identificador);
            if (excluida){
                return null;
            }
            return "Acao inexistente";
        }
        return "Acao inexistente";
    }

    public Acao buscar (int identificador){
        if (identificador >= 1 && identificador <= 100000){
            return repositorioAcao.buscar(identificador);
        }
        return null;
    }

    public static MediatorAcao getInstance() {
        if (instance == null) {
            instance = new MediatorAcao();
        }
        return instance;
    }
}
