/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.maze.ing;

import GameLogic.*;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Hovsep
 */
public class AMazeIng extends Application {
    static int spritesize = 64;
    @Override
    public void start(Stage primaryStage) 
    {
        Image poep = Sprite.LoadSprite("Resources/WallSprite.jpg");
        Node poepnode = new ImageView(poep);
        Group poepgroep = new Group(poepnode);
        
        
        Maze testmaze = new Maze(48, 2, 76);
        testmaze.printMaze(); 
        
        Block[][] mazegrid = testmaze.GetGrid();
        
        
        ArrayList<Image> images = new ArrayList<Image>();
        ArrayList<Node> nodes = new ArrayList<Node>();
        Group group;
        
        
        
        
        for(int y=0; y<testmaze.getGridSize(); y++)
        {
            for(int x=0; x<testmaze.getGridSize(); x++)
            {
                switch(mazegrid[y][x])
                {
                    case SOLID:
                        Image img = Sprite.LoadSprite("Resources/WallSprite.jpg");
                        images.add(img);
                        nodes.add(new ImageView(img));
                    case OPEN:
                        break;
                    case OBSTACLE:
                        break;
                            
                }
            }
        }
        group = new Group(nodes);
        
        
        /*Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        root.getChildren().add(btn);
        */
        //StackPane root = new StackPane();
        Scene scene = new Scene(group, 300, 250, Color.DARKSALMON);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);

        
    }
    
}
