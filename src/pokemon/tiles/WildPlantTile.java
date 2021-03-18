/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.tiles;

import java.awt.Color;
import java.awt.Graphics;
import pokemon.gfx.Assets;
import static pokemon.tiles.Tile.TILEHEIGHT;
import static pokemon.tiles.Tile.TILEWIDTH;

/**
 *
 * @author jlcadavid
 */
public class WildPlantTile extends Tile {
    
    public WildPlantTile(int id) {
        super(Assets.wild_plant, id);
    }

    @Override
    public boolean battleGround() {
        return true;
    }

//    @Override
//    public void render(Graphics g, int x, int y) {
//        super.render(g, x, y);
//        g.setColor(Color.red);
//        g.fillRect(x, y, TILEWIDTH, TILEHEIGHT);
//    }
    
}
