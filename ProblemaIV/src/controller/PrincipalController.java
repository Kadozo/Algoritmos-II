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
import javafx.scene.input.MouseEvent;
import model.Grafo;
import view.ForteSeguroMain;

/**
 * Controller da Tela Principal.fxml
 * @author Thiago Cardozo, Diego do Carmo
 */


public class PrincipalController {

    /**
     *
     */
    public static Grafo mapa = null;
    @FXML
    private Button AlterarPontos;

    @FXML
    private Button CalcularCaminho;

    @FXML
    private Button CarregarMapa;

    @FXML
    private Button AlterarEstacionamento;

    @FXML
    void clicouAlterarEstacionamento(ActionEvent event) {
        ForteSeguroMain.stage.setScene(ForteSeguroMain.cenaAlterarEstacionamento);
    }

    @FXML
    void clicouAlterarPontos(ActionEvent event) {
        ForteSeguroMain.stage.setScene(ForteSeguroMain.cenaAlterarPontos);
    }

    @FXML
    void clicouCalcularCaminho(ActionEvent event) {
        ForteSeguroMain.stage.setScene(ForteSeguroMain.cenaCalcularCaminho);
    }

    @FXML
    void clicouCarregarMapa(ActionEvent event) {
        ForteSeguroMain.stage.setScene(ForteSeguroMain.cenaCarregarMapa);
    }

    @FXML
    void mousedentro(MouseEvent event) {

    }

}
