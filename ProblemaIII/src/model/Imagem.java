/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Classe que simula uma imagem no sistema
 * @author Thiago Cardozo
 */
public class Imagem {
    private final String name;
    private final float size;

    /**
     *
     * @param name
     * @param size
     */
    public Imagem(String name, float size) {
        this.name = name;
        this.size = size;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public float getSize() {
        return size;
    }
    
}
