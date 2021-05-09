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
import model.Agendamento;
import model.Paciente;
import model.Procedimento;

/**
 *
 * @author Thiago Cardozo
 */
public class Historico extends LinkedList {
    
    
    
    

    /**
     *método que procura no histórico por atendente(String) e retorna uma 
     *lista com as correspondencias da busca
     * @param atendente
     * @return um iterator para uma lista com os agendamentos com o(a) 
     * atendente específico(a)
     */

    public Iterator procurarHistoricoPorAtendente(String atendente){
            Iterator temp = this.iterator();
            LinkedList resultado = new LinkedList();
            while(temp.hasNext()){
                Agendamento a = (Agendamento) temp.next();
                if( a.getAtendente().contains(atendente) )
                    resultado.add(a);
            }
            Iterator it = resultado.iterator();
            return it;
    }

    /**
     *método que procura no histórico por paciente (Paciente) e retorna uma 
     * lista com as correspondencias da busca
     * @param paciente
     * @return um iterator para um lista com os agendamentos com o paciente
     * especifico
     */
    public Iterator procurarHistoricoPorPaciente(Paciente paciente){
        Iterator temp = this.iterator();
            LinkedList resultado = new LinkedList();
            while(temp.hasNext()){
                Agendamento a = (Agendamento) temp.next();
                if( a.getPaciente().getCpf().contains(paciente.getCpf()) )
                    resultado.add(a);
            }
            Iterator it = resultado.iterator();
            return it;
    }

    /**
     *método que procura no histórico por medico(String) e retorna uma 
     *lista com as correspondencias da busca
     * @param medico
     * @return um iterator para a lista de com os agendamentos com o medico 
     * especifico
     */
    public Iterator procurarHistoricoPorMedico (String medico){
        Iterator temp = this.iterator();
            LinkedList resultado = new LinkedList();
            while(temp.hasNext()){
                Agendamento a = (Agendamento) temp.next();
                if( a.getProcedimento().getMedico().contains(medico) )
                    resultado.add(a);
            }
            Iterator it = resultado.iterator();
            return it;
    }

    /**
     *método que procura no histórico por procedimento(Procedimento) e retorna uma 
     *lista com as correspondencias da busca
     * @param procedimento
     * @return um iterator para lista com os agendamentos que possuem o 
     * procedimento especificado.
     */
    public Iterator procurarHistoricoPorProcedimento (Procedimento procedimento){
        Iterator temp = this.iterator();
            LinkedList resultado = new LinkedList();
            while(temp.hasNext()){
                Agendamento a = (Agendamento) temp.next();
                if( a.getProcedimento() == procedimento )
                    resultado.add(a);
            }
            Iterator it = resultado.iterator();
            return it;
    }

    /**
     *método que procura no histórico por data (String) e retorna uma 
     *lista com as correspondencias da busca. Lembrando que a data parâmetro é a
     * data do procedimento.
     * @param data
     * @return um iterator para lista com os agendamentos que possuem os 
     * procedimentos realizado na data especificada 
     */
    public Iterator procurarHistoricoPorData(String data) {
        Iterator temp = this.iterator();
            LinkedList resultado = new LinkedList();
            while(temp.hasNext()){
                Agendamento a = (Agendamento) temp.next();
                if( a.getDtProcedimento().contains(data) )
                    resultado.add(a);
            }
            Iterator it = resultado.iterator();
            return it;
    }
}
