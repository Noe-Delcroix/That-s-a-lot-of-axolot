package axolot;

import java.awt.*;

public class Block {

    private boolean hitbox;
    private String id;

    //temp
    private Color color;

    public Block(boolean hitbox,String id,Color color){
        this.hitbox=hitbox;
        this.id=id;
        this.color=color;

    }

    public Color getColor() {
        return color;
    }

    public String getId() {
        return id;
    }
}
