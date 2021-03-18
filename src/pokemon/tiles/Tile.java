/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author EQUIPO
 */
public class Tile {
    
    public static Tile[] tiles = new Tile[256];
    
    public static Tile grassTile_0 = new GrassTile(0);
    public static Tile grassTile_1 = new GrassTile(1);
    public static Tile grassTile_2 = new GrassTile(2);
    public static Tile grassTile_3 = new GrassTile(3);
    
    public static Tile sandTile = new SandTile(4);
    public static Tile left_SandTile = new SandTile(5);
    public static Tile right_SandTile = new SandTile(6);
    public static Tile up_SandTile = new SandTile(7);
    public static Tile down_SandTile = new SandTile(8);
    public static Tile ext_DownLeft_SandTile = new SandTile(9);
    public static Tile ext_DownRight_SandTile = new SandTile(10);
    public static Tile ext_UpLeft_SandTile = new SandTile(11);
    public static Tile ext_UpRight_SandTile = new SandTile(12);
    public static Tile int_DownRight_SandTile = new SandTile(13);
    public static Tile int_DownLeft_SandTile = new SandTile(14);
    public static Tile int_UpRight_SandTile = new SandTile(15);
    public static Tile int_UpLeft_SandTile = new SandTile(16);
    
    public static Tile noTree_UpLeft_TreeTile = new TreeTile(17);
    public static Tile noTree_UpRight_TreeTile = new TreeTile(18);
    public static Tile contTree_UpLeft_TreeTile = new TreeTile(19);
    public static Tile contTree_UpRight_TreeTile = new TreeTile(20);
    public static Tile contTree_MiddleLeft_TreeTile = new TreeTile(21);
    public static Tile contTree_MiddleRight_TreeTile = new TreeTile(22);
    public static Tile contTree_DownLeft_TreeTile = new TreeTile(23);
    public static Tile contTree_DownRight_TreeTile = new TreeTile(24);
    public static Tile noTree_DownLeft_TreeTile = new TreeTile(25);
    public static Tile noTree_DownRight_TreeTile = new TreeTile(26);
    
    public static Tile left_FenceTile = new FenceTile(27);
    public static Tile right_FenceTile = new FenceTile(28);
    public static Tile up_FenceTile = new FenceTile(29);
    public static Tile down_FenceTile = new FenceTile(30);
    public static Tile downLeft_FenceTile = new FenceTile(31);
    public static Tile downRight_FenceTile = new FenceTile(32);
    public static Tile upLeft_FenceTile = new FenceTile(33);
    public static Tile upRight_FenceTile = new FenceTile(34);
    public static Tile leftIntersec_FenceTile = new FenceTile(35);
    public static Tile rightIntersec_FenceTile = new FenceTile(36);
    
    public static Tile waterTile = new WaterTile(37);
    public static Tile ext_Left_WaterTile = new WaterTile(38);
    public static Tile ext_Right_WaterTile = new WaterTile(39);
    public static Tile ext_Up_WaterTile = new WaterTile(40);
    public static Tile ext_Down_WaterTile = new WaterTile(41);
    public static Tile ext_DownLeft_WaterTile = new WaterTile(42);
    public static Tile ext_DownRight_WaterTile = new WaterTile(43);
    public static Tile ext_UpLeft_WaterTile = new WaterTile(44);
    public static Tile ext_UpRight_WaterTile = new WaterTile(45);
    public static Tile int_Left_WaterTile = new WaterTile(46);
    public static Tile int_Right_WaterTile = new WaterTile(47);
    public static Tile int_Up_WaterTile = new WaterTile(48);
    public static Tile int_Down_WaterTile = new WaterTile(49);
    public static Tile int_DownLeft_WaterTile = new WaterTile(50);
    public static Tile int_DownRight_WaterTile = new WaterTile(51);
    public static Tile int_UpLeft_WaterTile = new WaterTile(52);
    public static Tile int_UpRight_WaterTile = new WaterTile(53);
    
    public static Tile wildPlantTile = new WildPlantTile(54);
    public static Tile dirtTile = new DirtTile(55);
    public static Tile redFlowersTile = new RedFlowersTile(56);
    public static Tile rockTile = new RockTile(57);
    public static Tile bushTile = new BushTile(58);
    
    public static final int TILEWIDTH = 32, TILEHEIGHT = 32;
    
    protected BufferedImage texture;
    protected BufferedImage[] textures;
    protected final int id;
    
    public Tile(BufferedImage texture, int id){
        this.texture = texture;
        this.id = id;
        
        tiles[id] = this;
    }
    
    public Tile(BufferedImage[] textures, int id){
        this.texture = textures[id];
        this.id = id;
        
        tiles[id] = this;
    }
    
    public void tick(){
        
    }
    
    public void render(Graphics g, int x, int y){
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }
    
    public boolean battleGround(){
        return false;
    }
    
    public boolean isSolid(){
        return false;
    }
    
    public int getId(){
        return id;
    }
    
}
