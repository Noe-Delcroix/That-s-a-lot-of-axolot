package axolot;

public class WorldGenerator {


    public WorldGenerator(){

    }

    public Block getBlock(int x,int y){

        if (y>2){
            if (Math.random()<0.5){
                return Blocks.get("water");
            }else{
                return Blocks.get("wall");
            }
        }else{
            return Blocks.get("air");
        }
    }
}
