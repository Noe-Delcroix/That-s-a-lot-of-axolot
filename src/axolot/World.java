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


    public void drawingLoop(Main main) {
        this.tick();
        this.render(main);
    }

    public void tick(){

    }

    public void render(Main main){
        main.background(88, 148, 211,255);
    }
}
