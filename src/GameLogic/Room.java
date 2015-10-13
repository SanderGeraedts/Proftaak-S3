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
    public int nrOfConnections;
    public static int roomOffset= 6;
    
    public Room(int x, int y, int w, int h)
    {
        this.area = new Rectangle(x, y, w, h);
        this.nrOfConnections = 0;
    }
    
    public boolean OverLapsWith(Room roomin)
    {
        Rectangle r = roomin.area;
        return area.x < r.x + r.width+roomOffset && area.x + area.width+roomOffset > r.x && area.y < r.y + r.height+roomOffset && area.y + area.height+roomOffset > r.y;
    }
    
    public void AddConnection()
    {
        this.nrOfConnections++;
    }
    
    public double CalcLength(Room room){
       double length;
        
       double xLength = sqrt(pow((double)room.area.x - (double)this.area.x, 2));
       double yLength = sqrt(pow((double)room.area.y - (double)this.area.y, 2));
       
       length = xLength + yLength;
       
       return length;
    }
}
