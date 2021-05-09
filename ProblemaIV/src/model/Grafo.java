/*******************************************************************************
Autor: Thiago Cardozo, Diego do Carmo 
Componente Curricular: Algoritmos II
Concluido em: 18/09/2019
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum 
trecho de código de outro colega ou de outro autor, tais como provindos de livros e 
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************************************************************************/
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import util.MyIterator;
import util.MyLinkedList;

/**
 * Classe simula o mapa, junto com suas funções. Dijsktra, adicionar pesos etc
 * @author Thiago Cardozo, Diego do Carmo
 */
public class Grafo {
    private static final int INDEFINIDO = -10;
    private final ArrayList<Integer> bancosIndex;
    private final ArrayList<Integer> coletaIndex;
    private int vertices [][];
    private Integer EstacionamentoIndex;
    private int pesoUltimaRota;

    /**
     *
     * @param numVertice
     */
    public Grafo(int numVertice) {
        bancosIndex = new ArrayList<>();
        coletaIndex = new ArrayList<>();
        EstacionamentoIndex = 0;
        vertices = new int[numVertice][numVertice];
        inicializarMatriz(vertices);
    }

    /**
     *
     * @return peso da rota feita pelo calcularRota()
     */
    public int getPesoUltimaRota() {
        return pesoUltimaRota;
    }

    /**
     *
     * @param pesoUltimaRota
     */
    public void setPesoUltimaRota(int pesoUltimaRota) {
        this.pesoUltimaRota = pesoUltimaRota;
    }
    
    /**
     * 
     * @return uma lista com os index de todos os bancos
     */
    public ArrayList<Integer> getBancosIndex() {
        return bancosIndex;
    }

    /**
     *
     * @return uma lista com os index de todos os pontos de coleta
     */
    public ArrayList<Integer> getColetaIndex() {
        return coletaIndex;
    }
    
    private void inicializarMatriz(int[][] matriz){
        for(int i = 0 ;i < matriz.length; i++){
            for(int j = 0; j < matriz.length; j++){
                if(i==j){
                    matriz[i][j] = 0;
                }
            }
        }
    }

    /**
     *
     * @return a matriz com todos os vertices do mapa
     */
    public int[][] getVertices() {
        return vertices;
    }

    /**
     *
     * @return o estacionamento atual
     */
    public Integer getEstacionamentoIndex() {
        return EstacionamentoIndex;
    }
    
    /**
     *
     * @param vertice 
     * @return a lista de vizinhos do vertice parametro
     */
    public MyLinkedList<Integer> getVizinhos(int vertice){
        MyLinkedList<Integer> retorno = new MyLinkedList();
        for(int i = 0; i< vertices[vertice].length; i++){
            if(vertices[vertice][i] != 0){
                retorno.add(i);
            }
        }
        return retorno;
    }

    /**
     * adiciona uma ligação nos pontos de origem e destino, passados por parâmetro, com o peso também passado por parâmetro
     * @param origem
     * @param destino
     * @param peso
     */
    public void  addLigacao(int origem,int destino,int peso){
        if(origem != destino){
            vertices[origem][destino] = peso;
            vertices[destino][origem] = peso;
        }
    }   

    /**
     * remove a ligação entre os pontos passados por parametro
     * @param origem
     * @param destino
     */
    public void removeLigacao(int origem,int destino){
        vertices[origem][destino] = 0;
        vertices[destino][origem] = 0;
    }

    /**
     * retorna o peso da ligação entre os pontos do parametro
     * @param origem
     * @param destino
     * @return o valor em int do peso da ligaçao
     */
    public int getPeso(int origem,int destino){
        return vertices[origem][destino];
    }

    /**
     * define um ponto para ser o estacionamento
     * @param vertice
     */
    public void definirEstacionamento(int vertice){ 
        vertices[vertice][vertice] = 0;//ESTACIONAMENTO;
        EstacionamentoIndex = vertice;
    }

    /**
     * define um ponto para ser um ponto de banco
     * @param vertice
     */
    public void definirBanco(int vertice){
        vertices[vertice][vertice] = 0; //BANCO;
        Integer i = vertice;
        bancosIndex.add(i);
    }

    /**
     *define um ponto para ser um ponto de coleta
     * @param vertice
     */
    public void definirColeta(int vertice){
        vertices[vertice][vertice] = 0; //COLETA;
        Integer i = vertice;
        coletaIndex.add(i);
    }
    
