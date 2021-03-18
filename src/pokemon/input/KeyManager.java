/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import pokemon.game.Handler;

/**
 *
 * @author EQUIPO
 */
public class KeyManager implements KeyListener{
    
    private Handler handler;
    private boolean[] keys;
    
    public boolean up, down, left, right;
    public int lastPressed = 3;
    
    public KeyManager(){
        keys = new boolean[256];
    }
    
    private int lastPressed(KeyEvent e){
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    return lastPressed = 0;
                case KeyEvent.VK_RIGHT:
                    return lastPressed = 1;
                case KeyEvent.VK_UP:
                    return lastPressed = 2;
                case KeyEvent.VK_DOWN:
                    return lastPressed = 3;
                default:
                    return lastPressed;
            }
    }
    
    public void tick(){
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        lastPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
    
}
