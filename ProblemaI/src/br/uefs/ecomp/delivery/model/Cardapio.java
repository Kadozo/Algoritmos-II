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
 * Classe destinada a guardar as informações das opções de menu
 * @author Thiago Cardozo
 */
public class Cardapio {
    private String descricao;
    private double valor;

    /**
     * Contrutor de Cardapio, que recebe como parâmetro: uma String e um double
     * @param descricao
     * @param valor
     */
    public Cardapio(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    /**
     * Retorna o nome da opção de menu
     * @return descricao da opção do menu
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Seta o nome da descrição da opção de menu para o parâmetro passado
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna o valor da opção de menu
     * @return valor da opção
     */
    public double getValor() {
        return valor;
    }

    /**
     * Muda o valor da opção de menu para o parâmetro passado
     * @param valor
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Método equals para a verificação se dois Objetos do tipo Cardapio são iguais
     * ou não, se forem iguais o retorno é true, caso contrário, false 
     * @param cardapio
     * @return boolean
     */
    public boolean equals(Cardapio cardapio){
        if (this.descricao.equals(cardapio.getDescricao()) && this.valor == cardapio.getValor()){
            return true;
        }
        else{
            return false;
        }
    }
}
