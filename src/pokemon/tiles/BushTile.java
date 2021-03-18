/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.tiles;

import java.awt.Color;
import java.awt.Graphics;
import pokemon.gfx.Assets;

/**
 *
 * @author EQUIPO
 */
public class BushTile extends Tile{
    
    public BushTile(int id) {
        super(Assets.bush,id);
    }
    
    @Override
    public boolean isSolid() {
        return true;
    }
}
