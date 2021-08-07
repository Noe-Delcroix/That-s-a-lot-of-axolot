package axolot;


import java.util.ArrayList;
import java.util.List;

public class Block {

    private boolean hitbox;
    private String id;
    private int dataValue;

    private List<Texture> textures;

    public Block(boolean hitbox,String id){
        this(hitbox,id,0);
    }


    public Block(boolean hitbox,String id,int dataValue){
        this.hitbox=hitbox;
        textures=new ArrayList<Texture>();
        this.id=id;
        this.dataValue=dataValue;
    }

    public void addTexture(Texture texture){
        textures.add(texture);
    }

    public Texture getTexture() {
        if (textures.size()==0)return null;
        return textures.get(0);
    }

    public Texture getTexture(World world,int x,int y) {
        if (textures.size()==0)return null;
        return textures.get((int)(world.getGenerator().getRandomTexture(x,y)*textures.size()));
    }

    public List<Texture> getTextures(){
        return this.textures;
    }
}
