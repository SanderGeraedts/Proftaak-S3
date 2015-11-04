package GameLogic;


import GameLogic.Player;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import a.maze.ing.AMazeIng;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Robin
 */
public class CollisionController 
{
    private ArrayList<Player> players;
    private ArrayList<Timer> timers;
    private ArrayList<Ability> abilities;
    
    Timer coltimer;
    
    public CollisionController()
    {
      this.players = new ArrayList<>();
      this.timers = new ArrayList<>();
      this.abilities = new ArrayList<>();
      //coltimer = new Timer();
      //coltimer.scheduleAtFixedRate(new CollisionCheck(), 100, 100);
    }
    
    public void addPlayer(Player p)
    {
        players.add(p);
        initTimers();
    }
    
    public void addAbility(Ability a)
    {
        abilities.add(a);
        initTimers();
    }
    
    private void initTimers()
    {
        clearTimers();
        if(players.size() > 0)
            for(Player p: players)
            {
                Timer t= new Timer();
                timers.add(t);
                t.scheduleAtFixedRate(new CollisionCheck(p), 100, 100);
            }
        if(abilities.size() > 0)
            for(Ability a:abilities) {
                Timer t = new Timer();
                timers.add(t);
                t.scheduleAtFixedRate(new AbilityCollisionCheck(a), 100, 100);
            }
    }
    
    private void clearTimers() {
        if(timers.size() > 0)
            for(Timer t: timers){
                t.cancel();
            }
    }
    
    private class CollisionCheck extends TimerTask {
        private Player player;
        private long hitcooldown;
        public CollisionCheck(Player player) {
            this.player= player;
            hitcooldown = 0;
        }
        @Override
        public void run() {
            for(Player p : players)
            {
                if(player.GetLocation().getLayoutX() == p.GetLocation().getLayoutX() && player.GetLocation().getLayoutY() == p.GetLocation().getLayoutY() && p.active)
                {
                    if(hitcooldown < System.currentTimeMillis() && player != p && player.active)
                    {
                        p.CollisionWith(player);
                        hitcooldown = System.currentTimeMillis() + 1000;
                    }
                }
            }
        }
        
    }
    
    private class AbilityCollisionCheck extends TimerTask {
        private Ability ability;
        
        public AbilityCollisionCheck(Ability a)
        {
            this.ability = a;
        }

        @Override
        public void run() {
            for(Player p : players)
            {
                //System.out.println("a");
                if(ability.getAbilityNode().getLayoutX() > p.GetLocation().getLayoutX()-16 &&
                        ability.getAbilityNode().getLayoutX() < p.GetLocation().getLayoutX() + 16 && 
                        ability.getAbilityNode().getLayoutY() > p.GetLocation().getLayoutY()-16 &&
                        ability.getAbilityNode().getLayoutY() < p.GetLocation().getLayoutY() + 16 && ability.active && p.active)
                {
                    p.CollisionWith(ability);
                    //ability.DestructAbility();
                }
            }
        }
    }
}
