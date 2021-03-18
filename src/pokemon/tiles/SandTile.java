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
public class SandTile extends Tile {
    
    public SandTile(int id) {
        super(Assets.sand[id - 4], id);
    }
    
}
