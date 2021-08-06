package axolot;

import java.awt.*;

public class Block {

    private boolean hitbox;
    private Texture texture;

    public Block(boolean hitbox,Texture texture){
        this.hitbox=hitbox;
        this.texture=texture;

    }

    public Texture getTexture() {
        return texture;
    }
}
