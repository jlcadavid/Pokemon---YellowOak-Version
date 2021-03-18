/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.entities.statics;

import java.awt.Color;
import java.awt.Graphics;
import pokemon.game.Handler;
import pokemon.gfx.Assets;

/**
 *
 * @author EQUIPO
 */
public class PokemonCenter extends StaticEntity {

    public PokemonCenter(Handler handler, float x, float y) {
        super(handler, x, y, 64, 128);
        
        bounds.x = 0;
        bounds.y = (int) (height / 1.5f) - 70;
        bounds.width = 200;
        bounds.height = (int) (height - height / 1.5f) + 92;
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.pokemon_center, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), 200, 168, null);
        
//        g.setColor(Color.red);
//        g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
//                (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
//                bounds.width, bounds.height);
    }
    
}
