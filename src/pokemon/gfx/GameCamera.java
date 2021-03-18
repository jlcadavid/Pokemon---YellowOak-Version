/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.gfx;

import pokemon.entities.Entity;
import pokemon.game.Handler;
import pokemon.tiles.Tile;

/**
 *
 * @author jlcadavid
 */
public class GameCamera {
    
    private final Handler handler;
    private float xOffset, yOffset;
    
    public GameCamera(Handler handler, float xOffset,  float yOffset){
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        
    }
    
    public void checkBlankSpace(){
        if (xOffset < 0) {
            xOffset = 0;
        }else if (xOffset > handler.getMap().getWidth() * Tile.TILEWIDTH - handler.getWidth()) {
            xOffset = handler.getMap().getWidth() * Tile.TILEWIDTH - handler.getWidth();
        }
        
        if (yOffset < 0) {
            yOffset = 0;
        }else if (yOffset > handler.getMap().getHeight() * Tile.TILEHEIGHT - handler.getHeight()) {
            yOffset = handler.getMap().getHeight() * Tile.TILEHEIGHT - handler.getHeight();
        }
    }
    
    public void centerOnEntity(Entity e){
        xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
        yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
        checkBlankSpace();
    }
    
    public void move(float xAmt, float yAmt){
        xOffset += xAmt;
        yOffset += yAmt;
        checkBlankSpace();
    }

    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
        checkBlankSpace();
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
        checkBlankSpace();
    }
    
}
