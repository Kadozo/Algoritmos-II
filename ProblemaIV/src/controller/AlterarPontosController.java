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
package controller;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import model.Grafo;
import view.ForteSeguroMain;


/**
 *Controller da tela AlterarPontos.fxml
 * @author Thiago Cardozo, Diego do Carmo
 */

public class AlterarPontosController {
 
    boolean flagAdd;
    static ArrayList<Integer> vetor = new ArrayList<>();
    @FXML
    private TextField addInput;

    @FXML
    private Label labelAddPonto;

    @FXML
    private Label labelRemoverPonto;

    @FXML
    private Label labelconfirmaçãoAdd;

    @FXML
    private Label labelconfirmaçãoRemove;

    @FXML
    private ComboBox<Integer> ComboRemove;

    @FXML
    private Button botaoRemover;

    @FXML
    private ComboBox<Integer> ComboLigacao1;

    @FXML
    private ComboBox<Integer> ComboLigacao2;

    @FXML
    private ComboBox<Integer> ComboRemoveLigacao;

    @FXML
    private Button botaoRemoverLigacao;

    @FXML
    private Button botaoAddLigacao;

    @FXML
    private TextField pesoInput;

    @FXML
    private ComboBox<Integer> ComboRemoveLigacao2;
    
    @FXML
    private Button buttomVoltarAlterarPontos;
    @FXML
    private Label addLigacaoConfirmacao;

    @FXML
    private Label removerLigacaoConfirmacao;
    
    @FXML
    private Button carregarBotao;


    @FXML
    void clicouAddLigacao(ActionEvent event) {
        if(pesoInput.getText() != null && !"".equals(pesoInput.getText())){
                try{
                int origem = ComboLigacao1.getSelectionModel().getSelectedItem();
                int destino = ComboLigacao2.getSelectionModel().getSelectedItem();
                int peso = Integer.parseInt(pesoInput.getText());
                PrincipalController.mapa.addLigacao(origem, destino,peso );
                System.out.println(PrincipalController.mapa.getPeso(origem, destino));
                addLigacaoConfirmacao.setText("Ligação feita entre: "+origem+" e "+destino);
                addLigacaoConfirmacao.setTextFill(new Color(0, 1, 0, 1));
                addLigacaoConfirmacao.setVisible(true);
                }
                catch(NumberFormatException e){
                    addLigacaoConfirmacao.setText("Defina apenas números inteiros");
                    addLigacaoConfirmacao.setTextAlignment(TextAlignment.CENTER);
                    addLigacaoConfirmacao.setTextFill(new Color(1, 0, 0, 1));
                    addLigacaoConfirmacao.setVisible(true);
                }
            }
    }

    @FXML
    void clicouRemover(ActionEvent event) {
        try {
            int remover = ComboRemove.getSelectionModel().getSelectedItem();
            PrincipalController.mapa.removerPonto(remover);
            atualizarcombos();
            
        } catch (Exception e) {
            System.out.println("aaaaa");
        }
    }

    @FXML
    void clicouRemoverLigacao(ActionEvent event) {
        if(ComboRemoveLigacao.getSelectionModel().getSelectedItem()== null ||
            ComboRemoveLigacao2.getSelectionModel().getSelectedItem() == null){
            removerLigacaoConfirmacao.setText("Selecione os dois Pontos");
            removerLigacaoConfirmacao.setTextFill(new Color(1, 0, 0, 1));
            removerLigacaoConfirmacao.setVisible(true);
        }
        else{
            int origem = ComboRemoveLigacao.getSelectionModel().getSelectedItem();
            int destino = ComboRemoveLigacao2.getSelectionModel().getSelectedItem();
            if(PrincipalController.mapa.getPeso(origem, destino)!= 0){
                PrincipalController.mapa.removeLigacao(origem, destino);
                System.out.println(PrincipalController.mapa.getPeso(origem, destino));
                removerLigacaoConfirmacao.setText("Ligação desfeita entre: "+origem+" e "+destino);
                removerLigacaoConfirmacao.setTextFill(new Color(0, 1, 0, 1));
                removerLigacaoConfirmacao.setVisible(true);
            }
            else{
                removerLigacaoConfirmacao.setText("Ligação entre: "+origem+" e "+destino+" Não existe");
                removerLigacaoConfirmacao.setTextFill(new Color(1, 0, 0, 1));
                removerLigacaoConfirmacao.setVisible(true);
            }
        }
    }

    @FXML
    void comboClicado(ActionEvent event) {
        ComboRemove.show();
    }

    @FXML
    void comboLigacao1Clicado(ActionEvent event) {
        ComboLigacao1.show();
    }

    @FXML
    void comboLigacao2Clicado(ActionEvent event) {
        ComboLigacao2.show();
    }

    @FXML
    void comboRemoveLigacao2Clicado(ActionEvent event) {
        ComboRemoveLigacao2.show();
    }

    @FXML
    void comboRemoveLigacaoClicado(ActionEvent event) {
        ComboRemoveLigacao.show();
    }

    @FXML
    void comecouDigitarAdd(KeyEvent event) {
        if(labelconfirmaçãoAdd.isVisible() && flagAdd){
            labelconfirmaçãoAdd.setVisible(false);
            flagAdd = false;
        }
    }

    @FXML
    void digitouAdd(ActionEvent event) {
        int limite = Integer.parseInt(addInput.getText());
        labelconfirmaçãoAdd.setVisible(true);
        flagAdd = true;
        if(PrincipalController.mapa == null){
            PrincipalController.mapa = new Grafo(limite);
            for(int j = 0; j <limite; j++){
                Integer e = j;
                vetor.add(e);
            }
            ComboLigacao1.getItems().addAll(vetor);
            ComboLigacao2.getItems().addAll(vetor);
            ComboRemove.getItems().addAll(vetor);
            ComboRemoveLigacao.getItems().addAll(vetor);
            ComboRemoveLigacao2.getItems().addAll(vetor);
        }
        else{
           PrincipalController.mapa.addNovoPonto(limite);
           for(int j = vetor.size(); j<PrincipalController.mapa.getVertices().length; j++){
               Integer e = j;
               vetor.add(e);
           }
           atualizarcombos();
        }
    }
        
    @FXML
    void digitouInputPeso(ActionEvent event) {
    }
    
    @FXML
    void clicouVoltarAlterarPontos(ActionEvent event) {
        ForteSeguroMain.stage.setScene(ForteSeguroMain.cenaPrincipal);
    }
    @FXML
    void cllicouCarregarMapa(ActionEvent event) {
        atualizarcombos();
        
    }

    /**
     * atualiza as comboboxes para os atuais dados do mapa
     */
    public void atualizarcombos(){
        ComboRemove.getItems().clear();
        ComboRemoveLigacao.getItems().clear();
        ComboRemoveLigacao2.getItems().clear();
        ComboLigacao1.getItems().clear();
        ComboLigacao2.getItems().clear();
        ComboRemove.getItems().addAll(vetor);
        ComboRemoveLigacao.getItems().addAll(vetor);
        ComboRemoveLigacao2.getItems().addAll(vetor);
        ComboLigacao1.getItems().addAll(vetor);
        ComboLigacao2.getItems().addAll(vetor);
    }
}
