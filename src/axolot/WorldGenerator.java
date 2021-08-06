package axolot;

public class WorldGenerator {

    OpenSimplexNoise noise;

    private final int AVERAGE_GROUND_HEIGHT;
    private final double GROUND_DIFF;
    private final double GROUND_SIZE;


    public WorldGenerator(int averageGroundHeight,double groundDiff,double groundSize){
        noise=new OpenSimplexNoise();

        AVERAGE_GROUND_HEIGHT=averageGroundHeight;
        GROUND_DIFF=groundDiff;
        GROUND_SIZE=groundSize;
    }

    public Block getBlock(float x,float y){

        int terrainHeight=(int)(AVERAGE_GROUND_HEIGHT+noise.eval(x/GROUND_SIZE,0)*GROUND_DIFF);
        int topHeight=(int)(4+noise.eval(x/10,0)*2);

        if (y>0){
            if (y>terrainHeight){
                if (y>terrainHeight+topHeight){
                    return Blocks.get("stone");
                }else{
                    return Blocks.get("sand");
                }

            }else{
                return Blocks.get("water");
            }
        }else{
            return Blocks.get("air");
        }
    }
}
