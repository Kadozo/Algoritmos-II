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
public class FilaEspera extends LinkedList {
    
    /**
     *Método add (adicionar) de FilaEspera, ele recebe um tipo Agendamento, e, 
     *baseado na prioridade do Agendamento, o insere na lista. Quanto maior a 
     *prioridade, mais a frente da fila o Agendamento estará.
     *
     * @param obj
     */
    
    
    public void add(Agendamento obj){
        if(head == null){
            super.add(obj);
        }
        else {
            Agendamento a = (Agendamento) head.getData();
            Iterator it = this.iterator();
            int count = 0;
            boolean flag = true;
                while(it.hasNext()){
                    a = (Agendamento) it.next();
                    if(a.getPrioridade()<obj.getPrioridade()){
                        super.add(count,obj);
                        flag = false;
                        return;
                    }
                     count++;
                }
                if(flag){
                    super.add(obj);
            }
        }
    }

    /**
     * Percorre a FilaEspera, do inicio pro final, a procura de um procedimento
     * a fim de encontrar o agendamento com maior prioridade que tenha esse
     * procedimento, retornando assim, o proximo paciente da fila de espera do
     * procedimento procurado.
     * @param procedimento
     * @return um objeto Paciente
     */
    public Paciente proximoPaciente(Procedimento procedimento) {
        Iterator it = iterator();
        int count = 0;
        while(it.hasNext()){
            Agendamento verific = (Agendamento) it.next();
            if(verific.getProcedimento().equals(procedimento)){
                Agendamento b = (Agendamento) remove(count);
                Paciente retorno = b.getPaciente();
                return retorno;
            }
            count++;
        }
        return null;
    }
}