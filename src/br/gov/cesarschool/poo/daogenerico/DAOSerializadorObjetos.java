package br.gov.cesarschool.poo.daogenerico;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DAOSerializadorObjetos {
    private String nomeDiretorio;

    public DAOSerializadorObjetos(Class<?> tipoEntidade) {
        nomeDiretorio = "." + File.separator + tipoEntidade.getSimpleName();
        File dir = new File(nomeDiretorio);
        if (!dir.exists()) {
            dir.mkdirs(); 
        }
    }

    public boolean incluir(Entidade entidade) {
        File file = new File(nomeDiretorio + File.separator + entidade.getIdUnico());
        if (file.exists()) {
            return false; 
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(entidade);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean alterar(Entidade entidade) {
        File file = new File(nomeDiretorio + File.separator + entidade.getIdUnico());
        if (!file.exists()) {
            return false; 
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(entidade);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(String idUnico) {
        File file = new File(nomeDiretorio + File.separator + idUnico);
        return file.delete(); 
    }

    public Entidade buscar(String idUnico) {
        File file = new File(nomeDiretorio + File.separator + idUnico);
        if (!file.exists()) {
            return null; 
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Entidade) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Entidade[] buscarTodos() {
        File dir = new File(nomeDiretorio);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return new Entidade[0];
        }
        List<Entidade> entidades = new ArrayList<>();
        for (File file : files) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                entidades.add((Entidade) ois.readObject());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return entidades.toArray(new Entidade[0]);
    }
}