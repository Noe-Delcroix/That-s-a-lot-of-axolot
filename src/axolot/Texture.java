package axolot;

import processing.core.PGraphics;
import processing.core.PImage;

import java.io.File;

public class Texture extends PGraphics {
    protected PImage img;

    public Texture(Main main,String path){
        System.out.println("loading texture at "+path);
         img=main.loadImage(path);
    }

    public PImage getImg() {
        return img;
    }

    public void render(Main main,float x,float y,float w,float h){
        main.image(this.img,x,y,w,h);
        Main.renderCount++;
    }
}
