/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.entities.creatures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import pokemon.game.Handler;
import pokemon.gfx.Animation;
import pokemon.gfx.Assets;
import pokemon.entities.pokemons.Pokemon;
import pokemon.states.BattleState;
import pokemon.states.State;
import pokemon.tiles.Tile;
import pokemon.utils.Utils;

/**
 *
 * @author EQUIPO
 */
public class Player extends Creature {
    
    private final int animSpeed = 150;
    private final Animation animDown, animLeft, animRight, animUp;
    
    private ArrayList<Pokemon> playerPokemons;
    
    private int battleTimer;

    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        
        bounds.x = 3;
        bounds.y = (int) (height / 1.5f) - 8;
        bounds.width = width - 6;
        bounds.height = (int) (height - height / 1.5f) + 8;
        
        animDown = new Animation(animSpeed, Assets.player_down);
        animLeft = new Animation(animSpeed, Assets.player_left);
        animRight = new Animation(animSpeed, Assets.player_right);
        animUp = new Animation(animSpeed, Assets.player_up);
        
        playerPokemons = new ArrayList<>();
        playerPokemons.add(new Pokemon(24, 75, 145, Pokemon.DEFAULT_POKEMON_WIDTH, Pokemon.DEFAULT_POKEMON_HEIGHT, Assets.pokemon_backsprites));
        
        battleTimer = Utils.Random(500, 250);
    }
    
    private BufferedImage getCurrentAnimationFrame() {
        if (xMove < 0)
            return animLeft.getCurrentFrame();
        else if (xMove > 0)
                  return animRight.getCurrentFrame();
        else if (yMove < 0)
                   return animUp.getCurrentFrame();
        else if (yMove > 0)
                   return animDown.getCurrentFrame();
        else if (xMove == 0 && yMove == 0) {
            switch (handler.getKeyManager().lastPressed) {
                case 0:
                    return Assets.player_left[0];
                case 1:
                    return Assets.player_right[0];
                case 2:
                    return Assets.player_up[0];
                default: 
                    return Assets.player_down[0];
            }
        } else return Assets.player_down[0];
    }

    private void getInput(){
        xMove = 0;
        yMove = 0;
                
        if(handler.getKeyManager().up && handler.getKeyManager().lastPressed == 2) {
            yMove = -speed;
            int ty = (int) ((y + yMove + bounds.y) / Tile.TILEHEIGHT);
            if (enteringBattle((int) ((x + bounds.x) / Tile.TILEWIDTH), ty)) {
                battleTimer = battleTimer - (int) speed;
                if (battleTimer <= 0) {
                    State.setState(new BattleState(handler, this));
                }
            }
        } 
        
        if(handler.getKeyManager().down && handler.getKeyManager().lastPressed == 3) {
            yMove = speed;
            int ty = (int) ((y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT);
            if (enteringBattle((int) ((x + bounds.x) / Tile.TILEWIDTH), ty)) {
                battleTimer = battleTimer - (int) speed;
                if (battleTimer <= 0) {
                    State.setState(new BattleState(handler, this));
                }
            }
        } 
        
        if(handler.getKeyManager().left && handler.getKeyManager().lastPressed == 0) {
            xMove = -speed;
            int tx = (int) ((x + xMove + bounds.x) / Tile.TILEWIDTH);
            if (enteringBattle(tx, (int) ((y + bounds.y) / Tile.TILEHEIGHT))) {
                battleTimer = battleTimer - (int) speed;
                if (battleTimer <= 0) {
                    State.setState(new BattleState(handler, this));
                }
            }
        } 
        
        if(handler.getKeyManager().right && handler.getKeyManager().lastPressed == 1) {
            xMove = speed;
            int tx = (int) ((x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH);
            if (enteringBattle(tx, (int) ((y + bounds.y) / Tile.TILEHEIGHT))) {
                battleTimer = battleTimer - (int) speed;
                if (battleTimer <= 0) {
                    State.setState(new BattleState(handler, this));
                }
            }
        }
    }
    
    protected boolean enteringBattle(int x , int y) {
            return handler.getMap().getTile(x, y).battleGround();
    }
    
    @Override
    public void tick() {
        animDown.tick();
        animLeft.tick();
        animRight.tick();
        animUp.tick();
        
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
                (int) (y - handler.getGameCamera().getyOffset()), DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT, null);
    
//        g.setColor(Color.yellow);
//        g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
//                (int) (y + bounds.y - handler.getGameCamera().getyOffset()),
//                bounds.width, bounds.height);
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    public int getBattleTimer() {
        return battleTimer;
    }

    public void setBattleTimer(int battleTimer) {
        this.battleTimer = battleTimer;
    }

    public ArrayList<Pokemon> getPlayerPokemons() {
        return playerPokemons;
    }

    public void setPlayerPokemons(ArrayList<Pokemon> playerPokemons) {
        this.playerPokemons = playerPokemons;
    }
    
}
