/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JOptionPane;
import pokemon.UI.ClickListener;
import pokemon.UI.UIButton;
import pokemon.UI.UIManager;
import pokemon.entities.creatures.Player;
import pokemon.entities.pokemons.Pokemon;
import pokemon.entities.pokemons.PokemonManager;
import pokemon.game.Handler;
import pokemon.gfx.Assets;
import pokemon.utils.Utils;

/**
 *
 * @author jlcadavid
 */
public class BattleState extends State {
    
    private final PokemonManager pokemonManager;
    private final Pokemon playerPokemon;
    private final Pokemon rivalPokemon;
    private UIManager uiManager;
    
    private int playerPokemonHP;
    private int rivalPokemonHP;
    private int playerPokemonDamage;
    private int rivalPokemonDamage;
    private int playerPokemonHPBar = 160;
    private int rivalPokemonHPBar = 160;
    
    private int buttonPressed;
    
    private static final int BUTTON_WIDTH = 162, BUTTON_HEIGHT = 54;
    
    public BattleState(final Handler handler, final Player player){
        super (handler);
        
        uiManager = new UIManager(handler);
        pokemonManager = new PokemonManager(handler);
        
        playerPokemon = player.getPlayerPokemons().get(0);
        rivalPokemon = new Pokemon(Utils.Random(151, 0), 460, 0, Pokemon.DEFAULT_POKEMON_WIDTH,
                Pokemon.DEFAULT_POKEMON_HEIGHT, Assets.pokemon_sprites);
        
        playerPokemonHP = playerPokemon.getHit_Points();
        rivalPokemonHP = rivalPokemon.getHit_Points();
        
        handler.getMouseManager().setUIManager(uiManager);

        uiManager.addObject(new UIButton(430, 410, BUTTON_WIDTH, BUTTON_HEIGHT,
                Assets.btn_fight, new ClickListener(){
            @Override
            public void onClick() {
                if (playerPokemonHP <= 0 || rivalPokemonHP <= 0) {
                    player.setBattleTimer(Utils.Random(500, 250));
                    handler.getMouseManager().setUIManager(null);
                    State.setState(State.getPreviousState());
                }
                else {
                    playerPokemonDamage = attack(rivalPokemon, playerPokemon);
                    playerPokemonHPBar = playerPokemonHPBar - ((playerPokemonHPBar * playerPokemonDamage) / playerPokemonHP);
                    playerPokemonHP = playerPokemonHP - playerPokemonDamage;
                    
                    rivalPokemonDamage = attack(playerPokemon, rivalPokemon);
                    rivalPokemonHPBar = rivalPokemonHPBar - ((rivalPokemonHPBar * rivalPokemonDamage) / rivalPokemonHP);
                    rivalPokemonHP = rivalPokemonHP - rivalPokemonDamage;
                    
                    buttonPressed = 1;
                    if (playerPokemonHP <= 0 || rivalPokemonHP <= 0) {
                        player.setBattleTimer(Utils.Random(500, 250));
                        handler.getMouseManager().setUIManager(null);
                        State.setState(State.getPreviousState());
                    }
                }
//                JOptionPane.showMessageDialog(null, "Still in development!", "Coming Soon...", 1);
            }
        }));

        uiManager.addObject(new UIButton(608, 410, BUTTON_WIDTH, BUTTON_HEIGHT,
                Assets.btn_bag, new ClickListener(){
            @Override
            public void onClick() {
                buttonPressed = 2;
                JOptionPane.showMessageDialog(null, "Still in development!", "Coming Soon...", 1);
            }
        }));

        uiManager.addObject(new UIButton(430, 470, BUTTON_WIDTH, BUTTON_HEIGHT,
                Assets.btn_pokemon, new ClickListener(){
            @Override
            public void onClick() {
                buttonPressed = 3;
                JOptionPane.showMessageDialog(null, "Still in development!", "Coming Soon...", 1);
            }
        }));

        uiManager.addObject(new UIButton(608, 470, BUTTON_WIDTH, BUTTON_HEIGHT,
                Assets.btn_run, new ClickListener(){
            @Override
            public void onClick() {
                player.setBattleTimer(Utils.Random(500, 250));
                handler.getMouseManager().setUIManager(null);
                State.setState(State.getPreviousState());
            }
        }));
        
        pokemonManager.addPokemon(playerPokemon);
        
        pokemonManager.addPokemon(rivalPokemon);
    }
    
    @Override
    public void tick() {
        uiManager.tick();
        pokemonManager.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.battle_background1, 0, 0, handler.getWidth(),
                handler.getHeight(), null);
        uiManager.render(g);
        pokemonManager.render(g);
        
        g.setColor(Color.darkGray);
        g.setFont(new Font("Segoe UI Semibold", 1, 25));
        
        g.drawString(playerPokemon.getName(), 505, 295);
        g.drawString("Lv "+ playerPokemon.getLevel(), 705, 295);
        g.drawString(playerPokemonHP + " / " + playerPokemon.getHit_Points(), 685, 353);
        if (playerPokemonHP <= (playerPokemon.getHit_Points() / 2)
                && playerPokemonHP > (playerPokemon.getHit_Points() / 4)) {
            g.drawImage(Assets.yellow_LifeBar, 610, 313, playerPokemonHPBar, 10, null);
        } else if (playerPokemonHP <= (playerPokemon.getHit_Points() / 4)) {
            g.drawImage(Assets.red_LifeBar, 610, 313, playerPokemonHPBar, 10, null);
        } else {
            g.drawImage(Assets.green_LifeBar, 610, 313, playerPokemonHPBar, 10, null); 
        }
        
        g.drawString(rivalPokemon.getName(), 35, 55);
        g.drawString("Lv " + rivalPokemon.getLevel(), 235, 55);
        
        if (rivalPokemonHP <= (rivalPokemon.getHit_Points() / 2)
                && rivalPokemonHP > (rivalPokemon.getHit_Points() / 4)) {
            g.drawImage(Assets.yellow_LifeBar, 140, 76, rivalPokemonHPBar, 10, null);
        } else if (rivalPokemonHP <= (rivalPokemon.getHit_Points() / 4)) {
            g.drawImage(Assets.red_LifeBar, 140, 76, rivalPokemonHPBar, 10, null);
        } else {
            g.drawImage(Assets.green_LifeBar, 140, 76, rivalPokemonHPBar, 10, null); 
        }
        
        g.setColor(Color.lightGray);
        g.setFont(new Font("Segoe UI Semibold", 0, 35));
        
        switch (buttonPressed) {
            default:
                g.drawString("What will", 40, 470);
                g.drawString(playerPokemon.getName() + " do?", 40, 510);
                break;
            case 1:
                g.drawString(playerPokemon.getName() + " attacked!", 40, 480);
                break;
            case 2:
                
                break;
            case 3:
                
                break;
        }
    }
    
    public int attack(Pokemon attacker, Pokemon hurt) {
        float damage = 0;
        while ((int) damage <= 0) {
            damage = (((2 * (float) attacker.getLevel() + 10) / 250) *
                ((float) attacker.getAttack() / (float) hurt.getDefense()) *
                ((float) Utils.Random(26, 0) + 2));
        }
        return (int) damage;
    }
}
