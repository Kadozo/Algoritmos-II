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

import util.Historico;
import util.FilaEspera;
import util.ListaPacientes;
import util.ListaAgendamentos;
import util.ListaLotes;

/**
 *
 * @author Thiago Cardozo
 */
public class Sistema {
    private Historico historico;
    private ListaPacientes pacientes;
    private ListaLotes ofertaSemanal;
    private FilaEspera filaDeEspera;
    private ListaAgendamentos agendamentos;

    /**
     *
     */
    public Sistema() {
        historico = new Historico();
        pacientes = new ListaPacientes();
        ofertaSemanal = new ListaLotes();
        filaDeEspera = new FilaEspera();
        agendamentos = new ListaAgendamentos(historico,filaDeEspera,ofertaSemanal);
    }

    public Historico getHistorico() {
        return historico;
    }

    public ListaPacientes getPacientes() {
        return pacientes;
    }

    public ListaLotes getOfertaSemanal() {
        return ofertaSemanal;
    }

    public ListaAgendamentos getAgendamentos() {
        return agendamentos;
    }

    public FilaEspera getFilaDeEspera() {
        return filaDeEspera;
    }
    
    
}
