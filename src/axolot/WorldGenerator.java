package axolot;

public class WorldGenerator {

    OpenSimplexNoise noise;


    public WorldGenerator(){
        noise=new OpenSimplexNoise();
    }

    public Block getBlock(int x,int y){

        if (y>2){
            if (noise.eval(((double)x)/10,((double)y)/10)>0.4){
                return Blocks.get("water");
            }else{
                return Blocks.get("wall");
            }
        }else{
            return Blocks.get("air");
        }
    }
}
