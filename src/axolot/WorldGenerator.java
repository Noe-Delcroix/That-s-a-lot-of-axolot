package axolot;

public class WorldGenerator {

    OpenSimplexNoise noise;

    private final int AVERAGE_GROUND_HEIGHT=25;
    private final double GROUND_DIFF=5;
    private final double GROUND_SIZE=20;

    private final double MAX_KELP_HEIGHT=10;
    private final double KELP_AMOUNT=0.5; //entre 0 et 1
    private final double KELP_GROWTH=0.8; //entre 0 et 1

    private final double CORAL_AMOUNT=1; //entre 0 et 1

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

    public boolean isKelpStart(float x,float y){
        return noise.eval(x*10,y*10)<(KELP_AMOUNT*2+1)-y*0.01 && getBlock(x,y+1).equals(Blocks.get("sand"));
    }

    public int kelpHeight(float x,float y){
        return (int) ( MAX_KELP_HEIGHT - ((noise.eval(x*10,y*10)+1)/2)*MAX_KELP_HEIGHT );
    }


    public Block getBlock(float x,float y){

        if (y>0) {
            if (y > this.terrainHeight(x) && !isCave(x, y)) {
                if (y > this.terrainHeight(x) + this.topHeight(x)) {
                    return Blocks.get("stone");
                }
                return Blocks.get("sand");
            }

            if (isKelpStart(x,y)){
                return Blocks.get("kelp");
            }

            return Blocks.get("water");
        }
        return Blocks.get("air");
    }

    public float getRandomTexture(int x,int y){
        return (float)((noise.eval(x,y)+1)/2);
    }
}
