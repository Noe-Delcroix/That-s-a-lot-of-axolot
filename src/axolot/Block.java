package axolot;

import java.awt.*;

public class Block {

    private boolean hitbox;

    //temp
    private Color color;

    public Block(boolean hitbox,Color color){
        this.hitbox=hitbox;
        this.color=color;

    }

    public Color getColor() {
        return color;
    }
}
