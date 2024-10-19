package br.com.cesarschool.poo.titulos.mediators;

import br.com.cesarschool.poo.titulos.entidades.EntidadeOperadora;
import br.com.cesarschool.poo.titulos.repositorios.RepositorioEntidadeOperadora;

public class MediatorEntidadeOperadora {
    private static MediatorEntidadeOperadora instance;
    public static MediatorEntidadeOperadora getInstance() {
        if (instance == null) {
            instance = new MediatorEntidadeOperadora();
        }
        return instance;
    }
    private RepositorioEntidadeOperadora repositorioEntidadeOperadora = new RepositorioEntidadeOperadora();

    private String validar(EntidadeOperadora entidade) {
        if (entidade.getIdentificador() < 100 || entidade.getIdentificador() > 1000000) {
            return "Identificador deve estar entre 100 e 1000000.";
        }

        String nome = entidade.getNome();
        if (nome == null || nome.trim().isEmpty()) {
            return "Nome deve ser preenchido.";
        }

        if (nome.length() < 5 || nome.length() > 60) {
            return "Nome deve ter entre 5 e 60 caracteres.";
        }
        return null;
    }

    public String incluir(EntidadeOperadora entidade) {
        String validacao = validar(entidade);

        if (validacao != null) {
            return validacao;
        }

        boolean incluida = repositorioEntidadeOperadora.incluir(entidade);
        if (incluida) {
            return null;
        }

        return "Entidade já existente";
    }

    public String alterar(EntidadeOperadora entidade) {
        String validacao = validar(entidade);

        if (validacao != null) {
            return validacao;
        }

        boolean alterada = repositorioEntidadeOperadora.alterar(entidade);
        if (alterada) {
            return null;
        }

        return "Entidade inexistente";
    }

    public String excluir(long identificador) {
        if (identificador <= 0 || identificador >= 100000) {
            return "Entidade inexistente";
        }

        boolean excluida = repositorioEntidadeOperadora.excluir(identificador);
        if (excluida) {
            return null;
        }

        return "Entidade inexistente";
    }

    public EntidadeOperadora buscar(long identificador) {
        if (identificador <= 0 || identificador > 100000) {
            return null;
        }
        return repositorioEntidadeOperadora.buscar(identificador);
    }


}
