import java.util.Random;

public class Temperatures {
    private int width;
    private int height;
    private int [][]Temperatures;
    private DTOTemperatureParameters DTOTemperatureParameters;

    public Temperatures(DTOTemperatureParameters DTOTemperatureParameters ,int width, int height) {
        this.DTOTemperatureParameters = DTOTemperatureParameters;
        this.width = width;
        this.height = height;
        this.Temperatures = new int[width][height];
        this.DTOTemperatureParameters = DTOTemperatureParameters;
    }

    public int getTemp(int x,int y){
        return Temperatures[x][y];
    }

    public void next(){
        createColdPoints();
        createSparks();
        if (this.DTOTemperatureParameters.isBottomUpTemps()){
            uptodown();
        } else {
            downtoup();
        }
    }

    public void uptodown(){
        for (int h=height-2;h>4;h--){
            for (int w=2;w<width-2;w++){
                double newTemp;
                newTemp =(
                        Temperatures[w][h]*this.DTOTemperatureParameters.getCellPonderation()[1]+
                                Temperatures[w+1][h]*this.DTOTemperatureParameters.getCellPonderation()[0]+
                                Temperatures[w-1][h]*this.DTOTemperatureParameters.getCellPonderation()[2]+
                                Temperatures[w][h+1]*this.DTOTemperatureParameters.getCellPonderation()[3]+
                                Temperatures[w+1][h+1]*this.DTOTemperatureParameters.getCellPonderation()[4]+
                                Temperatures[w-1][h+1]*this.DTOTemperatureParameters.getCellPonderation()[5])/
                                this.DTOTemperatureParameters.getCellsDivider()-
                                this.DTOTemperatureParameters.getAtenuationFactor();
                Temperatures[w][h] = (int) newTemp;

                if (Temperatures[w][h] <0){
                    Temperatures[w][h]=0;
                } else if (Temperatures[w][h]>255) {
                    Temperatures[w][h]=255;
                }
            }
        }
    }

    public void downtoup(){
        for (int h = 5; h < height - 1; h++){
            for (int w=2;w<width-2;w++){
                double newTemp;
                newTemp =(
                        Temperatures[w][h]*this.DTOTemperatureParameters.getCellPonderation()[1]+
                                Temperatures[w+1][h]*this.DTOTemperatureParameters.getCellPonderation()[0]+
                                Temperatures[w-1][h]*this.DTOTemperatureParameters.getCellPonderation()[2]+
                                Temperatures[w][h+1]*this.DTOTemperatureParameters.getCellPonderation()[3]+
                                Temperatures[w+1][h+1]*this.DTOTemperatureParameters.getCellPonderation()[4]+
                                Temperatures[w-1][h+1]*this.DTOTemperatureParameters.getCellPonderation()[5])/
                        this.DTOTemperatureParameters.getCellsDivider()-
                        this.DTOTemperatureParameters.getAtenuationFactor();
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
            if (randomNumber < (float) this.DTOTemperatureParameters.getCoolPixelPercentage()/100F){
                Temperatures[w][height-1] = 0;
            }
        }
    }

    public void createSparks(){
        Random rd = new Random();

        for (int w=0;w<width;w++){
            float randomNumber = rd.nextFloat();
            if (randomNumber < (float) this.DTOTemperatureParameters.getHotPixelPercentage()/100F){
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

    public DTOTemperatureParameters getDTOTemperatureParameters() {
        return DTOTemperatureParameters;
    }

    public void setDTOTemperatureParameters(DTOTemperatureParameters DTOTemperatureParameters) {
        this.DTOTemperatureParameters = DTOTemperatureParameters;
    }
}
