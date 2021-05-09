/*******************************************************************************
Autor: Thiago Cardozo de Jesus
Componente Curricular: Algoritmos II
Concluido em: 20/07/2019
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum 
trecho de código de outro colega ou de outro autor, tais como provindos de livros e 
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************************************************************************/
package util;

import java.util.Iterator;


/**
 * Classe de iterator da mylinkedlist
 * @author Thiago Cardozo
 */
public class MyIterator implements Iterator {
    
    Link temp;

    /**
     * construtor de MyIterator que recebe como parametro um Link
     * @param temp o link que será usado para a construção do Iterator
     */
    public MyIterator(Link temp) {
        this.temp = temp;
    }
    
    
    @Override
    public boolean hasNext() {
        return temp!= null;
    }

  
    @Override
    public Object next() {
        if(temp == null){
            return null;
        }
        Object O = temp.getData();
        temp = temp.getNext();
        return O;
    }
    
    
}

