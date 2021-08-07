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

    public int terrainHeight(float x){
        return (int)(AVERAGE_GROUND_HEIGHT+noise.eval(x/GROUND_SIZE,0)*GROUND_DIFF);
    }

    public int topHeight(float x){
        return (int)(4+noise.eval(x/10,0)*2);
    }

    public boolean isCave(float x,float y){
        return noise.eval(x/10,y/5)>-0.3 && noise.eval(x/100,y/100)>0.3;
    }

    public float getRandomTexture(int x,int y){
        return (float)((noise.eval(x,y)+1)/2);
    }

    public Block getBlock(float x,float y){

        if (y>0){
            if (y>this.terrainHeight(x) && !isCave(x,y)){
                if (y>this.terrainHeight(x)+this.topHeight(x)){
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
