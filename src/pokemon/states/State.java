/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.states;

import java.awt.Graphics;
import pokemon.game.Handler;

/**
 *
 * @author EQUIPO
 */
public abstract class State {
    
    private static State currentState;
    private static State previousState;
    
    public static void setState(State state){
        previousState = currentState;
        currentState = state;
    }
    
    public static State getState(){
        return currentState;
    }
    
    public static State getPreviousState(){
        return previousState;
    }
    
    public static void setPreviousState(State state) {
        previousState = state;
    }
    
    protected Handler handler;
    
    public State(Handler handler){
        this.handler = handler;
    }
    
    public abstract void tick();
    
    public abstract void render(Graphics g);
    
}
