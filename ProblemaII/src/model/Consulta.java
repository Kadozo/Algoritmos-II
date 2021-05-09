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
public class Consulta extends Procedimento {
    String especialidade;

    /**
     *
     * @param medico
     * @param sala
     * @param especialidade
     */
    public Consulta(String medico, String sala,String especialidade) {
        super(medico, sala);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    /**
     * método equals para verificar se os objetos possuem os mesmo atributos
     * @param consulta
     * @return verdadeiro caso forem iguais, falso caso não
     */
    public boolean equals(Consulta consulta){
        return super.equals(consulta) && this.especialidade.contains(consulta.getEspecialidade());
    } 
}
