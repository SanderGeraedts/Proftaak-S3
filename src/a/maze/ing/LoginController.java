/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.maze.ing;

import Database.DatabaseConnection;
import GameLogic.User;
import java.awt.Dialog;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Hovsep
 */
public class LoginController implements Initializable {

    DatabaseConnection db = new DatabaseConnection();
    StartGame st = new StartGame();
    private ObservableList<User> user;
    private ArrayList fakechat = new ArrayList();
    private ObservableList ObservableChat;
    String chatinfo = "Welkom bij Amazing chat";

    //Login
    @FXML
    private TextField tfBeginUsername;
    @FXML
    private TextField tfBeginPassword;
    @FXML
    private Button btBeginCreate;
    @FXML
    private Button btBeginLogIn;

    //Lobby    
    @FXML
    private TextArea tfLobbyChat;
    @FXML
    private ListView lvLobbyUsers = new ListView();
    @FXML
    private Button btLobbySend;
    @FXML
    private Button btLobbyCreateGame;
    @FXML
    private Button btLobbyJoinGame;
    @FXML
    private ListView lvLobbyGames = new ListView();
    @FXML
    private ListView lvLobbyChat = new ListView();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fakechat.add(chatinfo);
        initViews();
    }

    private void initViews() {
        ObservableChat = FXCollections.observableArrayList(this.fakechat);
        this.lvLobbyChat.setItems(this.ObservableChat);
    }

    /*
     /Check of de naam in de database gelijk is aan de textveld tfBeginUsername
     */
    @FXML
    public void Login(Event evt) throws SQLException, IOException {
        Stage stage;
        Parent root;

        if (tfBeginUsername.getText().equals(db.getUsername()) && tfBeginPassword.getText().equals(db.getPassword())) {

            stage = (Stage) btBeginCreate.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("Lobby.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            System.out.println("Naam:" + db.getUsername() + "\nPassword: " + db.getPassword());
        } else {
            System.out.println("Login mislukt");
        }
    }

    public void CreateGame(){
        
        
        
    }
    
    //Stuur bericht
    @FXML
    public void sendMessage(Event evt) {
        String info = tfLobbyChat.getText();
        fakechat.add(info);
        initViews();
        tfLobbyChat.clear();
    }

}
