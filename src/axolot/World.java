package axolot;

import processing.core.PGraphics;

public class World extends PGraphics{

    private WorldGenerator generator;
    private Player player;

    public World(){
        generator=new WorldGenerator();
        player=new Player(0,0);

        Blocks.init();
    }


    public void drawingLoop() {
        this.tick();
        this.render();
    }

    public void tick(){

    }

    public void render(){
        background(255,0,0,0);
    }
}
