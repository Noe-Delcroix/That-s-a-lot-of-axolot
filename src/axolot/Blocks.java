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

        String path="ressources"+ File.separator+"blocks"+File.separator;

        blocks.put("air",new Block(false));
        Texture water=new Texture(main,path+"water"+".png");
        blocks.put("water",new Block(false,water));

        textures=new ArrayList<Texture>();
        textures.add(new Texture(main,path+"sand.png"));
        textures.add(new Texture(main,path+"sand2.png"));
        textures.add(new Texture(main,path+"sand3.png"));
        textures.add(new Texture(main,path+"sand4.png"));
        for(Texture texture : textures)texture.addTexture(main,water);
        blocks.put("sand",new Block(true,textures));

        textures=new ArrayList<Texture>();
        textures.add(new Texture(main,path+"stone.png"));
        textures.add(new Texture(main,path+"stone2.png"));
        textures.add(new Texture(main,path+"stone3.png"));
        textures.add(new Texture(main,path+"stone4.png"));
        for(Texture texture : textures)texture.addTexture(main,water);
        blocks.put("stone",new Block(true,textures));
    }

    public static Block get(String id){
        return blocks.get(id);
    }
}
