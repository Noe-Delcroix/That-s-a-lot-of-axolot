package axolot;


import java.util.ArrayList;
import java.util.List;

public class Block {

    private boolean hitbox;
    private String id;
    private List<Texture> textures;

    public Block(boolean hitbox,String id){
        this.hitbox=hitbox;
        textures=new ArrayList<Texture>();
        this.id=id;
    }

    public Block(boolean hitbox,String id,Texture texture){
        this(hitbox,id);
        textures.add(texture);
    }

    public Block(boolean hitbox,String id,List<Texture> textures){
        this.hitbox=hitbox;
        this.textures=textures;
        this.id=id;
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
