package GameLogic;

import GameLogic.*;
import java.awt.Rectangle;
import java.util.*;
import javafx.scene.image.Image;

public class Maze {

	private int mazeID;
	/**
	 * 
	 * @param mazeID
	 * @param mazeSize
	 */
        //Maze grid:
        private final Block grid[][];

        //Sizes:
        private final int gridSize;
        private Random rand;

        //Rooms:
        private final int roomSize;
        private final int roomTries;
        private ArrayList<Room> finRooms;
        
        //Spawnpoints:
        private ArrayList<SpawnPoint> spawnPoints;
        
        //Graphics
        private final List<Image> sprites;
    
    public Maze(int gridsize, int roomsize, int roomtries)
    {
        this.gridSize = gridsize;
        this.grid = new Block[gridsize][gridsize]; //Y-X
        this.rand = new Random();
        this.roomSize = roomsize;
        this.roomTries = roomtries;
        this.finRooms = new ArrayList<Room>();
        this.sprites = new ArrayList<Image>();
        this.spawnPoints = new ArrayList<SpawnPoint>();
        
        sprites.add(Sprite.LoadSprite("Resources/WallSprite.jpg", 16, 16));
        
        
        //Starting off with nothing
        for(Block[] row : grid)
        {
            Arrays.fill(row, Block.SOLID);
        }
        for(int i=0; i<roomTries; i++)
        {
            Room r = generateRoom();
            //System.out.println("Room genned. X: " + r.area.x + " Y: " + r.area.y + " X2: " + (r.area.x+r.area.width) + " Y2: " + (r.area.y+r.area.height));
            boolean overlap = false;
            for(Room s : finRooms)
            {
                if(r.OverLapsWith(s))
                {
                    //System.out.println("Room overlaps");
                    overlap = true;
                }
            }
            
            if(overlap)
                continue;
            else
            {
                finRooms.add(r);
                //System.out.println("Room drawed");
                drawRoom(r);
            }
        }
        
        drawHallways(3);
        
        placeSpawnPoints(4);
    }
    
    private void placeSpawnPoints(int amount)
    {
        ArrayList<Room> spawnRooms = new ArrayList<Room>();
        for(int i=0; i<amount; i++)
        {
            if(i==0)
            {
                int idx = newRand(finRooms.size());
                Room r = finRooms.get(idx);

                int sX = r.area.x + (r.area.width/2);
                int sY = r.area.y + (r.area.height/2);

                SpawnPoint sp = new SpawnPoint(sX, sY);
                spawnPoints.add(sp);  
                spawnRooms.add(r);
                grid[sY][sX] = Block.SPAWNPOINT;
            }
            else
            {
                int idx = newRand(finRooms.size());
                Room r = finRooms.get(idx);
                
                if(!spawnRooms.contains(r))
                {
                    int sX = r.area.x + (r.area.width/2);
                    int sY = r.area.y + (r.area.height/2);

                    SpawnPoint sp = new SpawnPoint(sX, sY);
                    spawnPoints.add(sp);
                    spawnRooms.add(r);
                    grid[sY][sX] = Block.SPAWNPOINT;
                }
                else
                {
                    i--;
                    continue;
                }
            }

        }
    }
    
    private void drawRoom(Room r)
    {
        Rectangle rec = r.area;
        System.out.println("Starting draw");
        for(int y=rec.y; y<rec.y+rec.height; y++)
        {
            for(int x= rec.x; x<rec.x+rec.width; x++)
            {
                System.out.println("Grid X:" + x + " Y:" + y);
                grid[y][x]= Block.OPEN;
            }
        }
    }
    
    private void drawHallway(Room r1, Room r2){
        int x = 0;
        int y = 0;
        
        if(r1.area.x < r2.area.x){
            
            for(x = r1.area.x; x<=r2.area.x; x++){
                y = r1.area.y;
                grid[y][x] = Block.OPEN;
            }
            if(y < r2.area.y){
                for(y = r1.area.y; y <= r2.area.y; y++){
                    grid[y][x] = Block.OPEN;
                }
            }
            else{
                for(y = r1.area.y; y >= r2.area.y; y--){
                    grid[y][x] = Block.OPEN;
                }
            }
        }
        else{
            for(x = r1.area.x; x>=r2.area.x; x--){
                y = r1.area.y;
                grid[y][x] = Block.OPEN;
            }
            if(y < r2.area.y){
                for(y = r1.area.y; y <= r2.area.y; y++){
                    grid[y][x] = Block.OPEN;
                }
            }
            else{
                for(y = r1.area.y; y >= r2.area.y; y--){
                    grid[y][x] = Block.OPEN;
                }
            }
        }
    }
    
