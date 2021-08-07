package axolot.entities;

import axolot.Main;
import axolot.Texture;
import processing.core.PVector;

import java.io.File;

public class KindAxolot extends Axolot{
    public KindAxolot(PVector pos, Main main) {
        super(pos, Entities.get("kindaxolot"));
    }
}
