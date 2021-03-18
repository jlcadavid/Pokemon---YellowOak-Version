/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.game;

import pokemon.entities.creatures.Player;
import pokemon.entities.pokemons.Pokemon;
import pokemon.gfx.GameCamera;
import pokemon.input.KeyManager;
import pokemon.input.MouseManager;
import pokemon.maps.Map;

/**
 *
 * @author EQUIPO
 */
public class Handler {
    
    private Game game;
    private Map map;
    private Player player;
    private Pokemon pokemon;
    
    public Handler(Game game){
        this.game = game;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public GameCamera getGameCamera(){
        return game.getGameCamera();
    }
    
    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }
    
    public MouseManager getMouseManager(){
        return game.getMouseManager();
    }
    
    public int getWidth(){
        return game.getWidth();
    }
    
    public int getHeight(){
        return game.getHeight();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
