/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import exceptions.ImagemDuplicadaException;
import exceptions.MemoriaIndisponivelException;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *Testes de unidade da Classe Sistema, verifica se o todos os métodos foram implementados corretamente
 * @author Thiago Cardozo
 */
public class SystemTest {
    Sistema sys = new Sistema();
    Imagem i1,i2,i3,i4,i5,i6,i7,i8,i9,i10;
    Computador computador;
    @Before
    public void setUp() {
        i1 = new Imagem("name1", 15);
        i2 = new Imagem("name2", 15);
        i3 = new Imagem("name3", 15);
        i4 = new Imagem("name4", 15);
        i5 = new Imagem("name5", 15);
        i6 = new Imagem("name6", 15);
        i7 = new Imagem("name7", 15);
        i8 = new Imagem("name8", 15);
        i9 = new Imagem("name9", 15);
        i10 = new Imagem("name0", 15);
        computador = new Computador("Computer", 1500);
    }
    @Test(expected = ImagemDuplicadaException.class)
    public void alocarImagensDuplicadasTest() throws ImagemDuplicadaException, MemoriaIndisponivelException, IOException{
        sys.alocarImagens();
        assertEquals(15, sys.getComputadores().size());
        assertEquals(1000,sys.getRegistro().getElementsCount());
        Imagem imagem = new Imagem("aab", 15); //testa se a exception esta sendo lançada corretamente
        sys.AddImagem(imagem);   
    }
    @Test
    public void listagemImagens() throws MemoriaIndisponivelException, ImagemDuplicadaException{
        sys.addComputador(computador);
        sys.AddImagem(i1);
        sys.AddImagem(i2);
        sys.AddImagem(i3);
        sys.AddImagem(i4);
        sys.AddImagem(i5);
        sys.AddImagem(i6);
        sys.AddImagem(i7);
        sys.AddImagem(i8);
        sys.AddImagem(i9);
        sys.AddImagem(i10);
        assertEquals(10,sys.getRegistro().getElementsCount());
        assertEquals("name0,name1,name2,name3,name4,name5,"
                + "name6,name7,name8,name9,",sys.listarImagens());   
    }
    @Test
    public void addComputadores(){
        sys.addComputador(computador);
        sys.addComputador(computador);
        sys.addComputador(computador);
        assertEquals(3,sys.getComputadores().size());
    }
    @Test
    public void alocarImagens() throws ImagemDuplicadaException{
        sys.alocarImagens();
        assertEquals(15, sys.getComputadores().size());
        assertEquals(1000,sys.getRegistro().getElementsCount());
    }
    @Test
    public void removeTest() throws ImagemDuplicadaException {
        sys.alocarImagens();
        sys.removerImagem("aab");
        assertFalse(sys.searchImagem("aab"));
        assertEquals(999, sys.getRegistro().getElementsCount());
    }
    @Test
    public void listagemEspaço() throws ImagemDuplicadaException{
        sys.alocarImagens();
        assertEquals(15, sys.getComputadores().size());
        assertEquals("1943.0, 1949.0, 1963.0, 1952.0, 1973.0, 2014.0, 1999.0, "
                + "1968.0, 2026.0, 2084.0, 2047.0, 2112.0, "
                + "2131.0, 2155.0, 3500.0, ", sys.listarEspaço());
    }
    @Test
    public void listarConteudo() throws ImagemDuplicadaException{
        sys.alocarImagens();
        assertEquals(15, sys.getComputadores().size());
        assertEquals("abn,abp,abr,abx,abz,acb,acd,aci,ack,acu,acw,adc,adh,adj,"
                + "adl,adn,aeh,aem,aeo,aes,aez,afj,afm,afo,afq,afu,"
                + "afw,afy,aga,agf,agh,ahe,ahg,ahi,aih,aij,ail,aiv,aix,ajf,ajh,"
                + "ajj,akd,akf,aku,akw,aky,alf,alh,alx,amb,amd,"
                + "ams,amu,ann,anp,anr,aoa,ape,apg,apo,aqa,aql,aqn,aqp,ari,arl,"
                + "arr,ase,ask,atb,atd,aue,aun,auz,avb,avl,avn,aws,"
                + "awu,axw,aym,ayo,azd,azh,azl,azn,bat,bbw,bds,bdw,bed,ben,bep,"
                + "bgr,bgt,bgy,bij,bjd,bjj,bjm,bjo,ble,blj,",sys.listarConteudo(sys.getComputadores().get(0)));
        
        assertEquals("avf,avi,avr,awy,axq,ayi,ayv,azq,bay,bbq,bca,bcl,bcn,bcq,"
                + "bct,bdz,beu,bew,bey,bgm,bhd,bhf,bhh,bhn,bhv,bio,bjs,bjv,bkm,"
                + "bkp,bku,bkw,bls,blu,",sys.listarConteudo(sys.getComputadores().get(7)));
        
        assertEquals("",sys.listarConteudo(sys.getComputadores().get(14)));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
