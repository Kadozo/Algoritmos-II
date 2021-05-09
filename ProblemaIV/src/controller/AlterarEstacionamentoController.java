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

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import view.ForteSeguroMain;

/**
 *Controller da tela AlterarEstacionamento.fxml
 * @author Thiago Cardozo, Diego do Carmo
 */


public class AlterarEstacionamentoController {
    
    @FXML
    private ComboBox<Integer> comboEstacionamento;

    @FXML
    private ComboBox<Integer> comboAddBanco;

    @FXML
    private ComboBox<Integer> comboRemoveBanco;

    @FXML
    private ComboBox<Integer> comboAddColeta;

    @FXML
    private ComboBox<Integer> comboRemoveColeta;

    @FXML
    private Button buttomVoltarAlterarEstacionamento;
 
    @FXML
    private Button buttomUsarDados;
    @FXML
    private Label LabelEstacionamento;
    @FXML
    private Label labelAddBanco;

    @FXML
    private Label labelAddColeta;

    @FXML
    private Label labelConfirmacaoColetaBanco;
            
    @FXML
    void buttomUsarDados(ActionEvent event) {
        comboAddBanco.getItems().clear();
        comboAddColeta.getItems().clear();
        comboEstacionamento.getItems().clear();
        comboAddBanco.getItems().addAll(AlterarPontosController.vetor);
        comboAddColeta.getItems().addAll(AlterarPontosController.vetor);
        comboEstacionamento.getItems().addAll(AlterarPontosController.vetor);
        LabelEstacionamento.setText("O Estacionamento atual é o Ponto 0");
    }   
    @FXML
    void clicouVoltarEstacionamento(ActionEvent event) {
        ForteSeguroMain.stage.setScene(ForteSeguroMain.cenaPrincipal);
    }
    
    @FXML
    void clicouComboEstacionamento(ActionEvent event) {
        comboEstacionamento.show();
    }

    @FXML
    void comboAddBancoClicado(ActionEvent event) {
        comboAddBanco.show();
    }

    @FXML
    void comboAddColetaClicado(ActionEvent event) {
        comboAddColeta.show();
    }

    @FXML
    void comboRemoveBancoclicado(ActionEvent event) {
        comboRemoveBanco.show();
    }

    @FXML
    void comboRemoveColetaClicado(ActionEvent event) {
        comboRemoveColeta.show();
    }

    @FXML
    void teclouComboEstacionamento(KeyEvent event) {
        if(comboEstacionamento.getSelectionModel().getSelectedItem() != null){
            PrincipalController.mapa.definirEstacionamento(comboEstacionamento.getSelectionModel().getSelectedItem());
            LabelEstacionamento.setText("O Estacionamento atual é o Ponto "+ PrincipalController.mapa.getEstacionamentoIndex());
        }
    }
    @FXML
    void teclouRemoverBanco(KeyEvent event) {
        Integer removido = comboRemoveBanco.getSelectionModel().getSelectedItem();
        if(PrincipalController.mapa.getBancosIndex().remove(removido)){
            labelConfirmacaoColetaBanco.setTextFill(new Color(0, 0, 0, 1));
            labelConfirmacaoColetaBanco.setText("O ponto de Banco "+removido+" foi removido");
        }
        else{
            labelConfirmacaoColetaBanco.setText("Erro ao tentar remover o ponto de Banco "+ removido);
        }
        labelConfirmacaoColetaBanco.setVisible(true);
        labelAddBanco.setText("Existem "+PrincipalController.mapa.getBancosIndex().size()+" Pontos de banco no Mapa");
        comboRemoveBanco.getItems().clear();
        comboRemoveBanco.getItems().addAll(PrincipalController.mapa.getBancosIndex());
    }

    @FXML
    void teclouRemoverColeta(KeyEvent event) {
        Integer removido = comboRemoveColeta.getSelectionModel().getSelectedItem();
        if(PrincipalController.mapa.getColetaIndex().remove(removido)){
            labelConfirmacaoColetaBanco.setTextFill(new Color(0, 0, 0, 1));
            labelConfirmacaoColetaBanco.setText("O ponto de Coleta "+removido+" foi removido");
        }
        else{
            labelConfirmacaoColetaBanco.setText("Erro ao tentar remover o ponto de Coleta "+ removido);
        }
        labelConfirmacaoColetaBanco.setVisible(true);
        labelAddColeta.setText("Existem "+PrincipalController.mapa.getColetaIndex().size()+" Pontos de Coleta no Mapa");
        comboRemoveColeta.getItems().clear();
        comboRemoveColeta.getItems().addAll(PrincipalController.mapa.getColetaIndex());
    }

