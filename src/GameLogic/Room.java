/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameLogic;

import java.awt.Rectangle;
import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 *
 * @author Robin
 */
public class Room 
{
    public final Rectangle area;
    public static int roomOffset= 2;
    
    public boolean edge=false;
    
    /**
     * 
     * @param x: The x-coordinate of the room. Must be higher than 0.
     * @param y: The y-coordinate of the room. Must be higher than 0.
     * @param w: The width of the room. Must be higher than 1.
     * @param h: The height of the room. Must be higher than 1.
     * @param edge: if the room is a part of the edge of the maze, return true, else false.
     */
    public Room(int x, int y, int w, int h, boolean edge)
    {
        this.area = new Rectangle(x, y, w, h);
        this.edge= edge;
    }
    
    /**
     * Checks if [rooomin] overlaps with this room combined with the [roomOffset].
     * 
     * @param roomin: The room which needs to be checked if it overlaps with this room
     * @return true if the room overlaps, else false.
     */
    public boolean OverLapsWith(Room roomin)
    {
        Rectangle r = roomin.area;
        return area.x < r.x + r.width+roomOffset && area.x + area.width+roomOffset > r.x && area.y < r.y + r.height+roomOffset && area.y + area.height+roomOffset > r.y;
    }
    
    /**
     * Calculates the approximate lenght between this room and [room]. Returns the lenght as a double
     * 
     * @param room
     * @return the length as a double
     */
    public double CalcLength(Room room){
       double length;
        
       double xLength = sqrt(pow((double)room.area.x - (double)this.area.x, 2));
       double yLength = sqrt(pow((double)room.area.y - (double)this.area.y, 2));
       
       length = xLength + yLength;
       
       return length;
    }
}
