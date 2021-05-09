/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import util.MyLinkedList;

/**
 *
 * @author Thiago Cardozo & Diego do Carmo
 */
public class GrafoTest {
    Grafo grafoTest,grafoTeste2;
    
    /**
     *
     * @throws java.io.IOException
     */
    @Before
    public void setUp() throws IOException {
        File file = new File("pontos.txt");
        grafoTeste2 = new Grafo(file);
        grafoTest = new Grafo(10);
        grafoTest.addLigacao(0, 1, 2);
        grafoTest.addLigacao(0, 2, 3);
        grafoTest.addLigacao(0, 7, 4);
        grafoTest.addLigacao(9, 8, 2);
        grafoTest.addLigacao(8, 7, 2);
        grafoTest.addLigacao(2, 7, 3);
        grafoTest.addLigacao(2, 3, 2);
        grafoTest.addLigacao(3, 7, 3);
        grafoTest.addLigacao(3, 6, 3);
        grafoTest.addLigacao(5, 6, 2);
        grafoTest.addLigacao(5, 4, 1);
        grafoTest.addLigacao(4, 6, 2);
        grafoTest.definirEstacionamento(0);
        
    }

    /**
     * Test of getVertices method, of class Grafo.
     */
    @Test
    public void testGetVertices() {
        System.out.println("getVertices");
        Grafo instance = grafoTest;
        int[][] result = instance.getVertices();
        assertNotNull(result);
    }

    /**
     * Test of getEstacionamentoIndex method, of class Grafo.
     */
    @Test
    public void testGetEstacionamentoIndex() {
        System.out.println("getEstacionamentoIndex");
        Grafo instance = grafoTest;
        int expResult = 0;
        int result = instance.getEstacionamentoIndex();
        assertEquals(expResult, result);
    }

    /**
     * Test of getVizinhos method, of class Grafo.
     */
    @Test
    public void testGetVizinhos() {
        System.out.println("getVizinhos");
        Grafo instance = grafoTest;
        MyLinkedList<Integer> expResult = new MyLinkedList<>();
        expResult.add(4);
        expResult.add(6);
        MyLinkedList<Integer> result = instance.getVizinhos(5);
        assertEquals(expResult.size(), result.size());
        assertEquals(expResult.get(0), result.get(0));
        assertEquals(expResult.get(1), result.get(1));
    }

    /**
     * Test of addLigacao method, of class Grafo.
     */
    @Test
    public void testAddLigacao() {
        System.out.println("addLigacao");
        int origem = 0;
        int destino = 3;
        int peso = 8;
        Grafo instance = grafoTest;
        instance.addLigacao(origem, destino, peso);
        assertEquals(peso, instance.getPeso(origem, destino));
    }

    /**
     * Test of removeLigacao method, of class Grafo.
     */
    @Test
    public void testRemoveLigacao() {
        System.out.println("removeLigacao");
        int origem = 0;
        int destino = 7;
        Grafo instance = grafoTest;
        instance.removeLigacao(origem, destino);
        assertEquals(0, instance.getPeso(origem, destino));
    }

    /**
     * Test of getPeso method, of class Grafo.
     */
    @Test
    public void testGetPeso() {
        System.out.println("getPeso");
        int origem = 2;
        int destino = 7;
        Grafo instance = grafoTest;
        int expResult = 3;
        int result = instance.getPeso(origem, destino);
        assertEquals(expResult, result);
    }

    /**
     * Test of definirEstacionamento method, of class Grafo.
     */
    @Test
    public void testDefinirEstacionamento() {
        System.out.println("definirEstacionamento");
        int vertice = 8;
        Grafo instance = grafoTest;
        instance.definirEstacionamento(vertice);
        assertEquals(vertice, instance.getEstacionamentoIndex().intValue());
    }

    /**
     * Test of definirBanco method, of class Grafo.
     */
    @Test
    public void testDefinirBanco() {
        System.out.println("definirBanco");
        Grafo instance = grafoTest;
        instance.definirBanco(5);
        instance.definirBanco(2);
        instance.definirBanco(3);
        assertEquals(3, instance.getBancosIndex().size());
        assertEquals(5, instance.getBancosIndex().get(0).intValue());
        assertEquals(2, instance.getBancosIndex().get(1).intValue());
        assertEquals(3, instance.getBancosIndex().get(2).intValue());
    }

    /**
     * Test of definirColeta method, of class Grafo.
     */
    @Test
    public void testDefinirColeta() {
        System.out.println("definirColeta");
        Grafo instance = grafoTest;
        instance.definirColeta(5);
        instance.definirColeta(2);
        instance.definirColeta(3);
        assertEquals(3, instance.getColetaIndex().size());
        assertEquals(5, instance.getColetaIndex().get(0).intValue());
        assertEquals(2, instance.getColetaIndex().get(1).intValue());
        assertEquals(3, instance.getColetaIndex().get(2).intValue());
    }

    /**
     * Test of calcularRota method, of class Grafo.
     * @throws java.lang.Exception
     */
    @Test
    public void testCalcularRota() throws Exception {
        System.out.println("calcularRota");
        MyLinkedList<Integer> expResult = new MyLinkedList<>();
        expResult.add(2);
        expResult.add(3);
        expResult.add(6);
        expResult.add(4);
        MyLinkedList result = grafoTest.calcularRota(0,4);
        assertEquals(expResult.size(), result.size());
        assertEquals(expResult.get(0),result.get(0));
        assertEquals(expResult.get(1),result.get(1));
        assertEquals(expResult.get(2),result.get(2));
        assertEquals(expResult.get(3),result.get(3));
    }

    /**
     * Test of addNovoPonto method, of class Grafo.
     */
    @Test
    public void testAddNovoPonto() {
        System.out.println("addNovoPonto");
        Grafo instance = grafoTest;
        instance.addNovoPonto(1);
        assertEquals(11, instance.getVertices().length);
    }
    
    @Test
    public void testRemoverPonto(){
        System.out.println("removerPonto");
        Grafo instance = grafoTest;
        instance.removerPonto(5);
        
    }
}
