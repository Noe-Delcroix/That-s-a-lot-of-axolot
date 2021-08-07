package axolot;


import java.util.ArrayList;
import java.util.List;

public class Block {

    private boolean hitbox;
    private List<Texture> textures;

    public Block(boolean hitbox){
        this.hitbox=hitbox;
        textures=new ArrayList<Texture>();
    }

    public Block(boolean hitbox,Texture texture){
        this(hitbox);
        textures.add(texture);
    }

    public Block(boolean hitbox,List<Texture> textures){
        this.hitbox=hitbox;
        this.textures=textures;
    }

    public Texture getTexture() {
        if (textures.size()==0)return null;
        return textures.get(0);
    }

    public Texture getTexture(World world,int x,int y) {
        if (textures.size()==0)return null;
        return textures.get((int)(world.getGenerator().getRandomTexture(x,y)*textures.size()));
    }
}
