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

import model.Exame;
import model.Consulta;
import model.Lote;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author 
 */
public class LoteTeste {

    Exame exame1;
    Consulta consulta1;
    Lote lote;

    @Before
    public void setUp() throws Exception {
        exame1 = new Exame("Francisco Amaral", "E20", "Tomografia", "Sem recomendacoes", "Gravidez");
        consulta1 = new Consulta("João Ferreira", "C09", "Cardiologia");
        lote = new Lote(exame1, 7, "30/07/2019");
    }

    @Test
    public void testeInsercao() {
        assertEquals(exame1, lote.getProcedimento());
        assertEquals(7, lote.getQuantidade());
        assertEquals("30/07/2019", lote.getData());

        lote.setProcedimento(consulta1);
        lote.setQuantidade(10);
        lote.setData("31/07/2019");

        assertEquals(consulta1, lote.getProcedimento());
        assertEquals(10, lote.getQuantidade());
        assertEquals("31/07/2019", lote.getData());
    }
    @Test
    public void testEquals() {
        Lote l;
        l = new Lote(exame1, 7, "30/07/2019");
        assertTrue(l.equals(lote));     
        
        l = new Lote(consulta1, 5, "12/09/2019");
        assertFalse(l.equals(lote));
    }
}
