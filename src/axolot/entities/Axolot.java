package axolot.entities;

import axolot.Main;
import axolot.Texture;
import axolot.World;
import processing.core.PVector;

public class Axolot extends Entity{
    public Axolot(PVector pos, Texture sprite) {
        super(pos, sprite);
    }
    public void render(Main main, World world){
        this.sprite.render(main,world,pos.x,pos.y,1,1);
    }
}
