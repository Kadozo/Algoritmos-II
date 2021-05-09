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

import br.uefs.ecomp.delivery.model.Cliente;

import java.util.Iterator;

/**
 *
 * @author Thiago Cardozo
 */
public class ListaClientes  {
    private LinkClientes head;
    private int size = 0;

    /**
     *
     * @return
     */
    public LinkClientes getHead() {
        return head;
    }

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

    public void add(Cliente obj) {
        if (head == null){
            head = new LinkClientes(obj);
            head.setNext(null);
            size ++;
        }
        else {
            LinkClientes temp = head;
            while (temp.getNext()!= null){
                temp = temp.getNext();
            }
            LinkClientes novo = new LinkClientes(obj);
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

    public boolean add(int pos, LinkClientes obj) {
        return false;
    }

    /**
     * Remove um objeto de uma determinada posição, deslocando demais elementos seguintes para esquerda.
     *
     * @param pos a posição do objeto a ser removido.
     * @return o objeto removido ou null caso a lista esteja vazia ou pos seja
     * menor que 0 (zero) e maior que o tamanho da lista.
     */

    public Cliente remove(int pos) {
        if(head == null){
            return null;
        }
        int aux = 0;
        LinkClientes temp = head;
        LinkClientes anterior = head;
        while(aux != pos){
            anterior = temp;
            temp = temp.getNext();
            aux ++;
        }
        anterior.setNext(temp.getNext());
        temp.setNext(null);
        return temp.getData();
    }

    /**
     * Retorna o objeto em uma determinada posição da lista, sem remove-lo.
     *
     * @param index do objeto a ser recuperado.
     * @return o objeto recuperado ou null caso a lista esteja vazia ou pos seja
     * menor que 0 (zero) ou maior que o tamanho da lista.
     */

    public Cliente get(int index) {
        if (head == null){
            return null;
        }
        if (index < 0 || index > size){
            return null;
        }
        else {
            int aux = 0;
            LinkClientes temp = head;
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

    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */

    public Iterator iterator() {
        Iterator it = new Iterator() {
            LinkClientes temp = head;
            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public Cliente next() {
                Cliente aux = temp.getData();
                temp = temp.getNext();
                return aux;
            }
        };
        return it;
    }

    /**
     *
     * @return
     */
    public Cliente remove (){
        LinkClientes temp = head;
        head = head.getNext();
        size --;
        return temp.getData();
    }

    /**
     *
     * @param numero
     * @return
     */
    public Cliente removeByPhone (String numero){
        if (head == null){
            return null;
        }
        LinkClientes temp = head;
        LinkClientes anterior = head;
        String aux = temp.getData().getPhone();
        if(aux.equals(numero)){
            size --;
            head = head.getNext();
            return null;
        }
        while(aux.equals(numero)!= true || temp.getNext() == null){
            if(aux.equals(numero)){
                anterior.setNext(temp.getNext());
        temp.setNext(null);
        size --;
            }
            anterior = temp;
            temp = temp.getNext();
            aux = temp.getData().getPhone();
        }
        anterior.setNext(temp.getNext());
        temp.setNext(null);
        size --;
        return null;
    }

    /**
     *
     * @param nome
     * @return
     */
    public Iterator searchClientebyName (String nome){
        Iterator it  = new Iterator() {
            LinkClientes temp = head;
            @Override
            public boolean hasNext() {
                if (!(temp.getData().getName().contains(nome))){
                    return false;
                }
                if (temp == null){
                   return false;
               }
               return temp.getNext()!= null;
            }

            @Override
            public Cliente next() {
                if(temp.getData().getName().contains(nome)){
                    Cliente aux = temp.getData();
                    temp = temp.getNext();
                    return aux;
                }
                return null;   
            }
        };
                return it;
    }

    /**
     *
     * @param numero
     * @return
     */
    public Iterator searchClientebyPhone (String numero){
        Iterator it  = new Iterator() {
            LinkClientes temp = head;
            @Override
            public boolean hasNext() {
                if (temp == null){
                    return false;
                }
                while(temp.getNext()!= null){
                    if ((temp.getData().getPhone().contains(numero))){
                        return true;
                    }
                    temp = temp.getNext();
               }
               return temp.getNext()!= null;
            }

            @Override
            public Cliente next() {
                if (temp == null){
                    return null;
                }
                if(temp.getData().getPhone().contains(numero)){
                    Cliente aux = temp.getData();
                    temp = temp.getNext();
                    return aux;
                }
                return null;   
            }
        };
                return it;
    }
}
