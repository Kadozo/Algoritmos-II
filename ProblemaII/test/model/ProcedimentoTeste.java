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
 
package model;

import model.Procedimento;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author 
 */
public class ProcedimentoTeste {

    Procedimento procedimento;

    @Before
    public void setUp() throws Exception {
        procedimento = new Procedimento("Sidney", "sala 09");

    }

    @Test
    public void testeInsercao() {
        assertEquals("Sidney", procedimento.getMedico());
        assertEquals("sala 09", procedimento.getSala());

        procedimento.setMedico("Josineide");
        procedimento.setSala("sala especial 03");

        assertEquals("Josineide", procedimento.getMedico());
        assertEquals("sala especial 03", procedimento.getSala());

    }
}