    private void drawHallways(int nrOfHallways)
    { 
        
        for(Room room : finRooms){
                
            Room roomShort1 = null;
            Room roomShort2 = null;
            Room roomShort3 = null;

            double room1Length = 0;
            double room2Length = 0;
            double room3Length = 0;
            
            if(nrOfHallways == 2){
                for(Room r2 : finRooms){
                    double length = r2.CalcLength(room);
                    //check if room and r2 aren't the same and if r2 has less than 2 connections
                    if(room != r2){
                        if(length < room1Length || room1Length == 0){
                            //set shortest room to 2nd shortest room
                            roomShort2 = roomShort1;
                            room2Length = room1Length;

                            //set shortest room to current room
                            roomShort1 = r2;
                            room1Length = length;
                        }
                        else if(room1Length < length && length < room2Length || room2Length==0){
                            //set 2nd shortest room to current room
                            roomShort2 = r2;
                            room2Length = length;
                        }
                    }
                }

                //draw hallway
                try{
                    drawHallway(room, roomShort1);
                    drawHallway(room, roomShort2);
                }
                catch(NullPointerException e){
                    System.out.println(e.getMessage());
                }
            }
            if(nrOfHallways == 3){
                for(Room r2 : finRooms){
                    double length = r2.CalcLength(room);
                    //check if room and r2 aren't the same and if r2 has less than 2 connections
                    if(room != r2){
                        if(length < room1Length || room1Length == 0){
                            //set 2nd shortest room to 3rd shortest room
                            roomShort3 = roomShort2;
                            room3Length = room2Length;

                            //set shortest room to 2nd shortest room
                            roomShort2 = roomShort1;
                            room2Length = room1Length;

                            //set shortest room to current room
                            roomShort1 = r2;
                            room1Length = length;
                        }
                        else if(room1Length < length && length < room2Length || room2Length==0){
                            //set 2nd shortest room to 3rd shortest room
                            roomShort3 = roomShort2;
                            room3Length = room2Length;

                            //set 2nd shortest room to current room
                            roomShort2 = r2;
                            room2Length = length;
                        }
                        else if(room2Length < length && length < room3Length || room3Length==0){
                            //set 3rd shortest room to current room
                            roomShort3 = r2;
                            room3Length = length;
                        }
                    }
                }

                //draw hallway
                try{
                    drawHallway(room, roomShort1);
                    drawHallway(room, roomShort2);
                    drawHallway(room, roomShort3);
                }
                catch(NullPointerException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    
    public void printMaze()
    {
        for(int y=0; y<gridSize; y++)
        {
            String line = "";
            for(int x=0; x<gridSize; x++)
            {
                if(grid[y][x] == Block.SOLID){
                    line += " \u25A0 ";
                }
                if(grid[y][x] == Block.OPEN){
                    line += " \u25A1 ";
                }
                if(grid[y][x] == Block.SPAWNPOINT){
                    line += " X ";
                }
            }
            System.out.println(line);
        }
        
    }
    
    private Room generateRoom()
    {
        int width= newRand(roomSize);
        int height = newRand(roomSize);
        System.out.println("W:" + width + " H:" + height);
        Room r = new Room(1+newRand(gridSize-width-2), 1+newRand(gridSize-height-2), 2+width, 2+height);
        return r;
    }
    
    private int newRand(int bound)
    {
        return rand.nextInt(bound);
    }
        /*
        *Spawn a buff in a random location in the maze.
        */
	public void spawnBuff() {
		// TODO - implement Maze.spawnBuff
		throw new UnsupportedOperationException();
	}
        
    public Block[][] GetGrid()
    {
        return this.grid;
    }
    
    public int getGridSize()
    {
        return gridSize;
    }

}