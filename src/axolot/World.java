package axolot;

import processing.core.PGraphics;
import processing.core.PVector;

import java.awt.*;

public class World extends PGraphics{

    private WorldGenerator generator;
    private Player player;



    public World(){
        generator=new WorldGenerator();
        player=new Player(0,0);

        Blocks.init();
    }


    public void drawingLoop(Main main) {
        this.tick();
        this.render(main);
    }

    public void tick(){
        player.pos.x+=0.01;
        player.pos.y+=0.1;
    }

    public void render(Main main){
        main.background(88, 148, 211,255);

        PVector topleft=player.screenPosToWorldPos(-Main.width/2,-Main.height/2);
        PVector bottomright=player.screenPosToWorldPos(Main.width/2,Main.height/2);

        for (int y=(int)Math.floor(topleft.y);y<(int)Math.ceil(bottomright.y);y++){
            for (int x=(int)Math.floor(topleft.x);x<(int)Math.ceil(bottomright.x);x++){
                Block b=generator.getBlock(x,y);
                Color c=b.getColor();
                PVector pos=player.worldPosToScreenPos(x,y);
                main.fill(c.getRed(),c.getGreen(),c.getBlue(),c.getAlpha());
                main.noStroke();
                main.rect(pos.x,pos.y,player.zoom,player.zoom);

                //System.out.println("x="+x+" y="+y);
            }
        }
    }
}
