/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gos.login;

import gos.connect.DatabaseUtilities;
import java.net.URL;
import javafx.fxml.FXML;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {
    
    @FXML 
    private TextField fldUsername;
    
    @FXML
    private PasswordField fldPassword;
    
    @FXML
    private void btnLoginAction(ActionEvent loginEvent) {
        String message = "Login Successful!!!";
        if (fldUsername.getText().length() < 3 || fldPassword.getText().length() < 6 || fldPassword.getText().length() > 20) {
            message = "Username or Password invalid!!!";
        } 
            
        else if (!DatabaseUtilities.loginInforCheck(fldUsername.getText(), fldPassword.getText())) message = "Account not exist!!!"; 
        System.out.println(message);
    }
    
    @FXML
    private void btnSignupAction(ActionEvent signupEvent) {
        
    }
    
    @FXML
    private void btnExitAction(ActionEvent exitEvent) {
        System.exit(0);
    }
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
