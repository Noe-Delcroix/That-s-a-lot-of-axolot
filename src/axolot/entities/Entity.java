package axolot.entities;

import axolot.Texture;
import processing.core.PVector;

public class Entity {
    protected PVector pos;
    protected Texture sprite;


    public Entity(PVector pos,Texture sprite){
        this.pos = pos;
        this.sprite = sprite;
    }
}
