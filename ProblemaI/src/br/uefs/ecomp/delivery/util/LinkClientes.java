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

/**
 * Classe nó da ListaClientes
 * @author Thiago Cardozo
 */
public class LinkClientes {
    private Cliente data;
    private LinkClientes next;

    /**
     *
     * @param data
     */
    public LinkClientes(Cliente data) {
        this.data = data;
    }

    /**
     *
     * @return
     */
    public Cliente getData() {
        return data;
    }

    /**
     *
     * @param data
     */
    public void setData(Cliente data) {
        this.data = data;
    }

    /**
     *
     * @return
     */
    public LinkClientes getNext() {
        return next;
    }

    /**
     *
     * @param next
     */
    public void setNext(LinkClientes next) {
        this.next = next;
    }
}
