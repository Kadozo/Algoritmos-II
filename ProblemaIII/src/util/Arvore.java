/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 * implementação de um arvore AVL
 * @author Thiago Cardozo
 * @param <J>
 */
public class Arvore <J> implements Itree <J> {
    private Node <J> root;
    private int elementsCount;
    
    /**
     *
     */
    public Arvore() {
    }

    /**
     *
     * @return número de elementos adicionados na arvore
     */
    @Override
    public int getElementsCount() {
        return elementsCount;
    }
    
    /**
     *
     * @return o node raiz da arvore
     */
    public Node <J> getRoot(){
        return root;
    }
    /**
     * método para adicionar elementos a arvore, de maneira ordenada
     * @param key
     * @param obj
     * @return retorna true caso o elemento tenha sido adicionado corretamente, e false
     * caso contrário
     */
    @Override
    public boolean put(String key, J obj){
        Node <J> temp = new Node<>(obj, key);
        if(this.root == null){
            this.root = temp;
            elementsCount++;
        }
        else{
            try {
                this.root = put(this.root,temp);
            } catch (Exception ex) {
                return false;
            }
        }
        return true;
    }
    //método auxiliar para o put
    private Node<J> put(Node<J> reference,Node<J> node) throws Exception{
        Node <J> verific;
        if(reference == null){
            reference = node;
            verific = reference;
            elementsCount++;
            return verific;
        }
        else{
           if(reference.getKey().compareTo(node.getKey())>0){
                reference.setLeft(put(reference.getLeft(),node)); //isso ta certo?
                verific = reference;
            }
           else if(reference.getKey().compareTo(node.getKey())<0){
               reference.setRight(put(reference.getRight(),node));
               verific = reference; 
           }
           else{ //keys duplicadas
               throw new Exception("Imagens duplicadas");
           }
           verific = rebalance(verific);
           return verific;
        }
    }

    /**
     * retorna o contéudo do nó que tem a key passada por parametro
     * @param key
     * @return o contéudo do nó
     */
    @Override
    public J get(String key) {
        return get(key, this.root);
    }
    //método auxiliar do get
    private J get(String key,Node<J> reference){
        if(reference == null){ // caso a referencia passada seja nula, não tem motivo para a busca
            return null;
        }
        if(key.compareTo(reference.getKey()) == 0){
            return reference.getData();
        }
        //verifica se o obj possue valor maior ou menor, já que a arvore é ordenada 
        else{
            if(reference.getKey().compareTo(key)>0){ // se o valor do objeto for menor, a busca continua para a esquerda
                return get(key,reference.getLeft());
            }
            else{ // caso maior, ela continua para a direita
               return get(key, reference.getRight());
            }
        }
    }

    /**
     * verifica se um nó, através da key, está ou não está contido na arvore
     * @param key
     * @return retorna true caso o nó seja encontrado e false caso o nó não seja encontrado
     */
    public boolean search(String key){
        return search(key,this.root);
    }
    private boolean search(String key,Node<J> reference){
        if(reference == null){ // caso a referencia passada seja nula, não tem motivo para a busca
            return false;
        }
        if(key.compareTo(reference.getKey()) == 0){
            return true;
        }
        //verifica se o obj possue valor maior ou menor, já que a arvore é ordenada 
        else{
            if(reference.getKey().compareTo(key)>0){ // se o valor do objeto for menor, a busca continua para a esquerda
                return search(key,reference.getLeft());
            }
            else{ // caso maior, ela continua para a direita
               return search(key, reference.getRight());
            }
        }
    }
    /**
     * rotação a esquerda, caso o no esteja desbalanceado para a direita
     * @param node
     */
    @Override
    public Node<J> leftRotation(Node<J> node) { //retornar node
        Node<J> newRoot = node.getRight();
        Node<J> aux = newRoot.getLeft();
        newRoot.setLeft(node);
        node.setRight(aux);
        return newRoot;
    }

    /**
     *  rotação a direita, caso o no esteja desbalanceado para a esquerda
     * @param node
     */
    @Override
    public Node<J> rightRotation(Node<J> node) {
        Node<J> newRoot = node.getLeft();
        Node<J> aux = newRoot.getRight();
        newRoot.setRight(node);
        node.setLeft(aux);
        return newRoot;
    }

    /**
     * método responsavel por calcular o balanço do nó, para verificar se ele precisa ou não de rotação
     * @param node
     * @return um int que representa se ele está ou não balanceado. Valores entre -1 a 1 são considerados balanceados
     */
    @Override
    public int calculateBalance(Node<J> node) {
        int direita,esquerda;
        if(node == null)
            return -1;
        if(node.getRight() == null){
            direita = 0;
        }
        else{
            direita = 1 + node.getRight().getHeight();
        }
        if(node.getLeft() == null){
            esquerda = 0;
        }
        else{
            esquerda = 1 + node.getLeft().getHeight();
        }
        int balance = esquerda - direita;
        return balance;
    }

