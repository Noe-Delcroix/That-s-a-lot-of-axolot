package axolot;

import processing.core.PGraphics;
import processing.core.PImage;

import java.io.File;

public class Texture extends PGraphics {
    private PImage img;

    public Texture(Main main,String path){
        System.out.println("loading texture at "+path);
         img=main.loadImage(path);
    }

    public PImage getImg() {
        return img;
    }

    public static Texture forBlock(Main main,String id){
        String path="ressources"+ File.separator+"blocks"+File.separator+id+".png";
        return new Texture(main,path);
    }

    public void render(Main main,float x,float y,float w,float h){
        main.image(this.img,x,y,w,h);
        Main.renderCount++;
    }
}
