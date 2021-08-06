package axolot;

import processing.core.PApplet;

public class Main extends PApplet {
    public World world;

    public static void main(String[] args) {
        PApplet.main("axolot.Main",args);
    }

    public void settings(){
        fullScreen();
    }

    public void setup(){
        world=new World();
    }

    public void draw(){
        this.world.drawingLoop();
    }
}
