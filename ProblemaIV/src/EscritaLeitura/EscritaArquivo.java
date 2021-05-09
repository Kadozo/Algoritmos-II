/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EscritaLeitura;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javafx.scene.Cursor;

/**
 *
 * @author Thiago Cardozo
 */
public class EscritaArquivo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       int numerorVertices = 51;
       Random random = new Random();
       int m[][] = new int[numerorVertices][numerorVertices];
       System.out.println(m.length);
       for(int i=0;i<numerorVertices;i++){
           for(int j=0;j<numerorVertices;j++){
               if( j > i)
                    m[i][j] = random.nextInt(5);
               else if( i == j )
                   m[i][j] = 0;
               else
                    m[i][j] = m[j][i];
            }
        }
       FileWriter Cwriter = new FileWriter("MatrizAdj.txt");
       BufferedWriter Cbuffer = new BufferedWriter(Cwriter);
       for(int i = 0; i<numerorVertices;i++){
           for(int j = 0;j< numerorVertices;j++){
               if(j!= numerorVertices-1) 
               Cbuffer.write(m[i][j]+" ");
               else
                   Cbuffer.write(m[i][j]+"");
           }
           Cbuffer.newLine();
       }
       Cbuffer.close();
    }
       
}