    @FXML
    void teclouAddBanco(KeyEvent event) {
        if( PrincipalController.mapa.getEstacionamentoIndex() == comboAddBanco.getSelectionModel().getSelectedItem().intValue()){
            labelConfirmacaoColetaBanco.setText("O Ponto escolhido já esta definido como Estacionamento");
            labelConfirmacaoColetaBanco.setTextFill(new Color(1, 0, 0,1));
            labelConfirmacaoColetaBanco.setVisible(true);
        }
        else if(PrincipalController.mapa.getColetaIndex().contains(comboAddBanco.getSelectionModel().getSelectedItem())){
            labelConfirmacaoColetaBanco.setText("O Ponto escolhido já esta definido como ponto de Coleta");
            labelConfirmacaoColetaBanco.setTextFill(new Color(1, 0, 0,1));
            labelConfirmacaoColetaBanco.setVisible(true);
        }
        else{
            if(comboAddBanco.getSelectionModel().getSelectedItem() != null){
                if(!PrincipalController.mapa.getBancosIndex().contains(comboAddBanco.getSelectionModel().getSelectedItem()))
                    PrincipalController.mapa.getBancosIndex().add(comboAddBanco.getSelectionModel().getSelectedItem());
                labelAddBanco.setText("Existem "+PrincipalController.mapa.getBancosIndex().size()+" Pontos de banco no Mapa");
                labelConfirmacaoColetaBanco.setText("Ponto de Banco Adicionado");
                labelConfirmacaoColetaBanco.setTextAlignment(TextAlignment.CENTER);
                labelConfirmacaoColetaBanco.setTextFill(new Color(0, 1, 0, 1));
                labelConfirmacaoColetaBanco.setVisible(true);
            }
            comboRemoveBanco.getItems().clear();
            comboRemoveBanco.getItems().addAll(PrincipalController.mapa.getBancosIndex());
        }
    }

    @FXML
    void teclouAddColeta(KeyEvent event) {
        if( PrincipalController.mapa.getEstacionamentoIndex() == comboAddColeta.getSelectionModel().getSelectedItem().intValue()){
            labelConfirmacaoColetaBanco.setText("O Ponto escolhido já esta definido como Estacionamento");
            labelConfirmacaoColetaBanco.setTextFill(new Color(1, 0, 0,1));
            labelConfirmacaoColetaBanco.setVisible(true);
        }
        else if(PrincipalController.mapa.getBancosIndex().contains(comboAddColeta.getSelectionModel().getSelectedItem())){
            labelConfirmacaoColetaBanco.setText("O Ponto escolhido já esta definido como ponto de Banco");
            labelConfirmacaoColetaBanco.setTextFill(new Color(1, 0, 0,1));
            labelConfirmacaoColetaBanco.setVisible(true);
        }
        else{
            if(comboAddColeta.getSelectionModel().getSelectedItem() != null){
                if(!PrincipalController.mapa.getColetaIndex().contains(comboAddColeta.getSelectionModel().getSelectedItem()))
                    PrincipalController.mapa.getColetaIndex().add(comboAddColeta.getSelectionModel().getSelectedItem());
                labelAddColeta.setText("Existem "+PrincipalController.mapa.getColetaIndex().size()+" Pontos de coleta no Mapa");
                labelConfirmacaoColetaBanco.setText("Ponto de Coleta Adicionado");
                labelConfirmacaoColetaBanco.setTextAlignment(TextAlignment.CENTER);
                labelConfirmacaoColetaBanco.setTextFill(new Color(0, 1, 0, 1));
                labelConfirmacaoColetaBanco.setVisible(true);
            }
            comboRemoveColeta.getItems().clear();
            comboRemoveColeta.getItems().addAll(PrincipalController.mapa.getColetaIndex());
        }
    }
}

