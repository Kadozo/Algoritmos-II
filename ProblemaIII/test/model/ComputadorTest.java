/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import exceptions.MemoriaIndisponivelException;

/**
 * teste de unidade da Classe computador, verifica se o todos os métodos foram implementados corretamente
 * @author Thiago Cardozo
 */
public class ComputadorTest {
    Computador c1,c2;
    Imagem i1,i2,i3,i4,i5,i6;
    @Before
    public void setUp() {
        c1 = new Computador("A0B1", 1500);
        c2 = new Computador("A0B2", 1400);
        i1 = new Imagem("aaaa", 15);
        i2 = new Imagem("bbbb", 15);
        i3 = new Imagem("cccc", 20);
        i4 = new Imagem("dddd", 25);
        i5 = new Imagem("eeee", 35);
        i6 = new Imagem("ffff", 50);
    }
    @Test
    public void getTest(){
        assertEquals(c1.getId(), "A0B1");
        assertEquals(c2.getId(), "A0B2");
        assertEquals(1400, c2.getMemory(),0001);
        assertEquals(1500, c1.getMemory(),0001);
    }
    @Test
    public void addTest() throws MemoriaIndisponivelException{
  
        c1.add(i1);
        assertEquals(1485, c1.getMemory(), 0001);
        c1.add(i2);
        assertEquals(1470, c1.getMemory(), 0001);
        c1.add(i3);
        assertEquals(1450, c1.getMemory(), 0001);
        c2.add(i4);
        assertEquals(1375, c2.getMemory(), 0001);
        c2.add(i5);
        assertEquals(1340, c2.getMemory(), 0001);
        c2.add(i6);
        assertEquals(1290, c2.getMemory(), 0001);
        }
    }
