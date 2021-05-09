/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EscritaLeitura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 *
 * @author Thiago Cardozo
 */
public class CarregarArquivoParaMatriz {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File arquivo = new File("MatrizAdj2.txt");
        LineNumberReader linhas = new LineNumberReader(new FileReader(arquivo));
        linhas.skip(arquivo.length()); //pula para o ultimo caractere do arquivo
        int qtdLinhas = linhas.getLineNumber(); // verifica qual a linha atual do arquivo para encontrar a quantidade de vertices
        linhas.close();
        int m[][] = new int[qtdLinhas][qtdLinhas]; //cria uma matriz com a quantidade de linhas encontrada
        FileReader fReader = new FileReader("MatrizAdj2.txt");
        BufferedReader fBuffer = new BufferedReader(fReader);
        for(int i=0; i<qtdLinhas;i++){
            String linha = fBuffer.readLine();
            String[] split = linha.split(" ");
            for(int j = 0;j<qtdLinhas;j++){
                if(split[j].compareTo(" ") == 0){
                    
                }
                else{
                m[i][j] = Integer.parseInt(split[j]); //grava os ints na matriz
                }
            }
        }
        fBuffer.close(); 
        for(int i =0; i< m.length ; i++){ //impressão da matriz
            for(int j = 0; j<m.length; j++){
                System.out.print(m[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
    
}
