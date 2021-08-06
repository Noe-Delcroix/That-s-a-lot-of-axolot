package axolot;


public class World {

    private static WorldGenerator generator;
    private static Player player;

    public static void init() {
        World.generator=new WorldGenerator();
        player=new Player(0,0);

        Blocks.init();
    }

    public static void draw() {
        World.tick();
        World.render(player);
    }

    public static void tick(){

    }

    public static void render(Player player){

    }
}
