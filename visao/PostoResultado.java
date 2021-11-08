package visao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class PostoResultado {

    @FXML
    private TextField resultadoTextField;

    @FXML
    void mostrarResultado(ActionEvent event) {
        resultadoTextField.setText(String.valueOf(PostoController.getResultado()));
    }

   
    

    

}
