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
        zoom=40;
    }

    public void tick(Main main){
        if (main.mousePressed){
            if (main.mouseButton == LEFT){
                pos.x+=(main.pmouseX-main.mouseX)/zoom;
                pos.y+=(main.pmouseY-main.mouseY)/zoom;
                if (pos.y<0)pos.y=0;
            }
        }
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

    public float getZoom() {
        return zoom;
    }

    public void setZoom(float zoom) {
        this.zoom = zoom;
    }

    public void changeZoom(int a,Main main){
        PVector previous=this.screenPosToWorldPos(main.mouseX-Main.width/2,main.mouseY-Main.height/2);
        if(a==-1){
            if (zoom<Math.min(Main.width,Main.height)){
                zoom*=1.1;
            }
        }else{
            if (zoom>30){
                zoom*=0.9;
            }

        }
        PVector next=this.screenPosToWorldPos(main.mouseX-Main.width/2,main.mouseY-Main.height/2);
        this.pos.x+=(previous.x-next.x);
        this.pos.y+=(previous.y-next.y);

    }
}
