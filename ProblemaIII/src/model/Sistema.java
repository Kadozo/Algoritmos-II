/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import exceptions.*;
import util.*;
import java.io.*;

/**
 *Classe sistema do programa
 * @author Thiago Cardozo
 */
public class Sistema {
    private final Arvore <Registro> registro;
    private final Fila <Computador> computadores;
    private float maiorMemoria;

    /**
     *
     */
    public Sistema() {
        this.registro = new Arvore<>();
        computadores = new Fila<>();
    }

    /**
     * 
     * @return a arvore de Registro associada ao sistema
     */
    public Itree<Registro> getRegistro() {
        return registro;
    }

    /**
     *
     * @return a arvore de computadores associada ao sistema
     */
    public MyLinkedList<Computador> getComputadores() {
        return computadores;
    }
    
    /**
     * método que simula a "inicialização" do sistema ao chamar esse método
     * ocorre a importação dos arquivos de imagens e de computadores e a alocação
     * de todas as imagens para os computadores com maior memoria
     * @throws ImagemDuplicadaException  caso tentem adicionar uma imagem que já
     * está armazenada em algum dos computadores
     */
    public void alocarImagens() throws ImagemDuplicadaException{
       
        int contador = 0;
        boolean a;
        String linha;
        FileReader creader;
        try  {
             // abrindo arquivo para leitura o arquivo de computadores
            creader = new FileReader("files\\computadores.ascii");
            
            BufferedReader bufferComputadores = new BufferedReader(creader);
            a = true;
            while (a) {
                linha = bufferComputadores.readLine(); // atribuir cada linha do arquivo para a String "linha"
                if(linha == null){ // o arquivo chegou no fim, não a motivos para continuar
                    a = false;
                }
                else{
                    //separando as informações dos computadores, para criar os objetos.
                    String[] info = linha.split(" ");
                    float memoria = Float.parseFloat(info[1]);
                    if(memoria>maiorMemoria){
                        maiorMemoria = memoria;
                    }
                    Computador computador = new Computador(info[0],memoria );
                    addComputador(computador);
                }
            } // fim do while
            creader.close(); // fechando arquivo de computadores
        }//fim do try
        catch(IOException exception ){
            System.out.println("Não foi possivel abrir o arquivo de computadores");
        }
        
        
        try{
            try (FileReader ireader = new FileReader("files\\imagens.ascii")) {
                BufferedReader bufferImagens = new BufferedReader(ireader);
                a = true;
                while(a){
                    linha = bufferImagens.readLine();
                    if(linha == null){ // o arquivo chegou no fim
                        a = false;
                    }
                    else{//separando as informações das imagens
                        String[] info = linha.split(" ");
                        float size = Float.parseFloat(info[1]);
                        Imagem imagem = new Imagem(info[0], size);
                        contador++; // contagem do número da imagem
                        AddImagem(imagem); // adicionando as imagens criadas aos computadores
                        
                    }
                } // fim do while
            }
        }// fim do try// fim do try
        catch(IOException exception){
            System.out.println("Não foi possivel abrir o arquivo de Imagens");
        }
        catch(MemoriaIndisponivelException exception){
            System.out.println("Erro ao adicionar a imagem"+contador+"\no pc com maior memoria possuia"+maiorMemoria);
        }
    }
    
    /**
     * método que add um novo computador a lista de computadores do sistema
     * @param computador
     */
    public void addComputador(Computador computador){
        computadores.add(computador);
    }

    /**
     * lista todos os computadores e suas respectivas memorias disponiveis
     * @return
     */
    public String listarComputadores(){

        MyIterator<Computador> it = new MyIterator<>(computadores.getHead());
        String retorno = new String();
        while(it.hasNext()){
            retorno += it.next().getId();
            retorno += " Memoria:";
            retorno += it.next().getMemory();
            retorno += ", ";
        }
        return retorno;
    }
    
    /**
     *lista todas as imagens armazenadas em todos os computadores
     * @return
     */
    public String listarImagens(){
        return registro.inOrder(registro.getRoot());
    }
    
    /**
     * método que adiciona uma imagem ao computador que possue a maior mémoria 
     * @param imagem
     * @throws MemoriaIndisponivelException
     * @throws ImagemDuplicadaException
     */
    public void AddImagem(Imagem imagem) throws MemoriaIndisponivelException,ImagemDuplicadaException{
        if(registro.search(imagem.getName())){ 
            throw new ImagemDuplicadaException("A imagem"+imagem.getName()+"Já está armazenada no sistema");
        }

        Computador computador = computadores.proximo(maiorMemoria, computadores);
        Registro Novoregistro = new Registro(computador, imagem);
        registro.put(Novoregistro.getImagem().getName(), Novoregistro);
        computador.add(imagem);
        maiorMemoria = computador.getMemory();
    }
    
    /**
     * método que faz o cadastro de um novo computador no arquivo de computadores
     * @param computador
     * @throws IOException
     */
    public void gravarComputador(Computador computador) throws IOException{
        String novaLinha =computador.getId() +" "+computador.getMemory();
        FileWriter Cwriter = new FileWriter("files\\computadores.ascii", true);
        try (BufferedWriter Cbuffer = new BufferedWriter(Cwriter)) {
            Cbuffer.newLine();
            Cbuffer.append(novaLinha);
        }
    }
    
    /**
     * método que remove uma imagem do sistema
     * @param Key
     */
    public void removerImagem(String Key){
       Computador computador = registro.get(Key).getComputador();
       computador.getImagens().remove(Key);
       registro.remove(Key);
    }

    /**
     *método que procura uma imagem do sistema
     * @param key
     * @return boolean true caso a imagem tenha sido encontrada, caso não, false
     */
    public boolean searchImagem(String key){
        Registro correspondencia = this.registro.get(key);
        if(correspondencia == null){ // a imagem passada não ta armazenada e nenhum computador
            return false;
        }
        else{
            return false;
        }
    }

    /**
     * lista todos os espaços disponiveis de computadores 
     * @return string com todos os Espaços disponiveis
     */
    public String listarEspaço(){
        MyIterator<Computador> it = new MyIterator<>(this.computadores.getHead());
        String string = "";
        while(it.hasNext()){
            string += "" + it.next().getMemory();
            string += ", ";
        }
        return string;
    }

    /**
     * lista o conteudo de um determinado computador
     * @param computador
     * @return uma string com todas as imagens do computador
     */
    public String listarConteudo(Computador computador){
        String string = computador.listarImagens();
        return string;
    }
}
