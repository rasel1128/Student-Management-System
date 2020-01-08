/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
 *
 * @author Walton
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TextField name;
    @FXML
    private TextField father_name;
    @FXML
    private TextField mother_name;
    @FXML
    private TextField date;
    @FXML
    private TextField religion;
    @FXML
    private TextField address;
    @FXML
    private TextField room;
    @FXML
    private TextField roll;
    @FXML
    private TextField dep;
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void save(ActionEvent event) {
       final String FNAME = roll.getText();
		ArrayList<String> list_copy = new ArrayList<>();
                String text1 = name.getText();
                String text2 = father_name.getText();
                 String text3 = mother_name.getText();
                String text4 = date.getText();
                String text5 = religion.getText();
                 String text6 = address.getText();
                String text7 =room.getText();
                String text8 =roll.getText();
                String text9 =dep.getText();
		list_copy.add (text1);
		list_copy.add (text2);
                list_copy.add (text3);
               
		list_copy.add (text4);
               
                list_copy.add (text5);
               
		list_copy.add (text6);
               
                list_copy.add (text7);
                
		list_copy.add (text8);
                list_copy.add (text9);
               
                
		try ( BufferedWriter bw = 
				new BufferedWriter (new FileWriter (FNAME)) ) 
		{			
			for (String line : list_copy) {
				bw.write (line + "\n");
			}
			
			bw.close ();
			
		} catch (IOException e) {
		} 
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
