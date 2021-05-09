package br.uefs.ecomp.delivery.util;

/**
 *
 * @author Thiago Cardozo
 */
public interface IQueue {

    public void enqueue(Object data);

    public Object dequeue();

    public Object peek();

    public Object last();
    
    public int size();

    public boolean isEmpty();
}
