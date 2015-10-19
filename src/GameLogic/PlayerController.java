package GameLogic;

import a.maze.ing.AMazeIng;
import java.awt.Rectangle;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class PlayerController {

    private int state;
    private int direction;
    private int location;

    private AMazeIng guiMaze;

    //logix
    private String pressedKey = "";
    private Boolean upPressed = false;
    private Boolean downPressed = false;
    private Boolean leftPressed = false;
    private Boolean rightPressed = false;

    private Image img;
    private Node nod;
    private Rectangle rec;

    private String key;

    /**
     *
     * @param guiMaze
     * @param state
     * @param direction
     * @param location
     */
    public PlayerController(/*int state, int direction, int location,*/AMazeIng guiMaze) {
//        this.state = state;
//        this.direction = direction;
//        this.location = location;
        this.guiMaze = guiMaze;

        //Logix
        

    }

    private void moveImage(int dx, int dy) {
        if (dx == 0 && dy == 0) {
            return;
        }

        final double cx = nod.getBoundsInLocal().getWidth() / 2;
        final double cy = nod.getBoundsInLocal().getHeight() / 2;

        double x = cx + nod.getLayoutX() + dx * 4.40f;
        double y = cy + nod.getLayoutY() + dy * 4.40f;

        moveImgTo(x, y);
    }

    private void moveImgTo(double x, double y) {
        final double cx = nod.getBoundsInLocal().getWidth() / 2;
        final double cy = nod.getBoundsInLocal().getHeight() / 2;
        System.out.println("x: " + x + " - y: " + y);
        if (x - cx >= 0
                && x + cx <= 800
                && y - cy >= 0
                && y + cy <= 600) {
            nod.relocate(x - cx, y - cy);
            rec = new Rectangle((int) nod.getLayoutX(), (int) nod.getLayoutY(), 236, 236);
        }
    }

    /*
     *Check if the player is dead. If player life is lower then 1. player is dead.
     */
    public void isDead() {
        // TODO - implement PlayerController.isDead
        throw new UnsupportedOperationException();
    }

    /*
     *Player move up,down,left,right.
     */
    public void playerMove() {
        // TODO - implement PlayerController.playerMove
        throw new UnsupportedOperationException();
    }

    /*
     *
     */
    public void collisionCheck() {
        // TODO - implement PlayerController.collisionCheck
        throw new UnsupportedOperationException();
    }

    /*
     * Check damage done to player.
     */
    public void checkDamage() {
        // TODO - implement PlayerController.checkDamage
        throw new UnsupportedOperationException();
    }

    /*
     *Check if there is a trap.
     */
    public void checkTrap() {
        // TODO - implement PlayerController.checkTrap
        throw new UnsupportedOperationException();
    }

    /**
     * Use a ability whit the given id.
     *
     * @param id
     */
    public void useAbility(int id) {
        // TODO - implement PlayerController.useAbility
        throw new UnsupportedOperationException();
    }

}
