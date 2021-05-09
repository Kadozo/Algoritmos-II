/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import model.Computador;

/**
 *
 * @author Thiago Cardozo
 * @param <T>
 */
public class Fila <T> extends MyLinkedList <T> {
    public Computador proximo(float parametro,MyLinkedList<Computador> lista) {
        MyIterator<Computador> it = new MyIterator<>(lista.getHead());
        Computador verific = null,verific2 = null;
        boolean flag = true;
        while(flag && it.hasNext()){
            verific = it.next();
            if(parametro < verific.getMemory()){
                flag = false;
            }
            if(parametro == verific.getMemory()){
                verific2 = verific;
            }
        }
        if(it.hasNext()||verific2 == null)
            return verific;
        else // se não houve nenhum computador com memoria maior que o parametro, retorna o computador de possue memoria igual
            return verific2;
    }
}
