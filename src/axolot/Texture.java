package axolot;

import processing.core.PGraphics;
import processing.core.PImage;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.List;

public class Texture extends PGraphics {
    private PImage image;

    public Texture(Main main,String path){
        System.out.println("loading texture at "+path);
        image=main.loadImage(path);
    }

    public void addTexture(Main main,Texture other){

        PGraphics fusion= main.createGraphics(Math.max(this.image.width, other.getImg().width), Math.max(this.image.height, other.getImg().height));

        fusion.beginDraw();
        fusion.image(this.image,0,0,this.image.width,this.image.height);
        fusion.image(other.getImg(),0,0,other.getImg().width,other.getImg().height);
        fusion.endDraw();
        this.image=(PImage)fusion;
    }

    public void render(Main main,float screenX,float screenY, float sizeX,float sizeY){
        main.image(image,screenX,screenY,sizeX,sizeY);
        Main.renderCount++;
    }

    public void render(Main main, World world,int worldX,int worldY, float sizeX,float sizeY){
        PVector pos=world.getPlayer().worldPosToScreenPos(worldX,worldY);
        main.image(image,(int)pos.x,(int)pos.y,sizeX,sizeY);
        Main.renderCount++;
    }

    public PImage getImg() {
        return image;
    }
}
