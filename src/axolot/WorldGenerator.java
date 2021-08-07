package axolot;

public class WorldGenerator {

    OpenSimplexNoise noise;

    private final int AVERAGE_GROUND_HEIGHT=25;
    private final double GROUND_DIFF=5;
    private final double GROUND_SIZE=20;

    private final double MAX_KELP_HEIGHT=10;
    private final double KELP_AMOUNT=0.5; //entre 0 et 1
    private final double KELP_GROWTH=0.5; //entre 0 et 1


    public WorldGenerator(){
        noise=new OpenSimplexNoise();
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

    public int kelpHeight(float x){
        if (noise.eval(x*10,0)<0){
            return 0;
        }else{
            return (int)(10+noise.eval(x*10,0)*5);
        }
    }

    public float getRandomTexture(int x,int y){
        return (float)((noise.eval(x,y)+1)/2);
    }

    public Block getBlock(float x,float y){

        if (y>0) {
            if (y > this.terrainHeight(x) && !isCave(x, y)) {
                if (y > this.terrainHeight(x) + this.topHeight(x)) {
                    return Blocks.get("stone");
                }
                return Blocks.get("sand");
            }


            Block under=getBlock(x,y+1);
            if ( noise.eval(x*10,0)<KELP_AMOUNT*2-1 && under==Blocks.get("sand")) {
                return Blocks.get("kelp");
            }else if (under==Blocks.get("kelp")){
                if  (noise.eval(x*10,y*10)<KELP_GROWTH*2-1 && y>this.terrainHeight(x)-MAX_KELP_HEIGHT && y>=2){
                    return Blocks.get("kelp");
                }else{
                    return Blocks.get("kelp_top");
                }
            }


            return Blocks.get("water");
        }
        return Blocks.get("air");
    }
}
