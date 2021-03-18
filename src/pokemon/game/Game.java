/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.game;

import pokemon.display.Display;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import pokemon.input.KeyManager;
import pokemon.gfx.Assets;
import pokemon.gfx.GameCamera;
import pokemon.input.MouseManager;
import pokemon.states.MenuState;
import pokemon.states.State;

/**
 *
 * @author jlcadavid
 */
public class Game implements Runnable {    
    
    private Display display;
    private final int width, height;   
    public String title;
    
    private boolean running;
    private Thread thread;
    
    private BufferStrategy bs;
    private Graphics g;
    
    public State gameState;
    public State menuState;
    public State battleState;
    
    private final KeyManager keyManager;
    private final MouseManager mouseManager;
    
    private GameCamera gameCamera;
    
    private Handler handler;
    
    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
    }
    
    private void init(){
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();
        
        handler = new Handler(this);
        gameCamera = new GameCamera(handler, 0, 0);
        
        State.setState(new MenuState(handler));
    }
   
    private void tick(){
        keyManager.tick();
        
        if(State.getState() != null){
            State.getState().tick();
        }
    }
    
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        
        g = bs.getDrawGraphics();
        
        g.clearRect(0, 0, width, height);
        
        if(State.getState() != null){
            State.getState().render(g);
        }
        
        bs.show();
        g.dispose();
    }
    
    @Override
    public void run() {
        init();
        
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;
        
        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
            
            if(delta >= 1){
                tick();
                render();
                ticks++;
                delta--;
            }
            if (timer >= 1000000000) {
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }
    
    public KeyManager getKeyManager(){
        return keyManager;
    }
    
    public MouseManager getMouseManager(){
        return mouseManager;
    }
    
    public GameCamera getGameCamera(){
        return gameCamera;
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public synchronized void start(){
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public synchronized void stop(){
        if (!running) 
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
