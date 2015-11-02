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
    private Boolean onePressed = false;
    private Boolean twoPressed = false;
    private Boolean threePressed = false;
    private Boolean fourPressed = false;

    public Image imgCharacter;
    public Node nodCharacter;
    public Rectangle recCharacter;

    public Node sppp;

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

    int leftCount = 0;
    int rightCount = 0;
    int upCount = 0;
    int downCount = 0;

    //Player Abilities
    private List<Ability> abilities;
    int abilityCount = 0;
    public List<Node> abilityNodes;

    Node tempAbilityOne;

    int abilityRunning;

    //PlayerController
    @Override
    public void start(Stage primaryStage) {
        pController = new PlayerController(this);
        pController.direction = "UP";
        abilities = new ArrayList<Ability>();
        abilityNodes = new ArrayList<Node>();
        solidBlocks = new ArrayList<Node>();

        abilityRunning = 0;

        Image imgWall = Sprite.LoadSprite("Resources/WallSprite.jpg", 16, 16);
        Node nodWall = new ImageView(imgWall);
        Group groupWall = new Group(nodWall);

        Maze testmaze = new Maze(40, 2, 128);
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
                    case EDGE:
                        Image edg = Sprite.LoadSprite("Resources/MapEdge.jpg", 16, 16);
                        images.add(edg);
                        Node edgp = new ImageView(edg);
                        edgp.relocate(x * spritesize, y * spritesize);
                        nodes.add(edgp);
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
                switch (event.getCode()) {
                    case LEFT:
                        if (leftCount == 0 && rightCount == 0 && upCount == 0 && downCount == 0) {
                            leftPressed = true;
                            leftCount = 1;
                            pController.direction = "LEFT";
                        }
                        break;
                    case RIGHT:
                        if (leftCount == 0 && rightCount == 0 && upCount == 0 && downCount == 0) {
                            rightPressed = true;
                            rightCount = 1;
                            pController.direction = "RIGHT";
                        }
                        break;
                    case UP:
                        if (leftCount == 0 && rightCount == 0 && upCount == 0 && downCount == 0) {
                            upPressed = true;
                            upCount = 1;
                            pController.direction = "UP";
                        }
                        break;
                    case DOWN:
                        if (leftCount == 0 && rightCount == 0 && upCount == 0 && downCount == 0) {
                            downPressed = true;
                            downCount = 1;
                            pController.direction = "DOWN";
                        }
                        break;
                    case DIGIT1:
                        onePressed = true;
                        abilityCount++;
                        if (abilityCount == 1) {
                            Ability ability = new Ability(0);
                            abilities.add(ability);
                            tempAbilityOne = new ImageView(ability.img);
                            tempAbilityOne.setLayoutX(playerPos.getLayoutX());
                            tempAbilityOne.setLayoutY(playerPos.getLayoutY());
                            group.getChildren().add(tempAbilityOne);
                            nodCharacter.toFront();
                        }
                        break;
                    case DIGIT2:
                        twoPressed = true;
                        abilityCount++;
                        if (abilityCount == 1) {
                            abilities.add(new Ability(1));
                        }
                        break;
                    case DIGIT3:
                        threePressed = true;
                        abilityCount++;
                        if (abilityCount == 1) {
                            abilities.add(new Ability(2));
                        }
                        break;
                    case DIGIT4:
                        fourPressed = true;
                        abilityCount++;
                        if (abilityCount == 1) {
                            abilities.add(new Ability(3));
                        }
                        break;
                }
            }

        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
