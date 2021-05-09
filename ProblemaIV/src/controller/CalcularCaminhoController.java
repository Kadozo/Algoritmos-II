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
import javafx.scene.control.TextArea;
import util.MyLinkedList;
import view.ForteSeguroMain;
/**
 * Controller da tela CalcularCaminho.fxml
 * @author Thiago Cardozo, Diego do Carmo
 */


public class CalcularCaminhoController {

    @FXML
    private Label labelColeta;

    @FXML
    private ComboBox<Integer> comboColeta;

    @FXML
    private ComboBox<Integer> comboBanco;

    @FXML
    private Label labelBanco;

    @FXML
    private Button calcularButtom;

    @FXML
    private TextArea resultadoCalcular;

    @FXML
    private Button calcularCaminhoVoltar;

    @FXML
    private Button buttomCarregarDados;


    @FXML
    void clicouCaminhoVoltar(ActionEvent event) {
        ForteSeguroMain.stage.setScene(ForteSeguroMain.cenaPrincipal);
    }

    @FXML
    void clicouComboBanco(ActionEvent event) {
        
    }

    @FXML
    void clicouComboColeta(ActionEvent event) {
        
    }
    
    @FXML
    void clicouCarregarDados(ActionEvent event) {
        comboBanco.getItems().clear();
        comboColeta.getItems().clear();
        comboBanco.getItems().addAll(PrincipalController.mapa.getBancosIndex());
        comboColeta.getItems().addAll(PrincipalController.mapa.getColetaIndex());
        resultadoCalcular.setEditable(false);
    }
    @FXML
    void clicouCalcular(ActionEvent event){
        PrincipalController.mapa.setPesoUltimaRota(0);
        int origem = PrincipalController.mapa.getEstacionamentoIndex();
        int destino = comboColeta.getSelectionModel().getSelectedItem();
        try {
            MyLinkedList<Integer> parte1= PrincipalController.mapa.calcularRota(origem, destino);
            origem = destino;
            destino = comboBanco.getSelectionModel().getSelectedItem();
            MyLinkedList<Integer> parte2= PrincipalController.mapa.calcularRota(origem, destino);
            String resultado = "Para chegar no banco "+destino+""
                    + " passando pelo ponto de coleta "+origem+"\nvocê fará o seguinte caminho:\n";
            resultado += "saia do Estacionamento, em seguida passe pelos pontos:\n";
            for(int i = 0;i< parte1.size();i++){
                resultado += ""+parte1.get(i);
                resultado+="\t->\t";
            }
            for(int i = 0;i< parte2.size();i++){
                resultado += ""+parte2.get(i);
                if(i!= parte2.size()-1)
                    resultado+="\t->\t";
                else{
                    resultado +="\nvocê chegará ao destino em "+PrincipalController.mapa.getPesoUltimaRota()+" minutos";
                }
            }
            resultadoCalcular.setText(resultado);
        } catch (Exception ex) {
            resultadoCalcular.setText("O Caminho selecionado é inalcançável, por favor, escolha outros pontos");
        }
            
    }

}
