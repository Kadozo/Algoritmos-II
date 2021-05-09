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

import java.util.Date;

/**
 *
 * @author Thiago Cardozo
 */
public class Agendamento {
    String atendente;
    Paciente paciente;
    Procedimento procedimento;
    Date dtAgendamento;
    String dtProcedimento;
    int prioridade;
    boolean presenca = false;

    /**
     *
     * @param atendente
     * @param paciente
     * @param procedimento
     * @param dtAgendamento
     * @param dtProcedimento
     * @param prioridade
     */
    public Agendamento(String atendente, Paciente paciente, Procedimento procedimento, Date dtAgendamento, String dtProcedimento, int prioridade) {
        this.atendente = atendente;
        this.paciente = paciente;
        this.procedimento = procedimento;
        this.dtAgendamento = dtAgendamento;
        this.dtProcedimento = dtProcedimento;
        this.prioridade = prioridade;
    }
    

    public String getAtendente() {
        return atendente;
    }

    public void setAtendente(String atendente) {
        this.atendente = atendente;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public Date getDataInsercao() {
        return dtAgendamento;
    }

    public void setDataInsercao(Date dtAgendamento) {
        this.dtAgendamento = dtAgendamento;
    }

    public String getDtProcedimento() {
        return dtProcedimento;
    }

    public void setDtProcedimento(String dtProcedimento) {
        this.dtProcedimento = dtProcedimento;
    }

    public boolean isPresente() {
        return presenca;
    }

    public void setPresenca() {
        this.presenca = true;
    }
    
}
