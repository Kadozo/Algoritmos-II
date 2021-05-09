/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Thiago Cardozo
 * @param <J>
 */
public class Node <J> {
    private J data;
    private final String  key;
    private Node <J> right,left;

    /**
     *
     * @param object
     * @param key
     */
    public Node (J object,String key) {
        this.data = object;
        this.key = key;
    }
    
    /**
     *
     * @return
     */
    public J getData() {
        return data;
    }

    /**
     *
     * @param data
     */
    public void setData(J data) {
        this.data = data;
    }

    /**
     *
     * @return
     */
    public Node<J> getRight() {
        return right;
    }

    /**
     *
     * @param right
     */
    public void setRight(Node<J> right) {
        this.right = right;
    }

    /**
     *
     * @return
     */
    public Node<J> getLeft() {
        return left;
    }

    /**
     *
     * @param left
     */
    public void setLeft(Node<J> left) {
        this.left = left;
    }

    /**
     *
     * @return
     */
    public String getKey() {
        return key;
    }

    /**
     *calcula a altura do node
     * @return
     */
    public int getHeight() {
        int a,b;
        if(this.getLeft() == null){ //filho da esquerda é no folha
            a = 0; 
        }
        else{
            a = 1 + this.getLeft().getHeight(); // altura do filho da esquerda + 1
        }
        if(this.getRight() == null){ //filho da direita é no folha
            b = 0;
        }
        else{
        b = 1 + this.getRight().getHeight(); // altura do filho da direita + 1
        }
        return (a > b) ? a : b; //retorna sempre o maior valor
    }
    
}
