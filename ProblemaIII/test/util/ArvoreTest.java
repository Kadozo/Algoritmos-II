/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import model.Imagem;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *Testes de unidade da estrutura de dados Arvore AVL, verifica se o todos os métodos foram implementados corretamente
 * @author Thiago Cardozo
 */
public class ArvoreTest {
    Arvore<Imagem> tree;
    Imagem a1,a2,a3,a4,a5,a6,a7,a8,a9,a10;

    /**
     *
     */
    @Before
    public void setUp() {
        tree = new Arvore<>();
        a1 = new Imagem("a",(float) 15.5);
        a2 = new Imagem("b",(float) 15.5);
        a3 = new Imagem("c",(float) 15.5);
        a4 = new Imagem("d",(float) 15.5);
        a5 = new Imagem("e",(float) 15.5);
        a6 = new Imagem("f",(float) 15.5);
        a7 = new Imagem("g",(float) 15.5);
        a8 = new Imagem("h",(float) 15.5);
        a9 = new Imagem("i",(float) 15.5);
        a10 = new Imagem("j",(float) 15.5);
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void addTest() throws Exception{
        
        tree.put(a1.getName(), a1);
        tree.put(a2.getName(), a2);
        tree.put(a3.getName(), a3);
        tree.put(a4.getName(), a4);
        tree.put(a5.getName(), a5);
        tree.put(a7.getName(), a7);
        tree.put(a8.getName(), a8);
        tree.put(a9.getName(), a9);
        tree.put(a10.getName(), a10);
        tree.put(a6.getName(), a6);
        
        assertEquals(a2, tree.get("b"));
        assertEquals(a10, tree.get("j"));
        
        assertEquals("a,b,c,d,e,f,g,h,i,j,",tree.inOrder(tree.getRoot()));
    }

    /**
     *
     */
    @Test
    public void removeTest(){
        
        tree.put(a1.getName(), a1);
        tree.put(a2.getName(), a2);
        tree.put(a3.getName(), a3);
        tree.put(a4.getName(), a4);
        tree.put(a5.getName(), a5);
        tree.put(a7.getName(), a7);
        tree.put(a8.getName(), a8);
        tree.put(a9.getName(), a9);
        tree.put(a10.getName(), a10);
        tree.put(a6.getName(), a6);
        
        tree.remove("a");
        tree.remove("b");
        tree.remove("i");
        tree.remove("h");
        tree.remove("e");
        assertEquals("c,d,f,g,j,",tree.inOrder(tree.getRoot()));
        tree.printTree(tree.getRoot());
    }

    /**
     *
     */
    @Test
    public void getTest(){
        tree.put(a1.getName(), a1);
        tree.remove("a");
        assertNull(tree.get("a"));
        tree.put(a2.getName(), a2);
        tree.put(a3.getName(), a3);
        tree.remove("b");
        assertNull(tree.get("b"));
        tree.put(a3.getName(), a3);
        tree.put(a4.getName(), a4);
        assertEquals(a3, tree.get("c"));
        tree.remove("c");
        assertNull(tree.get("c"));
        assertTrue(tree.search("d"));
    }

    /**
     *
     */
    @Test
    public void searchTest(){
        tree.put(a1.getName(), a1);
        tree.put(a2.getName(), a2);
        tree.put(a3.getName(), a3);
        tree.put(a4.getName(), a4);
        tree.put(a5.getName(), a5);
        assertTrue(tree.search("a"));
        assertTrue(tree.search("b"));
        assertTrue(tree.search("c"));
        assertTrue(tree.search("d"));
        assertTrue(tree.search("e"));
        assertFalse(tree.search("f"));
        assertFalse(tree.search("g"));
        assertFalse(tree.search("h"));
        tree.put(a6.getName(), a7);
        tree.put(a8.getName(), a8);
        tree.put(a7.getName(), a9);
        assertTrue(tree.search("f"));
        assertTrue(tree.search("g"));
        assertTrue(tree.search("h"));
    }
}

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