    /**
     * método responsavel por verificar se há ou não a necessidade de rotacionar
     * os nós da arvore
     * @param node
     */
    @Override
    public Node<J> rebalance(Node<J> node) {
        int balance = calculateBalance(node);
        if(balance <= -2){ //desbalanceada para a direita
            
            if(node.getRight() != null){ //verifica se existe filho direito
                if(calculateBalance(node.getRight()) == 1){// verifica a necessidade de rotação dupla
                    node.setRight(rightRotation(node.getRight()));//rotação dupla a esquerda 
                }
            }
            node = leftRotation(node);
        }
        else if(balance >= 2){ //desbalanceada para a esquerda 
            if(node.getLeft() != null){ //verifica se existe filho esquerdo
                if(calculateBalance(node.getLeft()) == -1){ // verifica a necessidade de rotação dupla
                    node.setLeft(rightRotation(node.getLeft()));//inicio da rotação dupla a direita 
                }
            }
           node = rightRotation(node);
        }
        return node;
    }

    /**
     * método remove da arvore
     * @param key
     */
    @Override
    public void remove(String key) {
            this.root = remove(key,this.root);
            elementsCount--;
    }
    private Node<J> remove(String key,Node<J> reference){
        if(reference.getKey().compareToIgnoreCase(key)== 0) {
            if(reference.getRight() == null && reference.getLeft() == null){
                return null;
            }
            else if (reference.getLeft()!= null){
                if(reference.getRight() == null){ // o node possue apenas o filho esquerdo
                    Node<J> auxiliar = antecessor(reference);
                    auxiliar.setLeft(reference.getLeft());
                    auxiliar.setRight(reference.getRight());
                    if(auxiliar == auxiliar.getLeft()){
                        auxiliar.setLeft(null);
                    }
                    reference = auxiliar;
                }
                else{ // o node possue 2 filhos
                    Node<J> auxiliar = sucessor(reference);
                    auxiliar.setLeft(auxiliar.getRight());
                    auxiliar.setRight(null);
                    Node<J> auxiliar2 = auxiliar;
                    auxiliar2.setLeft(reference.getLeft());
                    auxiliar2.setRight(reference.getRight());
                    if(auxiliar2 == auxiliar2.getRight()){
                        auxiliar2.setRight(null);
                    }
                    auxiliar = reference;
                    auxiliar.setLeft(null);
                    auxiliar.setLeft(null);
                    reference = auxiliar2;
                    
                }
            }
            else{
                Node<J> auxiliar = sucessor(reference);
                auxiliar.setLeft(auxiliar.getRight());
                auxiliar.setRight(null);
                auxiliar.setLeft(reference.getLeft());
                auxiliar.setRight(reference.getRight());
                if(auxiliar == auxiliar.getRight()){
                    auxiliar.setRight(null);
                }
                reference = auxiliar;
            }
        }
        else{
            if(reference.getKey().compareToIgnoreCase(key)>0){
                reference.setLeft(remove(key, reference.getLeft()));
            }
            else{
                reference.setRight(remove(key, reference.getRight()));
            }
        }
        reference = rebalance(reference);
        return reference;
    }

    /**
     * Listagem da arvore com todos os elementos em ordem
     * @param node
     * @return
     */
    public String inOrder(Node<J> node){
        if(node != null){
            String retorno = "";
            retorno += inOrder(node.getLeft());
            System.out.print(node.getKey());
            retorno += node.getKey()+ ",";
            retorno += inOrder(node.getRight());
            return retorno;
        }
        return "";
    }

    /**
     *Listagem Pre-Order da arvore
     * @param node
     */
    public void printTree(Node<J> node){
        if(node != null){
            System.out.print(node.getKey());
            System.out.print("\nEsquerda: ");
            printTree(node.getLeft());
            System.out.println("\nDireita: ");
            printTree(node.getRight());
        }
    }
    private Node<J> sucessor(Node<J> node){
        Node<J> nodeAux = node.getRight();
        while(nodeAux.getLeft()!= null){
            nodeAux = nodeAux.getLeft();
        }
        
        return nodeAux;
    }
    private Node<J> antecessor(Node<J> node){
        Node<J> nodeAux = node.getLeft();
        while(nodeAux.getRight()!= null){
            nodeAux = node.getRight();
        }
        return nodeAux;
    }

    /**
     * retorna um nó com a key passada por parametro
     * @param key
     * @return
     */
    public Node<J> procurarNo(String key){
        return procuraNo(key,this.root);
    }
    private Node<J> procuraNo(String key,Node<J> reference){
        if(reference == null){ // caso a referencia passada seja nula, não tem motivo para a busca
            return null;
        }
        if(key.compareTo(reference.getKey()) == 0){
            return reference;
        }
        //verifica se o obj possue valor maior ou menor, já que a arvore é ordenada 
        else{
            if(reference.getKey().compareTo(key)>0){ // se o valor do objeto for menor, a busca continua para a esquerda
                return procuraNo(key,reference.getLeft());
            }
            else{ // caso maior, ela continua para a direita
               return procuraNo(key, reference.getRight());
            }
        }
    }
}
