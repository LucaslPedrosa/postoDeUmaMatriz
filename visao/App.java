package visao;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;  
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application{

    private double xoffset;
    private double yoffset;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage palco) throws Exception {
        Parent raiz = FXMLLoader.load(getClass().getResource("FXMLposto.fxml"));

        raiz.setOnMousePressed(event -> {
            xoffset = event.getSceneX();
            yoffset = event.getSceneY();
        });

        raiz.setOnMouseDragged(event -> {
            palco.setX(event.getScreenX()-xoffset);
            palco.setY(event.getScreenY()-yoffset);
        });

        //palco.initStyle(StageStyle.TRANSPARENT);
        Scene tela = new Scene(raiz);
        //tela.setFill(javafx.scene.paint.Color.TRANSPARENT);
        
        palco.setTitle("voce nao deveria estar vendo isso");
        palco.setScene(tela);

        //tela.setFill(javaFx.scene.paint.Color.TRANSPARENT);
        palco.show(); 
              
    }


}