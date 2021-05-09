/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.lang.Exception;
/**
 *
 * @author Thiago Cardozo
 * @param <J>
 */
public interface Itree <J> {
    
    /**
     *
     * @return
     */
    public int getElementsCount();
    /**
     *
     * @param key
     * @param obj
     * @return 
     */
    public boolean put(String key,J obj);
    /**
     *
     * @param key
     * @return
     */
    public Object get(String key);
    
    /**
     *
     * 
     * @param node
     * @return 
     * 
     */
    public Node<J> leftRotation(Node<J> node); 
    
    /**
     *
     * @param node
     * @return 
     */
    public Node<J> rightRotation(Node<J> node); 
    
    /**
     *
     * @param node
     * @return
     */
    public int calculateBalance(Node<J> node); // poderia ser método de node
    
    /**
     *
     * @param node
     * @return 
     */
    public Node<J> rebalance(Node<J> node);
    
    /**
     *
     * @param key
     */
    public void remove(String key);
}
