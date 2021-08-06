package axolot;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PVector;

public class Player extends PGraphics {

    PVector pos;
    PVector vel;
    float zoom;

    public Player(float originX,float originY){
        pos=new PVector(originX,originY);
        vel=new PVector(0,0);
        zoom=10;
    }

    public void tick(Main main){

    }

    public float getX(){
        return pos.x;
    }

    public float getY(){
        return pos.y;
    }

    public PVector worldPosToScreenPos(float worldX,float worldY){
        return new PVector((worldX-pos.x)*zoom,(worldY-pos.y)*zoom);
    }

    public PVector screenPosToWorldPos(float screenX,float screenY) {
        return new PVector(screenX / zoom + pos.x, screenY / zoom + pos.y);
    }
}
