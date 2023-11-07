import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class DTOPaletteParameters {
    private ArrayList<ColorTarget> colorsTarget = new ArrayList<ColorTarget>();

    public DTOPaletteParameters() {
        this.addColorTarget(new ColorTarget(0,new Color(0, 0, 0,0)));
    }

    public void addColorTarget(ColorTarget Target){
        this.colorsTarget.add(Target);
        Collections.sort(this.colorsTarget, (color1, color2) -> Integer.compare(color1.getTemperature(), color2.getTemperature()));
    }

    public ArrayList<ColorTarget> getColorsTarget() {
        return colorsTarget;
    }

    public void setColorsTarget(ArrayList<ColorTarget> colorsTarget) {
        this.colorsTarget = colorsTarget;
    }
}
