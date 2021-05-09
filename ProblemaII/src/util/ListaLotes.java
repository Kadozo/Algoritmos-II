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
import model.Lote;
import model.Procedimento;

/**
 *
 * @author Thiago Cardozo
 */
public class ListaLotes extends LinkedList {

    /**
     * itera através da lista de lotes a procura de um procedimento que seja
     * realizado na data especificada.
     * @param proc1
     * @param data
     * @return um Lote que atenda aos parâmetros da busca
     */
    public Lote procurarOferta(Procedimento proc1, String data) {
        Iterator it = this.iterator();
        while(it.hasNext()){
           Lote a = (Lote) it.next();
            if(a.getProcedimento() == proc1 && a.getData().contains(data)){
                return a;
            }
        }
        return null;
    }
    @Override
    public Lote get(int index) {
        if (head == null){
           return null;
        }
        if (index < 0 || index > size){
            return null;
        }
        else {
            int aux = 0;
            Link temp = head;
            while (aux != index) {
                temp = temp.getNext();
                aux ++;
            }
            return (Lote) temp.getData();
        }
    }

    /**
     * Método add (adicionar) da lista de lotes, que faz um controle sob os lotes
     * existentes e o parâmetro dado, caso o lote passado como parâmetro já 
     * esteja contido na lista, o add apenas somará a quantidade de ofertas 
     * disponíveis, caso contrário, ele adiocionará no final da lista.
     * @param lote
     */
    public void add(Lote lote) {
        if (head == null){
            head = new Link(lote);
            head.setNext(null);
            size ++;
        }
        else {
            boolean flag = false;
            Iterator it = this.iterator();
            while(it.hasNext()){
                Lote temp = (Lote) it.next();
                if(temp.equals(lote)){
                    temp.setQuantidade(temp.getQuantidade() + lote.getQuantidade());
                flag = true;
                }
            }
            if(!flag){
                super.add(lote);
            }
        }
    }
    
    
}
