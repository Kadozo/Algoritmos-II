/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Thiago Cardozo
 */
class Link <T> {
    private T data;
    private Link <T> next;

    /**
     * Construtor da classe link
     * @param data, conteúdo da link
     */
    public Link(T data) {
        this.data = data;
    }

    /**
     * retorna o Objeto que possue no Link
     * @return data, o conteúdo do link
     */
    public T getData() {
        return data;
    }

    /**
     * Método para alterar o conteúdo existente por um novo conteúdo
     * @param data,conteúdo que substituirá o antigo
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     *
     * @return next, um novo Link. Que inicialmente é tido como null
     */
    public Link <T>  getNext() {
        return next;
    }

    /**
     * Método para setar o next, ou seja, qual o próximo nó virá após o atual na lista
     * @param next, O Link que será o próximo do atual numa lista
     */
    public void setNext(Link <T>  next) {
        this.next = next;
    }
}
