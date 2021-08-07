package axolot;

import axolot.entities.Axolot;

import java.util.ArrayList;
import java.util.List;

public class MobCap {
    private List<Axolot> axolots;
    private int cap;

    public MobCap(List<Axolot> axolots, int cap){
        this.axolots = new ArrayList<>(axolots);
        this.cap = cap;
    }

    public int getCap() {
        return cap;
    }

    public List<Axolot> getEntities() {
        return axolots;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public void setEntities(List<Axolot> axolots) {
        this.axolots = axolots;
    }

    public void render(Main main, World world){
        for (Axolot a:axolots) {
            a.render(main,world);
        }
    }
}
