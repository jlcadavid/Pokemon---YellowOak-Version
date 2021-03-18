/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author EQUIPO
 */
public class UIButton extends UIObject {
    
    private String buttonText;
    private BufferedImage[] buttonImages;
    private ClickListener click;
    private int state;

    public UIButton(float x, float y, int width, int height, String buttonText, ClickListener click) {
        super(x, y, width, height);
        this.buttonText = buttonText;
        this.click = click;
        this.state = 0;
        
    }
    
    public UIButton(float x, float y, int width, int height, BufferedImage[] buttonImages, ClickListener click){
        super(x, y, width, height);
        this.buttonImages = buttonImages;
        this.click = click;
        this.state = 1;
        
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        switch(state) {
            case 0:
                if (!hovering) {
                    g.setColor(Color.white);
                    g.drawRect((int) x, (int) y, width, height);
                    g.setFont(new Font("Segoe UI Semibold", 0, 18));
                    g.drawString(buttonText, (int) x + (width / 6) - 8, (int) y + (height / 2) + 6);
                } else {
                    g.setColor(Color.yellow);
                    g.drawRect((int) x, (int) y, width, height);
                    g.setFont(new Font("Segoe UI Semibold", 2, 18));
                    g.drawString(buttonText, (int) x + (width / 6) - 8, (int) y + (height / 2) + 6);
                }
            break;
            case 1:
                if (!hovering) {
                    g.drawImage(buttonImages[0], (int) x, (int) y, width, height, null);
//                    g.setColor(Color.red);
//                    g.drawRect((int) x - 1, (int) y - 1, width + 1, height + 1);
                } else{
                    g.drawImage(buttonImages[1], (int) x, (int) y, width, height, null);
//                    g.setColor(Color.red);
//                    g.drawRect((int) x - 1, (int) y - 1, width + 1, height + 1);
                }
                break;
        }
        
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public void onClick() {
        click.onClick();
    }
    
}
