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

import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.Grafo;
import view.ForteSeguroMain;

/**
 * Controler da tela CarregarMapa.fxml
 * @author Thiago Cardozo, Diego do Carmo
 */

public class CarregarMapaController {
 
    @FXML
    private Label NomeDoArquivoLabel;

    @FXML
    private Button CarregarMapaButtom;

    @FXML
    private TextField DigitarArquivo;

    @FXML
    private Button VoltarCarregarButtom;

    @FXML
    private Label CarregarMapaLabel;
    
    @FXML
    private Label labelConfirmacao;
    
    @FXML
    void clicouCarregarBotao(ActionEvent event) {
        String Nomearquivo = DigitarArquivo.getText()+ ".txt";
        File arquivo = new File(Nomearquivo);
        try {
            PrincipalController.mapa = new Grafo(arquivo);
            AlterarPontosController.vetor.clear();
            for(int i = 0; i<PrincipalController.mapa.getVertices().length; i++){
            Integer e = i;
            AlterarPontosController.vetor.add(e);
            String string = "("+AlterarPontosController.vetor.size()+") Pontos Carregados de "+DigitarArquivo.getText();
            labelConfirmacao.setText(string);
            labelConfirmacao.setDisable(false);
        }
        } catch (IOException ex) {
            labelConfirmacao.setText("Erro ao tentar carregar, verifique se: "
                    + "\no arquivo foi escrito corretamente ou é um .txt");
            labelConfirmacao.setTextFill(new Color(0, 0, 0, 1));
            labelConfirmacao.setDisable(true);
            labelConfirmacao.setFont(new Font(15));
        }
    }

    @FXML
    void clicouVoltarBotaoMapa(ActionEvent event) {
        ForteSeguroMain.stage.setScene(ForteSeguroMain.cenaPrincipal);
    }

    @FXML
    void digitouCarregar(ActionEvent event) {

    }

}

