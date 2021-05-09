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

import br.uefs.ecomp.delivery.model.FilaPedidos;
import br.uefs.ecomp.delivery.model.Pedido;

import java.util.Iterator;

/**
 *
 * @author Thiago Cardozo
 */
public class ListaPedidos {
    private LinkPedidos head;
    private FilaPedidos pedidosEmAberto;
    
    /**
     *
     */
    public ListaPedidos() {
    }

    /**
     *
     * @param head
     */
    public ListaPedidos(LinkPedidos head) {
        this.head = head;
    }

    /**
     *
     * @param head
     */
    public void setHead(LinkPedidos head) {
        this.head = head;
    }
    
    /**
     *
     * @return
     */
    public LinkPedidos getHead() {
        return head;
    }

    
    /**
     * Retorna o tamanho da lista.
     *
     * @return tamanho da lista.
     */

    public int size() {
        int aux = 0;
        LinkPedidos temp = head;
        while(temp != null){
            aux++;
            temp = temp.getNext();
        }
        return aux;
    }

    /**
     * Insere objeto ao final da lista.
     *
     * @param obj a ser inserido ao final da lista.
     */

    public void add(Pedido obj) {
        if (head == null){
            head = new LinkPedidos(obj);
            head.setNext(null);
        }
        else {
            LinkPedidos temp = head;
            while (temp.getNext()!= null){
                temp = temp.getNext();
            }
            LinkPedidos novo = new LinkPedidos(obj);
            temp.setNext(novo);
            novo.setNext(null);
        }

    }

    /**
     * Insere um objeto em uma determinada posição da lista, empurrando demais elementos para direita.
     * Posição 0 refere-se a primeira posição da lista e a última posição depende do tamanho da lista.
     *
     * @param pos a posição do objeto na lista, após a inserção. Deve ser um
     *            valor entre 0 e o tamanho da lista.
     * @param obj a ser inserido na lista
     * @return true, caso o objeto tenha sido inserido e false caso contrário.
     */

    public boolean add(int pos, LinkCardapio obj) {
        return false;
    }

    /**
     * Remove um objeto de uma determinada posição, deslocando demais elementos seguintes para esquerda.
     *
     * @param pos a posição do objeto a ser removido.
     * @return o objeto removido ou null caso a lista esteja vazia ou pos seja
     * menor que 0 (zero) e maior que o tamanho da lista.
     */

    public LinkPedidos remove(int pos) {
        if(head == null){
            return null;
        }
        else {
            int aux = 0;
            LinkPedidos temp = head;
            LinkPedidos anterior = head;
            while (aux != pos) {
                anterior = temp;
                temp = temp.getNext();
                aux++;
            }
            anterior.setNext(temp.getNext());
            return temp;
        }
    }

    /**
     * Retorna o objeto em uma determinada posição da lista, sem remove-lo.
     *
     * @param index do objeto a ser recuperado.
     * @return o objeto recuperado ou null caso a lista esteja vazia ou pos seja
     * menor que 0 (zero) ou maior que o tamanho da lista.
     */

    public Pedido get(int index) {
        if (head == null){
            return null;
        }
        if (index < 0 || index > size()){
            return null;
        }
        else {
            int aux = 0;
            LinkPedidos temp = head;
            while (aux != index) {
                temp = temp.getNext();
                aux++;
            }
            return temp.getData();
        }
    }

    /**
     * Indica se a lista est� vazia.
     *
     * @return true caso a lista esteja vazia, false caso contrário
     */

    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */

    public Iterator iterator() {
        return null;
    }

    /**
     *
     * @return
     */
    public Pedido remove (){
        LinkPedidos temp = head;
        head = head.getNext();
        return temp.getData();
    }

    /**
     *
     * @return
     */
    public FilaPedidos getPedidosEmAberto(){
        return pedidosEmAberto;
    }
    /*public Cliente removeByPhone (String numero){
        LinkClientes temp = head;
        LinkClientes anterior = head;
        String aux = temp.getData().getPhone();
        while(aux != numero){
            anterior = temp;
            temp = temp.getNext();
            aux = temp.getData().getPhone();
        }
        anterior.setNext(temp.getNext());
        return temp.getData();
    }*/
}
