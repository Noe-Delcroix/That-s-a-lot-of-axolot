package axolot;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Blocks {
    public static Map<String,Block> blocks;

    public static void init(Main main){
        blocks=new HashMap<String,Block>();

        String path="ressources"+ File.separator+"blocks"+File.separator;
        Block b;

        b=new Block(false,"air");
        blocks.put("air",b);

        b=new Block(false,"water");
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

    }

    public static Block get(String id){
        return blocks.get(id);
    }
}
