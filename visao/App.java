package visao;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application{

    private double xoffset;
    private double yoffset;

    private static Scene resultado;
    private static Stage stage;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage palco) throws Exception {
        stage = palco;
        Parent raiz = FXMLLoader.load(getClass().getResource("FXMLposto.fxml"));

        raiz.setOnMousePressed(event -> {
            xoffset = event.getSceneX();
            yoffset = event.getSceneY();
        });

        raiz.setOnMouseDragged(event -> {
            palco.setX(event.getScreenX()-xoffset);
            palco.setY(event.getScreenY()-yoffset);
        });

        palco.initStyle(StageStyle.TRANSPARENT);
        Scene tela = new Scene(raiz);
        tela.setFill(javafx.scene.paint.Color.TRANSPARENT);
        
        palco.setTitle("voce nao deveria estar vendo isso");
        palco.setScene(tela);

        tela.setFill(javafx.scene.paint.Color.TRANSPARENT);
        palco.show(); 

        Parent fxmlResultado = FXMLLoader.load(getClass().getResource("FXMLresultado.fxml"));
        resultado = new Scene (fxmlResultado);      
    }
    
    public static void changeScreenResultado (ActionEvent event) {
        stage.setScene(resultado);
    }


}