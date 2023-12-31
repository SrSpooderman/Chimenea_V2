import java.awt.*;
import java.awt.image.BufferedImage;

public class FireModel extends BufferedImage {
    private int width;
    private int height;
    private Temperatures temperatures;
    private ColorPalette palette;

    public FireModel(DTOTemperatureParameters DTOTemperatureParameters,DTOPaletteParameters DTOPaletteParameters,int width, int height) {
        super(width, height, BufferedImage.TYPE_INT_ARGB);
        this.width = width;
        this.height = height;
        this.temperatures = new Temperatures(DTOTemperatureParameters,width, height);
        this.palette = new ColorPalette(DTOPaletteParameters);
        palette.calc();
    }

    private void createFireImage(){
        this.temperatures.next();
        ColorTarget color;

        setTransparent();

        for (int w = 0; w < this.width; w++) {
            for (int h = 0; h < this.height-1; h++) {
                int temperature = this.temperatures.getTemp(w, h);
                if (temperature > 0) {
                    color = palette.getColor(temperature);
                    super.setRGB(w, h, color.getColor().getRGB());
                }
            }
        }
    }

    public void setTransparent(){
        for (int w=0; w<this.width; w++){
            for (int h=0; h<this.height; h++){
                this.setRGB(w,h,new Color(0,0,0,0).getRGB());
            }
        }
    }

    public void next(){
        createFireImage();
    }

    public void setWidth(int width) {
        this.width = width;
    }


    public void setHeight(int height) {
        this.height = height;
    }

    public Temperatures getTemperatures() {
        return temperatures;
    }

    public ColorPalette getPalette() {
        return palette;
    }

    public void setTemperatures(Temperatures temperatures) {
        this.temperatures = temperatures;
    }
}
