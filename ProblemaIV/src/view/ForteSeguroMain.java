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
package view;


import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import  java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

/**
 * Classe main da aplicação, onde será rodada a interface
 * @author Thiago Cardozo, Diego do Carmo
 */
public class ForteSeguroMain extends Application {
    public static Scene cenaPrincipal,cenaAlterarPontos,cenaCalcularCaminho,cenaCarregarMapa,cenaAlterarEstacionamento;
    public static Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL url = getClass().getResource("AlterarEstacionamento.fxml");
        Parent root = (Parent) FXMLLoader.load(url);
        cenaAlterarEstacionamento = new Scene(root);
        url = getClass().getResource("CalcularCaminho.fxml");
        root = (Parent) FXMLLoader.load(url);
        cenaCalcularCaminho = new Scene(root);
        url = getClass().getResource("CarregarMapa.fxml");
        root = (Parent) FXMLLoader.load(url);
        cenaCarregarMapa = new Scene(root);
        url = getClass().getResource("AlterarPontos.fxml");
        root = (Parent) FXMLLoader.load(url);
        cenaAlterarPontos = new Scene(root);
        /////////////////////////////////////////////////////////
        URL arquivoFMLX = getClass().getResource("Principal.fxml");
        Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFMLX);
        cenaPrincipal = new Scene(fxmlParent);
        primaryStage.setScene(cenaPrincipal);
        stage = primaryStage;
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
    }
}
