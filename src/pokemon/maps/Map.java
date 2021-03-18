/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.maps;

import java.awt.Graphics;
import pokemon.entities.EntityManager;
import pokemon.entities.creatures.Creature;
import pokemon.entities.creatures.Player;
import pokemon.entities.statics.Gym;
import pokemon.entities.statics.Mart;
import pokemon.entities.statics.PokemonCenter;
import pokemon.game.Handler;
import pokemon.tiles.Tile;
import pokemon.utils.Utils;

/**
 *
 * @author EQUIPO
 */
public class Map {
    
    private final Handler handler;
    private final EntityManager entityManager;
    
    private int width, height;
    private int playerSpawnX, playerSpawnY;
    private int pcSpawnX, pcSpawnY;
    private int martSpawnX, martSpawnY;
    private int gymSpawnX, gymSpawnY;
    private int[][] tiles;
    
    public Map(Handler handler, String path){
        this.handler = handler;
        
        loadMap(path);
        
        entityManager = new EntityManager(handler, new Player(handler, Tile.TILEWIDTH * playerSpawnX,
                (Tile.TILEHEIGHT * playerSpawnY) - (Creature.DEFAULT_CREATURE_HEIGHT / 2)));
        
        entityManager.addEntity(new PokemonCenter(handler, Tile.TILEWIDTH * pcSpawnX, Tile.TILEHEIGHT * pcSpawnY));
        
        entityManager.addEntity(new Mart(handler, Tile.TILEWIDTH * martSpawnX, Tile.TILEHEIGHT * martSpawnY));
        
        entityManager.addEntity(new Gym(handler, Tile.TILEWIDTH * gymSpawnX, Tile.TILEHEIGHT * gymSpawnY));
    }
    
    public void tick(){
        entityManager.tick();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
    
    public void render(Graphics g){
        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
        int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
        
        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
               getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
                       (int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset())); 
            }
        }
        
        entityManager.render(g);
    }
    
    public Tile getTile(int x, int y){
        if(x < 0 || y < 0 || x >= width || y >= height){
            return Tile.grassTile_0;
        }
        
        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null) {
            return Tile.dirtTile;
        }
        else return t;
    }
    
    private void loadMap(String path){
        String file = Utils.loadMapAsString(path);
        String[] tokens = file.split("\\s+");
        
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        
        playerSpawnX = Utils.parseInt(tokens[2]);
        playerSpawnY = Utils.parseInt(tokens[3]);
        pcSpawnX = Utils.parseInt(tokens[4]);
        pcSpawnY = Utils.parseInt(tokens[5]);
        martSpawnX = Utils.parseInt(tokens[6]);
        martSpawnY = Utils.parseInt(tokens[7]);
        gymSpawnX = Utils.parseInt(tokens[8]);
        gymSpawnY = Utils.parseInt(tokens[9]);
        
        tiles = new int[width][height];
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 10]);
            }
        }
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
}
