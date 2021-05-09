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

import br.uefs.ecomp.delivery.model.Cardapio;

import java.util.Iterator;

/**
 *
 * @author Thiago Cardozo
 */
public class ListaCardapio {
    private LinkCardapio head;
    private int size = 0;

    /**
     * Retorna o tamanho da lista.
     *
     * @return tamanho da lista.
     */

    public int size() {
        return size;
    }

    /**
     * Insere objeto ao final da lista.
     *
     * @param obj a ser inserido ao final da lista.
     */

    public void add(Cardapio obj) {
        if (head == null){
            head = new LinkCardapio(obj);
            head.setNext(null);
            size ++;
        }
        else {
            LinkCardapio temp = head;
            while (temp.getNext()!= null){
                temp = temp.getNext();
            }
            LinkCardapio novo = new LinkCardapio(obj);
            temp.setNext(novo);
            novo.setNext(null);
            size ++;
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

    public LinkCardapio remove(int pos) {
        if(head == null){
            return null;
        }
        int aux = 0;
        LinkCardapio temp = head;
        LinkCardapio anterior = head;
        while(aux != pos){
            anterior = temp;
            temp = temp.getNext();
            aux ++;
        }
        anterior.setNext(temp.getNext());
        size --;
        return temp;
    }

    /**
     * Retorna o objeto em uma determinada posição da lista, sem remove-lo.
     *
     * @param index do objeto a ser recuperado.
     * @return o objeto recuperado ou null caso a lista esteja vazia ou pos seja
     * menor que 0 (zero) ou maior que o tamanho da lista.
     */

    public Cardapio get(int index) {
        if (head == null){
            return null;
        }
        if (index < 0 || index > size){
            return null;
        }
        else {
            int aux = 0;
            LinkCardapio temp = head;
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
    public Cardapio remove (){
        LinkCardapio temp = head;
        head = head.getNext();
        size --;
        return temp.getData();
    }
    /*public String showCardapio(){
        LinkCardapio temp = head;
        String exib ="";
        int aux = 0;
        while(aux!=this.size){
           exib = exib.concat(temp.getData().getDescricao());
        }
        return exib;
    }*/

    /**
     *
     * @return
     */

    public String showCardapio(){
        if(head == null){
            return null;
        }
        LinkCardapio temp = head;
        String exib = new String();
        exib = exib + temp.getData().getDescricao();
        
        while(temp!= null){
            if(temp != head){
                exib = exib +"\n"+temp.getData().getDescricao();
            }
            temp = temp.getNext();
        }
        return exib;
    }
}
