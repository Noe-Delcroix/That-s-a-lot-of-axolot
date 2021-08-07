package axolot;

import processing.core.PApplet;
import processing.event.MouseEvent;

import java.awt.*;

public class Main extends PApplet {
    public World world;

    public static int width;
    public static int height;

    public static int renderCount=0;

    public static void main(String[] args) {
        PApplet.main("axolot.Main",args);
    }

    public void settings(){
        noSmooth();

        fullScreen();
        width=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        height=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        /*width=960;
        height=540;
        size(width,height);*/



        System.out.println("Screen Size : w="+width+"h= "+height);
    }

    public void setup(){
        frameRate(60);
        world=new World(this);
    }

    public void draw(){
        renderCount=0;
        translate(width/2,height/2);
        this.world.drawingLoop(this);

        fill(255,255,0);
        stroke(0,0,0);
        textAlign(LEFT,TOP);
        textSize(30);
        text("Fps:"+(int)frameRate+" Renders:"+renderCount,-width/2,-height/2);


    }

    public void mouseWheel(MouseEvent event) {
        world.getPlayer().changeZoom(event.getCount(),this);
    }

}
