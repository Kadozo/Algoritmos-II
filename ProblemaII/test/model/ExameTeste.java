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
public class ExameTeste {

    Exame exame;

    @Before
    public void setUp() throws Exception {

        exame = new Exame("Maria Silva", "E20", "Eletrocardiograma", "Sem recomendacoes", "Sem restrições");
    }

    @Test
    public void testeInsercao() {
        assertEquals("Maria Silva", exame.getMedico());
        assertEquals("E20", exame.getSala());
        assertEquals("Eletrocardiograma", exame.getTipo());
        assertEquals("Sem recomendacoes", exame.getRecomendacoes());
        assertEquals("Sem restrições", exame.getRestricoes());

        exame.setMedico("Ana Paz");
        exame.setSala("E13");
        exame.setTipo("Ultrassom morfológica");

        assertEquals("Ana Paz", exame.getMedico());
        assertEquals("E13", exame.getSala());
        assertEquals("Ultrassom morfológica", exame.getTipo());

    }
    @Test
    public void testEquals() {
        Exame exame1 = new Exame("Maria Silva", "E20", "Eletrocardiograma", "Sem recomendacoes", "Sem restrições");
        assertTrue(exame1.equals(exame));
        
        exame1 = new Exame("Salvador", "E04", "Eletrocardiograma", "Sem objetos metalicos", "Sem restrições");
        assertFalse(exame1.equals(exame));
        
    }

}
