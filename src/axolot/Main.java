package axolot;

import processing.core.PApplet;

public class Main extends PApplet {
    public static void main(String[] args) {
        PApplet.main("axolot.Game",args);
    }

    public void settings(){
        fullScreen();
    }

    public void setup(){
        World.init();
    }

    public void draw(){
        World.draw();
    }
}
