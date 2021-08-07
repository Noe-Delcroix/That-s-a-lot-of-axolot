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

    public Texture(Main main,int width,int height, int r, int g, int b,int a){
        System.out.println("creating texture with size "+width+"x"+height);

        PGraphics fusion= main.createGraphics(width,height);
        fusion.beginDraw();
        fusion.background(r,g,b,a);
        fusion.endDraw();

        this.image=(PImage)fusion;
    }

    public void addTexture(Main main,Texture other){

        PGraphics fusion= main.createGraphics(Math.max(this.image.width, other.getImg().width), Math.max(this.image.height, other.getImg().height));

        fusion.beginDraw();
        fusion.image(this.image,0,0,fusion.width,fusion.height);
        fusion.image(other.getImg(),0,0,fusion.width,fusion.height);
        fusion.endDraw();
        this.image=(PImage)fusion;
    }

    public void render(Main main,float screenX,float screenY, float sizeX,float sizeY){
        main.image(image,screenX,screenY,sizeX,sizeY);
        Main.renderCount++;
    }

    public void render(Main main, World world,float worldX,float worldY, float sizeX,float sizeY){
        PVector pos=world.getPlayer().worldPosToScreenPos(worldX,worldY);
        main.image(image,(int)pos.x,(int)pos.y,sizeX*world.getPlayer().getZoom(),sizeY*world.getPlayer().getZoom());
        Main.renderCount++;
    }

    public PImage getImg() {
        return image;
    }
}
