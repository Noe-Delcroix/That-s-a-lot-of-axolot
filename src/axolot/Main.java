package axolot;

import processing.core.PApplet;
import processing.event.MouseEvent;

import java.awt.*;

public class Main extends PApplet {
    public World world;

    public static int width;
    public static int height;

    public static void main(String[] args) {
        PApplet.main("axolot.Main",args);
    }

    public void settings(){
        fullScreen();

        width=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        height=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        System.out.println("Screen Size : w="+width+"h= "+height);
    }

    public void setup(){
        world=new World();
    }

    public void draw(){
        translate(width/2,height/2);
        this.world.drawingLoop(this);
    }

    public void mouseWheel(MouseEvent event) {
        world.getPlayer().changeZoom(event.getCount());
    }

}
