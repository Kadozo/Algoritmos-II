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
public class Exame extends Procedimento {
    String tipo;
    String recomendacoes;
    String restricoes;

    /**
     *
     * @param medico
     * @param sala
     * @param tipo
     * @param recomendacoes
     * @param restricoes
     */
    public Exame(String medico, String sala, String tipo,String recomendacoes,String restricoes) {
        super(medico, sala);
        this.tipo = tipo;
        this.recomendacoes = recomendacoes;
        this.restricoes = restricoes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRecomendacoes() {
        return recomendacoes;
    }

    public void setRecomendacoes(String recomendacoes) {
        this.recomendacoes = recomendacoes;
    }

    public String getRestricoes() {
        return restricoes;
    }

    public void setRestricoes(String restricoes) {
        this.restricoes = restricoes;
    }
    
    /**
     *método equals para verificar se os objetos possuem os mesmo atributos
     * @param exame
     * @return verdadeiro caso iguais, falso caso não
     */
    public boolean equals(Exame exame){
        boolean verific1 = super.equals(exame) && this.tipo.contains(exame.getTipo());
        boolean verific2 = this.recomendacoes.contains(exame.getRecomendacoes())
                           && this.restricoes.contains(exame.getRestricoes());
        return verific1 && verific2;
    } 
}
