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

        List<Texture> textures=new ArrayList<Texture>();
        Texture texture;

        String path="ressources"+ File.separator+"blocks"+File.separator;

        blocks.put("air",new Block(false,"air"));
        Texture water=new Texture(main,path+"water"+".png");
        //Texture water=new Texture(main,16,16,0,0,255,100);
        blocks.put("water",new Block(false,"water",water));

        textures=new ArrayList<Texture>();
        textures.add(new Texture(main,path+"sand.png"));
        textures.add(new Texture(main,path+"sand2.png"));
        textures.add(new Texture(main,path+"sand3.png"));
        textures.add(new Texture(main,path+"sand4.png"));
        for(Texture t : textures)t.addTexture(main,water);
        blocks.put("sand",new Block(true,"sand",textures));

        textures=new ArrayList<Texture>();
        textures.add(new Texture(main,path+"stone.png"));
        textures.add(new Texture(main,path+"stone2.png"));
        textures.add(new Texture(main,path+"stone3.png"));
        textures.add(new Texture(main,path+"stone4.png"));
        for(Texture t : textures)t.addTexture(main,water);
        blocks.put("stone",new Block(true,"stone",textures));


        textures=new ArrayList<Texture>();
        textures.add(new Texture(main,path+"kelp.png"));
        textures.add(new Texture(main,path+"kelp2.png"));
        textures.add(new Texture(main,path+"kelp3.png"));
        for(Texture t : textures)t.addTexture(main,water);
        blocks.put("kelp",new Block(true,"kelp",textures));

        texture=new Texture(main,path+"kelp_top.png");
        texture.addTexture(main,water);
        blocks.put("kelp_top",new Block(false,"kelp_top",texture));

        texture=new Texture(main,path+"coral.png");
        texture.addTexture(main,water);
        blocks.put("coral",new Block(false,"coral",texture));
    }

    public static Block get(String id){
        return blocks.get(id);
    }
}
