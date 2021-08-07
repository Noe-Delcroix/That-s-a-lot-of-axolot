package axolot;

import axolot.entities.Axolot;
import axolot.entities.KindAxolot;
import processing.core.PGraphics;
import processing.core.PVector;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class World extends PGraphics{

    private WorldGenerator generator;
    private Player player;
    private ArrayList<MobCap> mobCapList;

    private Texture background;

    public World(Main main){
        generator=new WorldGenerator();
        player=new Player(0,0);

        background=new Texture(main,File.separator+"ressources"+ File.separator+"background.png");

        this.mobCapList = new ArrayList<MobCap>();
        KindAxolot k = new KindAxolot(new PVector(5f,5f),main);
        ArrayList<Axolot> kindAxolots = new ArrayList<>();
        kindAxolots.add(k);
        MobCap mobCap = new MobCap(kindAxolots,5);
        this.addMobCap(mobCap);

        Blocks.init(main);
    }

    public Player getPlayer() {
        return player;
    }

    public WorldGenerator getGenerator() {
        return generator;
    }

    public void drawingLoop(Main main) {
        this.tick(main);
        this.render(main);
    }

    public void addMobCap(MobCap mobCap){
        this.mobCapList.add(mobCap);
    }

    public void addMobCap(List<Axolot> axolots, int cap){
        this.mobCapList.add(new MobCap(axolots,cap));
    }

    public void tick(Main main){
        player.tick(main);
    }

    public void render(Main main){
        //main.background(86, 178, 239);
        background.render(main,-Main.width/2,-Main.height/2,Main.width,Main.height);
        //main.clear();

        for (MobCap m:mobCapList) {
            m.render(main,this);
        }

        PVector topleft=player.screenPosToWorldPos(-Main.width/2,-Main.height/2);
        PVector bottomright=player.screenPosToWorldPos(Main.width/2,Main.height/2);

        for (int y=(int)Math.floor(topleft.y);y<(int)Math.ceil(bottomright.y);y++){
            for (int x=(int)Math.floor(topleft.x);x<(int)Math.ceil(bottomright.x);x++){
                Block b=generator.getBlock(x,y);
                Texture texture=b.getTexture(this,x,y);
                if (texture!=null){
                    texture.render(main, this,x, y, 1, 1);
                }
            }
        }
    }
}
