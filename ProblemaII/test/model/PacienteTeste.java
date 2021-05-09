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

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import model.Paciente;


/**
 *
 * @author
 */
public class PacienteTeste {

    Paciente paciente1;

    @Before
    public void setUp() throws Exception {
        paciente1 = new Paciente("Ana", "089.345.555-00", "3445-8901", "24-07-1998");
    }

    @Test
    public void testeInsercao() {
        assertEquals("Ana", paciente1.getNome());
        assertEquals("089.345.555-00", paciente1.getCpf());
        assertEquals("3445-8901", paciente1.getTelefone());
        assertEquals("24-07-1998", paciente1.getDataNascimento());

        paciente1.setNome("Ana Maria");
        paciente1.setCpf("000.567.124-98");
        paciente1.setDataNascimento("24-07-2000");

        assertEquals("Ana Maria", paciente1.getNome());
        assertEquals("000.567.124-98", paciente1.getCpf());
        assertEquals("24-07-2000", paciente1.getDataNascimento());

    }

     @Test
    public void testEquals() {
        Paciente paciente2= new Paciente("Ana", "089.345.555-00", "3445-8901", "24-07-1998");
        assertTrue(paciente2.equals(paciente1));
        
        paciente2= new Paciente("Joao Carlos", "111.225.555-00", "2345-0198", "05-12-2000");
        assertFalse(paciente2.equals(paciente1));
        
    }

}
