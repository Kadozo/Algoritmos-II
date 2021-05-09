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
import model.Lote;

/**
 *
 * @author Thiago Cardozo
 */
public class ListaAgendamentos extends LinkedList{
    private FilaEspera filaDeEspera;
    private Historico historico;
    private ListaLotes ofertaSemanal;
    
    /**
     *
     * @param historico
     * @param filaDeEspera
     * @param ofertaSemanal
     */
    public ListaAgendamentos( Historico historico, FilaEspera filaDeEspera,ListaLotes ofertaSemanal ) {
        this.historico = historico;
        this.filaDeEspera = filaDeEspera;
        this.ofertaSemanal = ofertaSemanal;
    }
    /**
     *confirma a presença e retira o agendamento da lista de agendamentos e o 
     *aloca para o historico e a fila de espera
     * @param agendamento
     */

    public void confirmarPresenca(Agendamento agendamento){
        int count = 0;
        Iterator temp = this.iterator();
        while(temp.hasNext()){
            Agendamento a = (Agendamento) temp.next();
            if(a == agendamento){
                this.historico.add(a);
                this.filaDeEspera.add(a); 
                remove(count);
            }
            count++;
        }
    }
    
    /**
     * Método add (adicionar) para a Lista de Agendamentos, esse método faz um
     * controle sob quais agendamentos vão ser inseridos, verificando na lista 
     * de lotes se ainda existe oferta para o procedimento escolhido.
     * @param ag
     * @param lotes
     * @return uma string indicando se o agendamento foi realizado, ou procedimento
     * esgotado, ou procedimento indisponível para a data.
     */
    public String addAgendamento(Agendamento ag,ListaLotes lotes){
        Iterator it = lotes.iterator();
        while(it.hasNext()){
            Lote a = (Lote)it.next();
            if(a.getProcedimento() == ag.getProcedimento()){
               if(a.getData() != ag.getDtProcedimento()){
                   return "Procedimento indisponível para a data escolhida";
               }
               if(a.getQuantidade() == 0){
                        return "Procedimento esgotado";
               }
               this.add(ag);
               a.setQuantidade(a.getQuantidade()-1);
               return "Agendamento confirmado";
            }
        }
        return "Procedimento Inexistente";
    }
    
    /**
     * retorna uma lista com os pacientes ausentes, ou seja, os que não 
     * confirmaram presença
     * @param data
     * @return
     */
    public Iterator getPacientesAusentes(String data){
        Iterator it = this.iterator();
        LinkedList resultado = new LinkedList();
        while(it.hasNext()){
            Agendamento a = (Agendamento) it.next();
            if(a.getDtProcedimento().contains(data)){
                resultado.add(a.getPaciente());
            }
        }
        Iterator it2 = resultado.iterator();
        return it2;
    }
}
