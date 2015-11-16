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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Hovsep
 */
public class LoginController implements Initializable {

    DatabaseConnection db = new DatabaseConnection();
    StartGame st = new StartGame();
    private ObservableList<User> ObservableUsers;
    private ArrayList fakechat = new ArrayList();
    private ArrayList fakegames = new ArrayList();
    private ArrayList playerList = new ArrayList();
    private ObservableList ObservableChat;
    private ObservableList ObservableGames;
    String chatinfo = "Welkom bij Amazing chat";
    Stage stage;
    Parent root;

    //Login
    @FXML
    private TextField tfBeginUsername;
    @FXML
    private TextField tfBeginPassword;
    @FXML
    private Button btBeginLogIn;

    //Lobby    
    @FXML
    private TextArea tfLobbyChat;
    @FXML
    private ListView lvLobbyUsers = new ListView();
    @FXML
    private Button btLobbyCreateGame;
    @FXML
    private ListView lvLobbyGames = new ListView();
    @FXML
    private ListView lvLobbyChat = new ListView();

    //Create game
    @FXML
    private TextField tfCreateGameName;

    //Create User
    @FXML
    private AnchorPane apCreateUser;
    @FXML
    private TextField tfNewUserUsername;
    @FXML
    private TextField tfNewUserPassword;
    @FXML
    private Button btCreateAccount;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fakechat.add(chatinfo);
        fakegames.add("Games");
        try {
            fillPlayerList();
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        initViews();

    }

    private void initViews() {
        ObservableChat = FXCollections.observableArrayList(this.fakechat);
        ObservableGames = FXCollections.observableArrayList(this.fakegames);
        ObservableUsers = FXCollections.observableArrayList(this.playerList);
        this.lvLobbyUsers.setItems(this.ObservableUsers);
        this.lvLobbyChat.setItems(this.ObservableChat);
        this.lvLobbyGames.setItems(this.ObservableGames);

    }

    private void fillPlayerList() throws SQLException {
        for (User user : db.getUsers()) {
            playerList.add(user.getName());
        }
    }

    /*
     /Check of de naam in de database gelijk is aan de textveld tfBeginUsername
     */
    @FXML
    public void Login(Event evt) throws IOException, SQLException {

        for (User user : db.getUsers()) {
            if (tfBeginUsername.getText().equals(user.getName()) && tfBeginPassword.getText().equals(user.getEmail())) {

                stage = (Stage) btBeginLogIn.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("Lobby.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

                System.out.println("Naam:" + db.getUsername() + "\nPassword: " + db.getPassword());
            }
        }
    }

    @FXML
    public void CreateLobby(Event evt) throws IOException {
        stage = (Stage) btLobbyCreateGame.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("CreateGame.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //Create a new game
    @FXML
    public void CreateGame(Event evt) throws IOException {
        if ((tfCreateGameName.getText().equals(""))) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Please fill in game name");
            alert.showAndWait();
        } else {
            System.out.println("Why does this not work");
            fakegames.add(tfCreateGameName.getText());
            fakegames.add("WTF");
            initViews();
            //stage.close();
            AMazeIng a = new AMazeIng();
            //stage = (Stage) btBeginLogIn.getScene().getWindow();
            Stage stageAMazeIng = new Stage();
            a.start(stageAMazeIng);
            stageAMazeIng.show();

//            stage.show();
            //placeholder code//going back to the lobby // todo !!!!!!!!!!!!!!!!!!!!
            /*stage = (Stage) btCreateCreateGame.getScene().getWindow();
             root = FXMLLoader.load(getClass().getResource("Lobby.fxml"));
             Scene scene = new Scene(root);
             stage.setScene(scene);
             stage.show();*/            //placeholder end
        }
    }

    @FXML
    public void switchToCreateUser(Event evt) throws IOException {
        stage = (Stage) btBeginLogIn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("CreateUser.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void newUser(Event evt) throws SQLException {
        db.newUser(tfNewUserUsername.getText(), tfNewUserPassword.getText());
    }

    //Send a message to the chat. Adding it to the fakechat.
    public void sendMessage(Event evt) {
        fakechat.add(tfLobbyChat.getText());
        initViews();
        tfLobbyChat.clear();
    }

}
