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
package util;

import java.util.Iterator;

/**
 *
 * @author Thiago Cardozo
 * @param <T>
 */
public class MyLinkedList <T> implements IList <T> {
    private Link <T>  head;
    private int size = 0;

    /**
     * retorna a head da lista
     * @return
     */
    public Link<T> getHead() {
        return head;
    }

    /**
     * Retorna o tamanho da lista.
     *
     * @return tamanho da lista.
     */

    @Override
    public int size() {
        return size;
    }

    /**
     * Insere objeto ao final da lista.
     *
     * @param obj a ser inserido ao final da lista.
     */
    @Override
    public void add( T obj) {
        if (head == null){
            head = new Link <> (obj);
            head.setNext(null);
            size ++;
        }
        else {
            Link <T> temp = head;
            while (temp.getNext()!= null){
                temp = temp.getNext();
            }
            Link <T> novo = new Link <> (obj);
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
    @Override
    public boolean add(int pos, T obj) {
        if (pos > size || pos < 0){
            return false;
        }
        if (pos == 0){
            Link <T> temp = head;
            head = new Link <> (obj);
            head.setNext(temp);
            size ++;
            return true;
        }
        else{
            int aux = 0;
            Link <T> temp = head;
            Link <T> anterior = head;
            while (aux != pos){
                anterior = temp;
                temp = temp.getNext();
                aux++;
            }
            Link <T> novo = new Link <>(obj);
            anterior.setNext(novo);
            novo.setNext(temp);
            size ++;
            return true;
        }
    }

    /**
     * Remove um objeto de uma determinada posição, deslocando demais elementos seguintes para esquerda.
     *
     * @param pos a posição do objeto a ser removido.
     * @return o objeto removido ou null caso a lista esteja vazia ou pos seja
     * menor que 0 (zero) e maior que o tamanho da lista.
     */
    @Override
    public T remove(int pos) {
        if(head == null){
            return null;
        }
        if (pos == 0 ){
            Link <T> temp = head;
            head = head.getNext();
            size --;
            return temp.getData();
        }

        if (pos < 0 || pos > size){
            return null;
        }

        else {
            int aux = 0;
            Link <T> temp = head;
            Link <T> anterior = head;
            while (aux != pos && temp != null) {
                anterior = temp;
                temp = temp.getNext();
                aux++;
            }
            if (temp == null){
                anterior.setNext(temp);
                return null;
            }
            anterior.setNext(temp.getNext());
            size --;
            temp.setNext(null);
            return temp.getData();
        }
    }

    /**
     * Retorna o objeto em uma determinada posição da lista, sem remove-lo.
     *
     * @param index do objeto a ser recuperado.
     * @return o objeto recuperado ou null caso a lista esteja vazia ou pos seja
     * menor que 0 (zero) ou maior que o tamanho da lista.
     */
    @Override
    public T get(int index) {
        if (head == null){
           return null;
        }
        if (index < 0 || index > size){
            return null;
        }
        else {
            int aux = 0;
            Link <T> temp = head;
            while (aux != index) {
                temp = temp.getNext();
                aux ++;
            }
            return temp.getData();
        }
    }

    /**
     * Indica se a lista est� vazia.
     *
     * @return true caso a lista esteja vazia, false caso contrário
     */
    @Override
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public MyIterator iterator() {
        MyIterator it = new MyIterator <>(head);
        return it;
    }

    /**
     * Remove o primeiro elemento da lista
     * @return o conteúdo do elemento removido
     */
    public T remove (){
        Link <T> temp = head;
        head = head.getNext();
        size --;
        return temp.getData();
    }
    
    public T removeLast(){
        if(head == null){
            return null;
        }
        if(size == 1){
            T data = head.getData();
            head = null;
            return data;
        }
        int aux = 1;
        Link<T> temp = head;
        Link<T> anterior = temp;
        while( aux != size){
            anterior = temp;
            temp = temp.getNext();
            aux++;
        }
        T data = temp.getData();
        anterior.setNext(null);
        size--;
        return data;
    }
    
    public T remove(T obj){
        if(head == null){
            return null;
        }
        if (obj.equals(head.getData()) ){
            Link <T> temp = head;
            head = head.getNext();
            size --;
            return temp.getData();
        }

        else {
            Link <T> temp = head;
            Link <T> anterior = head;
            while (!(obj.equals(temp.getData())) && temp != null) {
                anterior = temp;
                temp = temp.getNext();
            }
            if (temp == null){ // não encontrou o obj a ser removido
                anterior.setNext(temp);
                return null;
            }
            anterior.setNext(temp.getNext());
            size --;
            temp.setNext(null);
            return temp.getData();
        }
    }
}
