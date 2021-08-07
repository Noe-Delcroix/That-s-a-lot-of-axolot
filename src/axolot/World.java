package axolot;

import axolot.entities.Axolot;
import axolot.entities.Entities;
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
    private Main main;

    private Texture background;

    public World(Main main){
        generator=new WorldGenerator();
        player=new Player(0,0);

        background=new Texture(main,File.separator+"ressources"+ File.separator+"background.png");

        this.mobCapList = new ArrayList<MobCap>();
        ArrayList<Axolot> kindAxolots = new ArrayList<>();
        MobCap mobCap = new MobCap(kindAxolots,5);
        this.addMobCap(mobCap);
        this.main = main;
        Blocks.init(main);
        Entities.init(main);
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
        spawn();
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
    public void spawn(){
        if (Math.random()<1 ){
            float x;
            float y;
            double r=Math.random();
            if (Math.random()<0.5){
                y = (float)(player.pos.y*(Math.random()*2-1)*Main.height/30/1.9);
                if (Math.random()<0.5){
                    x=(float) (player.pos.x-Main.width/30/1.9-Math.random()*20);
                }else{
                    x=(float) (player.pos.x+Main.width/30/1.9+Math.random()*20);
                }
            }else{
                x = (float)(player.pos.x*(Math.random()*2-1)*Main.width/30/1.9);
                if (Math.random()<0.5){
                    y=(float) (player.pos.y-Main.height/30/1.9-Math.random()*20);
                }else{
                    y=(float) (player.pos.y+Main.height/30/1.9+Math.random()*20);
                }
            }

            if (generator.getBlock(x,y).getId().equals("water")){
                mobCapList.get(0).getEntities().add(new KindAxolot(new PVector(x,y),main));
            }
        }
    }
}
