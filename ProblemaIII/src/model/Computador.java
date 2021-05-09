/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import util.*;
import exceptions.MemoriaIndisponivelException;

/**
 * Classe que simula a funcionalidade de um computador
 * @author Thiago Cardozo
 */
public class Computador {
    private final String id;
    private float memory;
    private final Arvore<Imagem> imagens;

    /**
     * 
     * @param id
     * @param memory
     */
    public Computador(String id, float memory) {
        this.id = id;
        this.memory = memory;
        this.imagens = new Arvore<>();
    }

    /**
     *
     * @return a mémoria restante do computador
     */
    public float getMemory() {
        return memory;
    }

    /**
     *
     * @param memory
     */
    public void setMemory(float memory) {
        this.memory = memory;
    }

    /**
     *
     * @return o ID do computador
     */
    public String getId() {
        return id;
    }
    
    /**
     *
     * @return a arvore de imagens associadas ao computador
     */
    public Arvore<Imagem> getImagens() {
        return imagens;
    }

    /**
     * método add para adicionar uma imagem ao computador, se o computador não 
     * tiver memoria para armazená-la uma exception será lançada
     * @param imagem
     * @return um boolean dizendo se a imagem foi adicionada ou não
     * @throws MemoriaIndisponivelException
     */
    public boolean add(Imagem imagem) throws MemoriaIndisponivelException {
        if(imagem.getSize()>this.memory){
            throw new MemoriaIndisponivelException();
        }
        boolean a = getImagens().put(imagem.getName(), imagem);
        if(a){
            setMemory(this.memory - imagem.getSize());
        }
        return a;
    }
    
    /**
     *Lista todas as imagens que estão armazenadas no computador
     * @return uma string com todas as imagens dos computadores
     */
    public String listarImagens(){
        return imagens.inOrder(imagens.getRoot());
    }
    
}
