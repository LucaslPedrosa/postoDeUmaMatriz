package visao;

import controle.Algoritimo;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PostoController {

    static int numeroDeLinhas =  0;
    static int numeroDeColuna = 0;

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
            numeroDeLinhas =  Integer.parseInt(numeroDeLinhasTextField.getText());
            numeroDeColuna = Integer.parseInt(numeroDeColunasTextField.getText());
            
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

        Node resultado = null;

        ObservableList<Node> childrens = gridPane.getChildren();
        int matrix[][] = new int[numeroDeLinhas][numeroDeColuna];
        int lin = 0;
        int col = 0;

        for(Node node : childrens){
            if(node instanceof TextField){


                matrix[lin][col] = Integer.parseInt(((TextField)node).getText());
                System.out.println(Integer.parseInt(((TextField)node).getText()));

                lin++;
                if(lin == numeroDeLinhas){
                    col++;
                    lin = 0;
                }
                
            }
        }

        try{
            Algoritimo.C = numeroDeColuna;
            Algoritimo.R = numeroDeLinhas;
            System.out.print("Rank of the matrix is : " + Algoritimo.rankOfMatrix(matrix));
        }catch(Exception e){
            System.out.println(e.getStackTrace());
        }
    }
    

}
