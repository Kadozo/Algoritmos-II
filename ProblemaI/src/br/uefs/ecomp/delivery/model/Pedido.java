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

import java.util.Date;

/**
 *
 * @author Thiago Cardozo
 */
public class Pedido {
    private Cliente cliente;
    private Date dataHora;
    private String endereco;
    private boolean situacao;
    private final ListaItens itens;
    private double valorTotal;

    /**
     *
     * @param cliente
     * @param dataHora
     * @param endereco
     * @param situacao
     */
    public Pedido(Cliente cliente, Date dataHora, String endereco, boolean situacao) {
        this.cliente = cliente;
        this.dataHora = dataHora;
        this.endereco = endereco;
        this.situacao = situacao;
        this.itens = new ListaItens(null);
    }
    
    /**
     * método para adicionar um item pedido na lista de itens pedidos
     * @param a item pedido a ser adicionado
     */
    public void inserirPedido(ItemPedido a){
        this.itens.add(a);
       
    }

    /**
     *
     * @return
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * muda o atual cliente relacionado a esse pedido para o passado no 
     * parâmetro
     * @param cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     *
     * @return
     */
    public Date getDataHora() {
        return dataHora;
    }

    /**
     * Muda a data e a hora relacionada ao pedidos para a passada em parâmetro
     * @param dataHora
     */
    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    /**
     * retorna o endereço relacionado ao pedido
     * @return enderenço do pedido
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     *muda o endereço do pedido para o endereço passado pelo parametro
     * @param endereco
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     *
     * @return
     */
    public boolean getSituacao() {
        return situacao;
    }

    /**
     * muda a situação do pedido, situação true significa que o pedido esta
     * aberto, situação false,fechado
     * @param situacao
     */
    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    /**
     * retorna a lista de itenspedidos
     * @return lista de itenspedidos
     */
    public ListaItens getItens() {
        return itens;
    }

    /**
     *retorna o valor do pedido, uma soma de todos os preço dos Itens de pedido
     * @return valor total do pedido
     */
    public double getValorTotal() {
        LinkItens temp = itens.getHead();
        int aux = 0;
        while (temp != null){
            valorTotal += temp.getData().getOpcaoMenu().getValor()*temp.getData().getQuantidade();
            temp = temp.getNext();
        }
        double tempValor = valorTotal;
        valorTotal = 0;
        return tempValor;
    }

    /**
     *atualiza o pedido de aberto para fechado
     */
    public void setFechado(){
        this.setSituacao(false);
    }
}
