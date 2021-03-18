/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.gfx;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author Estudiantes
 */
public class Assets {
    
    public static Image menu_animation, menu_logo, battle_background1;
    public static Image[] pokemon_sprites, pokemon_backsprites;
    
    public static BufferedImage dirt, rock, wild_plant, red_flowers, bush;
    public static BufferedImage green_LifeBar, yellow_LifeBar, red_LifeBar, exp_Bar;
    public static BufferedImage[] water, tree, grass, sand, fence, mountain;
    public static BufferedImage pokemon_center, mart, gym;
    public static BufferedImage[] player_down, player_left, player_right, player_up;
    public static BufferedImage[] btn_fight, btn_run, btn_bag, btn_pokemon;
    
    public static String pokemon_database;
    
    private static final int PWIDTH = 32, PHEIGHT = 48;
    private static final int TILEWIDTH = 16, TILEHEIGHT = 16;
    
    public static void init() {
        
        String pokemon_DataBase = "res/pokemons/pokemon.txt";
        
        Image menu_Animation = new ImageIcon("res/textures/giphy.gif").getImage();
        Image menu_Logo = new ImageIcon("res/textures/imageedit_2_5889270015.png").getImage();
        Image battle_Background1 = new ImageIcon("res/textures/background.png").getImage();
        
        SpriteSheet psheet = new SpriteSheet(ImageLoader.loadImage("/textures/trchar000.png"));
        SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("/textures/147331437357494.png"));
        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/oie_transparent (1).png"));
        SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/textures/More Tilesets.png"));
        SpriteSheet sheet4 = new SpriteSheet(ImageLoader.loadImage("/textures/Battle Menu.png"));
        SpriteSheet fightsheet = new SpriteSheet(ImageLoader.loadImage("/textures/FightButton.png"));
        SpriteSheet runsheet = new SpriteSheet(ImageLoader.loadImage("/textures/RunButton.png"));
        SpriteSheet bagsheet = new SpriteSheet(ImageLoader.loadImage("/textures/BagButton.png"));
        SpriteSheet pokemonsheet = new SpriteSheet(ImageLoader.loadImage("/textures/PokemonButton.png"));
              
        player_down = new BufferedImage[4];
        player_left = new BufferedImage[4];
        player_right = new BufferedImage[4];
        player_up = new BufferedImage[4];
        
        pokemon_sprites = new Image[152];
        pokemon_backsprites = new Image[152];
        
        btn_fight = new BufferedImage[2];
        btn_run = new BufferedImage[2];
        btn_bag = new BufferedImage[2];
        btn_pokemon = new BufferedImage[2];
        
        water = new BufferedImage[17];
        tree = new BufferedImage[10];
        grass = new BufferedImage[4];
        sand = new BufferedImage[13];
        fence = new BufferedImage[10];
        
        menu_animation = menu_Animation;
        menu_logo = menu_Logo;
        battle_background1 = battle_Background1;
        
        pokemon_database = pokemon_DataBase;
        
        player_down[0] = psheet.crop(0, 0, PWIDTH, PHEIGHT);
        player_down[1] = psheet.crop(32, 0, PWIDTH, PHEIGHT);
        player_down[2] = psheet.crop(64, 0, PWIDTH, PHEIGHT);
        player_down[3] = psheet.crop(96, 0, PWIDTH, PHEIGHT);
        player_left[0] = psheet.crop(0, 48, PWIDTH, PHEIGHT);
        player_left[1] = psheet.crop(32, 48, PWIDTH, PHEIGHT);
        player_left[2] = psheet.crop(64, 48, PWIDTH, PHEIGHT);
        player_left[3] = psheet.crop(96, 48, PWIDTH, PHEIGHT);
        player_right[0] = psheet.crop(0, 96, PWIDTH, PHEIGHT);
        player_right[1] = psheet.crop(32, 96, PWIDTH, PHEIGHT);
        player_right[2] = psheet.crop(64, 96, PWIDTH, PHEIGHT);
        player_right[3] = psheet.crop(96, 96, PWIDTH, PHEIGHT);
        player_up[0] = psheet.crop(0, 144, PWIDTH, PHEIGHT);
        player_up[1] = psheet.crop(32, 144, PWIDTH, PHEIGHT);
        player_up[2] = psheet.crop(64, 144, PWIDTH, PHEIGHT);
        player_up[3] = psheet.crop(96, 144, PWIDTH, PHEIGHT);
        
