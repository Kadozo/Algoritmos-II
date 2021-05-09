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

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author
 */
public class ConsultaTeste {

    Consulta consulta;

    @Before
    public void setUp() throws Exception {

        consulta = new Consulta("Alberto", "C09", "Dermatologia");
    }

    @Test
    public void testeInsercao() {
        assertEquals("Alberto", consulta.getMedico());
        assertEquals("C09", consulta.getSala());
        assertEquals("Dermatologia", consulta.getEspecialidade());

        consulta.setMedico("Marta");
        consulta.setSala("C05");
        consulta.setEspecialidade("Radiologia");

        assertEquals("Marta", consulta.getMedico());
        assertEquals("C05", consulta.getSala());
        assertEquals("Radiologia", consulta.getEspecialidade());
    }
    @Test
    public void testEquals() {
        Consulta consulta1= new Consulta("Alberto", "C09", "Dermatologia");
        assertTrue(consulta1.equals(consulta));
        
        consulta1 = new Consulta("John", "S01", "Radiologia");
        assertFalse(consulta1.equals(consulta));
        
    }
}
