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

/**
 *
 * @author Thiago Cardozo
 */
public class ItemPedido {
    private Pedido pedido;
    private Cardapio opcaoMenu;
    private int quantidade;
    private String observacao;

    /**
     *
     * @param pedido
     * @param opcaoMenu
     * @param quantidade
     * @param observacao
     */
    public ItemPedido(Pedido pedido, Cardapio opcaoMenu, int quantidade, String observacao) {
        this.pedido = pedido;
        this.opcaoMenu = opcaoMenu;
        this.quantidade = quantidade;
        this.observacao = observacao;
    }
    
    /**
     * método para retornar o pedido relacionado a esse item
     * @return o pedido relacionado a esse item
     */
    public Pedido getPedido() {
        return pedido;
    }

    /**
     * muda o atual pedido relacionado a esse item para o parametro passado
     * @param pedido 
     */
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    /**
     *
     * @return qual opção de menu o item representa
     */
    public Cardapio getOpcaoMenu() {
        return opcaoMenu;
    }

    /**
     * muda a opção de menu que o item corresponde
     * @param opcaoMenu
     */
    public void setOpcaoMenu(Cardapio opcaoMenu) {
        this.opcaoMenu = opcaoMenu;
    }

    /**
     * retorna a quantidade do itempedido
     * @return quantidade de itempedido
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * muda a quantidade do itempedido
     * @param quantidade
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * retorna as observacoes que o itempedido possue, por exemplo: sem molho, 
     * sem carne molho extra etc.
     * @return
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     *Muda as observações atuais que o item possue para as novas que serão
     * passadas no parâmetro
     * @param observacao
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
