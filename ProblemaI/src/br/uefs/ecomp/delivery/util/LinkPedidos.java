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

import br.uefs.ecomp.delivery.model.Pedido;

/**
 * Classe nó da ListaPedidos
 * @author Thiago Cardozo
 */
public class LinkPedidos {
    private Pedido data;
    private LinkPedidos next;

    /**
     *
     * @param data
     */
    public LinkPedidos(Pedido data) {
        this.data = data;
    }

    /**
     *
     * @return
     */
    public Pedido getData() {
        return data;
    }

    /**
     *
     * @param data
     */
    public void setData(Pedido data) {
        this.data = data;
    }

    /**
     *
     * @return
     */
    public LinkPedidos getNext() {
        return next;
    }

    /**
     *
     * @param next
     */
    public void setNext(LinkPedidos next) {
        this.next = next;
    }
}
