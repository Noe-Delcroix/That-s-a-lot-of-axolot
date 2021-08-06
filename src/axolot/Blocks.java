package axolot;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Blocks {
    public static Map<String,Block> blocks;

    public static void init(Main main){
        blocks=new HashMap<String,Block>();

        blocks.put("air",new Block(false,null));
        blocks.put("water",new Block(false,Texture.forBlock(main,"water")));
        blocks.put("sand",new Block(true,Texture.forBlock(main,"sand")));
        blocks.put("stone",new Block(true,Texture.forBlock(main,"stone")));
    }

    public static Block get(String id){
        return blocks.get(id);
    }
}
