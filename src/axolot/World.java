package axolot;

import processing.core.PGraphics;
import processing.core.PVector;

import java.awt.*;
import java.io.File;

public class World extends PGraphics{

    private WorldGenerator generator;
    private Player player;

    private Texture background;

    public World(Main main){
        generator=new WorldGenerator(30,5,20);
        player=new Player(0,0);

        background=new Texture(main,"ressources"+ File.separator+"background.png");

        Blocks.init(main);
    }

    public Player getPlayer() {
        return player;
    }

    public void drawingLoop(Main main) {
        this.tick(main);
        this.render(main);
    }

    public void tick(Main main){
        player.tick(main);
    }

    public void render(Main main){
        //main.background(86, 178, 239);
        background.render(main,-Main.width/2,-Main.height/2,Main.width,Main.height);
        //main.clear();

        PVector topleft=player.screenPosToWorldPos(-Main.width/2,-Main.height/2);
        PVector bottomright=player.screenPosToWorldPos(Main.width/2,Main.height/2);

        for (int y=(int)Math.floor(topleft.y);y<(int)Math.ceil(bottomright.y);y++){
            for (int x=(int)Math.floor(topleft.x);x<(int)Math.ceil(bottomright.x);x++){
                Block b=generator.getBlock(x,y);
                PVector pos=player.worldPosToScreenPos(x,y);
                Texture texture=b.getTexture();
                if (texture!=null){
                    texture.render(main, pos.x, pos.y, player.getZoom(), player.getZoom());
                }
            }
        }
    }
}