        btn_fight[0] = fightsheet.crop(0, 0, 54, 18);
        btn_fight[1] = fightsheet.crop(54, 0, 54, 18);
        btn_run[0] = runsheet.crop(0, 0, 54, 18);
        btn_run[1] = runsheet.crop(54, 0, 54, 18);
        btn_bag[0] = bagsheet.crop(0, 0, 54, 18);
        btn_bag[1] = bagsheet.crop(54, 0, 54, 18);
        btn_pokemon[0] = pokemonsheet.crop(0, 0, 54, 18);
        btn_pokemon[1] = pokemonsheet.crop(54, 0, 54, 18);
        
        water[0] = sheet3.crop(188, 86, TILEWIDTH, TILEHEIGHT);
        water[1] = sheet3.crop(171, 86, TILEWIDTH, TILEHEIGHT);
        water[2] = sheet3.crop(205, 86, TILEWIDTH, TILEHEIGHT);
        water[3] = sheet3.crop(188, 69, TILEWIDTH, TILEHEIGHT);
        water[4] = sheet3.crop(188, 103, TILEWIDTH, TILEHEIGHT);
        water[5] = sheet3.crop(171, 103, TILEWIDTH, TILEHEIGHT);
        water[6] = sheet3.crop(205, 103, TILEWIDTH, TILEHEIGHT);
        water[7] = sheet3.crop(171, 69, TILEWIDTH, TILEHEIGHT);
        water[8] = sheet3.crop(205, 69, TILEWIDTH, TILEHEIGHT);
        water[9] = sheet3.crop(171, 137, TILEWIDTH, TILEHEIGHT);
        water[10] = sheet3.crop(205, 137, TILEWIDTH, TILEHEIGHT);
        water[11] = sheet3.crop(188, 120, TILEWIDTH, TILEHEIGHT);
        water[12] = sheet3.crop(188, 154, TILEWIDTH, TILEHEIGHT);
        water[13] = sheet3.crop(171, 154, TILEWIDTH, TILEHEIGHT);
        water[14] = sheet3.crop(205, 154, TILEWIDTH, TILEHEIGHT);
        water[15] = sheet3.crop(171, 120, TILEWIDTH, TILEHEIGHT);
        water[16] = sheet3.crop(205, 120, TILEWIDTH, TILEHEIGHT);
        
        tree[0] = sheet3.crop(239, 290, TILEWIDTH, TILEHEIGHT);
        tree[1] = sheet3.crop(256, 290, TILEWIDTH, TILEHEIGHT);
        tree[2] = sheet3.crop(273, 290, TILEWIDTH, TILEHEIGHT);
        tree[3] = sheet3.crop(290, 290, TILEWIDTH, TILEHEIGHT);
        tree[4] = sheet3.crop(273, 307, TILEWIDTH, TILEHEIGHT);
        tree[5] = sheet3.crop(290, 307, TILEWIDTH, TILEHEIGHT);
        tree[6] = sheet3.crop(273, 324, TILEWIDTH, TILEHEIGHT);
        tree[7] = sheet3.crop(290, 324, TILEWIDTH, TILEHEIGHT);
        tree[8] = sheet3.crop(239, 324, TILEWIDTH, TILEHEIGHT);
        tree[9] = sheet3.crop(256, 324, TILEWIDTH, TILEHEIGHT);
        