//                System.out.println(event.getCode());
                switch (event.getCode()) {
//                    case A:
//                        leftPressed = false;
//                        System.out.println("A released");
//                        break;
//                    case LEFT:
//                        if (leftCount == 0 && rightCount == 0 && upCount == 0 && downCount == 0) {
//                        leftPressed = false;
//                        }
//                        break;
//                    case D:
//                        rightPressed = false;
//                        System.out.println("D released");
//                        break;
//                    case RIGHT:
//                        if (leftCount == 0 && rightCount == 0 && upCount == 0 && downCount == 0) {
//                        rightPressed = false;
//                        }
//                        break;
//                    case W:
//                        upPressed = false;
//                        System.out.println("W released");
//                        break;
//                    case UP:
//                        if (leftCount == 0 && rightCount == 0 && upCount == 0 && downCount == 0) {
//                        upPressed = false;
//                        }
//                        break;
//                    case S:
//                        downPressed = false;
//                        System.out.println("S released");
//                        break;
//                    case DOWN:
//                        if (leftCount == 0 && rightCount == 0 && upCount == 0 && downCount == 0) {
//                        downPressed = false;
//                        }
//                        break;
                    case DIGIT1:
                        onePressed = false;
                        abilityCount = 0;
                        break;
                    case DIGIT2:
                        twoPressed = false;
                        abilityCount = 0;
                        break;
                    case DIGIT3:
                        threePressed = false;
                        abilityCount = 0;
                        break;
                    case DIGIT4:
                        fourPressed = false;
                        abilityCount = 0;
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
                switch (pController.direction) {
                    case "UP":
                        if (onePressed || abilityRunning == 1) {
                            
                            for (Node n : solidBlocks) { //Deze if statement is gemaakt door Kasper omdat de rest van mijn groepje incompatibel is, behalve Jeroen die doet tenminste iets nuttigs.
                                if (n.getLayoutX() == tempAbilityOne.getLayoutX() && n.getLayoutY() >= tempAbilityOne.getLayoutY() - spritesize && n.getLayoutY() <= tempAbilityOne.getLayoutY()-1) {
                                    collision = true;
                                }
                            }
                            if (collision == false) {
                            tempAbilityOne.relocate(tempAbilityOne.getLayoutX(), tempAbilityOne.getLayoutY() - 4);
                            abilityRunning = 1;
                            }
                            else {
                                abilityRunning = 0;
                            }
                        }
                        break;
                        //case "DOWN":

                    //if (onePressed)
                    default:
                    //donothing
                }
                if (leftPressed || leftCount > 0) {
                    collision = false;

                    for (Node n : solidBlocks) {
                        if (n.getLayoutX() == playerPos.getLayoutX() - spritesize && n.getLayoutY() == playerPos.getLayoutY()) {
                            collision = true;
                        }
                    }
                    System.out.println(leftCount);

                    if (leftCount < 17 && collision == false) {
                        playerPos.relocate(playerPos.getLayoutX() - 1, playerPos.getLayoutY());
                        leftCount++;
                    } else {
                        leftPressed = false;
                        leftCount = 0;
                    }

                } else if (rightPressed || rightCount > 0) {
                    collision = false;

                    for (Node n : solidBlocks) {
                        if (n.getLayoutX() == playerPos.getLayoutX() + spritesize && n.getLayoutY() == playerPos.getLayoutY()) {
                            collision = true;
                        }
                    }
                    System.out.println(rightCount);

                    if (rightCount < 17 && collision == false) {
                        playerPos.relocate(playerPos.getLayoutX() + 1, playerPos.getLayoutY());
                        rightCount++;
                    } else {
                        rightPressed = false;
                        rightCount = 0;
                    }

                } else if (downPressed || downCount > 0) {
                    collision = false;

                    for (Node n : solidBlocks) {
                        if (n.getLayoutX() == playerPos.getLayoutX() && n.getLayoutY() == playerPos.getLayoutY() + spritesize) {
                            collision = true;
                        }
                    }
                    System.out.println(downCount);

                    if (downCount < 17 && collision == false) {
                        playerPos.relocate(playerPos.getLayoutX(), playerPos.getLayoutY() + 1);
                        downCount++;
                    } else {
                        downPressed = false;
                        downCount = 0;
                    }

                } else if (upPressed || upCount > 0) {
                    collision = false;

                    for (Node n : solidBlocks) {
                        if (n.getLayoutX() == playerPos.getLayoutX() && n.getLayoutY() == playerPos.getLayoutY() - spritesize) {
                            collision = true;
                        }
                    }
                    System.out.println(upCount);

                    if (upCount < 17 && collision == false) {
                        playerPos.relocate(playerPos.getLayoutX(), playerPos.getLayoutY() - 1);
                        upCount++;
                    } else {
                        upPressed = false;
                        upCount = 0;
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
