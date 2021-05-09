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
 *
 * @author Thiago Cardozo
 */
public class ImagemTest {
    Imagem i1,i2,i3;
    @Before
    public void setUp() {
        i1 = new Imagem("abfds", 15);
        i2 = new Imagem("abf", 10);
        i3 = new Imagem("bbbb", 9);
    }
    @Test
    public void getTest(){
        assertEquals(10, i2.getSize(),00001);
        assertEquals(15, i1.getSize(),00001);
        assertEquals(9, i3.getSize(),00001);
        assertEquals("abfds", i1.getName());
        assertEquals("abf", i2.getName());
        assertEquals("bbbb", i3.getName());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
