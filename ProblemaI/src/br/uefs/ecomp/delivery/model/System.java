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

import br.uefs.ecomp.delivery.util.ListaCardapio;
import br.uefs.ecomp.delivery.util.ListaClientes;
import br.uefs.ecomp.delivery.util.LinkClientes;
import br.uefs.ecomp.delivery.util.ListaPedidos;

import java.util.Iterator;

/**
 *
 * @author Thiago Cardozo
 */
public class System {
    private ListaCardapio cardapio;
    private ListaClientes clientes;
    private ListaPedidos pedidos;
    private final FilaPedidos pedidosAbertos;
    private final ListaPedidos pedidosFechados;

    /**
     *
     */
    public System() {
        this.cardapio = new ListaCardapio();
        this.clientes = new ListaClientes();
        this.pedidos = new ListaPedidos();
        this.pedidosFechados = new ListaPedidos();
        this.pedidosAbertos = new FilaPedidos(this.pedidosFechados.getHead());
    }

    /**
     *
     * @return
     */
    public ListaPedidos getPedidosFechados() {
        pedidosFechados.setHead(pedidosAbertos.getReffFechados());
        return pedidosFechados;
    }

    /**
     *
     * @return
     */
    public FilaPedidos getPedidosAbertos() {
        return pedidosAbertos;
    }

    /**
     *
     * @return
     */
    public ListaCardapio getCardapio() {
        return cardapio;
    }

    /**
     *
     * @param cardapio
     */
    public void sePtCardapio(ListaCardapio cardapio) {
        this.cardapio = cardapio;
    }

    /**
     *
     * @return
     */
    public ListaClientes getClientes() {
        return clientes;
    }

    /**
     *
     * @param clientes
     */
    public void setClientes(ListaClientes clientes) {
        this.clientes = clientes;
    }

    /**
     *
     * @return
     */
    public ListaPedidos getPedidos() {
        return pedidos;
    }

    /**
     *
     * @param pedidos
     */
    public void setPedidos(ListaPedidos pedidos) {
        this.pedidos = pedidos;
    }

    /**
     *
     * @return
     */
    public Iterator iterator(){
        Iterator it = new Iterator() {
            LinkClientes temp = clientes.getHead();
            @Override
            public boolean hasNext() {
                if(temp == null){
                    return false;
                }
                return temp.getNext() != null;
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
}
