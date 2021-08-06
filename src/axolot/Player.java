package axolot;

public class Player {

    Vector pos;
    Vector vel;

    public Player(float originX,float originY){
        pos=new Vector(originX,originY);
        vel=new Vector(0,0);
    }

    public void tick(){

    }

    public float getX(){
        return pos.x;
    }

    public float getY(){
        return pos.y;
    }
}
