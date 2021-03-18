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
public class Gym extends StaticEntity {

    public Gym(Handler handler, float x, float y) {
        super(handler, x, y, 136, 90);
        
        bounds.x = 3;
        bounds.y = (int) (height / 1.5f) - 40;
        bounds.width = 280;
        bounds.height = (int) (height - height / 1.5f) + 130;
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.gym, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), 288, 196, null);
        
//        g.setColor(Color.red);
//        g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
//                (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
//                bounds.width, bounds.height);
    }
    
}
