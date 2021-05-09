/*******************************************************************************
Autor: Thiago Cardozo de Jesus
Componente Curricular: Algoritmos II
Concluido em: 20/07/2019
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum 
trecho de código de outro colega ou de outro autor, tais como provindos de livros e 
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************************************************************************/
package model;

/**
 *
 * @author Thiago Cardozo
 */
public class Lote {
    Procedimento procedimento;
    int quantidade;
    String data;

    /**
     *
     * @param procedimento
     * @param quantidade
     * @param data
     */
    public Lote(Procedimento procedimento, int quantidade, String data) {
        this.procedimento = procedimento;
        this.quantidade = quantidade;
        this.data = data;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    /**
     *método equals para verificar se os objetos possuem os mesmo atributos
     * @param lote
     * @return verdadeiro caso forem iguais, falso caso não.
     */
    public boolean equals(Lote lote){
        return this.data.contains(lote.getData()) && this.procedimento.equals(lote.getProcedimento());
    }
    
}