    /**
     * calcula e retorna a menor rota para do ponto de origem para o ponto de destino
     * @param origem
     * @param destino
     * @return a menor rota para entre os pontos parâmetros
     * @throws java.lang.Exception
     */
    public MyLinkedList<Integer> calcularRota(int origem, int destino )throws Exception{
        int pesos[] = new int[vertices.length]; // vetor que guardará os pesos para chegar nos vertices
        int predecessores[] = new int[vertices.length]; // vetor que guardara o predecessor de cada vertice
        MyLinkedList<Integer> naoVisitados = new MyLinkedList<>(); // lista de vertices ainda não visitados
        pesos[origem] = 0; // como é o vertice de origem, o peso para chegar nele é zero
        for(int i = 0; i<pesos.length;i++){
            if(i!= origem){ // todos os outros vertices são inicializados com uma estimativa de valor muito alta
                pesos[i] = Integer.MAX_VALUE/2;
            }
            predecessores[i] = INDEFINIDO; // todos os predecessores são inicializados como indefinidos
            naoVisitados.add(i); // todos os nó são adicionados na lista de não visitados
        }
        
        while(naoVisitados.isEmpty()== false){ // será executado até que todos os nós tenham sido visitados
            int proximoAberto = obterProximoAberto(pesos,naoVisitados);
            Integer proximo = proximoAberto;
            naoVisitados.remove(proximo);
            MyLinkedList<Integer> vizinhos = getVizinhos(proximoAberto);
            MyIterator<Integer> it = vizinhos.iterator();
            while(it.hasNext()){ //inicio de segundo while
               Integer vizinho = it.next();
               int distancia = pesos[proximoAberto] + getPeso(proximoAberto, vizinho);
               if(distancia< pesos[vizinho]){ // se a distancia para chegar nesse vizinho for menor, atualiza-se os dados
                   pesos[vizinho] = distancia;
                   predecessores[vizinho] = proximoAberto; // atualiza o predecesssor pelo qual é mais rapido chegar ao vizinho
               }
            } // fim do segundo while
            if(proximoAberto == destino){
                this.pesoUltimaRota += pesos[destino];
                return obterRota(predecessores,destino);
            }
        } // fim do primeiro while
        throw new Exception("Não foi possível encontrar um caminho para o ponto selecionado");
    }
    
    
    private int obterProximoAberto(int[] pesos,MyLinkedList<Integer> naoVisitados){
        int indexProximo = 0;
        int distanciaEstimada = Integer.MAX_VALUE/2;
        MyIterator<Integer> it = naoVisitados.iterator();
        while(it.hasNext()){
            int indexAux = it.next();
            if(pesos[indexAux]<distanciaEstimada){ // se o vertice possue uma distancia menor ele será o mais proximo
                indexProximo = indexAux;
                distanciaEstimada = pesos[indexAux];
            }
        }
        return indexProximo;
    }
    
    private MyLinkedList<Integer> obterRota(int[] predecessores, int destino){
        int i = destino;
        MyLinkedList<Integer> rotaInvertida = new MyLinkedList<>();
        MyLinkedList<Integer> rota = new MyLinkedList<>();
        while(predecessores[i]!= INDEFINIDO){
            rotaInvertida.add(i);
            i = predecessores[i];
        }
        while(rotaInvertida.isEmpty() == false){
            rota.add(rotaInvertida.removeLast());
        }
        return rota;
    }

    /**
     * adiciona uma quantidade a mais de pontos no mapa 
     * @param quantidade
     */
    public void addNovoPonto(int quantidade){
        int[][] novaMatriz = new int[vertices.length+quantidade][vertices.length+quantidade];
        inicializarMatriz(novaMatriz);
        System.arraycopy(vertices, 0, novaMatriz, 0, vertices.length);
        vertices = novaMatriz;
    }
    
    /**
     * remove um determinado ponto do mapa
     * @param ponto
     */
    public void removerPonto(int ponto){
        int[][] novaMatriz = new int[vertices.length-1] [vertices.length-1];
        if(ponto == vertices.length -1){// ponto no final da matriz
            for(int i=0;i<novaMatriz.length;i++)
                System.arraycopy(vertices[i], 0,novaMatriz[i], 0, novaMatriz.length);
            this.vertices = novaMatriz;
        }
        else if(ponto == 0){ //ponto no inicio da matriz
            for(int i=0;i<novaMatriz.length;i++)
                System.arraycopy(vertices[i+1], 0,novaMatriz[i], 0, novaMatriz.length);
            this.vertices = novaMatriz;
        }
        else{ //ponto no meio da matriz
            for(int i=0;i<ponto;i++)
                System.arraycopy(vertices[i], 0, novaMatriz[i], 0, ponto);
            
            for(int i=ponto+1;i<novaMatriz.length;i++)
                System.arraycopy(vertices[i],0 , novaMatriz[i-1],0, ponto);
            
            for(int i=0;i<novaMatriz.length;i++)
                for(int j=ponto+1;j<novaMatriz.length;j++)
                    novaMatriz[i][j-1] = vertices[i][j];
            vertices = novaMatriz;
        }
    }
    /**
     *construtor que recebe um file como parametro
     * @param file
     * @throws java.io.IOException
     */
    public Grafo(File file) throws IOException {
        this.vertices = carregarMatriz(file);
        bancosIndex = new ArrayList<>();
        coletaIndex = new ArrayList<>();
    }
    private int[][] carregarMatriz(File file) throws FileNotFoundException, IOException{
        int qtdLinhas;
        try (LineNumberReader linhas = new LineNumberReader(new FileReader(file))) {
            linhas.skip(file.length()); //pula para o ultimo caractere do arquivo
            qtdLinhas = linhas.getLineNumber(); // verifica qual a linha atual do arquivo para encontrar a quantidade de vertices
        } //pula para o ultimo caractere do arquivo
        int m[][] = new int[qtdLinhas][qtdLinhas]; //cria uma matriz com a quantidade de linhas encontrada
        FileReader fReader = new FileReader(file);
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
        return m;
    }
    
    
}
