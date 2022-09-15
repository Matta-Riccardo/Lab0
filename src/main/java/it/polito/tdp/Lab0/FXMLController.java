package it.polito.tdp.Lab0;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private int cont = 3;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnLogIn;

    @FXML
    private Button btnReset;

    @FXML
    private TextField txtPassword;

    @FXML
    private Label txtResult;

    @FXML
    private Label txtTentativi;

    @FXML
    private TextField txtUser;

    @FXML
    void doLogIn(ActionEvent event) {
    	
    	String user = txtUser.getText();
    	String password = txtPassword.getText();
    	String regex = "[!?#@]";
    	
    		
    	if(user.length()!=0) {
    		
    		if(password.length()!=0){
        			
        		if(password.length() >= 7) {
        				
        			Pattern pattern = Pattern.compile(regex);
        		    Matcher matcher = pattern.matcher(password);
        		    boolean matchFound = matcher.find();
        				
        			if(matchFound) {
        				txtResult.setText("Log-In avvenuto con successo!");	
        				txtUser.setDisable(true);
        				txtPassword.setDisable(true);
        				btnLogIn.setDisable(true);
        				txtTentativi.setText("");	
        				return;
        			}else {
        				cont--;
        				txtResult.setText("inserire nella password un carattere tra: !?@#");
        				txtTentativi.setText(cont + " tentativi rimasti");
        			}	
        		}else {
        			cont--;
        			txtResult.setText("inserire almenon 7 caratteri");
        			txtTentativi.setText(cont + " tentativi rimasti");	
        		}		
        	}else {
        		txtResult.setText("Inserisci una password!");
        	}
    	}else {
    		txtTentativi.setText(cont + " tentativi rimasti");
    		txtResult.setText("Inserisci il tuo user!");
    		
    	}
    		
    	
    	if(cont == 0) {
    		txtUser.setDisable(true);
    		txtPassword.setDisable(true);
    		btnLogIn.setDisable(true);
    		txtResult.setText("Log-In fallito!");
    		txtTentativi.setText("");
    	}			
    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	
    	txtUser.setText("");
    	txtPassword.setText("");
    	txtResult.setText("");
    	
    	txtUser.setDisable(false);
    	txtPassword.setDisable(false);
    	btnLogIn.setDisable(false);
    	
    	cont = 3;
    	
    	txtTentativi.setText(cont + " tentativi rimasti");
    	
    	
    }

    @FXML
    void initialize() {
        assert btnLogIn != null : "fx:id=\"btnLogIn\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtPassword != null : "fx:id=\"txtPassword\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTentativi != null : "fx:id=\"txtTentativi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtUser != null : "fx:id=\"txtUser\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}


