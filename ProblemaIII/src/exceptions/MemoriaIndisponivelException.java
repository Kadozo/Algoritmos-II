/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Thiago Cardozo
 */
public class MemoriaIndisponivelException extends Exception{

    public MemoriaIndisponivelException() {
        super("Este Computador não possue memória suficiente para armazenar essa imagem");
    }
   
}
