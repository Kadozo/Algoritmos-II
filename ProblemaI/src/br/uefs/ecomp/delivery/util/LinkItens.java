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

import br.uefs.ecomp.delivery.model.ItemPedido;

/**
 * Classe nó da ListaItens
 * @author Thiago Cardozo
 */
public class LinkItens {
    private ItemPedido data;
    private LinkItens next;

    /**
     *
     * @param data
     */
    public LinkItens(ItemPedido data) {
        this.data = data;
    }

    /**
     *
     * @return
     */
    public ItemPedido getData() {
        return data;
    }

    /**
     *
     * @param data
     */
    public void setData(ItemPedido data) {
        this.data = data;
    }

    /**
     *
     * @return
     */
    public LinkItens getNext() {
        return next;
    }

    /**
     *
     * @param next
     */
    public void setNext(LinkItens next) {
        this.next = next;
    }
    
}
