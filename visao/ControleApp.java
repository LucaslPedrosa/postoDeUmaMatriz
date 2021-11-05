package visao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class ControleApp {

    @FXML
    private TextField numeroDeLinhasTextField;

    @FXML
    private TextField numeroDeColunasTextField;

    @FXML
    private AnchorPane anchorPaneGridPane;

    @FXML
    private GridPane gridPane;

    @FXML
    void mostrarMatrizButton(ActionEvent event) {
        try {
            int numeroDeLinhas =  Integer.parseInt(numeroDeLinhasTextField.getText());
            int numeroDeColuna = Integer.parseInt(numeroDeColunasTextField.getText());
            GridPane.setColumnIndex(gridPane, numeroDeColuna);
            GridPane.setRowIndex(gridPane, numeroDeLinhas);

        anchorPaneGridPane.setVisible(true);
            
        } catch (NumberFormatException n) {
            //TODO: handle exception
        }
    }
    

}

