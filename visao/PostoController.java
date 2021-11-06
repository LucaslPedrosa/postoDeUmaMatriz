package visao;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PostoController {

    @FXML
    private TextField numeroDeLinhasTextField;

    @FXML
    private TextField numeroDeColunasTextField;

    @FXML
    private Button calcularButton;
    
    @FXML
    private GridPane gridPane;


    @FXML
    void mostrarMatrizButton(ActionEvent event) {
        try {
            int numeroDeLinhas =  Integer.parseInt(numeroDeLinhasTextField.getText());
            int numeroDeColuna = Integer.parseInt(numeroDeColunasTextField.getText());
            GridPane.setColumnIndex(gridPane, numeroDeColuna);
            GridPane.setRowIndex(gridPane, numeroDeLinhas);
            for (int i = 0; i < numeroDeLinhas; ++i) {
                for (int j = 0; j < numeroDeColuna; ++j) {
                    gridPane.add(new TextField(), j, i);
                   
                }
            }
            calcularButton.setVisible(true);
            
            
        } catch (NumberFormatException n) {
            //TODO: handle exception
        }
    }

    @FXML
    void calcularPostoDeMatriz(ActionEvent event) {

    }
    

}
