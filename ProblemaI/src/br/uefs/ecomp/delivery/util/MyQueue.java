/*******************************************************************************
Autor: Thiago Cardozo de Jesus
Componente Curricular: Algoritmos & Programação II I
Concluido em: 05/05/2019
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
trecho de código de outro colega ou de outro autor, tais como provindos de livros e
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************************************************************************/
package br.uefs.ecomp.delivery.util;

/**
 *
 * @author Thiago Cardozo
 */
public class MyQueue implements IQueue {
    private Link first;
    private int size;

    /**
     *
     * @param data
     */
    @Override
    public void enqueue(Object data) {
        if (first == null){
            first = new Link(data);
            first.setNext(null);
            size ++;
        }
        else {
            Link temp = first;
            while (temp.getNext()!= null){
                temp = temp.getNext();
            }
            Link novo = new Link(data);
            temp.setNext(novo);
            novo.setNext(null);
            size ++;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public Object dequeue() {
        Link temp = first;
        first = temp.getNext();
        size --;
        return temp.getData();
    }

    /**
     *
     * @return
     */
    @Override
    public Object peek() {
        return first.getData();
    }

    /**
     *
     * @return
     */
    @Override
    public Object last() {
        Link temp = first;
        while (temp.getNext()!= null){
            temp = temp.getNext();
        }
        return temp.getData();
    }

    /**
     *
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return (first == null);
    }
}
