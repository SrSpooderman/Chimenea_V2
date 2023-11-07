import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class DTOPaletteParameters {
    private ArrayList<ColorTarget> colorsTarget = new ArrayList<ColorTarget>();

    public DTOPaletteParameters() {
        this.addColorTarget(new ColorTarget(0,new Color(0, 0, 0,0)));
        this.addColorTarget(new ColorTarget(255,new Color(255,255,255,255)));
    }

    public void addColorTarget(ColorTarget target){
        int existingIndex = -1;
        for (int i = 0; i < colorsTarget.size(); i++) {
            if (colorsTarget.get(i).getTemperature() == target.getTemperature()) {
                existingIndex = i;
                break;
            }
        }

        if (existingIndex != -1) {
            colorsTarget.set(existingIndex, target);
        } else {
            colorsTarget.add(target);
        }
        Collections.sort(this.colorsTarget, (color1, color2) -> Integer.compare(color1.getTemperature(), color2.getTemperature()));
    }

    public ArrayList<ColorTarget> getColorsTarget() {
        return colorsTarget;
    }

    public void setColorsTarget(ArrayList<ColorTarget> colorsTarget) {
        this.colorsTarget = colorsTarget;
    }
}
