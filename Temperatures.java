import java.util.Random;

public class Temperatures {
    private int width;
    private int height;
    private int [][]Temperatures;
    private float coldPointsPercentatge;
    private float sparkPercentatge;

    public Temperatures(int width, int height, float coldPointsPercentatge, float sparkPercentatge) {
        this.width = width;
        this.height = height;
        this.coldPointsPercentatge = coldPointsPercentatge;
        this.sparkPercentatge = sparkPercentatge;
        this.Temperatures = new int[width][height];
    }

    public int getTemp(int x,int y){
        return Temperatures[x][y];
    }

    public void next(){
        createColdPoints();
        createSparks();
        calcTemperatures();
    }

    public void calcTemperatures(){
        for (int h=height-2;h>4;h--){
            for (int w=2;w<width-2;w++){
                double newTemp;
                newTemp =(
                        Temperatures[w][h]*1.5D+
                                Temperatures[w+1][h]*1.2D+
                                Temperatures[w-1][h]*1.2D+
                                Temperatures[w][h+1]*0.7D+
                                Temperatures[w+1][h+1]*0.7D+
                                Temperatures[w-1][h+1]*0.7D)/5.98569D-1.8D;
                Temperatures[w][h] = (int) newTemp;

                if (Temperatures[w][h] <0){
                    Temperatures[w][h]=0;
                } else if (Temperatures[w][h]>255) {
                    Temperatures[w][h]=255;
                }
            }
        }
    }

    public void createColdPoints(){
        Random rd = new Random();

        for (int w=0;w<width;w++){
            float randomNumber = rd.nextFloat();
            if (randomNumber < coldPointsPercentatge){
                Temperatures[w][height-1] = 0;
            }
        }
    }

    public void createSparks(){
        Random rd = new Random();

        for (int w=0;w<width;w++){
            float randomNumber = rd.nextFloat();
            if (randomNumber < coldPointsPercentatge){
                Temperatures[w][height-1] = 255;
            }
        }
    }

    public void resetTemperatures(){
        for (int h=height-2;h>4;h--) {
            for (int w = 2; w < width - 2; w++) {
                this.Temperatures[w][h] = 0;
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int[][] getTemperatures() {
        return Temperatures;
    }

    public void setTemperatures(int[][] temperatures) {
        Temperatures = temperatures;
    }

    public float getColdPointsPercentatge() {
        return coldPointsPercentatge;
    }

    public void setColdPointsPercentatge(float coldPointsPercentatge) {
        this.coldPointsPercentatge = coldPointsPercentatge;
    }

    public float getSparkPercentatge() {
        return sparkPercentatge;
    }

    public void setSparkPercentatge(float sparkPercentatge) {
        this.sparkPercentatge = sparkPercentatge;
    }
}
