/*******************************************************************************
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
/**
 * Classe nó da MylinkedList
 * @author Thiago Cardozo
 */
public class Link {
    private Object data;
    private Link next;

    /**
     * Construtor da classe link
     * @param data, conteúdo da link
     */
    public Link(Object data) {
        this.data = data;
    }

    /**
     * retorna o Objeto que possue no Link
     * @return data, o conteúdo do link
     */
    public Object getData() {
        return data;
    }

    /**
     * Método para alterar o conteúdo existente por um novo conteúdo
     * @param data,conteúdo que substituirá o antigo
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     *
     * @return next, um novo Link. Que inicialmente é tido como null
     */
    public Link getNext() {
        return next;
    }

    /**
     * Método para setar o next, ou seja, qual o próximo nó virá após o atual na lista
     * @param next, O Link que será o próximo do atual numa lista
     */
    public void setNext(Link next) {
        this.next = next;
    }
}
