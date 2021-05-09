/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *Testes de unidade da Classe Registro, verifica se o todos os métodos foram implementados corretamente
 * @author Thiago Cardozo
 */
public class RegistroTest {
    Registro r1,r2,r3;
    Computador c1,c2,c3;
    Imagem i1,i2,i3;
    @Before
    public void setUp() {
        c1 = new Computador("ID01", 50);
        c2 = new Computador("ID02", 50);
        c3 = new Computador("ID03", 50);
        i1 = new Imagem("NOME01", 50);
        i2 = new Imagem("NOME02", 50);
        i3 = new Imagem("NOME03", 50);
        r1 = new Registro(c1, i1);
        r2 = new Registro(c2, i2);
        r3 = new Registro(c3, i3);
        
    }
    @Test
    public void RegistroTest(){
        assertEquals(c1, r1.getComputador());
        assertEquals(c2, r2.getComputador());
        assertEquals(c3, r3.getComputador());
        assertEquals(i1, r1.getImagem());
        assertEquals(i2, r2.getImagem());
        assertEquals(i3, r3.getImagem());
    }
}

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
