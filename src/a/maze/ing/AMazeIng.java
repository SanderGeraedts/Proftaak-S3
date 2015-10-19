/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.maze.ing;

import GameLogic.*;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Kasper
 */
public class AMazeIng extends Application {

    static int spritesize = 16;

    private String pressedKey = "";

    private Boolean upPressed = false;
    private Boolean downPressed = false;
    private Boolean leftPressed = false;
    private Boolean rightPressed = false;

    private Image imgCharacter;
    private Node nodCharacter;
    private Rectangle recCharacter;

    private Node sppp;

    private String key;

    public Group group;

    public ArrayList<Node> nodes;

    public Scene scene;

    public PlayerController pController;

    //Moving checks
    public List<Node> solidBlocks;

    public Node playerPos;

    public Boolean collision;

    public Node tempNode;

    //PlayerController
    @Override
    public void start(Stage primaryStage) {
        solidBlocks = new ArrayList<Node>();

        Image imgWall = Sprite.LoadSprite("Resources/WallSprite.jpg", 16, 16);
        Node nodWall = new ImageView(imgWall);
        Group groupWall = new Group(nodWall);

        Maze testmaze = new Maze(24, 2, 100);
        testmaze.printMaze();

        Block[][] mazegrid = testmaze.GetGrid();

        ArrayList<Image> images = new ArrayList<Image>();
        nodes = new ArrayList<Node>();

        for (int y = 0; y < testmaze.getGridSize(); y++) {
            for (int x = 0; x < testmaze.getGridSize(); x++) {
                switch (mazegrid[y][x]) {
                    case SOLID:
                        Image sol = Sprite.LoadSprite("Resources/WallSprite.jpg", 16, 16);
                        images.add(sol);
                        Node wpos = new ImageView(sol);
                        wpos.relocate(x * spritesize, y * spritesize);
                        nodes.add(wpos);
                        solidBlocks.add(wpos);
                        break;
                    case OPEN:
                        Image ope = Sprite.LoadSprite("Resources/FloorSprite.jpg", 16, 16);
                        images.add(ope);
                        Node opos = new ImageView(ope);
                        opos.relocate(x * spritesize, y * spritesize);
                        nodes.add(opos);
                        break;
                    case SPAWNPOINT:
                        Image spp = Sprite.LoadSprite("Resources/SpawnPoint.jpg", 16, 16);
                        images.add(spp);
                        sppp = new ImageView(spp);
                        sppp.relocate(x * spritesize, y * spritesize);
                        nodes.add(sppp);
                        break;

                }
            }
        }
        
        double tempDoubleX = 0;
        double tempDoubleY = 0;
        if (nodes.contains(sppp)) {
            tempDoubleX = sppp.getLayoutX();
            tempDoubleY = sppp.getLayoutY();
        }
        imgCharacter = Sprite.LoadSprite("Resources/SpawnPoint.jpg", 16, 16);
        nodCharacter = new ImageView(imgCharacter);
        nodCharacter.relocate(tempDoubleX, tempDoubleY);
        nodes.add(nodCharacter);
        playerPos = nodCharacter;
        tempNode = playerPos;

        group = new Group(nodes);
        
        scene = new Scene(group, testmaze.getGridSize() * spritesize, testmaze.getGridSize() * spritesize, Color.DARKSALMON);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println(event.getCode());
                switch (event.getCode()) {
                    case A:
                        leftPressed = true;
                        System.out.println("A pressed");
                        break;
                    case D:
                        rightPressed = true;
                        System.out.println("D pressed");
                        break;
                    case W:
                        upPressed = true;
                        System.out.println("W pressed");
                        break;
                    case S:
                        downPressed = true;
                        System.out.println("S pressed");
                        break;
                }
            }

        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println(event.getCode());
                switch (event.getCode()) {
                    case A:
                        leftPressed = false;
                        System.out.println("A released");
                        break;
                    case D:
                        rightPressed = false;
                        System.out.println("D released");
                        break;
                    case W:
                        upPressed = false;
                        System.out.println("W released");
                        break;
                    case S:
                        downPressed = false;
                        System.out.println("S released");
                        break;
                }
            }
        });

        primaryStage.setTitle("a-MAZE-ing");
        primaryStage.setScene(scene);
        primaryStage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                int dx = 0, dy = 0;
                
                if (leftPressed) {
                    collision = false;                    
                    
                    for (Node n : solidBlocks) {
                       if (n.getLayoutX() == playerPos.getLayoutX() - spritesize && n.getLayoutY() == playerPos.getLayoutY()) {
                           collision = true;
                       }
                    }
                    
                    if (collision == false) 
                    {                    
                        playerPos.relocate(playerPos.getLayoutX() - spritesize, playerPos.getLayoutY());
                        leftPressed = false;
                        dx -= 1;
                        key = "A";
                    }
                    

                } else if (rightPressed) {
                    collision = false;                    
                    
                    for (Node n : solidBlocks) {
                       if (n.getLayoutX() == playerPos.getLayoutX() + spritesize && n.getLayoutY() == playerPos.getLayoutY()) {
                           collision = true;
                       }
                    }
                    
                    if (collision == false) 
                    {                    
                        playerPos.relocate(playerPos.getLayoutX() + spritesize, playerPos.getLayoutY());
                        rightPressed = false;
                        dx -= 1;
                        key = "D";
                    }

                } else if (downPressed) {
                    collision = false;                    
                    
                    for (Node n : solidBlocks) {
                       if (n.getLayoutX() == playerPos.getLayoutX() && n.getLayoutY() == playerPos.getLayoutY() + spritesize) {
                           collision = true;
                       }
                    }
                    
                    if (collision == false) 
                    {                    
                        playerPos.relocate(playerPos.getLayoutX(), playerPos.getLayoutY() + spritesize);
                        downPressed = false;
                        dx -= 1;
                        key = "S";
                    }

                } else if (upPressed) {
                    collision = false;                    
                    
                    for (Node n : solidBlocks) {
                       if (n.getLayoutX() == playerPos.getLayoutX() && n.getLayoutY() == playerPos.getLayoutY() - spritesize) {
                           collision = true;
                       }
                    }
                    
                    if (collision == false) 
                    {                    
                        playerPos.relocate(playerPos.getLayoutX(), playerPos.getLayoutY() - spritesize);
                        upPressed = false;
                        dx -= 1;
                        key = "W";
                    }
                }
            }
        };
        timer.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

    private void moveImage(int dx, int dy) {
        if (dx == 0 && dy == 0) {
            return;
        }

        final double cx = nodCharacter.getBoundsInLocal().getWidth() / 2;
        final double cy = nodCharacter.getBoundsInLocal().getHeight() / 2;

        double x = cx + nodCharacter.getLayoutX() + dx * 2.40f;
        double y = cy + nodCharacter.getLayoutY() + dy * 2.40f;

        moveImgTo(x, y);
    }

    private void moveImgTo(double x, double y) {
        final double cx = nodCharacter.getBoundsInLocal().getWidth() / 2;
        final double cy = nodCharacter.getBoundsInLocal().getHeight() / 2;
        System.out.println("x: " + x + " - y: " + y);
        if (x - cx >= 0
                && x + cx <= 600
                && y - cy >= 0
                && y + cy <= 800) {
            nodCharacter.relocate(x - cx, y - cy);
            recCharacter = new Rectangle((int) nodCharacter.getLayoutX(), (int) nodCharacter.getLayoutY(), 236, 236);
        }
    }

}
