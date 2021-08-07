package axolot;

import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Blocks {
    public static Map<String,Block> blocks;

    public static void init(Main main){
        blocks=new HashMap<String,Block>();

        String path="ressources"+File.separator+"blocks"+File.separator;

        blocks.put("air",new Block(false,null));
        blocks.put("water",new Block(false,new Texture(main,path+"water"+".png")));
        blocks.put("sand",new Block(true,new Texture(main,path+"sand"+".png")));
        blocks.put("stone",new Block(true,new Texture(main,path+"stone"+".png")));
    }

    public static Block get(String id){
        return blocks.get(id);
    }
}
