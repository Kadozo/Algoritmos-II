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
package util;

import java.util.Iterator;
import model.Paciente;

/**
 *
 * @author Thiago Cardozo
 */
public class ListaPacientes extends LinkedList {
    

    /**
     * método para busca de pacientes com o parametro de nome
     * @param nome
     * @return um lista com todos os pacientes que tenham o nome passado
     */
    public Iterator buscarPacientePorNome(String nome){
        Iterator temp = new MyIterator(head);
        LinkedList resultado = new LinkedList();
        while(temp.hasNext()){
            Paciente p = (Paciente) temp.next();
            if(p.getNome().contains(nome)){
                resultado.add(p);
            }
        }
        Iterator iresultado = new MyIterator(resultado.getHead());
        return iresultado;
    }
    

    /**
     *método de busca de paciente com o parametro de cpf
     * @param cpf
     * @return o paciente que possue o cpf específico
     */
    public Paciente buscarPacientePorCPF(String cpf){
        Iterator temp = new MyIterator(head);
        while(temp.hasNext()){
            Paciente p = (Paciente) temp.next();
            if(p.getCpf().contains(cpf)){
               return p;
            }
        }
        return null;
    }
}
