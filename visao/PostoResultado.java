package visao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PostoResultado {

    @FXML
    private String resultadoTextField = setText();

    private String setText() {
        return String.valueOf(PostoController.getResultado());
    }
    

    

}