        grass[0] = sheet3.crop(103, 1, TILEWIDTH, TILEHEIGHT);
        grass[1] = sheet3.crop(103, 18, TILEWIDTH, TILEHEIGHT);
        grass[2] = sheet3.crop(120, 18, TILEWIDTH, TILEHEIGHT);
        grass[3] = sheet3.crop(103, 35, TILEWIDTH, TILEHEIGHT);
        
        sand[0] = sheet3.crop(1, 1, TILEWIDTH, TILEHEIGHT);
        sand[1] = sheet3.crop(18, 1, TILEWIDTH, TILEHEIGHT);
        sand[2] = sheet3.crop(35, 1, TILEWIDTH, TILEHEIGHT);
        sand[3] = sheet3.crop(52, 1, TILEWIDTH, TILEHEIGHT);
        sand[4] = sheet3.crop(69, 1, TILEWIDTH, TILEHEIGHT);
        sand[5] = sheet3.crop(18, 18, TILEWIDTH, TILEHEIGHT);
        sand[6] = sheet3.crop(35, 18, TILEWIDTH, TILEHEIGHT);
        sand[7] = sheet3.crop(52, 18, TILEWIDTH, TILEHEIGHT);
        sand[8] = sheet3.crop(69, 18, TILEWIDTH, TILEHEIGHT);
        sand[9] = sheet3.crop(18, 35, TILEWIDTH, TILEHEIGHT);
        sand[10] = sheet3.crop(35, 35, TILEWIDTH, TILEHEIGHT);
        sand[11] = sheet3.crop(52, 35, TILEWIDTH, TILEHEIGHT);
        sand[12] = sheet3.crop(69, 35, TILEWIDTH, TILEHEIGHT);
        
        fence[0] = sheet3.crop(103, 205, TILEWIDTH, TILEHEIGHT);
        fence[1] = sheet3.crop(137, 205, TILEWIDTH, TILEHEIGHT);
        fence[2] = sheet3.crop(120, 188, TILEWIDTH, TILEHEIGHT);
        fence[3] = sheet3.crop(120, 222, TILEWIDTH, TILEHEIGHT);
        fence[4] = sheet3.crop(103, 222, TILEWIDTH, TILEHEIGHT);
        fence[5] = sheet3.crop(137, 222, TILEWIDTH, TILEHEIGHT);
        fence[6] = sheet3.crop(103, 188, TILEWIDTH, TILEHEIGHT);
        fence[7] = sheet3.crop(137, 188, TILEWIDTH, TILEHEIGHT);
        fence[8] = sheet3.crop(103, 239, TILEWIDTH, TILEHEIGHT);
        fence[9] = sheet3.crop(120, 239, TILEWIDTH, TILEHEIGHT);
        
        dirt = sheet3.crop(1, 409, TILEWIDTH, TILEHEIGHT);
        rock = sheet3.crop(120, 273, TILEWIDTH, TILEHEIGHT);
        wild_plant = sheet3.crop(120, 1, TILEWIDTH, TILEHEIGHT);
        red_flowers = sheet3.crop(120, 35, TILEWIDTH, TILEHEIGHT);
        bush = sheet3.crop(120, 205, TILEWIDTH, TILEHEIGHT);
        
        green_LifeBar = sheet4.crop(117, 9, 9, 3);
        yellow_LifeBar = sheet4.crop(117, 13, 9, 3);
        red_LifeBar = sheet4.crop(117, 17, 9,  3);
        exp_Bar = sheet4.crop(129, 9, 7, 2);
        
        pokemon_center = sheet2.crop(8, 158, 80, 72);
        mart = sheet2.crop(15, 248, 68, 72);
        gym = sheet2.crop(88, 231, 115, 80);
        
        for (int i = 0; i < 151; i++) {
            pokemon_sprites[i] = new ImageIcon("res/pokemons/sprites/(" + (i + 1) + ").png").getImage();
            pokemon_backsprites[i] = new ImageIcon("res/pokemons/backsprites/(" + (i + 1) + ").png").getImage();
        }
        
    }
}
