package axolot;

import processing.core.PApplet;

public class Main extends PApplet {
    public World world;

    public static final int WIDTH=800;
    public static final int HEIGHT=450;

    public static void main(String[] args) {
        PApplet.main("axolot.Main",args);
    }

    public void settings(){
        size(WIDTH,HEIGHT);
        //fullScreen();
    }

    public void setup(){
        world=new World();
        translate(WIDTH/2,HEIGHT/2);
    }

    public void draw(){
        this.world.drawingLoop(this);
        noLoop();
    }

}
