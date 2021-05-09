/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autores: Daniel Fernandes, Diego Silva, Esdras Sena, Estéfane Souza, José Gabriel Gomes, Mateus Fernandes e Thiago Cardozo
 * Data:  21/07/2019
 *
 * Declaramos que este código foi elaborado de forma coletiva pelos autores
 * e não contém nenhum trecho de código de outro autor, tais como provindos 
 * de livros e apostilas, e páginas ou documentos eletrônicos da Internet. 
 * Qualquer trecho de código de outra autoria que uma citação para o mesmo
 * não a minha está destacado com autor e a fonte do código, e estou ciente
 * que estes trechos não serão considerados para fins de avaliação.
 */
 
package allTest;

import model.AgendamentoTeste;
import model.ConsultaTeste;
import model.ExameTeste;
import model.LoteTeste;
import model.PacienteTeste;
import model.ProcedimentoTeste;
import model.SistemaTeste;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import util.LinkedTest;
import util.FilaPrioridadeTeste;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    LinkedTest.class,
    FilaPrioridadeTeste.class, 
    AgendamentoTeste.class,
    ConsultaTeste.class,
    ExameTeste.class,
    LoteTeste.class,
    PacienteTeste.class,
    ProcedimentoTeste.class,
    SistemaTeste.class
})

public class AllTests {
}
