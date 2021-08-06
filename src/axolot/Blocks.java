package axolot;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Blocks {
    public static Map<String,Block> blocks;

    public static void init(){
        blocks=new HashMap<String,Block>();

        blocks.put("air",new Block(false,"air",new Color(0,0,0,0)));
        blocks.put("water",new Block(false,"water",new Color(0,255,255,128)));
        blocks.put("wall",new Block(true,"wall",new Color(255,255,0)));
    }

    public static Block get(String id){
        return blocks.get(id);
    }
}
