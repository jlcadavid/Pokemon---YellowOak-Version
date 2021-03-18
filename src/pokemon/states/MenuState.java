/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.states;

import java.awt.Graphics;
import javax.swing.JOptionPane;
import pokemon.UI.ClickListener;
import pokemon.UI.UIButton;
import pokemon.UI.UIManager;
import pokemon.game.Handler;
import pokemon.gfx.Assets;

/**
 *
 * @author EQUIPO
 */
public class MenuState extends State {
    
    private final UIManager uiManager;
    private static final int BUTTON_WIDTH = 112, BUTTON_HEIGHT = 56;
    
    public MenuState(final Handler handler){
        super (handler);
       
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUIManager(uiManager);

        uiManager.addObject(new UIButton(400, 464, BUTTON_WIDTH, BUTTON_HEIGHT, "New Game", new ClickListener(){
            @Override
            public void onClick() {
                handler.getMouseManager().setUIManager(null);
                State.setState(new GameState(handler));
            }
        }));

        uiManager.addObject(new UIButton(536, 464, BUTTON_WIDTH, BUTTON_HEIGHT, "Load Game", new ClickListener(){
            @Override
            public void onClick() {
                JOptionPane.showMessageDialog(null, "Still in development!", "Coming Soon...", 1);
            }
        }));

        uiManager.addObject(new UIButton(672, 464, BUTTON_WIDTH, BUTTON_HEIGHT, "  Settings", new ClickListener(){
            @Override
            public void onClick() {
                JOptionPane.showMessageDialog(null, "Still in development!", "Coming Soon...", 1);

            }
        }));
    }
    
    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.menu_animation, 0, 0, handler.getWidth(), handler.getHeight(), null);
        g.drawImage(Assets.menu_logo, 0, 88, 436, 478, null);
        uiManager.render(g);
    }
    
}
