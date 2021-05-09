/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Classe que faz o Registro do armazenamento das imagens, visto que uma imagem
 * só pode esta armazenada em um computador
 * @author Thiago Cardozo
 */
public class Registro {
    Computador computador;
    Imagem imagem;

    /**
     * 
     * @param computador
     * @param imagem
     */
    public Registro(Computador computador, Imagem imagem) {
        this.computador = computador;
        this.imagem = imagem;
    }

    /**
     *
     * @return
     */
    public Computador getComputador() {
        return computador;
    }

    /**
     *
     * @param computador
     */
    public void setComputador(Computador computador) {
        this.computador = computador;
    }

    /**
     *
     * @return
     */
    public Imagem getImagem() {
        return imagem;
    }

    /**
     *
     * @param imagem
     */
    public void setImagem(Imagem imagem) {
        this.imagem = imagem;
    }
    
}
