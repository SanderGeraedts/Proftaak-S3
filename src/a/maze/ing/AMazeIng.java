/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a.maze.ing;

import GameLogic.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import javafx.scene.input.KeyCode;
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
    static long defCooldown = 30 * 1000;

    public Image imgCharacter;
    public Node nodCharacter;
    public Rectangle recCharacter;

    public Image imgEnemy;
    public Node nodEnemy;
    public Rectangle recEnemy;

    public Node sppp;

    private String key;

    public Group group;

    public ArrayList<Node> nodes;

    public Scene scene;

    public PlayerController pController;
    //public EnemyController eController;

    //Moving checks
    public List<Node> solidBlocks;

    public Node playerPos;

    public Boolean collision;

    public Node tempNode;

    //enemie moving checks
    public Node enemyPos;
    public Boolean enemyCollision;
    public Node tempNodeEnemy;

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

    public List<Node> spawnPoints;

    long abilityCooldown;
    ArrayList<Long> abilityCooldowns;

    //PlayerController
    @Override
    public void start(Stage primaryStage) {
        abilities = new ArrayList<Ability>();
        abilityNodes = new ArrayList<Node>();
        solidBlocks = new ArrayList<Node>();
        spawnPoints = new ArrayList<Node>();

        abilityRunning = 0;

        Image imgWall = Sprite.LoadSprite("Resources/WallSprite.jpg", 16, 16);
        Node nodWall = new ImageView(imgWall);
        Group groupWall = new Group(nodWall);

        Maze testmaze = new Maze(40, 2, 128);
        testmaze.printMaze();

        Block[][] mazegrid = testmaze.GetGrid();

        //Create list of all the block images
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
                        Node sppp = new ImageView(spp);
                        sppp.relocate(x * spritesize, y * spritesize);
                        nodes.add(sppp);
                        spawnPoints.add(sppp);
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

        group = new Group(nodes);
        scene = new Scene(group, testmaze.getGridSize() * spritesize, testmaze.getGridSize() * spritesize, Color.DARKSALMON);
        primaryStage.setTitle("Pathfinding");
        primaryStage.setScene(scene);
        primaryStage.show();

        //For each spawnpoint, add a player.
        Player p = new Player(1, 1);
        for (Node n : spawnPoints) {
            group.getChildren().add(p.GetLocation());
            p.SpawnPlayer(n);
            p.GetLocation().toFront();
            System.out.println("Cur pos: " + p.GetLocation().getLayoutX() + ":" + p.GetLocation().getLayoutY());
            break; //Break so it only adds one
        }

        PlayerController playerController = new PlayerController(p, mazegrid);

        /*
         Monster m = new Monster(1, 1);
         group.getChildren().add(m.GetLocation());
         Node n = spawnPoints.get(1);
         m.SpawnPlayer(n);
         m.GetLocation().toFront();
        
         AIController aiController = new AIController(m, mazegrid);
         */
        List<KeyCode> mkeys = new ArrayList<KeyCode>();
        mkeys.add(KeyCode.LEFT);
        mkeys.add(KeyCode.RIGHT);
        mkeys.add(KeyCode.UP);
        mkeys.add(KeyCode.DOWN);

        List<KeyCode> akeys = new ArrayList<KeyCode>();
        akeys.add(KeyCode.DIGIT1); //Throw
        akeys.add(KeyCode.DIGIT2); //Defensive
        akeys.add(KeyCode.DIGIT3); //Trap
        akeys.add(KeyCode.DIGIT4); //Global

        abilityCooldown = 0;// = System.currentTimeMillis(); 
        abilityCooldowns = new ArrayList<>();
        Map<KeyCode, Long> cooldowns = new HashMap<KeyCode, Long>() {
            {
                put(KeyCode.DIGIT1, (long) 0);
                put(KeyCode.DIGIT2, (long) 0);
                put(KeyCode.DIGIT3, (long) 0);
                put(KeyCode.DIGIT4, (long) 0);
            }
        };

        //INPUT DETECTION:
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                //Abilities while standing still:
                if (akeys.contains(event.getCode())) {
                    if (playerController.getCurrentKey() == null) //If player is standing still
                    {
                        /*
                         if(abilityCooldown >= System.currentTimeMillis())
                         {
                         System.out.println("Still in cooldown. Time left: " + (abilityCooldown - System.currentTimeMillis()) / 1000);
                         return;
                         }*/
                        switch (event.getCode()) {
                            case DIGIT1: //Throw
                                //System.out.println(cooldowns.get(event.getCode()) + " EN: " +System.currentTimeMillis());
                                if (cooldowns.get(event.getCode()) >= System.currentTimeMillis()) {
                                    System.out.println("Still in cooldown. Time left: " + (cooldowns.get(event.getCode()) - System.currentTimeMillis()) / 1000);
                                    return;
                                }
                                System.out.println("Throw activated. starting cooldown");
                                cooldowns.put(event.getCode(), System.currentTimeMillis() + defCooldown);
                                break;
                            case DIGIT2: //Defensive
                                //System.out.println(cooldowns.get(event.getCode()) + " EN: " +System.currentTimeMillis());
                                if (cooldowns.get(event.getCode()) >= System.currentTimeMillis()) {
                                    System.out.println("Still in cooldown. Time left: " + (cooldowns.get(event.getCode()) - System.currentTimeMillis()) / 1000);
                                    return;
                                }
                                System.out.println("Defense activated. starting cooldown");
                                cooldowns.put(event.getCode(), System.currentTimeMillis() + defCooldown);
                                break;
                            case DIGIT3: //Trap
                                //System.out.println(cooldowns.get(event.getCode()) + " EN: " +System.currentTimeMillis());
                                if (cooldowns.get(event.getCode()) >= System.currentTimeMillis()) {
                                    System.out.println("Still in cooldown. Time left: " + (cooldowns.get(event.getCode()) - System.currentTimeMillis()) / 1000);
                                    return;
                                }
                                System.out.println("Trap activated. starting cooldown");
                                cooldowns.put(event.getCode(), System.currentTimeMillis() + defCooldown);
                                break;
                            case DIGIT4: //Global
                                //System.out.println(cooldowns.get(event.getCode()) + " EN: " +System.currentTimeMillis());
                                if (cooldowns.get(event.getCode()) >= System.currentTimeMillis()) {
                                    System.out.println("Still in cooldown. Time left: " + (cooldowns.get(event.getCode()) - System.currentTimeMillis()) / 1000);
                                    return;
                                }
                                System.out.println("Global activated. starting cooldown");
                                cooldowns.put(event.getCode(), System.currentTimeMillis() + defCooldown);
                                break;
                        }
                    }
                }

                //Abilities while moving:
                if (mkeys.contains(playerController.getCurrentKey())) //If the 'current' key pressed is a movement key
                {
                    if (!akeys.contains(event.getCode())) //If the new key pressed is not in the abilities list
                    {
                        return; //Do nothing with input
                    } else {
                        switch (event.getCode()) //Get the key
                        {
                            case DIGIT1: //Throw
                                //
                                break;
                            case DIGIT2: //Defensive
                                //
                                break;
                            case DIGIT3: //Trap
                                //
                                break;
                            case DIGIT4: //Global
                                //
                                break;
                        }
                    }
                }

                //If you are already moving, just return.
                if (playerController.getCurrentKey() != null) //Can be modified to allow for multiple keypresses
                {
                    return;
                }
                switch (event.getCode()) {
                    case LEFT:
                        //System.out.println("Left pressed");
                        playerController.setCurrentKey(KeyCode.LEFT);
                        break;
                    case RIGHT:
                        //System.out.println("Right pressed");
                        playerController.setCurrentKey(KeyCode.RIGHT);
                        break;
                    case UP:
                        //System.out.println("Right pressed");
                        playerController.setCurrentKey(KeyCode.UP);
                        break;
                    case DOWN:
                        //System.out.println("Right pressed");
                        playerController.setCurrentKey(KeyCode.DOWN);
                        break;
                }
            }
        });

        //INPUT RELEASE DETECTION:
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (playerController.getCurrentKey() != event.getCode()) {
                    return;
                }
                switch (event.getCode()) {
                    case LEFT:
                        //System.out.println("Left released");
                        playerController.setCurrentKey(null);
                        break;
                    case RIGHT:
                        //System.out.println("Right released");
                        playerController.setCurrentKey(null);
                    case UP:
                        playerController.setCurrentKey(null);
                        break;
                    case DOWN:;
                        playerController.setCurrentKey(null);
                        break;
                }
            }
        });
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
