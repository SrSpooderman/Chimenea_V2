import java.awt.*;

public class ColorTarget {
    private int temperature;
    private Color color;

    public ColorTarget(int temperature, Color color) {
        this.temperature = temperature;
        this.color = color;
    }
    public int getA(){
        return color.getAlpha();
    }

    public int getR(){
        return color.getRed();
    }

    public int getG(){
        return color.getGreen();
    }

    public int getB(){
        return color.getBlue();
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
