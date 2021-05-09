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
public class Procedimento {
    String medico;
    String sala;

    /**
     *
     * @param medico
     * @param sala
     */
    public Procedimento(String medico, String sala) {
        this.medico = medico;
        this.sala = sala;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    /**
     *método equals para verificar se os objetos possuem os mesmo atributos
     * @param procedimento
     * @return verdadeiro caso iguais, falso caso não.
     */
    public boolean equals(Procedimento procedimento){
        return (this.sala.contains(procedimento.getSala()) && this.medico.contains(procedimento.getMedico()));
    }
    
}
