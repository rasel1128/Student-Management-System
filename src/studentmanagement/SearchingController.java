/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Walton
 */
public class SearchingController implements Initializable {

    @FXML
    private TextField roll;
    @FXML
    private Label show;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void search(ActionEvent event) {
         StringBuilder sb = new StringBuilder();
         String text1 = roll.getText();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(text1))) {

            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        show.setText(sb.toString());
      
    }

    @FXML
    private void back_menu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new
           FXMLLoader(getClass().getResource("Menu.fxml"));
          Parent root2;
           root2 = (Parent)fxmlLoader.load();
          Stage stage = new Stage();
          stage.setScene(new scene(root2));
           stage.setTitle("Student Management");
        stage.show();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
     private static class scene extends Scene {

        public scene(Parent root2) {
            super(root2);
        }
    }
    
}
