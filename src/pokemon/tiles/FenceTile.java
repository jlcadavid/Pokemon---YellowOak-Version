/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.tiles;

import pokemon.gfx.Assets;

/**
 *
 * @author EQUIPO
 */
public class FenceTile extends Tile{
    
    public FenceTile(int id) {
        super(Assets.fence[id - 27], id);
    }
    
    @Override
    public boolean isSolid() {
        return true;
    }
}
