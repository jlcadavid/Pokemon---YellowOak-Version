/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.entities.pokemons;

import java.awt.Graphics;
import java.util.ArrayList;
import pokemon.game.Handler;
import pokemon.gfx.Assets;

/**
 *
 * @author EQUIPO
 */
public class PokemonManager {
    
    private Handler handler;
    private ArrayList<Pokemon> pokemons;
    
    public PokemonManager(Handler handler) {
        this.handler = handler;
        pokemons = new ArrayList<>();
    }
    
    public void tick() {
        for (Pokemon p : pokemons) {
            p.tick();
        }
    }
    
    public void render(Graphics g) {
        for (Pokemon p : pokemons) {
            p.render(g);
        }
    }

    public String getPath(int id) {
        return Assets.pokemon_database;
    }
    
    public void addPokemon(Pokemon p) {
        pokemons.add(p);
    }
    
    public void removePokemon(Pokemon p) {
        pokemons.remove(p);
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
    
}
