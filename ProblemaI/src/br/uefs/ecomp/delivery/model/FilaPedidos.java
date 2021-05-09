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
package br.uefs.ecomp.delivery.model;

import br.uefs.ecomp.delivery.util.*;

/**
 *
 * @author Thiago Cardozo
 */
public class FilaPedidos{
    private LinkPedidos first;
    private int size = 0;
    private LinkPedidos reffFechados;

    /**
     * Contrutor de FilaPedidos que recebe como parâmetro uma Referencia para a
     * lista de pedidos fechados
     * @param reffFechados
     */
    public FilaPedidos(LinkPedidos reffFechados) {
        this.reffFechados = reffFechados;
    }
   
    /**
     * contrutor vazio de FilaPedidos
     */
    public FilaPedidos() {
        this.first = null;
    }

    /**
     * metodo que retorna a referencia para a lista de itens fechados
     * @return a referencia do primeiro item da lista de itens fechados
     */
    public LinkPedidos getReffFechados() {
        return reffFechados;
    }
    
    /**
     * verificação para saber se a fila está vazia ou não, caso esteja vazia o 
     * retorno será true, caso contrário o retorno é false
     * @return boolean
     */
    public boolean isEmpty() {
        return first == null; //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * retorna o tamanho da fila
     * @return tamanho da fila
     */
    public int size() {
        return size; //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * percorre a fila afim de encontrar o seu ultimo elemento, encontrado ele
     * retorna o conteudo dele
     * @return retorna o ultimo pedido da lista
     */
    public Pedido last() {
        LinkPedidos temp = first;
        while (temp.getNext()!= null){
            temp = temp.getNext();
        }
        return temp.getData(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * método que retorna o conteudo do primeiro elemento da fila
     * @return o primeiro pedido da fila
     */
    public Pedido peek() {
        return first.getData(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * retira da fila o primeiro elemento e retorna o seu conteudo
     * @return o primeiro pedido que foi retirado da fila
     */
    public Pedido dequeue() {
       if(first == null){
           return null;
       }
        LinkPedidos temp = first;
        first = temp.getNext();
        size --;
        return temp.getData(); 
    }
    
    /**
     * percorre toda a lista afim de adicionar um novo elemento ao final da fila
     * @param data
     */
    public void enqueue(Pedido data) {
        if (first == null){
            first = new LinkPedidos (data);
            first.setNext(null);
            size ++;
        }
        else {
            LinkPedidos temp = first;
            while (temp.getNext()!= null){
                temp = temp.getNext();
            }
            LinkPedidos novo = new LinkPedidos(data);
            temp.setNext(novo);
            novo.setNext(null);
            size ++;
        }
    }
    
    /**
     * esse metodo faz com que o primeiro elemento da fila de pedidos abertos 
     * seja eliminado e adiciona esse mesmo elemento no inicio da lista 
     * de pedido fechados
     */
    public void setNexttoPedidoFechado(){
        LinkPedidos temp = reffFechados;
        if(temp == null){
            temp = new LinkPedidos(this.dequeue());
            reffFechados = temp;
            reffFechados.getData().setFechado();
        }
        else{
        while(temp.getNext()!= null){
            temp = temp.getNext();
        }
        LinkPedidos aux = new LinkPedidos(this.dequeue());
        aux.getData().setFechado();
        temp.setNext(aux);
        }
    }
}
