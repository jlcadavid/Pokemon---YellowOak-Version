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
public class Mart extends StaticEntity {

    public Mart(Handler handler, float x, float y) {
        super(handler, x, y, 68, 90);
        
        bounds.x = 0;
        bounds.y = (int) (height / 1.5f) - 35;
        bounds.width = 165;
        bounds.height = (int) (height - height / 1.5f) + 90;
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.mart, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), 176, 176, null);
        
//        g.setColor(Color.red);
//        g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
//                (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
//                bounds.width, bounds.height);
    }
    
}
