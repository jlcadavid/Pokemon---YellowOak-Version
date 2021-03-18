/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.states;

import java.awt.Graphics;
import pokemon.game.Handler;
import pokemon.maps.Map;

/**
 *
 * @author EQUIPO
 */
public class GameState extends State{
    
    private final Map map;

    public GameState(Handler handler) {
        super (handler);
        map = new Map(handler, "res/maps/map1.txt");
        handler.setMap(map);
    }
    
    @Override
    public void tick() {
        map.tick();
    }

    @Override
    public void render(Graphics g) {
        map.render(g);
    }
}

