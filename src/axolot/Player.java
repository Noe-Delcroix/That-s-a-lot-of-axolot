package axolot;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PVector;

public class Player extends PGraphics {

    PVector pos;
    PVector vel;

    public Player(float originX,float originY){
        pos=new PVector(originX,originY);
        vel=new PVector(0,0);
    }

    public void tick(){

    }

    public float getX(){
        return pos.x;
    }

    public float getY(){
        return pos.y;
    }
}
