package axolot;

public class WorldGenerator {

    public WorldGenerator(){

    }

    public Block getBlock(int x,int y){
        Block b;

        if (y>2){
            if (x%3==0 && y%3==0){
                b= Blocks.get("wall");
            }else {
                b= Blocks.get("water");
            }
        }else{
            b= Blocks.get("air");
        }

        System.out.println("Returned "+b.getId());
        return b;
    }
}
