package axolot.entities;

import axolot.Block;
import axolot.Main;
import axolot.Texture;
import processing.core.PVector;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Entities {
    public static Map<String, Texture> entities;

    public static void init(Main main){
        entities=new HashMap<String,Texture>();

        String path=File.separator+"ressources"+ File.separator+"entities"+File.separator;

        entities.put("kindaxolot",new Texture(main,path+"axolotl_gentil.png"));

        /*b=new Block(false,"water");
        blocks.put("water",b);
        Texture waterOverlay=new Texture(main,path+"water"+".png");
        b.addTexture(waterOverlay);




        b=new Block(true,"sand");
        blocks.put("sand",b);
        b.addTexture(new Texture(main,path+"sand.png"));
        b.addTexture(new Texture(main,path+"sand2.png"));
        b.addTexture(new Texture(main,path+"sand3.png"));
        b.addTexture(new Texture(main,path+"sand4.png"));
        for (Texture t : b.getTextures())t.addTexture(main,waterOverlay);

        b=new Block(true,"stone");
        blocks.put("stone",b);
        b.addTexture(new Texture(main,path+"stone.png"));
        b.addTexture(new Texture(main,path+"stone2.png"));
        b.addTexture(new Texture(main,path+"stone3.png"));
        b.addTexture(new Texture(main,path+"stone4.png"));
        for (Texture t : b.getTextures())t.addTexture(main,waterOverlay);

        b=new Block(true,"kelp");
        blocks.put("kelp",b);
        b.addTexture(new Texture(main,path+"kelp.png"));
        b.addTexture(new Texture(main,path+"kelp2.png"));
        b.addTexture(new Texture(main,path+"kelp3.png"));
        for (Texture t : b.getTextures())t.addTexture(main,waterOverlay);

        b=new Block(false,"kelp_top");
        blocks.put("kelp_top",b);
        b.addTexture(new Texture(main,path+"kelp_top.png"));
        for (Texture t : b.getTextures())t.addTexture(main,waterOverlay);

        b=new Block(false,"coral");
        blocks.put("coral",b);
        b.addTexture(new Texture(main,path+"coral.png"));
        b.addTexture(new Texture(main,path+"coral2.png"));
        b.addTexture(new Texture(main,path+"coral3.png"));
        b.addTexture(new Texture(main,path+"coral4.png"));
        b.addTexture(new Texture(main,path+"coral5.png"));
        for (Texture t : b.getTextures())t.addTexture(main,waterOverlay);
        */
    }

    public static Texture get(String id){
        return entities.get(id);
    }
}

